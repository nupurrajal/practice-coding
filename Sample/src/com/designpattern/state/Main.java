package com.designpattern.state;

public class Main {
    public static void main(String[] args) {
        drawUIControl(new TextBox());
    }

    private static void drawUIControl(UIControl uiControl) {
        drawUIControl(uiControl);
    }
}
