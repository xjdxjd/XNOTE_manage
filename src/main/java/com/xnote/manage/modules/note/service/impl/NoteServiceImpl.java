package com.xnote.manage.modules.note.service.impl;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.modules.note.bean.Note;
import com.xnote.manage.modules.note.bean.NoteContent;
import com.xnote.manage.modules.note.mapper.NoteContentMapper;
import com.xnote.manage.modules.note.mapper.NoteMapper;
import com.xnote.manage.modules.note.service.NoteService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService
{
    @Resource
    private NoteMapper noteMapper;
    @Resource
    private NoteContentMapper noteContentMapper;

    @Override
    public List<Note> getAllNotes()
    {
        return null;
    }


    @Override
    public Integer addNote(Note note)
    {
        if(ObjectUtils.isEmpty(note))
        {
            return CommonConstant.STATUS_ZERO.getInt();
        }
        Integer row = noteMapper.addNote(note);
        return row;
    }

    @Override
    public Integer addNoteContent(NoteContent content)
    {

        if(ObjectUtils.isEmpty(content))
        {
            return CommonConstant.STATUS_ZERO.getInt();
        }
        Integer row = noteContentMapper.addNoteContent(content);
        return row;
    }
}
