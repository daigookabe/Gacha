package com.okabe;

import com.okabe.data.Rarity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class Gacha {
    static long seed = System.currentTimeMillis() + Runtime.getRuntime().freeMemory();
    static Random random = new Random(seed);

    public static void doGacha (int normalTicketCount, int specialTicketCount) {
        // ノーマルチケットを使った場合
        System.out.println("------ノーマルチケット結果------");
        if (normalTicketCount == 0){
            System.out.println("チケットを使用していません");
        } else {
            for (int normalRound = 1; normalRound <= normalTicketCount; normalRound++){
                if (normalRound % 10 == 0) {
                    String itemName = getSpecialGachaItem(normalRound);
                    System.out.println(itemName);
                    if (normalRound == normalTicketCount) {
                        break;
                    }
                } else {
                    String itemName;
                    itemName = getNormalGachaItem(normalRound);
                    System.out.println(itemName);
                }
            }
        }

        // スペシャルチケットを使った場合
        System.out.println("\n------スペシャルチケット結果------");
        if (specialTicketCount == 0){
            System.out.println("チケットを使用していません");
        } else {
            for (int specialRound = 1; specialRound <= specialTicketCount; specialRound++){
                String itemName = getSpecialGachaItem(specialRound);
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
    public static String getNormalGachaItem(int normalRound) {
        int rand = random.nextInt(99);
        System.out.println("【" + normalRound + "連目】　(通常確率)");
        Rarity rarity = new Rarity(1, 1, "★★★　メダロット一式", 3, 100);

        //ファイル読み込みで使用する３つのクラス
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferReader = null;

        try {
            //読み込みファイルのインスタンス生成
            //ファイル名を指定する
            fileInputStream = new FileInputStream("rarity.csv");
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferReader = new BufferedReader(inputStreamReader);

            //読み込み行
            String line;

            //読み込み行数の管理
            int i = 0;

            //列名を管理する為の配列
            String[] arr = null;

            //1行ずつ読み込みを行う
            while ((line = bufferReader.readLine()) != null) {

                //先頭行は列名
                if (i == 0) {

                    //カンマで分割した内容を配列に格納する
                    // arr = {"ID", "ticketType", "itemName", "odds", "sumOdds"};
                    arr = line.split(",");

                } else {

                    //データ内容をコンソールに表示する
                    System.out.println("-------------------------------");

                    //データ件数を表示
                    System.out.println("データ" + i + "件目");

                    //カンマで分割した内容を配列に格納する
                    String[] data = line.split(",");

                    //配列の中身を順に表示する。列数(=列名を格納した配列の要素数)分繰り返す
                    int colno = 0;
                    for (String column : arr) {
                        System.out.println(column + ":" + data[colno]);
                        colno++;
                    }
                }

                //行数のインクリメント
                i++;
            }


        } catch (Exception e) {
            // todo:エラー処理は後でやる
            System.out.println("!!ERROR!!");
        } finally {
            try {
                bufferReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (rand <= rarity.sumOdds - 1) {
            return rarity.itemName;
        }
//        if (rand <= 19) {
//            return "★★★　メダロットパーツ";
//        }
//        if (rand <= 31) {
//            return "★★　メダロット一式";
//        }
        return "★★　メダロットパーツ";
    }

    // スペシャルガチャのオッズ
    public static String getSpecialGachaItem(int specialRound) {
        int rand = random.nextInt(99);
        System.out.println("【" + specialRound + "連目】　(⭐️スペシャルオッズ⭐️)");

        if (rand <= 19) {
            return "★★★　メダロット一式";
        }
        return "★★★　メダロットパーツ";
    }


}
