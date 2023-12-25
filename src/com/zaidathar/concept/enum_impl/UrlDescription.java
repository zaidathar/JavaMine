package com.zaidathar.concept.enum_impl;

import java.util.EnumMap;

public class UrlDescription {
    private static EnumMap<API_ENUM, String> apiDetails = new EnumMap<>(API_ENUM.class);


    static {
        System.out.println("Filling map ....");
        API_ENUM[] apiEnums = API_ENUM.values();
        for(API_ENUM apiEnum : apiEnums){
            apiDetails.put(apiEnum, apiEnum.description);
        }
    }
    public static String getDescription(String api){
        return apiDetails.get(API_ENUM.getAPI_ENUM(api));
    }
    private enum API_ENUM {
        GET_CUSTOMER("GET/api/v1/get-costumer", "get api for");

        private String api;

        private String description;

        API_ENUM(String api, String description) {
            this.api = api;
            this.description = description;
        }

        private static API_ENUM getAPI_ENUM(String api){
            for(API_ENUM apiEnum : API_ENUM.values()){
                System.out.println("url "+ apiEnum.api + " api "+ api);
                if(apiEnum.api.equalsIgnoreCase(api)){

                    return apiEnum;
                }
            }
            return null;
        }
    }
}

