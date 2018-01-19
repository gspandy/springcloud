package com.pandie.springcloud;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.pandie.springcloud.enity.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.client.RestTemplate;

/**
 * 控制器 博客出处：http://www.cnblogs.com/GoodHelper/
 *
 */
@Controller
public class MainController {
    @Autowired
    private RestTemplate restTemplate;
	@GetMapping("/")
	public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String account, Model model) {
		model.addAttribute("name", account);
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/loginPost")
	public @ResponseBody Map<String, Object> loginPost(String account, String password, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		if (!"123456".equals(password)) {
			map.put("success", false);
			map.put("message", "密码错误");
			return map;
		}

		// 设置session
		session.setAttribute(WebSecurityConfig.SESSION_KEY, account);
        String url="http://localhost:8082/hello1";
        RespEntity user=restTemplate.getForObject(url, RespEntity.class);
		map.put("success", true);
		map.put("message", "登录成功"+user);
		return map;
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 移除session
		session.removeAttribute(WebSecurityConfig.SESSION_KEY);
		return "redirect:/login";
	}


    @GetMapping("/getHttp")
    public String getHttp(HttpSession session) {
        // 移除session

        return "redirect:/login";
    }

}
