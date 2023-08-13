package com.zaidathar.concept.inheritence.diamond_problem;

public class DiamondProblemClassImpl extends DiamondProblemAbstractClass implements DiamondProblemInterface1, DiamondProblemInterface2{
    /**
     * No need to implement printMyName method as it already implemented in out abstract class
     * If we implements both interface in this class again we are getting error for implementing abstract method.
     * as this class is child of abstract class that already implemented method of both interface
     * at the end printMyName came from interface so no need to again implement in this class.
     */

    public static void main(String[] args) {
        DiamondProblemClassImpl obj = new DiamondProblemClassImpl();
        obj.printMyName(); // this implementation came from abstract class.
    }
}
