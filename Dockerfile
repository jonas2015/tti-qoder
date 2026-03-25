# TTi Group - Complete Application
# Single container with both frontend (nginx) and backend (Java)

# Stage 1: Build frontend
FROM node:18-alpine AS frontend-builder
WORKDIR /app/frontend
COPY frontend/package*.json ./
RUN npm ci
COPY frontend/ .
ARG VITE_API_URL=/api
ENV VITE_API_URL=$VITE_API_URL
RUN npm run build

# Stage 2: Build backend
FROM maven:3.9-eclipse-temurin-17 AS backend-builder
WORKDIR /app/backend
COPY backend/pom.xml .
RUN mvn dependency:go-offline -B
COPY backend/src ./src
RUN mvn package -DskipTests

# Stage 3: Final runtime image
FROM eclipse-temurin:17-jre-alpine

# Install nginx
RUN apk add --no-cache nginx bash curl

# Create app directories
RUN mkdir -p /app/backend /app/frontend

# Remove default nginx config that conflicts
RUN rm -rf /etc/nginx/conf.d/*

# Copy backend jar
COPY --from=backend-builder /app/backend/target/*.jar /app/backend/app.jar

# Copy frontend build files
COPY --from=frontend-builder /app/frontend/dist /app/frontend

# Copy startup script
COPY start-services.sh /app/start-services.sh
RUN chmod +x /app/start-services.sh

# Expose ports
EXPOSE 80 8080

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=30s --retries=3 \
    CMD curl -sf http://localhost:8080/ || exit 1

# Run as root
CMD ["/app/start-services.sh"]
