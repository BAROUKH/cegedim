package com.company;

public class Output {
    private int yTour, yPiece;
    private char xTour, xPiece;
    private boolean isTaken;

    Output(char xTour, char xPiece, int yTour, int yPiece, boolean isTaken) {
        this.yTour = yTour;
        this.yPiece = yPiece;
        this.xTour = xTour;
        this.xPiece = xPiece;
        this.isTaken = isTaken;
    }

    @Override
    public String toString() {
        return String.format("T%c%d%s%c%d", xTour, yTour, isTaken ? "x" : "-", xPiece, yPiece);
    }
}
