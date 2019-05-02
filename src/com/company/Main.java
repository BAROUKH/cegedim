package com.company;

import java.util.List;

public class Main {
    public static void main(String[] str) {
        CaseContainer caseContainerTour = new CaseContainer('d', 5, new Case(Types.AMI));
        Echiquier echiquier = initialize(caseContainerTour);

        List<Output> outputs = echiquier.Treatment(caseContainerTour);

        for (Output output : outputs) {
            System.out.println(output);
        }
    }

    private static Echiquier initialize(CaseContainer caseContainer) {
        Echiquier echiquier = new Echiquier();
        echiquier.setCase(caseContainer);
        echiquier.setCase(new CaseContainer('g', 5, new Case(Types.AMI)));
        echiquier.setCase(new CaseContainer('d', 2, new Case(Types.AMI)));
        echiquier.setCase(new CaseContainer('d', 7, new Case(Types.ENNEMI)));
        return echiquier;
    }
}

