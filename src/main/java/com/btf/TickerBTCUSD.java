package com.btf;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TickerBTCUSD {
    private  Double mid	; //[price]	(bid + ask) / 2
    private  Double bid	; //[price]	Innermost bid
    private  Double ask	; //[price]	Innermost ask
    private  Double last_price; //	[price]	The price at which the last order executed
    private  Double low	; //[price]	Lowest trade price of the last 24 hours
    private  Double high	; //[price]	Highest trade price of the last 24 hours
    private  Double volume	; //[price]	Trading volume of the last 24 hours
    private  Double timestamp ; //	[time]	The timestamp at which this information was valid

    @Override
    public String toString() {
        Date currentDate = new Date(timestamp.longValue()*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY HH:mm:ss");
        return  " last_price >" +last_price+" time >"
                + dateFormat.format(currentDate);
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getLast_price() {
        return last_price;
    }

    public void setLast_price(Double last_price) {
        this.last_price = last_price;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }
}
