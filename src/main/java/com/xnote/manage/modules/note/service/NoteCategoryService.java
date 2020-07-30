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

    /**
     * 添加笔记分类
     * @param category
     * @return
     */
    public Integer addCate(NoteCategory category);

    /**
     * 根据ID查询笔记分类
     * @param id
     * @return
     */
    public NoteCategory getCategoryById(String id);

    /**
     * 根据cateCode查询笔记分类
     * @param cateCode
     * @return
     */
    public NoteCategory getCategoryByCode(String cateCode);
    /**
     * 更新笔记分类
     * @param category
     * @return
     */
    public Integer updateCate(NoteCategory category);

    /**
     * 根据ID删除笔记分类
     * @param cateId
     * @return
     */
    public Integer delCateById(String cateId);

    /**
     * 模糊查询
     * @param code
     * @return
     */
    public List<NoteCategory> searchCate(String code);

    /**
     * 批量删除
     * @param delIds 需要删除的笔记分类ID列表
     * @return
     */
    public Integer batchesDelCate(List<String> delIds);

}
