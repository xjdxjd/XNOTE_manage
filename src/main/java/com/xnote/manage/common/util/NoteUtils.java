package com.xnote.manage.common.util;

import com.xnote.manage.common.constant.CommonConstant;
import com.xnote.manage.modules.note.bean.Note;
import com.xnote.manage.modules.note.bean.NoteContent;
import com.xnote.manage.modules.note.bean.NoteStar;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;

/**
 * 笔记工具类
 */
public class NoteUtils
{
    /**
     * 组装笔记类
     * @param note
     * @return
     */
    public static Note assembleNote(Note note)
    {
        if(StringUtils.isEmpty(note.getNoteId())){
            note.setNoteId(UUIDUtils.getUUID());
        }

        if(StringUtils.isEmpty(note.getNoteCont())){
            note.setNoteCont(UUIDUtils.getUUID());
        }

        if(ObjectUtils.isEmpty(note.getCreateTime())){
            note.setCreateTime(DateUtils.getCurrentDate());
        }

        if(ObjectUtils.isEmpty(note.getUpdateTime())){
            note.setUpdateTime(DateUtils.getCurrentDate());
        }

        if(ObjectUtils.isEmpty(note.getTimestamp())){
            note.setTimestamp(DateUtils.getTimestamp());
        }
        return note;
    }

    /**
     * 组装笔记内容
     * @param contentId
     * @param noteId
     * @param content
     * @return
     */
    public static NoteContent assembleNoteContent(String contentId, String noteId, NoteContent content)
    {
        if(StringUtils.isEmpty(contentId)){
            return null;
        }

        if(StringUtils.isEmpty(noteId)){
            return null;
        }

        if(StringUtils.isEmpty(content.getContId())){
            content.setContId(contentId);
        }

        if(StringUtils.isEmpty(content.getNoteId())){
            content.setNoteId(noteId);
        }

        return content;
    }

    /**
     * 组装笔记内容
     * @param noteId
     * @param star
     * @return
     */
    public static NoteStar assembleNoteStar(String noteId, NoteStar star)
    {
        if(StringUtils.isEmpty(noteId)){
            return null;
        }

        if(StringUtils.isEmpty(star.getStarId())){
            star.setStarId(UUIDUtils.getUUID());
        }

        if(StringUtils.isEmpty(star.getNoteId())){
            star.setNoteId(noteId);
        }

        if(ObjectUtils.isEmpty(star.getNoteStar())){
            star.setNoteStar(CommonConstant.STATUS_NORMAL.getInt());
        }

        if(ObjectUtils.isEmpty(star.getUpdateTime())){
            star.setUpdateTime(DateUtils.getCurrentDate());
        }

        if(ObjectUtils.isEmpty(star.getUpdateTimestamp())){
            star.setUpdateTimestamp(DateUtils.getTimestamp());
        }

        return star;
    }
}
