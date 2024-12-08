package jp.yamashita.raiseclick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/loginForm")
    public String showLoginForm(){
        return "loginForm";
    }

}
