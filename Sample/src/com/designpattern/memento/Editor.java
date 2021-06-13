package com.designpattern.memento;

public class Editor {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EditorState createState() {
        return new EditorState(this.content);
    }

    public void restorState(EditorState currState) {
        content = currState.getContent();
    }
}
