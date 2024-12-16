package jp.yamashita.raiseclick.controller;

import jp.yamashita.raiseclick.repository.UserRepository;
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
