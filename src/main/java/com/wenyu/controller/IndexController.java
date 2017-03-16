package com.wenyu.controller;

import com.wenyu.domain.Photo;
import com.wenyu.domain.ResultDto;
import com.wenyu.service.PhotoService;
import com.wenyu.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Random;

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
    public String upload(){
        return "upload";
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public ResultDto uploadPhoto(Photo photo, @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                String filePath="D:\\home\\photo\\";
                String fileName= FileUtil.getFileName()+".jpg";
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filePath+fileName)));
                out.write(file.getBytes());
                out.flush();
                out.close();
                String url ="http://192.168.2.11/photo/images/"+fileName;
                photo.setUrl(url);
                int add = photoService.addPhoto(photo);
                if(add>0){
                    return ResultDto.success();
                }
                return ResultDto.error("存储失败！");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResultDto.error("上传失败，系统异常！");
        } else {
            return ResultDto.error("上传失败，文件为空！");
        }

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
