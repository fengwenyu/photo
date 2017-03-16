package com.wenyu.controller;

import com.wenyu.domain.Photo;
import com.wenyu.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * Created by 文宇 on 2017/3/13.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    PhotoService photoService;

    @RequestMapping("")
    public String index(){
        return "photo/photo";
    }


    @RequestMapping("/list")
    public String findBypage(String pageIndex, @RequestParam(defaultValue = "10") String pageSize, Model model){
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
        model.addAttribute("photos",listByPage);
        return "list";
    }

    @RequestMapping("/list1")
    public String findBypage1(String pageIndex, @RequestParam(defaultValue = "20") String pageSize, Model model){
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
        model.addAttribute("photos",listByPage);
        return "home/photo";
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
