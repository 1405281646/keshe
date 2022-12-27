package com.zkl.keshe.controller;

import com.zkl.keshe.R;
import com.zkl.keshe.entity.FactoriesDo;
import com.zkl.keshe.service.FactoriesService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public R save(@RequestBody FactoriesDo factoriesDo) {
        boolean save = factoriesService.save(factoriesDo);
        if (save) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/update")
    public R update(@RequestBody FactoriesDo factoriesDo) {
        boolean updateById = factoriesService.updateById(factoriesDo);
        if (updateById) {
            return R.ok();
        }
        return R.error();
    }

    @PostMapping("/remove")
    public R remove(@RequestParam Integer id) {
        boolean removeById = factoriesService.removeById(id);
        if (removeById) {
            return R.ok();
        }
        return R.error();
    }
}
