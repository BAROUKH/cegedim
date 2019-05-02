package com.company;

class CaseContainer {
    private Case $case;
    private char x;
    private int y;

    CaseContainer(char x, int y, Case $case) {
        this.$case = $case;
        this.x = x;
        this.y = y;
    }

    Case get$case() {
        return $case;
    }

    char getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
