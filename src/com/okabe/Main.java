package com.okabe;


import com.okabe.card.Card;

public class Main {

    public static void main(String[] args) {
        // argsエラーチェック
        final Gacha gacha = new Gacha();

        try {
            boolean argsCheck = gacha.isError(args);
            if (argsCheck) {
                return;
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        int normalCount = Integer.parseInt(args[0]);
        int specialCount = Integer.parseInt(args[1]);

        gacha.doGacha(normalCount, specialCount);

        final Card card = new Card();

        card.draw();
    }
}
