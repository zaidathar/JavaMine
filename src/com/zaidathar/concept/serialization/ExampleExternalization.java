package com.zaidathar.concept.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ExampleExternalization extends ParentClass implements Externalizable {

    public static final long serialVersionUID = -726873927901L;
    private String name;
    private Integer age;
    private transient String phone;
    public static Integer num = 29821;

    // For Externalization we need define no-args constructor else we get exception
    public ExampleExternalization(){
        System.out.println("Externalization constructors ..");
    }

    public ExampleExternalization(String name, Integer age, String phone){
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    @Override
    public String toString(){
        return "Class ['name' : "+this.name+", 'age' : "+this.age+", 'phone' : "+this.phone+"]";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeObject(phone);
        out.writeInt(num);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

        name = (String) in.readObject();
        age = in.readInt();
        phone = (String) in.readObject();
        num = in.readInt();

    }
}
