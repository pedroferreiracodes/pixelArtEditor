package io.codeforall.bootcamp.filhosdaMAIN;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    private Rectangle cursorPointer;
    private int cellSize;
    private Rectangle[] thickRec;
    Color currentCursorColor;
    int PADDING = 10;

    public Cursor(int cellSize) {
        this.cursorPointer = new Rectangle((cellSize * 3)+PADDING, (cellSize * 5)+PADDING, cellSize, cellSize);
        this.cellSize = cellSize;
        this.thickRec = new Rectangle[0];
        this.currentCursorColor = Color.BLACK;
    }

    public void cursorDraw() {
        cursorPointer.setColor(currentCursorColor);
        cursorPointer.draw();
        cursorThickener(this, cellSize, currentCursorColor);
    }

    public void moveRight() {
        cursorDeleter();
        cursorPointer.translate(cellSize, 0);
        cursorThickener(this, cellSize, currentCursorColor);
    }

    public void moveLeft() {
        cursorDeleter();
        cursorPointer.translate(-cellSize, 0);
        cursorThickener(this, cellSize, currentCursorColor);
    }

    public void moveUp() {
        cursorDeleter();
        cursorPointer.translate(0, -cellSize);
        cursorThickener(this, cellSize, currentCursorColor);
    }

    public void moveDown() {
        cursorDeleter();
        cursorPointer.translate(0, cellSize);
        cursorThickener(this, cellSize, currentCursorColor);

    }


    public int[] getCursorCoor() {
        int yCoor = getCursorX() / cellSize;
        int xCoor = getCursorY() / cellSize;
        return new int[]{xCoor, yCoor};
    }

    public int getCursorX() {
        return cursorPointer.getX();
    }

    public int getCursorMaxX() {
        return cursorPointer.getX() + cursorPointer.getWidth();
    }

    public int getCursorY() {
        return cursorPointer.getY();
    }

    public int getCursorMaxY() {
        return cursorPointer.getY() + cursorPointer.getHeight();
    }

    public Rectangle[] cursorThickener(Cursor cursor, int cellSize, Color color) {
        int thickCalc = (int) Math.ceil(cellSize / 9);
        thickRec = new Rectangle[thickCalc];
        for (int i = thickRec.length - 1; i >= 0; i--) {
            thickRec[i] = new Rectangle(cursor.cursorPointer.getX() + i, cursor.cursorPointer.getY() + i, cellSize - 2 * i, cellSize - 2 * i);
            thickRec[i].setColor(color);
            thickRec[i].draw();
        }
        return thickRec;
    }

    public void cursorDeleter() {
        for (Rectangle rectangle : thickRec) {
            rectangle.delete();
        }
    }

    public void setCursorColor(Color color) {
        this.cursorPointer.setColor(color);
    }
}
