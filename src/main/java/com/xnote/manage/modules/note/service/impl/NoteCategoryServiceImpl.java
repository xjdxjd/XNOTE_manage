package com.xnote.manage.modules.note.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.common.util.DateUtils;
import com.xnote.manage.modules.note.bean.NoteCategory;
import com.xnote.manage.modules.note.mapper.NoteCategoryMapper;
import com.xnote.manage.modules.note.service.NoteCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoteCategoryServiceImpl implements NoteCategoryService
{
    @Resource
    private NoteCategoryMapper noteCategoryMapper;

    @Override
    public List<NoteCategory> getNoteCategory()
    {
        List<NoteCategory> cates = noteCategoryMapper.getNoteCategory();
        if(CollectionUtils.isEmpty(cates))
        {
            return null;
        }
        return cates;
    }

    @Override
    public Integer addCate(NoteCategory category)
    {
        if(ObjectUtils.isEmpty(category))
        {
            return CommonConstant.STATUS_ZERO.getInt();
        }

        Integer row = noteCategoryMapper.addCate(category);
        return row;
    }

    @Override
    public NoteCategory getCategoryById(String id)
    {
        if(StringUtils.isEmpty(id)) { return null; }

        NoteCategory category = noteCategoryMapper.getCategoryById(id);
        if(ObjectUtils.isEmpty(category))
        {
            return null;
        }

        return category;
    }

    @Override
    public NoteCategory getCategoryByCode(String cateCode) {

        if(StringUtils.isEmpty(cateCode)) { return null; }

        NoteCategory category = noteCategoryMapper.getCategoryByCode(cateCode);
        if(ObjectUtils.isEmpty(category))
        {
            return null;
        }

        return category;
    }

    @Override
    public Integer updateCate(NoteCategory category)
    {
        if(ObjectUtils.isEmpty(category) || StringUtils.isEmpty(category.getCateId())) { return 0; }

        category.setUpdateTime(DateUtils.getCurrentDate());
        category.setTimestamp(DateUtils.getTimestamp());
        Integer row = noteCategoryMapper.updateCate(category);
        return row;
    }

    @Override
    public Integer delCateById(String cateId)
    {
        if(StringUtils.isEmpty(cateId))
        {
            return CommonConstant.STATUS_ZERO.getInt();
        }

        Integer row = noteCategoryMapper.delCateById(cateId);
        return row;
    }

    @Override
    public List<NoteCategory> searchCate(String code)
    {
        return noteCategoryMapper.searchCate(code);
    }

    @Override
    public Integer batchesDelCate(List<String> delIds)
    {
        if(CollectionUtils.isEmpty(delIds))
        {
            return CommonConstant.STATUS_ZERO.getInt();
        }
        Integer row = noteCategoryMapper.batchesDelCate(delIds);
        return row;
    }
}
