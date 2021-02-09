package com.yliu.controller;


import com.yliu.bean.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试")
@RestController
@ResponseBody
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public Result hello(){
        return Result.ok("Hello World");
    }
}
