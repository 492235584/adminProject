package api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xiejiahao on 2016/8/28.
 */
@Controller
public class TestApi {

    @RequestMapping("/test")
    public String test(HttpServletResponse response) {
        response.addCookie(new Cookie("token","123456test"));
        return "test";
    }

}
