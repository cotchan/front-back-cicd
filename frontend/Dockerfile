# 엔진엑스에 제공할 빌드 파일을 생성하는 단계
FROM node:alpine as builder

# 해당 애플리케이션의 소스 코드가 이 디렉터리로 들어감
WORKDIR /app

# 소스 코드가 바뀔 때마다 종속성까지 다시 복사하지 않도록
# 먼저 종속성 목록을 담고 있는 package.json을 복사
COPY ./package.json ./

# package.json에 명시된 종속성을 설치
RUN npm install

# 로컬에 있는 모든 소스 코드를 WORKDIR로 복사
COPY ./ ./

# 컨테이너가 시작되면 실행할 명령어를 명시
RUN npm run build

# 엔진엑스를 가동하고 앞서 생성한 빌드 파일을 제공합니다.
# default.conf에 해준 설정을 엔진엑스 컨테이너 안으로 복사합니다.
FROM nginx
EXPOSE 3000
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /app/build /usr/share/nginx/html