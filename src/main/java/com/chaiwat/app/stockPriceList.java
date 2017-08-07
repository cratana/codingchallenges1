package com.chaiwat.app;

import java.util.ArrayList;

/**
 * Created by cratana on 7/12/2017 AD.
 */
public class stockPriceList {
    String date;
    float openPrice;
    float highPrice;
    float lowPrice;
    float closedPrice;
    float diffPrice;
    float diffPercentPrice;
    float volumeTotal;
    float valueTotal;

    public stockPriceList(String date, float openPrice, float highPrice, float lowPrice, float closedPrice,
                          float diffPrice, float diffPercentPrice, float volumeTotal, float valueTotal)
    {
        this.date = date;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closedPrice = closedPrice;
        this.diffPrice = diffPrice;
        this.diffPercentPrice = diffPercentPrice;
        this.volumeTotal = volumeTotal;
        this.valueTotal = valueTotal;
    }

    public stockPriceList()
    {

    }

    @Override
    public String toString() {
        return "stockPriceList{" +
                "date='" + date + '\'' +
                ", openPrice=" + openPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                ", closedPrice=" + closedPrice +
                ", diffPrice=" + diffPrice +
                ", diffPercentPrice=" + diffPercentPrice +
                ", volumeTotal=" + volumeTotal +
                ", valueTotal=" + valueTotal +
                '}';
    }



}

