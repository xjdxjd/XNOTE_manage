package com.xnote.manage.modules.note.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.modules.note.bean.NoteCategory;
import com.xnote.manage.modules.note.bean.NoteContent;
import com.xnote.manage.modules.note.mapper.NoteCategoryMapper;
import com.xnote.manage.modules.note.service.NoteCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

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

}
