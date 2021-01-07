FROM node:12.19.0-alpine as build
MAINTAINER Fernando Vieira - node
ENV NODE_ENV=development
COPY . /var/www
WORKDIR /var/www
RUN npm install 
ENTRYPOINT ["npm", "start"]
EXPOSE 3000
