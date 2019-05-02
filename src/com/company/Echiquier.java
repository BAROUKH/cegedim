package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

class Echiquier {

    private static char minX = 'a';
    private static int tableLength = 8;
    private static char maxX = (char) (minX + tableLength);

    private LinkedHashMap<Character, Case[]> cases;

    Echiquier() {
        this.cases = new LinkedHashMap<>();
        for (char i = minX; i < maxX; i++) {
            this.cases.put(i, new Case[tableLength]);
        }
    }

    void setCase(char x, int y, Case aCase) {
        cases.get(x)[y - 1] = aCase;
    }

    void setCase(CaseContainer caseContainer) {
        setCase(caseContainer.getX(), caseContainer.getY(), caseContainer.get$case());
    }

    List<Output> Treatment(CaseContainer caseContainer) {
        ArrayList<Output> outputs = new ArrayList<>();
        outputs.addAll(checkVertical(caseContainer));
        outputs.addAll(checkHorizontal(caseContainer));
        return outputs;
    }


    private List<Output> checkHorizontal(CaseContainer caseContainer) {
        ArrayList<Output> output = new ArrayList<>();
        int start = caseContainer.getX() + 1;
        for (char i = (char) start; i < maxX; i++) {
            if (checkCase(caseContainer, output, i, caseContainer.getY()))
                break;
        }
        for (char i = (char) (caseContainer.getX() - 1); i >= minX; i--) {
            if (checkCase(caseContainer, output, i, caseContainer.getY()))
                break;
        }
        return output;

    }

    private List<Output> checkVertical(CaseContainer caseContainer) {
        ArrayList<Output> output = new ArrayList<>();
        for (int i = caseContainer.getY() + 1; i <= tableLength; i++) {
            if (checkCase(caseContainer, output, caseContainer.getX(), i))
                break;
        }
        for (int i = caseContainer.getY() - 1; i >= 0; i--) {
            if (checkCase(caseContainer, output, caseContainer.getX(), i))
                break;
        }
        return output;
    }


    private boolean checkCase(CaseContainer caseContainer, List<Output> output, char i, int y) {
        if (cases.get(i)[y - 1] == null) {
            output.add(new Output(caseContainer.getX(), i, caseContainer.getY(), y, false));
            return false;
        } else if (cases.get(i)[y - 1].getType() == caseContainer.get$case().getType()) {
            return true;
        } else {
            output.add(new Output(caseContainer.getX(), i, caseContainer.getY(), y, true));
            return true;
        }
    }
}
