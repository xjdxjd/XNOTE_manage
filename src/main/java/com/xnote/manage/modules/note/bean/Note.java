package com.xnote.manage.modules.note.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Note {
    private String noteId;

    private String noteTitle;

    private String noteCont;

    private String noteCate;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    private Long timestamp;

    //  笔记内容
    private NoteContent noteContent;
    //  笔记分类
    private Map<String,NoteCategory> noteCategory;
    //  笔记评论
    private List<NoteComment> comments;
    //  笔记点赞量
    private NoteStar noteStar;

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId == null ? null : noteId.trim();
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle == null ? null : noteTitle.trim();
    }

    public String getNoteCont() {
        return noteCont;
    }

    public void setNoteCont(String noteCont) {
        this.noteCont = noteCont == null ? null : noteCont.trim();
    }

    public String getNoteCate() {
        return noteCate;
    }

    public void setNoteCate(String noteCate) {
        this.noteCate = noteCate == null ? null : noteCate.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public NoteContent getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(NoteContent noteContent) {
        this.noteContent = noteContent;
    }

    public Map<String, NoteCategory> getNoteCategory() {
        return noteCategory;
    }

    public void setNoteCategory(Map<String, NoteCategory> noteCategory) {
        this.noteCategory = noteCategory;
    }

    public List<NoteComment> getComments() {
        return comments;
    }

    public void setComments(List<NoteComment> comments) {
        this.comments = comments;
    }

    public NoteStar getNoteStar() {
        return noteStar;
    }

    public void setNoteStar(NoteStar noteStar) {
        this.noteStar = noteStar;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId='" + noteId + '\'' +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteCont='" + noteCont + '\'' +
                ", noteCate='" + noteCate + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", timestamp=" + timestamp +
                '}';
    }
}