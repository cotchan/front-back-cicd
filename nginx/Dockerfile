# 엔진엑스 베이스 이미지 가져오기
FROM nginx

# 앞서 작성한 엔진엑스 설정 파일을 컨테이너 안에 있는 엔진엑스 설정파일로 넣어주기
# default.conf에 작성된 것을 컨테이너에서 실행될 nginx에도 적용될 수 있게 COPY 명령어로 복사
COPY ./default.conf /etc/nginx/conf.d/default.conf