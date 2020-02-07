package com.okabe;

import static com.okabe.Gacha.*;

public class Main {

    public static void main(String[] args) {
        // argsエラーチェック
        try {
            boolean argsCheck = isError(args);
            if (argsCheck) {
                return;
            }
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        int normalCount = Integer.parseInt(args[0]);
        int specialCount = Integer.parseInt(args[1]);

        doGacha(normalCount, specialCount);
    }
}
