package fadet.private_deploy1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {
    @GetMapping("/test")
    public String hello(){
        System.out.println("test ok");
        return "test ok";
    }
}
