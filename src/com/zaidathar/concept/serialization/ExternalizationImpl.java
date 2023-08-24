package com.zaidathar.concept.serialization;

import java.io.*;

public class ExternalizationImpl {
    public static void main(String[] args) {
        ExampleExternalization externalization = new ExampleExternalization("Externalization",34,"+91919191919");
        System.out.println("Static field before "+ExampleExternalization.num);
        ExampleExternalization.num = 549380;
        String file = "/home/zaid/JavaMine/externalization.ser";
        try{

            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(externalization);
            System.out.println("Serialization completed using externalization");
            fos.close();
            oos.close();
        }
        catch (IOException e){
            System.out.println("Exception caught for IOException "+e.getMessage());
        }

        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ExampleExternalization ex = (ExampleExternalization) ois.readObject();
            System.out.println("Deserialization completed using externalization");
            System.out.println("Object is "+ex);
            fis.close();
            ois.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println("Static field after "+ExampleExternalization.num);
    }
}
