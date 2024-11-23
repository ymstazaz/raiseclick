package jp.yamashita.raiseclick;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.AttributedString;


@Controller
public class UserController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/userForm")
    public String showUserForm(@ModelAttribute("userForm") UserForm form){
        return "userForm";
    }

    @PostMapping("/users")
    public String createUser(UserForm userForm, Model model) {
        try {
            // ユーザー情報を挿入
            userRepository.insert(
                    userForm.getName(),
                    userForm.getAddress(),
                    userForm.getPassword(),
                    userForm.getPrefecture(),
                    userForm.getCity(),
                    userForm.getGender(),
                    userForm.getAge()
            );
        } catch (Exception e) {
            logger.error("Error occurred while creating user: ", e);
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return "redirect:/";
    }
}
