package site.orangefield.jusotest;

// 원래는 static에 넣으면 안되고 Redis에 넣어야 한다
// 혹은 본인 세션 저장소에
// 모든 클라이언트가 Store를 공유하니까
public class Store {
    public static String roadFullAddr;
}
