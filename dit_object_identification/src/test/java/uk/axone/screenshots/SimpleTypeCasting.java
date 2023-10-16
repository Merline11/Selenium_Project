package uk.axone.screenshots;

import org.testng.annotations.Test;

public class SimpleTypeCasting {

    @Test
    public void simpleTypeCasting(){
        double salary = 99999.99;
        int simpleSalary;

        System.out.println("salary before typecasting :"+salary);
        // simpleSalary = salary; // type mismatch error
        simpleSalary = (int) salary;
        System.out.println("salary after typecasting :"+simpleSalary);
    }
}
