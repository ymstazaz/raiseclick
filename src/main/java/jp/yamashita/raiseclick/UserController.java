package jp.yamashita.raiseclick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {
    private final UserService userService;

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
    public String createUser(UserForm userForm){
        userRepository.insert(userForm.getName(),userForm.getAddress(),userForm.getPassword(),userForm.getPrefecture(),userForm.getCity(),userForm.getGender(),userForm.getAge());
        return "redirect:/";
    }
}
