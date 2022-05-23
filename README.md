# 주소 API 테스트
juso.go.kr

### step1 Branch
- 기존 로직 사용

### master Branch
- Store에 저장헤서 폴링하는 방식 사용
- Store는 세션 저장소(Redis)를 사용하는 것이 좋다
- 폴링보다는 웹소켓이나 SSE로 push해주는 것이 좋다