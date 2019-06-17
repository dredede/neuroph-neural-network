package com.technobium;

import com.btf.TickerBTCUSD;
import com.btf.TradesBTCUSD;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.client.urlconnection.HttpURLConnectionFactory;
import com.sun.jersey.client.urlconnection.URLConnectionClientHandler;
import org.apache.http.client.ClientProtocolException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            WebResource service = client.resource(
                    UriBuilder.fromUri("https://api.bitfinex.com/v1/trades/BTCUSD").build());
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
        WebResource service = client.resource(UriBuilder.fromUri(
                "https://api.bitfinex.com/v1/pubticker/btcusd").build());
        // getting   data
        TickerBTCUSD tickerBTCUSD = new TickerBTCUSD();
        System.out.println("Convert JSON to person object");
        tickerBTCUSD = service.accept(MediaType.APPLICATION_JSON).get(TickerBTCUSD.class);

        return tickerBTCUSD;
    }
    Client getClient( ){

        System.setProperty("http.proxyHost","proxy");
        System.setProperty("http.proxyPort","3128");
        System.setProperty("java.net.useSystemProxies", "true");

        ClientConfig config = new DefaultClientConfig();

        Client client = new Client(new URLConnectionClientHandler(
                new HttpURLConnectionFactory() {
                    Proxy p = null;
                    @Override
                    public HttpURLConnection getHttpURLConnection(URL url)
                            throws IOException {
                        if (p == null) {
                            if (System.getProperties().containsKey("http.proxyHost")) {
                                p = new Proxy(Proxy.Type.HTTP,
                                        new InetSocketAddress(
                                                System.getProperty("http.proxyHost"),
                                                Integer.getInteger("http.proxyPort", 3128)));
                            } else {
                                p = Proxy.NO_PROXY;
                            }
                        }
                        return (HttpURLConnection) url.openConnection(p);
                    }
                }), config);
        return  client;
    }


}