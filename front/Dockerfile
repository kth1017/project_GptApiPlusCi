FROM node:latest as builder

# 작업 폴더를 만들고 npm 설치
RUN mkdir /usr/src/app
WORKDIR /usr/src/app
ENV PATH /usr/src/app/node_modules/.bin:$PATH
COPY front/package.json /usr/src/app/package.json
RUN npm install --silent
RUN npm install react-scripts@5.0.1 -g --silent

# 소스를 작업폴더로 복사하고 빌드
COPY front/. /usr/src/app
RUN npm run build --verbose

FROM nginx:latest
# nginx의 기본 설정을 삭제하고 앱에서 설정한 파일을 복사
RUN rm -rf /etc/nginx/default.conf
COPY front/conf/default.conf /etc/nginx/conf.d/default.conf

# 위에서 생성한 앱의 빌드산출물을 nginx의 샘플 앱이 사용하던 폴더로 이동
COPY --from=builder /usr/src/app/build /usr/share/nginx/html

# 80포트 오픈하고 nginx 실행
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]