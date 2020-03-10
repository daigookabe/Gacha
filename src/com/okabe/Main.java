package com.okabe;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        System.out.println("どのガチャを引きますか？\n1：メダロットガチャ　2：ミニ四駆ガチャ");

        Scanner scan = new Scanner(System.in);

        int gachaNumber = scan.nextInt();

        System.out.println("ノーマルチケットは何枚使用しますか？");

        int normalCount = scan.nextInt();

        System.out.println("スペシャルチケットは何枚使用しますか？");

        int specialCount = scan.nextInt();

        System.out.println("---------------------------------");
        System.out.println("引くガチャ ： " + printData.gachaSelect(gachaNumber));
        System.out.println("ノーマルチケット ： " + normalCount + "枚");
        System.out.println("スペシャルチケット ： " + specialCount + "枚");
        System.out.println("---------------------------------");
        System.out.println("でよろしいですか？\n1：はい　2：いいえ");

        int judge = scan.nextInt();

        if(judge == 2) {
            System.out.println("処理を中止します");
            System.exit(0);
        } else {
            Gacha.doGacha(normalCount, specialCount);
        }
    }
}
