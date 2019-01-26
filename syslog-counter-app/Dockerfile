FROM node:current-alpine
WORKDIR /opt/
COPY . .
EXPOSE 3000
RUN npm install
CMD cd /opt/syslog-counter-app && npm start
