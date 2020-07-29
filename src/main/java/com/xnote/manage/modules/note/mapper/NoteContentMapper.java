package com.xnote.manage.modules.note.mapper;

import com.xnote.manage.modules.note.bean.NoteContent;

public interface NoteContentMapper {
    int deleteByPrimaryKey(String contId);

    int insert(NoteContent record);

    int insertSelective(NoteContent record);

    NoteContent selectByPrimaryKey(String contId);

    int updateByPrimaryKeySelective(NoteContent record);

    int updateByPrimaryKeyWithBLOBs(NoteContent record);

    int updateByPrimaryKey(NoteContent record);
}