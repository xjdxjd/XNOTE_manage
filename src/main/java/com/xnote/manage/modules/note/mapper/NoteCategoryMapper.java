package com.xnote.manage.modules.note.mapper;

import com.xnote.manage.modules.note.bean.NoteCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoteCategoryMapper
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
    public NoteCategory getCategoryById(@Param("cateId") String id);

    /**
     * 根据cateCode查询笔记分类
     * @param cateCode
     * @return
     */
    public NoteCategory getCategoryByCode(@Param("cateCode") String cateCode);
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
    public Integer delCateById(@Param("cateId") String cateId);

    /**
     * 模糊查询
     * @param code
     * @return
     */
    public List<NoteCategory> searchCate(@Param("cateCode") String code);

    /**
     * 批量删除
     * @param delIds 需要删除的笔记分类ID列表
     * @return
     */
    public Integer batchesDelCate(List<String> delIds);
}