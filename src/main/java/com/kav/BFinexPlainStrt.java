package com.kav;

import java.io.IOException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.apache.http.client.ClientProtocolException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
public class BFinexPlainStrt {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("https://api.bitfinex.com/v1/trades/BTCUSD").build());

        // getting   data
        System.out.println(service.accept(MediaType.APPLICATION_JSON).get(String[].class));

    }
}


