package com.okabe;

import java.io.IOException;

public interface GachaInterface {
    //メソッドの名前、引数。戻り値の型だけ定義
    void doGacha (int gachaNumber, int normalTicketCount, int specialTicketCount, int count)throws IOException;
}
