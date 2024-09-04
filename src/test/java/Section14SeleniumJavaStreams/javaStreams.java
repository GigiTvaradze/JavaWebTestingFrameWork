package Section14SeleniumJavaStreams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class javaStreams {

    @Test(description = "Count the Number of names starting with alphabet G in List")
    public void withoutJavaStream(){

        ArrayList<String> names = new ArrayList<String>();
        names.add("Gigi");
        names.add("Mariami");
        names.add("Luka");
        names.add("Tamo");
        names.add("Giorgi");

        int count = 0;

        for (String name : names) {
            if (name.startsWith("G")){
                count++;
            }
        }

        System.out.println(count);
    }


    @Test
    public void withJavaStream(){
        ArrayList<String> names = new ArrayList<String>();
        /*
        ArrayList<String>: This declares a variable named names of type ArrayList<String>.
        ArrayList is a resizable array implementation in Java, part of the java.util package. It can store a dynamically sized collection of elements.

        names = new ArrayList<String>();: This instantiates the ArrayList object.
        The new keyword is used to create a new instance of the ArrayList class.
        ArrayList<String>() calls the constructor of the ArrayList class, initializing an empty list that can hold String elements.
         */

        names.add("Gigi");
        names.add("Mariami");
        names.add("Luka");
        names.add("Tamo");
        names.add("Giorgi");

        Long number = names.stream().filter(s -> s.startsWith("G")).count();
        /*
        stream() is a method provided by the Collection interface.
        A Stream is an object that allows you to perform various operations on a sequence of elements, such as filtering, mapping, and reducing, in a functional style.
        names.stream(): This converts the names list into a stream.

        filter(s -> s.startsWith("G")): This filters the elements of the stream based on a condition.
        filter is a method that takes a Predicate (a functional interface that represents a boolean-valued function.

        The lambda expression s -> s.startsWith("G") is the Predicate used here.
        s is a placeholder for each element in the stream, representing a String from the names list.
        s.startsWith("G") checks if the String s starts with the letter "G". If it does, the filter method keeps that element in the stream; otherwise, it excludes it.
         */

        System.out.println(number);

    }

    @Test
    public void jStream(){
        Long countIa =Stream.of("Gigi","Aleko","Ana","Malkhazi","mariami","nanuchia").filter(s -> s.contains("ia")).count();
        System.out.println(countIa);

        Long countLongNames =Stream.of("Gigi","Aleko","Ana","Malkhazi","mariami","nanuchia").filter(s -> s.length() > 4).count();
        System.out.println(countLongNames);

        Stream.of("Gigi","Aleko","Ana","Malkhazi","mariami","nanuchia").filter(s -> s.length() > 4).forEach(System.out::println);

        Stream.of("Gigi", "Aleko", "Ana", "Malkhazi", "mariami", "nanuchia").filter(s -> s.length() > 4).distinct().limit(1).forEach(System.out::println);
    }

    @Test(description = "Print names of length > 4 with Uppercase")
    public void jMap(){
        Stream.of("Gigi","Aleko","Ana","Malkhazi","mariami","nanuchia")
                .filter(s -> s.length() > 4)
                .filter(s -> s.endsWith("i"))
                .forEach(s -> System.out.println(s.toUpperCase()));
    }

    @Test
    public void collectListAndConvertToList(){
       List<String> listOfNamesEndsWithI = Stream.of("Gigi","Aleko","Ana","Malkhazi","mariami","nanuchia")
                .filter(s -> s.endsWith("i"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(listOfNamesEndsWithI.get(0));
    }

    @Test
    public void assignment(){
        List<Integer> num = Arrays.asList(3,123,124,1325,12,21,5,6,3,4,5,6,123,43,12,12,12);
        //print unique numbers from this array
        //sort the array

        //num.stream().distinct().forEach(System.out::println);
        //num.stream().distinct().sorted().collect(Collectors.toList()).forEach(System.out::println);

        List<Integer> secondInSortedList = num.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(secondInSortedList.get(3));
    }
}
