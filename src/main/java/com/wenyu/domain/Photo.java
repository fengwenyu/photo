package com.wenyu.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 文宇 on 2017/3/13.
 */
@Getter
@Setter
@ToString
public class Photo implements Serializable{
    private int id;
    private String desc;
    private String url;
    private String location;
    private Date date;
}
