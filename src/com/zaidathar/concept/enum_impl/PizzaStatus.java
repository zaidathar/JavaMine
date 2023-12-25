package com.zaidathar.concept.enum_impl;

import java.util.HashMap;
import java.util.Map;

public enum PizzaStatus {
    ORDERED (5,"5"){
        @Override
        public boolean isOrdered() {
            return true;
        }

        @Override
        public void setValue(){
            map.put(ORDERED,"Ordered");
        }
    },
    READY (2, "2"){
        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setValue(){
            map.put(READY,"Ready");
        }
    },
    DELIVERED (0, "0"){
        @Override
        public boolean isDelivered() {
            return true;
        }

        @Override
        public void setValue(){
            map.put(DELIVERED,"Delivered");
        }
    };




    private int timeToDelivery;
    private String value;
    private static Map<PizzaStatus , String> map = new HashMap<>();
    public boolean isOrdered() {return false;}

    public boolean isReady() {return false;}

    public boolean isDelivered(){return false;}

    public void setValue(String value){

    }

    public int getTimeToDelivery() {
        return timeToDelivery;
    }

    public String getValue(){
        return map.get(this);
    }

    PizzaStatus (int timeToDelivery, String value) {
        this.timeToDelivery = timeToDelivery;
        this.value = value;
    }

    public abstract void setValue();
}
