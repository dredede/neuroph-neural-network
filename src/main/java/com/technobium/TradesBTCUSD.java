package com.technobium;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TradesBTCUSD {
    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private int tid ;
    private Long timestamp ;
    private  Double price ;
    private   Double amount;
    private   String exchange;
    private   String type;

    /*public TradesBTCUSD(int tid, String timestamp, Double price, Double amount, String exchange, String type) {
        this.tid = tid;
        this.timestamp = timestamp;
        this.price = price;
        this.amount = amount;
        this.exchange = exchange;
        this.type = type;
    }
*/
    @Override
    public String toString() {

        Date currentDate = new Date(timestamp*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY HH:mm:ss");
        return  " price >" + price +  " amount >"+amount  +" time >"
                + dateFormat.format(currentDate);

    }
}
/*
 tid	[integer]
timestamp	[time]
price	[price]
amount	[decimal]
exchange	[string]	"bitfinex"
type	[string]
*/