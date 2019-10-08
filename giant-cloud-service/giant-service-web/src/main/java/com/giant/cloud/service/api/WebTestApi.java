package com.giant.cloud.service.api;

import com.giant.cloud.service.service.WebTestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class WebTestApi {

    @Autowired
    private WebTestService webTestService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/test")
    @ApiOperation("测试")
    public String doTest() {
        return webTestService.getTest() + " from server port: " + serverPort;
    }
}
