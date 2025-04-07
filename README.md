# URL Shortener Micro Service Architecture 
## Init Version
![image](https://github.com/user-attachments/assets/a7fec6e3-c239-4d93-b7be-e296b2b2f639)

## About Services
### URL Shorten Service
#### 역할
- Orginal URL에 매핑되는 Short URL 생성
- 생성된 Short URL을 URL Persistence Service로 저장 요청
- 생성된 Short URL을 유저에게 응답
#### 특징
- DB 의존없이 유일한 ID 생성기 구현
  - 생성된 ID는 Short URL로 사용
  - 매우 가벼운 어플리케이션이라 확장이 매우 간편
  - Tiwitter Snowflake Algorithm에서 영감을 얻어 유일한 Short URL 생성 보장
 
[자세히](https://jeongseonghun.com/posts/troubleshooting/%ED%99%95%EC%9E%A5%EC%84%B1%EA%B3%BC-%EB%8B%A8%EC%88%9C%EC%84%B1-%EB%91%90-%EB%A7%88%EB%A6%AC-%ED%86%A0%EB%81%BC-%EC%9E%A1%EA%B8%B0-DB-%EC%97%86%EB%8A%94-URL-%EB%8B%A8%EC%B6%95-%EC%84%9C%EB%B9%84%EC%8A%A4-%EC%84%A4%EA%B3%84-%EB%8F%84%EC%A0%84/)
### URL Redirect Service
#### 역할
- Short URL에 매핑된 Original URL로 Redirect 수행
#### 특징
- 302응답으로 Redirect 수행

### URL Persistence Service
#### 역할
- RDBMS와 타 서비스들 간의 인터페이스 역할
#### 특징
- RDBMS와 통신을 위한 설정, 리포지토리, 엔티티를 관리

### API Gateway
#### 역할
- 클라이언트와 직접 통신하는 역할
#### 특징
- 특정 URL을 하단의 서비스로 라우팅


