package com.xnote.manage.modules.note.service;

import com.xnote.manage.modules.note.bean.Note;
import com.xnote.manage.modules.note.bean.NoteContent;

import java.util.List;

public interface NoteService
{
    /**
     * 获取所有笔记
     * @return
     */
    public List<Note> getAllNotes();

    /**
     * 添加笔记
     * @return
     */
    public Integer addNote(Note note);

    /**
     * 添加笔记内容
     * @return
     */
    public Integer addNoteContent(NoteContent content);
}
