package com.xnote.manage.modules.note.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.modules.note.bean.NoteStar;
import com.xnote.manage.modules.note.mapper.NoteStarMapper;
import com.xnote.manage.modules.note.service.NoteStarService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class NoteStarServiceImpl implements NoteStarService
{
    @Resource
    private NoteStarMapper noteStarMapper;

    @Override
    public Integer addNoteStar(NoteStar star)
    {
        if(ObjectUtils.isEmpty(star))
        {
            return CommonConstant.STATUS_ZERO.getInt();
        }
        Integer row = noteStarMapper.addNoteStar(star);
        return row;
    }
}
