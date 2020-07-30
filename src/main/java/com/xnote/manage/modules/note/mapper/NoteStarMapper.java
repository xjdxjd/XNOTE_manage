package com.xnote.manage.modules.note.mapper;

import com.xnote.manage.modules.note.bean.NoteStar;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteStarMapper
{
    public Integer addNoteStar(NoteStar star);








    int deleteByPrimaryKey(String starId);
    int insert(NoteStar record);
    int insertSelective(NoteStar record);
    NoteStar selectByPrimaryKey(String starId);
    int updateByPrimaryKeySelective(NoteStar record);
    int updateByPrimaryKey(NoteStar record);
}