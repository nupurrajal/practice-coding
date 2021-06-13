package com.designpattern.state;

public class Canvas {

    private ToolType currTool;

    public ToolType getCurrTool() {
        return currTool;
    }

    public void setCurrTool(ToolType currTool) {
        this.currTool = currTool;
    }
    public void mouseUp() {
        switch (currTool) {
            case SELECTION:
                System.out.println("Draw dashed rectangle");
                break;
            case BRUSH:
                System.out.println("Brush it");
                break;
            case ERASER:
                System.out.println("Erase that thing on screen");
                break;
            default:
                System.out.println("No valid icon selected");
        }
    }

    public void mouseDown() {
        switch (currTool) {
            case SELECTION:
                System.out.println("Selection icon");
                break;
            case BRUSH:
                System.out.println("Brush icon");
                break;
            case ERASER:
                System.out.println("Eraser icon");
                break;
            default:
                System.out.println("No valid icon selected");
        }
    }
}
