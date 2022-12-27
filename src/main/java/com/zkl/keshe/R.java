package com.zkl.keshe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author BailuGansan
 * @email 1195137943@qq.com
 * 返回参数
 * msg相应信息
 * code 状态码
 * data返回数据
 */

public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 4000);
        put("msg", "操作成功");
    }

    /**
     *
     */


    public static R error() {
        return error(5000, "操作失败");
    }

    public static R error(String msg) {
        return error(5000, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        HashMap<String, Object> data = new HashMap<>();
        data.put("data", map);
        r.putAll(data);
        return r;
    }

    public static R ok(List<? extends Object> list) {
        R r = new R();
        HashMap<String, Object> data = new HashMap<>();
        data.put("data", list);
        r.putAll(data);
        return r;
    }

    public static R ok(String msg, Object o) {
        R r = new R();
        r.put("msg", msg);
        HashMap<String, Object> data = new HashMap<>();
        data.put("data", o);
        r.putAll(data);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public static R saveOK() {
        return R.ok("添加成功");
    }

    public static R removeOK() {
        return R.ok("删除成功");
    }

    public static R updateOK() {
        return R.ok("更新成功");
    }


    public static R listok(List<? extends Object> list) {
        R r = new R();
        r.put("msg", "获取列表成功");
        HashMap<String, Object> data = new HashMap<>();
        data.put("data", list);
        r.putAll(data);
        return r;
    }

    public static R get(List<? extends Object> list) {
        R r = new R();
        r.put("msg", "获取信息成功");
        HashMap<String, Object> data = new HashMap<>();
        data.put("data", list);
        r.putAll(data);
        return r;
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}