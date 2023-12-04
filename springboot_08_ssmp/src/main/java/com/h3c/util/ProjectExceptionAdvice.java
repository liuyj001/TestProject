package com.h3c.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@ResponseBody
//@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public Object doOtherException(Exception ex) {
        //记录日志
        //发送邮件
        ex.printStackTrace();
        return "报错啦";
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public Object doOtherException1(Exception ex) {
        //记录日志
        //发送邮件
        ex.printStackTrace();
        return "报错啦NullPointer";
    }
}
