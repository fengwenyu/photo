package com.wenyu.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by 文宇 on 2017/3/16.
 */
@Getter
@Setter
@ToString
public class ResultDto implements Serializable {
    String code;
    String msg;
    Object content;
    public static ResultDto success(){
        return new ResultDto("0","success");
    }

    public static ResultDto success(Object content){
       return new ResultDto("0", "success",content);
    }
    public static ResultDto error(String msg){
        return new ResultDto("1",msg);
    }

    private ResultDto(String code, String msg,Object obj) {
        this.code = code;
        this.msg = msg;
        this.content=obj;
    }

    private ResultDto(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultDto() {
    }

}
