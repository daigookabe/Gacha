package com.okabe;

import com.okabe.data.Rarity;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MiniyonkuService extends GachaService {

    public MiniyonkuService(){};

    String csvName = "gacha_miniyonku.csv";

    @Override
    public void doGacha(int gachaNumber, int normalTicketCount, int specialTicketCount, int gachaCount) throws IOException {
        //読み込みファイルのインスタンス生成
        fileInputStream = new FileInputStream(csvName);
        inputStreamReader = new InputStreamReader(fileInputStream);
        bufferedReader = new BufferedReader(inputStreamReader);

        //1行分のデータ
        String line;

        //rarity.csvをparseする
        rarityArray = new ArrayList<Rarity>();

        //読み込み行数の初期化
        int rowNumber = 0;

        //bufferedReaderで読み込んだ内容がnullになるまで繰り返す
        while ((line = bufferedReader.readLine()) != null) {

            //Rarityクラスをインスタンス化
            Rarity rarity = new Rarity();

            // 一行目はカラム名が入っているので飛ばす
            if (rowNumber == 0) {
                rowNumber++;
                continue;
            } else {
                //カンマで分割した内容を配列に格納する
                String rarityColumns[] = line.split(",");

                //splitした各情報をそれぞれsetしていく
                int id = Integer.parseInt(rarityColumns[GachaConstants.RARITY_CSV_ID_INDEX]);
                rarity.setId(id);

                int gachaType = Integer.parseInt(rarityColumns[GachaConstants.RARITY_CSV_GACHA_TYPE_INDEX]);
                rarity.setGachaType(gachaType);

                String itemName = rarityColumns[GachaConstants.RARITY_CSV_ITEM_NAME_INDEX];
                rarity.setItemName(itemName);

                int odds = Integer.parseInt(rarityColumns[GachaConstants.RARITY_CSV_ODDS_INDEX]);
                rarity.setOdds(odds);

                int sumOdds = Integer.parseInt(rarityColumns[GachaConstants.RARITY_CSV_SUMODDS_INDEX]);
                rarity.setSumOdds(sumOdds);

                //配列rarityArrayに入れる
                rarityArray.add(rarity);
                rowNumber++;
            }
        }

        String itemName;
        int gachaType = 1;

        // ガチャをひく
        if (gachaCount == 0){
            System.out.println("回数が入力されていません");
        } else {
            try {
                for (int round = 1; round <= gachaCount; round++) {
                    // 5回目はスペシャルオッズに流す
                    if (round % 5 == 0) {
                        gachaType = GachaConstants.GACHA_TYPE_SPECIAL;
                        GachaView.printRoundAndType(round, gachaType);
                        itemName = getGachaItem(gachaType);
                        System.out.println(itemName);
                        gachaType = GachaConstants.GACHA_TYPE_NORMAL;
                        if (round == gachaCount) {
                            break;
                        }
                    } else {
                        // 通常オッズ
                        GachaView.printRoundAndType(round, gachaType);
                        itemName = getGachaItem(gachaType);
                        System.out.println(itemName);
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
                bufferedReader.close();
                throw e;
            }
        }
        System.out.println("\nEND");
    }

    // ガチャ抽選
    public static String getGachaItem(int gachaType) throws IOException {
        //ランダムの生成
        int rand = random.nextInt(99);

        //アイテム名の初期化
        String itemName = "";

        // 配列rarityArrayのガチャタイプと入力されたガチャタイプが一致しているか検証
        for (Rarity rarityFromCsv : rarityArray) {
            // 一致していなければ再検証
            if (rarityFromCsv.getGachaType() != gachaType) {
                continue;
            }
            // 一致していればitemNameにrarityArrayのアイテムをセットする
            if (rand < rarityFromCsv.getSumOdds()) {
                itemName = rarityFromCsv.getItemName();
                break;
            }
        }
        return itemName;
    }
}