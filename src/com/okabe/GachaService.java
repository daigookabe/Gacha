package com.okabe;

import com.okabe.data.Rarity;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class GachaService implements GachaInterface {
    static long seed = System.currentTimeMillis() + Runtime.getRuntime().freeMemory();
    static Random random = new Random(seed);

    //ファイル読み込みで使用する３つのクラス
    static FileInputStream fileInputStream = null;
    static InputStreamReader inputStreamReader = null;
    static BufferedReader bufferedReader = null;

    static List<Rarity> rarityArray = null;

    public  GachaService() {}

    @Override
    public void doGacha(int gachaNumber, int normalTicketCount, int specialTicketCount, int count) throws IOException {

    }
}
