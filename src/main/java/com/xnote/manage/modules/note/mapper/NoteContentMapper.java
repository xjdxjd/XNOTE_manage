package com.xnote.manage.modules.note.mapper;

import com.xnote.manage.modules.note.bean.NoteContent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteContentMapper {

    Integer addNoteContent(NoteContent content);














    int deleteByPrimaryKey(String contId);
    int insert(NoteContent record);
    int insertSelective(NoteContent record);
    NoteContent selectByPrimaryKey(String contId);
    int updateByPrimaryKeySelective(NoteContent record);
    int updateByPrimaryKeyWithBLOBs(NoteContent record);
    int updateByPrimaryKey(NoteContent record);

}