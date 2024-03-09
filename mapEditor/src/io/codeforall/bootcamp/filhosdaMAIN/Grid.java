package io.codeforall.bootcamp.filhosdaMAIN;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.FileOutputStream;

public class Grid {

    Cursor cursor;
    CursorControls cursorControls;
    int PADDING = 10;

    private int cellInitialX = 0 + PADDING;
    private int cellInitialY = 0 + PADDING;

    private int cellSize;
    private Rectangle[][] cellArr;
    private Color[][] cellColor;


    public Grid(int xSize, int ySize, int cellSize) {
        this.cellArr = new Rectangle[xSize][ySize];
        this.cellSize = cellSize;
        this.cellColor = new Color[xSize][ySize];
        this.cursorControls = new CursorControls();
    }

    public void gridDraw() {
        for (int i = 0; i < cellArr.length; i++) {
            for (int j = 0; j < cellArr[i].length; j++) {
                cellArr[i][j] = new Rectangle(cellInitialX, cellInitialY, cellSize, cellSize);
                cellArr[i][j].draw();
                cellInitialX = cellInitialX + cellSize;
                if (cellInitialX >= cellSize * cellArr[i].length) {
                    cellInitialX = 0 + PADDING;
                }
            }
            cellInitialY = cellInitialY + cellSize;
        }
    }

    public void cursorInit() {
        this.cursor = new Cursor(cellSize);
        cursor.cursorDraw();
        cursorControls.cursorControllerInniter(this, cursor);
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getGridMaxX() {
        return (cellArr.length * cellSize) + PADDING;
    }

    public int getGridMaxY() {
        return (cellArr.length * cellSize) + PADDING;
    }

    public Grid getGrid() {
        return this;
    }

    public int getPADDING() {
        return PADDING;
    }

    public Color getCurrentCellColor() {
        return cellColor[cursor.getCursorCoor()[0]][cursor.getCursorCoor()[1]];
    }

    public void paintCell(Color color) {
        cellArr[cursor.getCursorCoor()[0]][cursor.getCursorCoor()[1]].setColor(color);
        cellArr[cursor.getCursorCoor()[0]][cursor.getCursorCoor()[1]].fill();
        cellColor[cursor.getCursorCoor()[0]][cursor.getCursorCoor()[1]] = color;
        if (color.equals(Color.BLACK)) {
            cursor.setCursorColor(Color.WHITE);
            cursor.cursorDraw();
        }
        if (color.equals(Color.WHITE)) {
            cellArr[cursor.getCursorCoor()[0]][cursor.getCursorCoor()[1]].setColor(Color.BLACK);
            cellArr[cursor.getCursorCoor()[0]][cursor.getCursorCoor()[1]].draw();
            cellColor[cursor.getCursorCoor()[0]][cursor.getCursorCoor()[1]] = color;
        }
    }

//    public void save() {
//        FileOutputStream outputStream = new FileOutputStream("files");
//        byte b = 0x37;
//        outputStream.write(b);
//    }
//
//    public void load() {
//
//    }

}