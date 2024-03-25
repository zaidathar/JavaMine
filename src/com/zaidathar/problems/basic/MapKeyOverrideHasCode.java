package com.zaidathar.problems.basic;

import java.util.HashMap;
import java.util.Map;

class MapKey{
    private String id;

    MapKey(String id){
        this.id =id;
    }

    public int hashCode(){
        // It will always return same hashCode for all object
        // which lead to collision then map will check for equal
        return 193702;
    }

    // If equals also return true for each than Map will override value not the key
//    public boolean equals(Object m){
//        return true;
//    }

    // If equals methods handled properly, Map will handle collision using Tree to store key and value
    public boolean equals(Object m){
        if(this == m)return true;
        if(this.id.equalsIgnoreCase(((MapKey)m).getId()))
            return true;
        return false;
    }

    public String getId(){
        return id;
    }
}
public class MapKeyOverrideHasCode {
    // problem : Override Key's hashCode and insert different key value pair in map
    public static void main(String[] args) {
        MapKey m1 = new MapKey("Red");
        MapKey m2 = new MapKey("Green");
        MapKey m3 = new MapKey("Yellow");

        Map<MapKey, String> map = new HashMap<>();
        map.put(m1,"1");
        map.put(m2,"2");
        map.put(m3,"3");
        map.put(m1,"4");

        map.entrySet().stream().forEach(e-> System.out.println(e.getKey().getId()+" -> "+e.getValue()));




    }
}
