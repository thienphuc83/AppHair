package com.example.hair.server;

public class APIService {

    private static String base_url = "https://treesshop.000webhostapp.com/ServerAppHair/";

    public static DataService getService(){
        return APIRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
