package uk.axone.extentreports;

import java.util.Date;

public class DateFormatter {

    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d.toString().replace(" ","-").replace(":","_"));
    }
}
