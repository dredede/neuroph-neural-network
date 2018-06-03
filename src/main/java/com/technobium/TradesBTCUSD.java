package com.technobium;


import java.text.SimpleDateFormat;
import java.time.*;
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

       int tid ;
       Long timestamp ;
       Double price ;
       Double amount;
       String exchange;
       String type;

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
        ZoneId sourceZone = ZoneId.of("UTC");
        ZoneId targetZone = ZoneId.of("CET");
        Date currentDate = new Date(timestamp*1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return  " price >" + price +  " amount >"+amount  +" time >"
                + dateFormat.format(currentDate);
               // +Instant.ofEpochMilli(timestamp).atOffset(ZoneOffset.of("Z")).withOffsetSameLocal(ZoneOffset.of("+2"));

        /*
                +ZonedDateTime.ofInstant(Instant.ofEpochMilli(timestamp), sourceZone)
                .withZoneSameLocal(targetZone)
                .toString();*/
               // +timestamp;
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