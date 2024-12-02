package jp.yamashita.raiseclick;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Arrays;
import java.util.List;


@Controller
public class UserController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private PasswordEncoder passwordEncoder;
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/userForm")
    public String showUserForm(Model model) {
        List<String> prefectures = Arrays.asList(
                "北海道", "青森県", "岩手県", "宮城県", "秋田県",
                "山形県", "福島県", "茨城県", "栃木県", "群馬県",
                "埼玉県", "千葉県", "東京都", "神奈川県", "新潟県",
                "富山県", "石川県", "福井県", "山梨県", "長野県",
                "岐阜県", "静岡県", "愛知県", "三重県", "滋賀県",
                "京都府", "大阪府", "兵庫県", "奈良県", "和歌山県",
                "鳥取県", "島根県", "岡山県", "広島県", "山口県",
                "徳島県", "香川県", "愛媛県", "高知県", "福岡県",
                "佐賀県", "長崎県", "熊本県", "大分県", "宮崎県",
                "鹿児島県", "沖縄県"
    );
        model.addAttribute("prefectures", prefectures);
        model.addAttribute("userForm", new UserForm());
        return "userForm";
    }

    @PostMapping("signup")
    public String signup(@ModelAttribute UserForm userForm,Model model){
        try {
            User user = new User();
            user.setName(userForm.getName());
            user.setAddress(userForm.getAddress());
            user.setPassword(passwordEncoder.encode(userForm.getPassword())); // パスワードを暗号化
            user.setPrefecture(userForm.getPrefecture());
            user.setCity(userForm.getCity());
            user.setGender(userForm.getGender());
            user.setAge(userForm.getAge());
            user.setRole("ROLE_USER"); // デフォルトのロールを設定

            // Userオブジェクトを渡してinsert
            userService.createUser(user);
        } catch (Exception e) {
            logger.error("Error occurred while creating user: ", e);
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
        return "redirect:/";
    }
}

