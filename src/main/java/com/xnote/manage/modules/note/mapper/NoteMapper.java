package com.xnote.manage.modules.note.mapper;

import com.xnote.manage.modules.note.bean.Note;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteMapper
{

    public Integer addNote(Note note);















    int deleteByPrimaryKey(String noteId);
    int insert(Note record);
    int insertSelective(Note record);
    Note selectByPrimaryKey(String noteId);
    int updateByPrimaryKeySelective(Note record);
    int updateByPrimaryKey(Note record);
}