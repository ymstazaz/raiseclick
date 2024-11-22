package jp.yamashita.raiseclick;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {
    @GetMapping("/userForm")
    public String showUserForm(@ModelAttribute("userForm") UserForm form){
        return "userForm";
    }
}
