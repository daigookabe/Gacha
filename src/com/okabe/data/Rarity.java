package com.okabe.data;

import java.util.*;

public class Rarity {
    public int id;
    public int ticketType;
    public String itemName;
    public int odds;
    public int sumOdds;

    public Rarity() {}

    public Rarity(int id, int ticketType, String itemName, int odds, int sumOdds) {
        this.id = id;
        this.ticketType = ticketType;
        this.itemName = itemName;
        this.odds = odds;
        this.sumOdds = sumOdds;

    }

}
