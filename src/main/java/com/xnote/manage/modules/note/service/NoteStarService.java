package com.xnote.manage.modules.note.service;

import com.xnote.manage.modules.note.bean.NoteStar;
import org.springframework.stereotype.Service;

@Service
public interface NoteStarService
{

    /**
     * 初始化笔记点赞数
     * @return
     */
    public Integer addNoteStar(NoteStar star);
}
