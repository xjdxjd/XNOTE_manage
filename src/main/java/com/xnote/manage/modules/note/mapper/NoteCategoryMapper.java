package com.xnote.manage.modules.note.mapper;

import com.xnote.manage.modules.note.bean.NoteCategory;
import com.xnote.manage.modules.note.bean.NoteContent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoteCategoryMapper
{
    public List<NoteCategory> getNoteCategory();

    Integer addNoteContent(NoteContent content);




    int insert(NoteCategory record);
    int insertSelective(NoteCategory record);

}