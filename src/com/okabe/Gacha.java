package com.okabe;

import java.io.*;
import java.util.Random;

public class Gacha {
    static long seed = System.currentTimeMillis() + Runtime.getRuntime().freeMemory();
    static Random random = new Random(seed);
    final static int NORMAL_GACHA_TYPE = 1;
    final static int SPECIAL_GACHA_TYPE = 2;


    public static void doGacha (int normalTicketCount, int specialTicketCount) throws IOException {
        // ノーマルチケットを使った場合
        System.out.println("------ノーマルチケット結果------");
        int ticketCount = normalTicketCount;

        if (ticketCount == 0){
            System.out.println("チケットを使用していません");
        } else {
            for (int round = 1; round <= normalTicketCount; round++){
                if (round % 10 == 0) {
                    String itemName = getSpecialGachaItem(round);
                    System.out.println(itemName);
                    if (round == normalTicketCount) {
                        break;
                    }
                } else {
                    String itemName;
                    itemName = getNormalGachaItem(round);
                    System.out.println(itemName);
                }
            }
        }

        // スペシャルチケットを使った場合
        System.out.println("\n------スペシャルチケット結果------");
        ticketCount = normalTicketCount;

        if (ticketCount == 0){
            System.out.println("チケットを使用していません");
        } else {
            for (int round = 1; round <= specialTicketCount; round++){
                String itemName = getSpecialGachaItem(round);
                System.out.println(itemName);
            }
        }

        System.out.println("\nEND");
    }

//    // argsのチェック
//    public static boolean isError(String[] args) {
//        boolean argsCheck = false;
//        String argsCheckResult = "";
//
//        // argsの長さチェック
//        if (args.length == 0) {
//            argsCheckResult = "!!引数を設定してください!!";
//        } else if (args.length == 1) {
//            argsCheckResult = "!!引数が少ないです!!";
//        } else if (args.length >= 3) {
//            argsCheckResult = "!!引数が多いです!!";
//        }
//
//        // 有効値チェック
//        if (0 == Integer.parseInt(args[0]) + Integer.parseInt(args[1])) {
//            argsCheckResult = "!!引数に1以上を設定してください!!";
//        }
//
//        // TODO 範囲チェック実装
//
//        if (argsCheckResult.length() != 0) {
//            throw new IllegalArgumentException(argsCheckResult);
//        }
//
//        System.out.println(argsCheckResult);
//        return argsCheck;
//    }

    // ノーマルガチャのオッズ
    public static String getNormalGachaItem(int round) throws IOException {
        System.out.print("【" + printData.normalGachaCountNumber(round) + "連目】　");
        System.out.println(printData.ticketJudgment(round, 0));

        //ファイル読み込みで使用する３つのクラス
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        String itemName = null;

        try {
            //読み込みファイルのインスタンス生成
            //ファイル名を指定する
            fileInputStream = new FileInputStream("rarity.csv");
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);


            //ランダムの生成
            int rand = random.nextInt(99);

            //1行分のデータ
            String line;

            //読み込み行数の初期化
            int rowNumber = 0;

            //1行ずつ読み込みを行う
            while ((line = bufferedReader.readLine()) != null) {
                //カンマで分割した内容を配列に格納する
                String[] rarityColumns = line.split(",");

                if(rowNumber == 0 || Integer.parseInt(rarityColumns[1]) != NORMAL_GACHA_TYPE) {
                    rowNumber++;
                    continue;
                }

                if (rand < Integer.parseInt(rarityColumns[4])) {
                    itemName = rarityColumns[2];
                    break;
                }
                rowNumber++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return itemName;
    }

    // スペシャルガチャのオッズ
    public static String getSpecialGachaItem(int round) throws IOException {
        System.out.print("【" + printData.specialGachaCountNumber(round) + "連目】　");
        System.out.println(printData.ticketJudgment(0, round));

        //ファイル読み込みで使用する３つのクラス
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        String itemName = null;

        try {
            //読み込みファイルのインスタンス生成
            //ファイル名を指定する
            fileInputStream = new FileInputStream("rarity.csv");
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);


            //ランダムの生成
            int rand = random.nextInt(99);

            //1行分のデータ
            String line;

            //読み込み行数の初期化
            int rowNumber = 0;

            //1行ずつ読み込みを行う
            while ((line = bufferedReader.readLine()) != null) {
                //カンマで分割した内容を配列に格納する
                String[] rarityColumns = line.split(",");

                if(rowNumber == 0 || Integer.parseInt(rarityColumns[1]) != SPECIAL_GACHA_TYPE) {
                    rowNumber++;
                    continue;
                }

                if (rand < Integer.parseInt(rarityColumns[4])) {
                    itemName = rarityColumns[2];
                    break;
                }
                rowNumber++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return itemName;
    }
}

