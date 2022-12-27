package com.zkl.keshe.controller;

import com.zkl.keshe.R;
import com.zkl.keshe.entity.FactoriesDo;
import com.zkl.keshe.service.FactoriesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("Factories")
public class FactoriesController {
    @Resource
    FactoriesService factoriesService;


    @GetMapping("/list")
    public R list() {
        List<FactoriesDo> list = factoriesService.list();
        return R.listok(list);
    }
}
