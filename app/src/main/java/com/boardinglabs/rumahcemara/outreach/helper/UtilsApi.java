package com.boardinglabs.rumahcemara.outreach.helper;

public class UtilsApi {

    // 10.0.2.2 ini adalah localhost.
//    public static final String BASE_URL_API = "http://37.72.172.144/rumah-cemara-api/public/api/";
    public static final String BASE_URL_API = "http://68.183.226.23/rumah-cemara-api/public/api/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }

}
