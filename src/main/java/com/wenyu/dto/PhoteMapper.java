package com.wenyu.dto;

import com.wenyu.domain.Photo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 文宇 on 2017/3/13.
 */
public interface PhoteMapper {
    public List<Photo> getListByPage(@Param("start") int start, @Param("end") int end);

    public int addPhoto(@Param("photo") Photo photo);

    public int delPhoto(@Param("id") String id);

    public int revertPhoto(@Param("id") String id);
}
