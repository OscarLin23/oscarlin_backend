package com.example.oscarlin.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Result {
    //定义两个常量，成功的code是200，失败的是-1
    private static final String SUCCESS_CODE = "200";
    private static final String SERVER_EXCEPTION_CODE="500";
    private static final String ERROR_CODE = "-1";
    private static final String SERVER_EXCEPTION="服务端异常";
    private static final String PARAMETER_ISNULL="输入参数为空";
    private static final String SUCCESS = "成功";
    private static final String ERROR="失败";
    private String code;//code：接口的响应结果
    private Object data;//data：数据
    private String msg;//msg：存放错误信息

    //无参数的成功方法，只返回成功代码“200”
    public static Result success() {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS);
        return result;
    }

    //有参数的成功方法，返回成功代码“200” 和 数据data
    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(SUCCESS_CODE);
        result.setMsg(SUCCESS);
        result.setData(data);
        return result;
    }

    //失败的方法，返回自定义错误信息 和 错误代码“-1”
    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(ERROR_CODE);
        result.setMsg(ERROR);
        return result;
    }

    //失败的方法，返回自定义错误信息 和 自定义错误代码
    public static Result ServerException(String code, String msg) {
        Result result = new Result();
        result.setCode(SERVER_EXCEPTION_CODE);
        result.setMsg(SERVER_EXCEPTION);
        return result;
    }

}


