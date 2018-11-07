package com.technobium;


import com.google.common.primitives.Doubles;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.apache.http.client.ClientProtocolException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.*;


public class Bitfinex {
    public static void main(String[] args) throws ClientProtocolException, IOException {
       /*ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("https://api.bitfinex.com/v1/trades/BTCUSD").build());
        // getting   data
        TradesBTCUSD [] tradesBTCUSD = new TradesBTCUSD[1000];
        System.out.println("2. Convert JSON to person object");
        tradesBTCUSD =service.accept(MediaType.APPLICATION_JSON).get(TradesBTCUSD[].class);
        for (int i = 0; i <  tradesBTCUSD.length; i++
                ) {
            System.out.println( "#"+i + tradesBTCUSD[i].toString());
        }
        System.out.println(service.accept(MediaType.APPLICATION_JSON).get(TradesBTCUSD[].class));
        */
           //       List <Double> ListBitAmount = this.getListBitAmount();
        Bitfinex lsBts = new Bitfinex ();
        List <Double>  doubleListBitPrice  =lsBts.getListBitPrice("buy");
        System.out.println("Buy->Max->"+ Collections.max(doubleListBitPrice ));
        System.out.println("Buy->Min->"+ Collections.min(doubleListBitPrice ));
        /*for (int i = 0; i < doubleListBitPrice.size(); i++) {
            System.out.println("Buy->Max->"+doubleListBitPrice.get(i) );
        }
        */
    }

        public    List <Double>  getListBitPrice ( String getType  ) {
            int size = 1000;
            Double[] amuntTradesBTCUSD;
            ClientConfig config = new DefaultClientConfig();
            Client client = Client.create(config);
            WebResource service = client.resource(UriBuilder.fromUri("https://api.bitfinex.com/v1/trades/BTCUSD").build());
            // getting   data
            TradesBTCUSD[] tradesBTCUSD = new TradesBTCUSD[size];
            System.out.println("2. Convert JSON to person object");
            tradesBTCUSD = service.accept(MediaType.APPLICATION_JSON).get(TradesBTCUSD[].class);
            //amuntTradesBTCUSD = new Double[size];
            List <Double> listAmount = new ArrayList<Double>();
            for (int i = 0; i < tradesBTCUSD.length; i++
                    ) {
                System.out.println( "#"+i + tradesBTCUSD[i].toString());
               // amuntTradesBTCUSD[i] = tradesBTCUSD[i].getAmount();
                if ( tradesBTCUSD[i].getType().equals( getType )) {
                    listAmount.add(tradesBTCUSD[i].getPrice());
                }
            }
            //List<Double> listAmount1 =  Doubles.asList(amuntTradesBTCUSD);
            //new    Arrays.asList(amuntTradesBTCUSD.class);
            //List<Double> listAmount = Doubles.asList(1,2,3,4,5);
            return listAmount;
        }

}