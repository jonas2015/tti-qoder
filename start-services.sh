#!/bin/bash
# Start both backend and frontend services

# Start backend in background
echo "Starting TTi Backend..."
cd /app/backend
nohup java -jar -Xmx512m app.jar > /var/log/backend.log 2>&1 &
BACKEND_PID=$!

# Wait for backend to start
echo "Waiting for backend to initialize..."
for i in {1..30}; do
    if curl -sf http://localhost:8080/ > /dev/null 2>&1; then
        echo "Backend is ready!"
        break
    fi
    sleep 2
done

# Start nginx (frontend)
echo "Starting TTi Frontend..."
nginx -g 'daemon off;' &
NGINX_PID=$!

# Wait for both processes
echo "TTi Group is running!"
echo "- Frontend: http://localhost:80"
echo "- Backend:  http://localhost:8080"

# Handle shutdown gracefully
trap "kill $BACKEND_PID $NGINX_PID 2>/dev/null; exit" SIGTERM SIGINT

# Keep container running
wait
