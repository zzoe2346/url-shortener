# URL Shortener Micro Service Architecture 
## Init Version
![image](https://github.com/user-attachments/assets/c2702b17-814e-43b5-92e0-d4228138b9b3)
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
  - Tiwitter Snowflake Algorithm에서 영감을 얻어 7자리의 유일한 Short URL 생성 보장

### URL Redirect Service
#### 역할
#### 특징

### URL Persistence Service
#### 역할
#### 특징

### API Gateway
#### 역할
#### 특징


