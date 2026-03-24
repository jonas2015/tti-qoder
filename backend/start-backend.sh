#!/bin/bash
# Start Spring Boot backend

cd /app/backend
exec java -jar -Xmx512m app.jar
