package com.example.demo1.controller;

import com.example.demo1.dto.AccessTokenDTO;
import com.example.demo1.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state
                           ) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setCliend_id("b86056f9728c803d74c3");
        accessTokenDTO.setClient_secret("6302daa465aed5825ad0c439e1b38f131aef5978");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
