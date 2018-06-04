package com.technobium;


import java.io.IOException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.apache.http.client.ClientProtocolException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;



public class Bitfinex {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        ClientConfig config = new DefaultClientConfig();
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



    }

}
