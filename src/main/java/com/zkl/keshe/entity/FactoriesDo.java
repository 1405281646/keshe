package com.zkl.keshe.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("factories")
public class FactoriesDo {
    /**
     * 工厂编号
     */

    private Integer fno;
    /**
     * 工厂名称
     */

    private String fname;
    /**
     * 工厂厂长名称
     */

    private String fmname;


}
