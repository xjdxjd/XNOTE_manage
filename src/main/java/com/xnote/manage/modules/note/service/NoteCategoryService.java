package com.xnote.manage.modules.note.service;

import com.xnote.manage.modules.note.bean.NoteCategory;

import java.util.List;

public interface NoteCategoryService
{
    /**
     * 获取全部的笔记分类
     * @return
     */
    public List<NoteCategory> getNoteCategory();

}
