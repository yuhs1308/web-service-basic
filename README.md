# 개발자 중점 통합 관리 프로젝트


## 프로젝트 개요

B2C,B2B 웹서비스를 개발하고 운영하기 위한 기본적인 골격 만들기
웹서비스를 기본으로 하는 프로젝트(B2C, B2B 서비스 포함)를 수행할 때  개발 및 유지보수를 보다 편하고 빠르게 할 수 있도록 기본 틀을 마련하는 프로젝트


## 프로젝트 중점

- 얼마나 오류추적을 빠르게 할 수 있는 시스템
- 권한, 사이트 기본 기능, 기본적인 보안이 적용되어 있는 시스템\
- 협동으로 프로젝트를 수행 할 시 쉽게 소스리뷰, 오류추적을 할 수 있도록 협업에 특화 될 수 있도록 개발 - Exception, log 추적에 용이


## 전체 시스템 설계

- 유저 : 웹사이트의 기본기능을 사용
- 운영자 : 조직관리, 권한관리, 유저관리 등을 할 수 있어야 함
- 개발자 : 유저, 운영자 사이트 이용시 오류를 쉽게 분석 할 수 있어야 함

![통합관리 웹서비스 설계](https://user-images.githubusercontent.com/124989074/223991928-2f214227-3037-465d-a9be-ea2e8f9811fd.png)


## 환경

서버 

        Linux (centos나 우분투 사용)
개발환경

        spring boot + mybatis + jsp + sb admin
        MySQL
        SQL-SERVER
        OpenJDK 17


## 개발 포인트

1. 다중 DB 처리
2. Exception 처리
3. Filter
4. AOP
5. Intercepter
6. 권한 설정
7. 파일 업로드 설정



## 개발 내용
1. USER 사이트
- [ ] ExceptionHandler를 이용하여 Exception 처리
- [ ] AOP 사용 로그 처리
- [ ] interceptor 사용 권한 처리
- [ ] Filter 사용 


2. ADMIN 사이트
- [X] VIEW 설계 및 개발
- [X] 다중 디비
- [X] 기본 라이브러리 셋팅
- [X] 로그 셋팅
- [ ] ExceptionHandler를 이용하여 Exception 처리
- [ ] AOP 사용 로그 처리
- [ ] interceptor 사용 권한 처리
- [ ] Filter 사용 
- [X] 메뉴별 권한 적용


3. SYSTEM 정보 사이트
- [ ] 보안 로그인
- [ ] Exception, LOG 확인 페이지
- [ ] 운영자 관리


## 메뉴 생성 및 권한 할당 개발 중
