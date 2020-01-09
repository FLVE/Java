package top.iwjf.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.iwjf.community.dto.AccessTokenDTO;
import top.iwjf.community.dto.GithubUser;
import top.iwjf.community.mapper.UserMapper;
import top.iwjf.community.model.User;
import top.iwjf.community.provider.GithubProvider;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    @Autowired
    private UserMapper userMapper;

    @Value("${github.client.id}")
    private  String clientId;
    @Value("${github.client.secret}")
    private String clientSecret;
    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    //从前端跳转页面上获取code和state
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        //需要携带以下参数去获取accessToken
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRediret_uri(redirectUri);
        accessTokenDTO.setState(state);
        //得到accessToken
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);

        //利用accessToken得到个人信息
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if(githubUser != null){
            //获得数据后存入数据库
            User user = new User();
            user.setAccountId(String.valueOf(githubUser.getId()));
            String token = UUID.randomUUID().toString();

            user.setToken(token);
            user.setName(githubUser.getName());
            user.setGmtCreated(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreated());
            userMapper.insert(user);

//          添加cookie
            response.addCookie(new Cookie("token",token));
            //登陆成功,写cookie和session
//            request.getSession().setAttribute("user",githubUser);
            return "redirect:/";
        }else {
            //登陆失败
            return "redirect:/";
        }
    }
}
