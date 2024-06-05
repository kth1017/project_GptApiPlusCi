# project_GptApiPlusCi
기존 프로젝트 GptApi_1에 CI/CD 파이프라인을 추가한 프로젝트
(기존 프로젝트 주소 : https://github.com/kth1017/project_GptApi_1)

- 기존 프로젝트 : 외부 Api(Gpt/Papago)를 이용한 웹서비스 토이 프로젝트
- 전환 후 변경점 : github actions를 활용한 CI/CD 파이프라인 구축, 모니터링시 AWS SSM을 사용한 SSH 연결 대체 등 상세 내용은 후술

url 링크: https://bit.ly/48863IO & post 링크: https://fadet-coding.tistory.com/92

# 개요
react+spring으로 GptApi, PapagoApi를 이용하여 만든 프로그래밍 ai질문 웹서비스
![image](https://user-images.githubusercontent.com/96664524/221394229-c8e595b7-4350-44b9-b22c-0ab44d492125.png)
![image](https://user-images.githubusercontent.com/96664524/221394278-c8740e1e-0d9d-4520-a836-53025e297674.png)

# 사용 기술
NginX(웹서버, 포워드 프록시) > React(앞단) > axios > Spring Boot(뒷단) > JPA > mariaDB (DB)

빌드툴
- react : Component 캡슐화 , Context API, axios 라이브러리를 사용하여 구성 / MUI로 디자인
- sping boot: spring boot를 이용해 mvc 패턴의 서버 작성, jpa/jpql을 사용한 entity-db 매핑, junit5로 클래스별 유닛 테스트

배포툴
- NginX : 포워드 프록시로 사용하여 정적 React build 파일 배포 및 캐싱
- AWS EC2&RDS : EC2를 사용하여 배포 + RDS DB 연동 / VPC 구축
- docker : 통합 후 EC2내 docker-compose를 사용해 배포

- github actions : runner를 사용해 CI/CD 파이프라인 구축
- AWS SSM(Systems Manager) : 기존 복잡한 리소스 사용량 관리 및 SSH 연결을 통한 인스턴스 관리를 쉽게 대체

# ver 2.0.0
@branch 'main' commit 'ver 2.0.0'

@to be
- gpt 엔진을 text-davinci-003 deprecated로 인해 gpt-3.5-turbo-instruct로 변경 및 추가 설정 수정
- github actions 작동 워크플로우 yml 파일 등록
- 빌드 용량 확보를 위한 dockerfile 수정
- 기존 테스트를 단위 테스트로 일부 전환(진행 중)
- 리액트 프론트엔드 부분 및 모호했던 패키지, 클래스명 수정

@ +
- aws 정책 변경으로 EIP 유료화에 따라 EIP 릴리즈 및 링크 DNS로 교체(240201 추가)
- github access token 만료로 재발급 진행 및 이전 DNS 변경으로 인한 프록시 패스 수정(240211 추가)
- aws rds에서 인증서의 CA(인증기관) 만료로 인해 mariaDB 인스턴스 업데이트(240319 추가)
- 네이버 파파고 api 서비스의 기존 무료 정책 유료화에 따라 번역 api를 파파고 대신 deepl로 변경(240424 추가)
- max_token이 1280이므로 2,000자 이상의 글자수를 가진 답변이 가끔 나오기에 답변 글자수 20,000자로 수정(240501 추가)
- aws ssm 설정 변경 및 기존에 사용하던 jupiterNotebook 삭제(240605 추가)
