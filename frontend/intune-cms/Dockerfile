FROM node:20 AS build

# Set work directory
WORKDIR /app

# Copy package.json and install dependencies
COPY package*.json ./
RUN npm install

# Copy the rest of the Angular project
COPY . .

# Build the Angular app
RUN npm run build --configuration production

# ----------------------------
# 2. Serve with Nginx
# ----------------------------
FROM nginx:1.27

# Remove default Nginx website
RUN rm -rf /usr/share/nginx/html/*

# Copy Angular dist folder (update name if needed)
COPY --from=build /app/dist/intune-cms /usr/share/nginx/html

# Expose port 80 from the container
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]