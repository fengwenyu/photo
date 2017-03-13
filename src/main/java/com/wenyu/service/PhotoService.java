package com.wenyu.service;

import com.wenyu.domain.Photo;
import com.wenyu.dto.PhoteMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 文宇 on 2017/3/13.
 */
@Service
public class PhotoService {
    @Autowired
    PhoteMapper photeMapper;
    public List<Photo> getListByPage(int index,int size){
        return photeMapper.getListByPage((index-1)*size,index*size);
    }
    public int addPhoto(Photo photo){
        return photeMapper.addPhoto(photo);
    }

    public int delPhoto(String id) {
        return photeMapper.delPhoto(id);
    }

    public int revertPhoto(String id) {
        return photeMapper.revertPhoto(id);
    }
}
