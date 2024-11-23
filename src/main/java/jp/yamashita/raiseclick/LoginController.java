package jp.yamashita.raiseclick;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm(){
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(String address, String password, Model model, HttpSession session){
        User user =userRepository.findByAddress(address);
        if (user != null && user.getPassword().equals(password)){
            model.addAttribute("message","ログイン成功");
            return "redirect:/home";
        }
        model.addAttribute("errorMessage", "メールアドレスまたはパスワードが間違えています");
        return "loginForm";
    }
}
