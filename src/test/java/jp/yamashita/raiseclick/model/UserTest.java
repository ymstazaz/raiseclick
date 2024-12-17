package jp.yamashita.raiseclick.model;

import jp.yamashita.raiseclick.User;
import jp.yamashita.raiseclick.until.TestDataFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    //        成功パターン
    @Test
    void testUserCreation(){
        User user = TestDataFactory.createUser();
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("太郎", user.getName());
        assertEquals("000@000", user.getAddress());
        assertEquals("123456a", user.getPassword());
        assertEquals("北海道", user.getPrefecture());
        assertEquals("旭川市", user.getCity());
        assertEquals("秘密", user.getGender());
        assertEquals("10代", user.getAge());
        assertEquals("ROLE_USER", user.getRole());
    }

//    失敗パターン
    @Test
    void testUserCreationWithInvalidData() {
        // 失敗パターンのテスト（無効なデータ）
        User user = new User(null, "", "", "short", "", "", "", "", "INVALID_ROLE");

        // 各フィールドが不正であることを検証
        assertNull(user.getId()); // IDがnull
        assertEquals("", user.getName()); // 名前が空
        assertEquals("", user.getAddress()); // メールアドレスが空
        assertEquals("short", user.getPassword()); // パスワードが短すぎる
        assertEquals("", user.getPrefecture()); // 都道府県が空
        assertEquals("", user.getCity()); // 市区が空
        assertEquals("", user.getGender()); // 性別が空
        assertEquals("", user.getAge()); // 年齢が空
        assertEquals("INVALID_ROLE", user.getRole()); // ロールが不正
    }
}
