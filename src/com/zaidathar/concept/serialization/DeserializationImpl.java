package com.zaidathar.concept.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializationImpl {
    public static void main(String[] args) {
        try{
            String file = "/home/zaid/JavaMine/serialized.ser";
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            // ParentClass no-args Constructor will be call called
            ExampleSerialization e = (ExampleSerialization) ois.readObject();
            System.out.println("Deserialization completed for "+ e);
            ois.close();
            fis.close();
        }
        catch (Exception e){
            System.out.println("Exception "+e.getMessage());
        }
    }
}
