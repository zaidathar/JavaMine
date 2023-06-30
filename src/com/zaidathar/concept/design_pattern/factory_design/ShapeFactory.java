package com.zaidathar.concept.design_pattern.factory_design;

public class ShapeFactory {

    public static Shape getShapeInstance(String name){
        if(name.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }
        else if(name.equalsIgnoreCase("SQUARE")){
            return new Square();
        }

        return null;
    }
    
}
