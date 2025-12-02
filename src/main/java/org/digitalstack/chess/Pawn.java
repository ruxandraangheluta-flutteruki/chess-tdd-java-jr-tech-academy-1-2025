package org.digitalstack.chess;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public void setPieceColor(PieceColor value) {
        this.pieceColor = value;
    }

    public void move(MovementType movementType, int newX, int newY) {
        if (!chessBoard.isLegalBoardPosition(newX, newY)) {
            return;
        }

        switch (movementType) {
            case MOVE:
                int direction;

                if (this.pieceColor == PieceColor.WHITE) {
                    direction = 1;
                } else {
                    direction = -1;
                }

                if (newX == this.xCoordinate && newY == this.yCoordinate + direction) {
                    this.xCoordinate = newX;
                    this.yCoordinate = newY;
                }
                break;

            case CAPTURE:
                break;
        }
    }

    @Override
    public String toString() {
        return currentPositionAsString();
    }

    protected String currentPositionAsString() {
        return String.format("Current X: %s\nCurrent Y: %s\nPiece Color: %s", xCoordinate, yCoordinate, pieceColor);
    }
}