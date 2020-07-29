package com.xnote.manage.modules.note.bean;

public class NoteContent {
    private String contId;

    private String noteId;

    private String noteContext;

    public String getContId() {
        return contId;
    }

    public void setContId(String contId) {
        this.contId = contId == null ? null : contId.trim();
    }

    public String getNoteId() {
        return noteId;
    }

    public void setNoteId(String noteId) {
        this.noteId = noteId == null ? null : noteId.trim();
    }

    public String getNoteContext() {
        return noteContext;
    }

    public void setNoteContext(String noteContext) {
        this.noteContext = noteContext == null ? null : noteContext.trim();
    }
}