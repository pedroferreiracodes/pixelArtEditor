package io.codeforall.bootcamp.filhosdaMAIN;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class CursorControls implements KeyboardHandler {

    private Cursor cursor;
    private Keyboard keyboard;
    private String currentMove;
    private Grid grid;
    private int cellSize;

    public void cursorControllerInniter(Grid grid, Cursor cursor) {
        this.grid = grid;
        cellSize = grid.getCellSize();
        this.cursor = cursor;
        init();
    }

    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (canCursorMove("RIGHT")) {
                    currentMove = "RIGHT";
                    cursor.moveRight();
                    if (grid.getCurrentCellColor() == Color.BLACK){
                        cursor.setCursorColor(Color.WHITE);
                        cursor.cursorThickener(this.cursor, grid.getCellSize(), Color.WHITE);
                    }
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (canCursorMove("LEFT")) {
                    currentMove = "LEFT";
                    cursor.moveLeft();
                    if (grid.getCurrentCellColor() == Color.BLACK){
                        cursor.setCursorColor(Color.WHITE);
                        cursor.cursorThickener(this.cursor, grid.getCellSize(), Color.WHITE);
                    }
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (canCursorMove("UP")) {
                    currentMove = "UP";
                    this.cursor.moveUp();
                    if (grid.getCurrentCellColor() == Color.BLACK){
                        cursor.setCursorColor(Color.WHITE);
                        cursor.cursorThickener(this.cursor, grid.getCellSize(), Color.WHITE);
                    }
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (canCursorMove("DOWN")) {
                    currentMove = "DOWN";
                    cursor.moveDown();
                    if (grid.getCurrentCellColor() == Color.BLACK){
                        cursor.setCursorColor(Color.WHITE);
                        cursor.cursorThickener(this.cursor, grid.getCellSize(), Color.WHITE);
                    }
                }
                break;
            case KeyboardEvent.KEY_1:
                grid.paintCell(Color.BLACK);
                break;
            case KeyboardEvent.KEY_2:
                grid.paintCell(Color.RED);
                break;
            case KeyboardEvent.KEY_3:
                grid.paintCell(Color.MAGENTA);
                break;
            case KeyboardEvent.KEY_4:
                grid.paintCell(Color.PINK);
                break;
            case KeyboardEvent.KEY_5:
                grid.paintCell(Color.CYAN);
                break;
            case KeyboardEvent.KEY_6:
                grid.paintCell(Color.BLUE);
                break;
            case KeyboardEvent.KEY_7:
                grid.paintCell(Color.GREEN);
                break;
            case KeyboardEvent.KEY_8:
                grid.paintCell(Color.YELLOW);
                break;
            case KeyboardEvent.KEY_9:
                grid.paintCell(Color.ORANGE);
                break;
            case KeyboardEvent.KEY_0:
                grid.paintCell(Color.WHITE);
                break;
            case KeyboardEvent.KEY_T:
                grid.getCurrentCellColor();
                break;
            case KeyboardEvent.KEY_S:
                //grid.save();
                break;
            case KeyboardEvent.KEY_L:
                //grid.load();
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent e) {

    }

    private boolean canCursorMove(String currentMove) {
        if (currentMove.equals("UP")) {
            if (this.cursor.getCursorY() <= grid.getPADDING()) {
                return false;
            }
        } else if (currentMove.equals("DOWN")) {
            if (cursor.getCursorMaxY() >= grid.getGridMaxY()) {
                return false;
            }
        } else if (currentMove.equals("LEFT")) {
            if (cursor.getCursorX() <= grid.getPADDING()) {
                return false;
            }
        } else if (currentMove.equals("RIGHT")) {
            if (cursor.getCursorMaxX() >= grid.getGridMaxX()) {
                return false;
            }
        }
        return true;
    }

    public void init() {
        keyboard = new Keyboard(this);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(pressedRight);

        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(pressedLeft);

        KeyboardEvent pressedUp = new KeyboardEvent();
        pressedUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(pressedUp);

        KeyboardEvent pressedDown = new KeyboardEvent();
        pressedDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(pressedDown);

        KeyboardEvent pressed1 = new KeyboardEvent();
        pressed1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressed1.setKey(KeyboardEvent.KEY_1);
        keyboard.addEventListener(pressed1);

        KeyboardEvent pressed2 = new KeyboardEvent();
        pressed2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressed2.setKey(KeyboardEvent.KEY_2);
        keyboard.addEventListener(pressed2);

        KeyboardEvent pressed3 = new KeyboardEvent();
        pressed3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressed3.setKey(KeyboardEvent.KEY_3);
        keyboard.addEventListener(pressed3);

        KeyboardEvent pressed4 = new KeyboardEvent();
        pressed4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressed4.setKey(KeyboardEvent.KEY_4);
        keyboard.addEventListener(pressed4);

        KeyboardEvent pressed5 = new KeyboardEvent();
        pressed5.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressed5.setKey(KeyboardEvent.KEY_5);
        keyboard.addEventListener(pressed5);

        KeyboardEvent pressed6 = new KeyboardEvent();
        pressed6.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressed6.setKey(KeyboardEvent.KEY_6);
        keyboard.addEventListener(pressed6);

        KeyboardEvent pressed7 = new KeyboardEvent();
        pressed7.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressed7.setKey(KeyboardEvent.KEY_7);
        keyboard.addEventListener(pressed7);

        KeyboardEvent pressed8 = new KeyboardEvent();
        pressed8.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressed8.setKey(KeyboardEvent.KEY_8);
        keyboard.addEventListener(pressed8);

        KeyboardEvent pressed9 = new KeyboardEvent();
        pressed9.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressed9.setKey(KeyboardEvent.KEY_9);
        keyboard.addEventListener(pressed9);

        KeyboardEvent pressed0 = new KeyboardEvent();
        pressed0.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressed0.setKey(KeyboardEvent.KEY_0);
        keyboard.addEventListener(pressed0);

        KeyboardEvent pressedT = new KeyboardEvent();
        pressedT.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedT.setKey(KeyboardEvent.KEY_T);
        keyboard.addEventListener(pressedT);

        KeyboardEvent pressedS = new KeyboardEvent();
        pressedS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedS.setKey((KeyboardEvent.KEY_S));
        keyboard.addEventListener(pressedS);

        KeyboardEvent pressedL = new KeyboardEvent();
        pressedL.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedL.setKey((KeyboardEvent.KEY_L));
        keyboard.addEventListener(pressedL);
    }

}
