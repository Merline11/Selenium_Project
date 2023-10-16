package uk.axone.framework.oopsrefresher;

/**
*
 * Car IS-A Vehicle
 * IS-A  Relationship
 * Inheritance applied
 */
public class Car extends Vehicle {

    public String yearOfMaking;

    // Aggregation
    // HAS-A Relationship
    // Car HAS-A Vehicle (car and vehicle is a unrelated classes)
    public Engine myEngine;

    public void navigationalSystem() {
        System.out.println("I am inside Car's GPS/NavigationalSystem method");
    }

    public static void main(String[] args) {
         Car tesla = new Car();
        tesla.yearOfMaking = "123";
        tesla.nameOfTheVehicle = "hello";

        tesla.navigationalSystem();
        tesla.accelerate();
    }
}
