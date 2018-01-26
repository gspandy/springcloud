package com.pandie.springcloud;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import com.pandie.springcloud.enity.RespEntity;
import com.pandie.springcloud.enity.TStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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
        Map<String, Object> reqmap = new HashMap<>();
        reqmap.put("age",11);

		if (!"1234561".equals(password)) {
            String method="post";
            //http://test.88106.org/index.php/topapi?format=json&v=v1&account=18532523324&vcode_type=signup&verifycode=bc8w&method=user.verifyAccount
           // http://test.88106.org/index.php/topapi?format=json&v=v1&vcode_type=signup&method=user.vcode
                HttpHeaders headers = new HttpHeaders();
                headers.add("X-Auth-Token", UUID.randomUUID().toString());
                MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
                postParameters.add("format", "json");
                postParameters.add("v", "v1");
            postParameters.add("account", "18532523324");
            postParameters.add("verifycode", "bc8w");

            postParameters.add("vcode_type", "signup");
            postParameters.add("method", "user.verifyAccount");
                HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(
                        postParameters, headers);
            RespEntity  rs1= restTemplate.postForObject(
                        "http://test.88106.org/index.php/topapi?", requestEntity,
                    RespEntity.class);
                //删除


/*
            TStudent rs=new TStudent();
            rs.setAge(11);
            rs.setName("DF");
            String json="{'mobile':'13949151980','type':'topapi-signup','vcode':'123456'}";
            String url="http://localhost:8082/hello1?param={param}";
            RespEntity user=restTemplate.getForObject(url, RespEntity.class,json);*/
			map.put("success", false);
			map.put("message", "密码错误");
			return map;
		}

		// 设置session
		session.setAttribute(WebSecurityConfig.SESSION_KEY, account);

		map.put("success", true);
		map.put("message", "登录成功");
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
