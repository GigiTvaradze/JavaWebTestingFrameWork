package Section3JavaConcepts;

import org.testng.annotations.Test;

public class javaConcept {
    //Java Variables

    /*
    String - stores text, such as "Hello". String values are surrounded by double quotes
    int - stores integers (whole numbers), without decimals, such as 123 or -123
    float - stores floating point numbers, with decimals, such as 19.99 or -19.99
    char - stores single characters, such as 'a' or 'B'. Char values are surrounded by single quotes
    boolean - stores values with two states: true or false
    */

    //Data Types

    int myNum = 5;               // Integer (whole number)
    float myFloatNum = 5.99f;    // Floating point number
    char myLetter = 'D';         // Character
    boolean myBool = true;       // Boolean
    String myText = "Hello";     // String


    /*
    Data types are divided into two groups:
    Primitive data types - includes byte, short, int, long, float, double, boolean and char
    Non-primitive data types - such as String, Arrays and Classes (you will learn more about these in a later chapter)
     */

    /*
    Difference Between int <> Integer

    Memory use: It takes 4 bytes to store an integer value in it.
                It takes 16 bytes to store an integer value in it.

    Type:       An int is a primitive data type
                An Integer is a wrapper class for the int data type that gives us more flexibility in converting, storing, and manipulating int data

    Purpose:    It is used for only a single purpose, i.e., storing an integer value into memory.
                Its main purpose is to convert an int into an object or an object into an int.
     */



    /*
    Java array is an object which contains elements of a similar data type.
    it is a data structure where we store similar elements.
    Array in Java is index-based, the first element of the array is stored at the 0th index, 2nd element is stored on 1st index and so on.
    */

    // array []
    //it means array of 5 elements
    int[] arr = new int[5];

    //one dimensional array - A one-dimensional array stores a single list of various elements having a similar data type.
    String[] name = {"gigi","luka"};

    //two-dimensional - A two-dimensional array stores an array of various arrays, or a list of various lists, or an array of various one-dimensional arrays.
    String[][] nameSurname = {
            {},
            {},
            {}
    };

    @Test
    public void enhancedForLoop(){
        //this means that every iteration pick one value and store in n variable.
    for(String n : name) {
        System.out.println(n);
        }
    }


    //Arraylist

    /*
    The ArrayList class is a resizable array, which can be found in the java.util package.
    array cannot be modified (if you want to add or remove elements to/from an array, you have to create a new one).
    While elements can be added and removed from an ArrayList whenever you want.

    //Create an ArrayList object called cars that will store strings
    ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object

    cars.add("Volvo");
    cars.add("BMW");
    cars.add("Ford");
    cars.add("Mazda");
    System.out.println(cars);
     */

    //HOW REVERSE THE STRING
    //Method 1: Using StringBuilder
    public class ReverseString {
        public static void main(String[] args) {
            String original = "Hello, World!";
            String reversed = reverseStringUsingStringBuilder(original);
            System.out.println("Original: " + original);
            System.out.println("Reversed: " + reversed);
        }

        public static String reverseStringUsingStringBuilder(String str) {
            StringBuilder stringBuilder = new StringBuilder(str); // Create a StringBuilder object with the original string
            return stringBuilder.reverse().toString(); // Reverse the string and convert it back to String
        }
    }

    //Method 2: Using a Loop
    public class ReverseStringWithLopp {
        public static void main(String[] args) {
            String original = "Hello, World!";
            String reversed = reverseStringUsingLoop(original);
            System.out.println("Original: " + original);
            System.out.println("Reversed: " + reversed);
        }

        public static String reverseStringUsingLoop(String str) {
            char[] charArray = str.toCharArray(); // Convert the string to a character array
            String reversed = ""; // Initialize an empty string to hold the reversed string

            for (int i = charArray.length - 1; i >= 0; i--) { // Loop from the end of the array to the beginning
                reversed += charArray[i]; // Append each character to the reversed string
            }

            return reversed; // Return the reversed string
        }
    }
/*
Explanation:
Convert to Char Array: We convert the string into a character array using toCharArray().
Loop: We loop through the character array starting from the last character down to the first.
Building Reversed String: In each iteration, we concatenate the current character to the reversed string.
Output: Finally, we return the reversed string and print it.
 */

}
