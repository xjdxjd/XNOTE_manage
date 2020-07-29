package com.xnote.manage.modules.note.mapper;

import com.xnote.manage.modules.note.bean.NoteComment;

public interface NoteCommentMapper {
    int deleteByPrimaryKey(String commId);

    int insert(NoteComment record);

    int insertSelective(NoteComment record);

    NoteComment selectByPrimaryKey(String commId);

    int updateByPrimaryKeySelective(NoteComment record);

    int updateByPrimaryKeyWithBLOBs(NoteComment record);

    int updateByPrimaryKey(NoteComment record);
}