package com.basename.controller;

import com.basename.lib.ResponseData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leets")
public class LeetController {

    @PostMapping
    public ResponseData leetSort(@RequestParam String name){
        System.out.println(name);
        ResponseData responseData = new ResponseData();
        responseData.setData(1);
        return  responseData;
    }
}
