package com.designpattern.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
    private List<EditorState> states = new ArrayList<>();

    public void push (EditorState state) {
        states.add(state);
    }

    public EditorState pop() {
         EditorState curr = states.get(states.size() - 1);
         states.remove(curr);
         return curr;
    }
}
