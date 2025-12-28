# ----------------------------
# Build stage
# ----------------------------
FROM node:20 AS build

WORKDIR /app
RUN npm install -g npm@11.6.2

COPY package*.json ./
RUN npm ci

COPY . .
ENV NODE_OPTIONS=--max_old_space_size=4096
RUN npm run build

# ----------------------------
# Runtime stage (SSR)
# ----------------------------
FROM node:20-slim AS runtime

WORKDIR /app
ENV NODE_ENV=production

COPY --from=build /app/dist/intune-cms ./dist/intune-cms
COPY package*.json ./

RUN npm install --omit=dev

EXPOSE 4000

CMD ["node", "dist/intune-cms/server/server.mjs"]