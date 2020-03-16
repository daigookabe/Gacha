package com.okabe;

import java.util.Scanner;

public class printData {
    public static String gachaSelect(int gachaNumber) {
        String gachaName;
        if(gachaNumber == 1) {
            gachaName = "メダロットガチャ";
        } else if(gachaNumber == 2){
            gachaName = "ミニ四駆ガチャ";
        } else {
            gachaName = "";
        }

        return gachaName;
    }

    public static String ticketJudgment(int gachaType) {
        String ticketJudgment;

        if(gachaType == 1) {
            ticketJudgment = "通常確率";
        } else if(gachaType == 2) {
            ticketJudgment = "⭐️スペシャルオッズ⭐️";
        } else {
            ticketJudgment = "";
        }

        return ticketJudgment;
    }

    public static int normalGachaCountNumber(int normalRound) {
        int normalGachaCountNumber;

        normalGachaCountNumber = normalRound;
        return normalGachaCountNumber;
    }

    public static int specialGachaCountNumber(int SpecialRound) {
        int specialGachaCountNumber;

        specialGachaCountNumber = SpecialRound;
        return specialGachaCountNumber;
    }
}
