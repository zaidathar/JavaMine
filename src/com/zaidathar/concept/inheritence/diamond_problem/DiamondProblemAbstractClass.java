package com.zaidathar.concept.inheritence.diamond_problem;

public abstract class DiamondProblemAbstractClass implements DiamondProblemInterface1, DiamondProblemInterface2{

    /**

      If this abstract class is empty, it will not give error to implemented interface's method
      as we will be implementing those abstract methods in those classes who are extending this class.

     */


    /**

      If we make abstract method with same name as Interface method it will not impact on abstract
      but class need to implement this method who is extending this abstract class.

     */
    //    public abstract void printMyName();

    /**
     * If we implement abstract method then no need to implement in class that are extending this abstract class
     */
    @Override
    public void printMyName() {
        System.out.println("Hi my name is Zaid");
    }
}
