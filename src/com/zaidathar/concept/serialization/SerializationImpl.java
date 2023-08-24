package com.zaidathar.concept.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationImpl {
    public static void main(String[] args) throws IOException {
        String file = "/home/zaid/JavaMine/serialized.ser";
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream ois = new ObjectOutputStream(fos);
        ExampleSerialization e = new ExampleSerialization("Java","Oracle co",32,"9192939495");
        ois.writeObject(e);
        ois.close();
        fos.close();
        System.out.println("Serialization completed !! ");
    }

}
