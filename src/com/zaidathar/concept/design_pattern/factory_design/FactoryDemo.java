package com.zaidathar.concept.design_pattern.factory_design;

import java.util.Objects;

public class FactoryDemo {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShapeInstance("rectangle");
        if(Objects.nonNull(shape))
            shape.getShape();
        else
            System.out.println("wrong shape provided");

    }
}
