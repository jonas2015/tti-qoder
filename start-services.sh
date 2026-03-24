#!/bin/bash

# Create required directories
mkdir -p /var/log /run /var/lib/nginx/logs /var/cache/nginx

# Fix permissions for nginx
touch /var/lib/nginx/logs/error.log
chmod 777 /var/log /run /var/lib/nginx/logs /var/cache/nginx

# Start backend
echo "Starting TTi Backend..."
cd /app/backend
nohup java -jar -Xmx512m app.jar > /dev/null 2>&1 &
BACKEND_PID=$!

# Wait for backend
echo "Waiting for backend to initialize..."
for i in $(seq 1 30); do
    if curl -sf http://localhost:8080/ > /dev/null 2>&1; then
        echo "Backend is ready!"
        break
    fi
    sleep 2
done

# Create complete nginx config inline
cat > /tmp/nginx.conf << 'EOF'
daemon off;
worker_processes 1;
error_log /dev/stderr;
pid /run/nginx.pid;

events {
    worker_connections 1024;
}

http {
    access_log /dev/stdout;
    include /etc/nginx/mime.types;
    default_type application/octet-stream;

    server {
        listen 80;
        server_name localhost;
        root /app/frontend;
        index index.html;

        location / {
            try_files $uri $uri/ /index.html;
        }

        location /api/ {
            proxy_pass http://localhost:8080/api/;
            proxy_http_version 1.1;
            proxy_set_header Host $host;
            proxy_set_header X-Real-IP $remote_addr;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_set_header X-Forwarded-Proto $scheme;
        }
    }
}
EOF

# Start nginx
echo "Starting TTi Frontend..."
nginx -c /tmp/nginx.conf &
NGINX_PID=$!

echo "TTi Group is running!"

# Handle shutdown
trap "kill $BACKEND_PID $NGINX_PID 2>/dev/null; exit" SIGTERM SIGINT

wait
