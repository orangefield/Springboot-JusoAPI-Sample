package site.orangefield.jusotest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JusoController {

    @GetMapping("/")
    public String home(Model model) {
        String jusoUrl = "https://www.juso.go.kr/addrlink/addrLinkUrl.do?confmKey=U01TX0FVVEgyMDIyMDUyMzEwNTAwNDExMjYwMDM=&returnUrl=http://localhost:8080/juso/callback&resultType=4";
        model.addAttribute("jusoUrl", jusoUrl);
        return "home";
    }

    // 해당 콜백이 호출되면 push해주는 것이 좋다(Stream이 유지되고 있어야 한다)(웹소켓/SSE)
    // 웹소켓 - 서버를 하나 더 만들어야 함
    // SSE(Server Send Event)
    @PostMapping("/juso/callback")
    // 스프링 기본 전략 x-www-form-urlencoded니까 출력변수를 그냥 넣으면 된다
    public void jusoCallback(String roadFullAddr) {
        System.out.println(roadFullAddr);
        Store.roadFullAddr = roadFullAddr;
    }

    @GetMapping("/juso/check")
    public @ResponseBody String jusoCheck() {
        return Store.roadFullAddr;
    }
}
