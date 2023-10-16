package uk.axone.alertsandmousemovements;

import org.testng.annotations.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHowSetCollectionWorks {

    @Test
    public void testSetCollection() {
        Set<String> citySet = new HashSet<>();
        citySet.add("London");
        citySet.add("Manchester");
        citySet.add("Edinburgh");
        citySet.add("Birmingham");
        citySet.add("Mumbai");
        citySet.add("Mumbai");
        System.out.println(citySet.size());
        citySet.add(null);
        citySet.add(null);
        System.out.println(citySet.size());

        System.out.println("------------------------Iteration 1---------------------------------");

        //iterate through the elements
        Iterator<String> itr1 = citySet.iterator();
        System.out.println(itr1.next());
        System.out.println(itr1.next());
        System.out.println(itr1.next());
        System.out.println(itr1.next());
        System.out.println(itr1.next());

        System.out.println("-------------------------Iteration 2--------------------------------");

        Iterator<String> itr2 = citySet.iterator();
        while(itr2.hasNext()) {
            System.out.println(itr2.next());
        }
        System.out.println("-------------------------Iteration 3--------------------------------");

        for (String s:citySet) {
            System.out.println(s);
        }

    }
}
