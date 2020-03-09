package com.okabe;

import java.util.Random;

public class Gacha {
    static long seed = System.currentTimeMillis() + Runtime.getRuntime().freeMemory();
    static Random random = new Random(seed);

    public static void doGacha (int normalCount, int specialCount) {
        // ノーマルチケットを使った場合
        if (normalCount == 0){
            System.out.println("---ノーマルチケット結果---\nチケットを使用していません");
        } else {
            System.out.println("\n---ノーマルチケット結果---");
            for (int iNormal = 1; iNormal <= normalCount; iNormal++){
                if (iNormal != 1 && iNormal % 10 == 0) {
                    String itemName = getSpecialGachaItem(iNormal, normalCount);
                    System.out.println(itemName);
                    if (iNormal == normalCount) {
                        break;
                    }
                } else {
                    String itemName;
                    itemName = getNormalGachaItem(iNormal, normalCount);
                    System.out.println(itemName);
                }
            }
        }

        // スペシャルチケットを使った場合
        if (specialCount == 0){
            System.out.println("\n---スペシャルチケット結果---\nチケットを使用していません");
        } else {
            System.out.println("\n---スペシャルチケット結果---");
            for (int iSpecial = 1; iSpecial <= specialCount; iSpecial++){
                String itemName = getSpecialGachaItem(iSpecial, specialCount);
                System.out.println(itemName);
            }
        }
    }

    // argsのチェック
    public static boolean isError(String[] args) {
        boolean argsCheck = false;
        String argsCheckResult = "";

        // argsの長さチェック
        if (args.length == 0) {
            argsCheckResult = "!!引数を設定してください!!";
        } else if (args.length == 1) {
            argsCheckResult = "!!引数が少ないです!!";
        } else if (args.length >= 3) {
            argsCheckResult = "!!引数が多いです!!";
        }

        // 有効値チェック
        if (0 == Integer.parseInt(args[0]) + Integer.parseInt(args[1])) {
            argsCheckResult = "!!引数に1以上を設定してください!!";
        }

        // TODO 範囲チェック実装

        if (argsCheckResult.length() != 0) {
            throw new IllegalArgumentException(argsCheckResult);
        }

        System.out.println(argsCheckResult);
        return argsCheck;
    }

    // ノーマルガチャのオッズ
    public static String getNormalGachaItem(int count, int time) {
        String itemName;
        int num = random.nextInt(101);
        System.out.println("【" + count + "連目】　(通常確率)");

        if (0 <= num && num<= 2) {
            itemName = "★★★　星3メダロット一式";
        } else if (3 <= num && num <= 19) {
            itemName = "★★★　星3メダロットパーツ";
        } else if (20 <= num && num <= 31) {
            itemName = "★★　星2メダロット一式";
        } else {
            itemName = "★★　星2メダロットパーツ";
        }
        return itemName;
    }

    // スペシャルガチャのオッズ
    public static String getSpecialGachaItem(int count, int time) {
        String itemName;
        int num = random.nextInt(101);
        System.out.println("【" + count + "連目】　(⭐️スペシャルオッズ⭐️)");

        if (0 <= num && num<= 19) {
            itemName = "★★★　星3メダロット一式";
        } else {
            itemName = "★★　星2メダロット一式";
        }
        return itemName;
    }
}
