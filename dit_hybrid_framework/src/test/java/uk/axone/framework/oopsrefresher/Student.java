package uk.axone.framework.oopsrefresher;

public class Student {

    public String name;
    public int rollNumber;
    //Aggregation
    public Address address;

    public Student(String name, int rollNumber, Address address) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.address = address;
    }

    public void printStudent(){
        System.out.println("Name of the student : "+name +", their roll number :" +rollNumber);
        System.out.println("They live in: "+address.city+", their state: "+address.state+", their country: "+address.country);
    }

    public static void main(String[] args) {
        Student student1 = new Student("Merline",1234, new Address("Reading","Berkshire","United Kingdom"));
        Student student2 = new Student("Jayaraj",56789, new Address("Avinashi","Coimbatore","TamilNadu"));

        student1.printStudent();
        student2.printStudent();
    }
}
