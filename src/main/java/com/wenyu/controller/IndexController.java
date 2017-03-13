package com.wenyu.controller;

import com.wenyu.domain.Photo;
import com.wenyu.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * Created by 文宇 on 2017/3/13.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    PhotoService photoService;
    @RequestMapping("/list")
    public  List<Photo> findBypage(String pageIndex,@RequestParam(defaultValue = "10") String pageSize){
        int index = 0;
        int size = 0;
        try {
            index = Integer.parseInt(pageIndex);
            size = Integer.parseInt(pageSize);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return null;
        }
        List<Photo> listByPage = photoService.getListByPage(index, size);
        return listByPage;
    }

    @RequestMapping("/upload")
    public String uploadPhoto(Photo photo){
        int add = photoService.addPhoto(photo);
        if(add>0){
            return "success";
        }
        return "error";
    }

    @RequestMapping("/del")
    public String delPhoto(String id){
        int del = photoService.delPhoto(id);
        if(del>0){
            return "success";
        }
        return "error";
    }
    @RequestMapping("/revert")
    public String revertPhoto(String id){
        int revert = photoService.revertPhoto(id);
        if(revert>0){
            return "success";
        }
        return "error";
    }

}
