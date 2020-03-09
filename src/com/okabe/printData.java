package com.okabe;

import java.util.Scanner;

public class printData {
    public static String gachaSelect(int gachaNumber) {
        String gachaName;
        if(gachaNumber == 1) {
            gachaName = "メダロットガチャ";
        } else {
            gachaName = "ミニ四駆ガチャ";
        }

        return gachaName;
    }


    //todo レアリティの実装
    public static void rarityResult(int rarityNumber) {
        String[] rarity = {"★★★★", "★★★", "★★★", "★"};

        System.out.println(rarity[rarityNumber]);
    }

    //todo　アイテム名の実装
    public static void medalotItemResult(int itemNumber) {
        String[] itemName = {"メダロット一式", "メダロットパーツ"};

        System.out.println(itemName[itemNumber]);
    }
}
