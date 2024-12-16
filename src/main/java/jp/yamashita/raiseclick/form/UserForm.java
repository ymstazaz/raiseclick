package jp.yamashita.raiseclick;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserForm {
    @NotBlank(message = "名前は必須です")
    private String name;
    @NotBlank(message = "メールアドレスは必須です")
    @Email(message = "メールアドレスの形式が正しくありません")
    private String address;
    @NotBlank(message = "パスワードは必須です")
    @Size(min = 6, message = "2文字以上で入力してください")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]+$", message = "英字と数字を組み合わせて入力してください")
    private String password;
    @NotBlank(message = "都道府県は必須です")
    private String prefecture;
    @NotBlank(message = "市区は必須です")
    private String city;
    @NotBlank(message = "性別は必須です")
    @Pattern(regexp = "^(男|女|秘密)$", message = "「男」「女」「秘密」のいずれかをご選択ください")
    private String gender;
    @Pattern(regexp = "^(10代|20代|30代|40代|50代|60代以上)$", message = "選択項目のいずれかをご選択ください")
    private String age;

}
