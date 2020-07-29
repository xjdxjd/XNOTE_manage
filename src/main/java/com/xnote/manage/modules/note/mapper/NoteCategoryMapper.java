package com.xnote.manage.modules.note.mapper;

import com.xnote.manage.modules.note.bean.NoteCategory;

public interface NoteCategoryMapper {
    int insert(NoteCategory record);

    int insertSelective(NoteCategory record);
}