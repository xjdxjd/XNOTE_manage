package com.xnote.manage.modules.note.mapper;

import com.xnote.manage.modules.note.bean.Note;

public interface NoteMapper {
















    int deleteByPrimaryKey(String noteId);
    int insert(Note record);
    int insertSelective(Note record);
    Note selectByPrimaryKey(String noteId);
    int updateByPrimaryKeySelective(Note record);
    int updateByPrimaryKey(Note record);
}