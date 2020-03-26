package com.okabe;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner scan = new Scanner(System.in);
        int normalCount = 0;
        int specialCount = 0;
        int count = 0;

        System.out.println("どのガチャを引きますか？\n1：メダロットガチャ　2：ミニ四駆ガチャ");

        int gachaNumber = scan.nextInt();
        System.out.println("引くガチャ ： " + GachaView.gachaSelect(gachaNumber));

        if (gachaNumber == 1) {
            System.out.println("ノーマルチケットは何枚使用しますか？");
            normalCount = scan.nextInt();

            System.out.println("スペシャルチケットは何枚使用しますか？");
            specialCount = scan.nextInt();
        } else {
            System.out.println("何回引きますか？");
            count = scan.nextInt();
        }

        System.out.println("---------------------------------");
        System.out.println("引くガチャ ： " + GachaView.gachaSelect(gachaNumber));
        if (gachaNumber == 1) {
            System.out.println("ノーマルチケット ： " + normalCount + "枚");
            System.out.println("スペシャルチケット ： " + specialCount + "枚");
        } else {
            System.out.println("引く回数 ： " + count + "回");
        }
        System.out.println("---------------------------------");
        System.out.println("でよろしいですか？\n1：はい　2：いいえ");

        int judge = scan.nextInt();

        if(judge == 2) {
            System.out.println("処理を中止します");
            System.exit(0);
        } else if (judge == 1) {
            GachaController.doGacha(gachaNumber, normalCount, specialCount, count);
        } else {
            System.out.println("!!!値が不正です!!!");
        }
    }
}
