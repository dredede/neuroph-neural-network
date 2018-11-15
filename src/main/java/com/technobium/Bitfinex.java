package com.technobium;

import com.btf.TickerBTCUSD;
import com.btf.TradesBTCUSD;
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
        Bitfinex lsBts = new Bitfinex ();
        List <Double>  doubleListBitPrice  =lsBts.getListBitPrice("buy");
        System.out.println("Buy->Max->"+ Collections.max(doubleListBitPrice ));
        System.out.println("Buy->Min->"+ Collections.min(doubleListBitPrice ));
        TickerBTCUSD ticker = new TickerBTCUSD();
        ticker= lsBts.getBitTicker();
        System.out.println(ticker);
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
            List <Double> listAmount = new ArrayList<Double>();
            for (int i = 0; i < tradesBTCUSD.length; i++
                    ) {
              //  System.out.println( "#"+i + tradesBTCUSD[i].toString());
                if ( tradesBTCUSD[i].getType().equals( getType )) {
                    listAmount.add(tradesBTCUSD[i].getPrice());
                }
            }
            return listAmount;
        }

    public    TickerBTCUSD  getBitTicker ( ) {

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("https://api.bitfinex.com/v1/pubticker/btcusd").build());
        // getting   data
        TickerBTCUSD tickerBTCUSD = new TickerBTCUSD();
        System.out.println("Convert JSON to person object");
        tickerBTCUSD = service.accept(MediaType.APPLICATION_JSON).get(TickerBTCUSD.class);

        return tickerBTCUSD;
    }

}