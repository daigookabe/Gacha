package com.okabe.data;

public class Rarity {
    private int id;
    private int gachaType;
    private String itemName;
    private int odds;
    private int sumOdds;

    public Rarity() {}

    public Rarity(int id, int ticketType, String itemName, int odds, int sumOdds) {
        this.id = id;
        this.gachaType = ticketType;
        this.itemName = itemName;
        this.odds = odds;
        this.sumOdds = sumOdds;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getGachaType() {
        return gachaType;
    }

    public void setGachaType(int gachaType) {
        this.gachaType = gachaType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getOdds() {
        return odds;
    }

    public void setOdds(int odds) {
        this.odds = odds;
    }

    public int getSumOdds() {
        return sumOdds;
    }

    public void setSumOdds(int sumOdds) {
        this.sumOdds = sumOdds;
    }
}
