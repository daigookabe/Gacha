package com.okabe;

public class GachaView {
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

    private static String gachaTypeJudgment(int gachaType) {
        String gachaTypeJudgment;

        switch (gachaType) {
            case GachaConstants.GACHA_TYPE_NORMAL:
                gachaTypeJudgment = "通常確率";
                break;
            case GachaConstants.GACHA_TYPE_SPECIAL:
                gachaTypeJudgment = "⭐️スペシャルオッズ⭐️";
                break;
            default:
                gachaTypeJudgment = "設定無し";
                break;
        }

        return gachaTypeJudgment;
    }

    public static void printRoundAndType(int round, int gachaType) {
        System.out.println("【" + round + "連目】　" + gachaTypeJudgment(gachaType));
    }
}
