package com.technobium;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.apache.http.client.ClientProtocolException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;


class DateDeserializer implements JsonDeserializer {

    public Date deserialize(JsonElement json, Type typeOfT,
                            JsonDeserializationContext context)
            throws JsonParseException {
        return json == null ? null : new Date(json.getAsLong());
    }
}

class DateSerializer implements JsonSerializer {
    public JsonElement serialize(Date date, Type typeOfSrc,
                                 JsonSerializationContext context) {
        return date == null ? null : new JsonPrimitive(date.getTime());
    }

    public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}

public class Bitfinex {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("https://api.bitfinex.com/v1/trades/BTCUSD").build());

        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Date.class, new DateDeserializer());
        gson.registerTypeAdapter(Date.class, new DateSerializer());
        Gson objGson = gson.setPrettyPrinting().create();
        // getting   data
        //System.out.println(service.accept(MediaType.APPLICATION_JSON).get(String.class));
        //String json  = service.accept(MediaType.APPLICATION_JSON).get(String.class);
         TradesBTCUSD [] tradesBTCUSD = new TradesBTCUSD[1000];
        //List <TradesBTCUSD> tradesBTCUSD = Arrays.asList(service.accept(MediaType.APPLICATION_JSON_TYPE).get(TradesBTCUSD[].class));

       // Type listType = new TypeToken<TradesBTCUSD>() {		}.getType();
        System.out.println("2. Convert JSON to person object");
        //System.out.println(json);
/*
        for (int i = 0; i <  json.length; i++
             ) {
            TradesBTCUSD objFromJson = objGson.fromJson(json[i], listType);
            System.out.println(objFromJson);
        }
*/
        tradesBTCUSD =service.accept(MediaType.APPLICATION_JSON).get(TradesBTCUSD[].class);
        for (int i = 0; i <  tradesBTCUSD.length; i++
             ) {
            System.out.println( "#"+i + tradesBTCUSD[i].toString());

        }

          System.out.println(service.accept(MediaType.APPLICATION_JSON).get(TradesBTCUSD[].class));



    }

}
