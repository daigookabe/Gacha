package com.okabe;

import java.io.*;

public class GachaController {
    public static void doGacha (int gachaNumber, int normalTicketCount, int specialTicketCount, int count) throws IOException {
        GachaInterface medalotService = new MedalotService();
        medalotService.doGacha(gachaNumber, normalTicketCount, specialTicketCount, count);
    }
}

