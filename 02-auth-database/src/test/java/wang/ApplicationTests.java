package wang;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import wang.bean.User;
import wang.service.IUserService;


@SpringBootTest
@Slf4j
class ApplicationTests {
    @Resource
    private IUserService userService;

    @Test
    @DisplayName("根据用户名查询用户")
    void testMp() {
        User admin = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUserName, "admin"));
        log.info(String.valueOf(admin));
    }

    @Test
    @DisplayName("插入一条用户数据")
    void insertUserTest() {
        User user = new User();
        user.setUserName("admin1");
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        user.setLoginName("管理员");
        user.setPhone("13688888888");
        userService.save(user);
    }

    @Test
    @DisplayName("根据手机号和密码登录")
    void loginTest() {
        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getPhone, "13951905171"));
        if ("$2a$10$SCN6iCjrhEcDUIE6Qzgg/O9jlowCo2AuaGk9gr8Q45EclWWfSGsKa".equals(user.getPassword())) {
            log.info("登录成功");
        } else {
            log.info("登录失败");
        }
    }
}