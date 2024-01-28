# project_GptApiPlusCi
기존 프로젝트 GptApi_1에 CI 파이프라인을 추가한 프로젝트
(기존 프로젝트 주소 : https://github.com/kth1017/project_GptApi_1)

- 기존 프로젝트 : 외부 Api(Gpt/Papago)를 이용한 웹서비스 토이 프로젝트
- 전환 후 변경점 : github actions를 활용한 CI파이프라인 및 자동 배포 구축, 모니터링시 AWS SSM을 사용한 SSH 연결 대체 등 상세 내용은 후술

url 링크: bit.ly/3HtTm0e 

# 개요
react+spring으로 GptApi, PapagoApi를 이용하여 만든 프로그래밍 ai질문 웹서비스
![image](https://user-images.githubusercontent.com/96664524/221394229-c8e595b7-4350-44b9-b22c-0ab44d492125.png)
![image](https://user-images.githubusercontent.com/96664524/221394278-c8740e1e-0d9d-4520-a836-53025e297674.png)

# 사용 기술
NginX(웹서버, 포워드 프록시) > React(앞단) > axios > Spring Boot(뒷단) > JPA > mariaDB (DB)

- react : Component 캡슐화 , Context API, axios 라이브러리를 사용하여 구성 / MUI로 디자인
- sping boot: spring boot를 이용해 mvc 패턴의 서버 작성, jpa/jpql을 사용한 entity-db 매핑, junit5로 클래스별 유닛 테스트

- AWS EC2&RDS : EC2를 사용하여 배포 + RDS DB 연동 / VPC 구축
- docker : 모든 빌드 파일을 이미지화하여 EC2내 docker-compose를 사용해 배포
- NginX : 포워드 프록시로 사용하여 정적 React build 파일 배포 및 캐싱
