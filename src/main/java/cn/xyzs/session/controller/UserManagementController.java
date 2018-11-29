package cn.xyzs.session.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RefreshScope
public class UserManagementController {

    /**
     * redis sesion共享
     *
     * @param request
     * @return
     */
    @RequestMapping("/getUser")
    public String getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)) {
            username = "testSessionRedis|" + System.currentTimeMillis();
            session.setAttribute("username", username);
        }
        System.out.println("访问端口：" + request.getServerPort());
        return username;
    }
}
