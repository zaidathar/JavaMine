package com.zaidathar.utils;

public class DistanceUtils {
    public static double getDistanceByHarvesineFormula(double lat1, double lon1, double lat2, double lon2){
        double dist = 0d;

        // calculate distance between latitude and longitude
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        // convert latitudes to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Harvesine Formula 
        double a = Math.pow(Math.sin(latDistance / 2), 2) +
                Math.pow(Math.sin(lonDistance / 2), 2) *
                        Math.cos(lat1) *
                        Math.cos(lat2);

        double rad = 6371; 
        double c = 2 * Math.asin(Math.sqrt(a));
        dist = (rad * c) * 1000;
        
        return dist;
    }
}
