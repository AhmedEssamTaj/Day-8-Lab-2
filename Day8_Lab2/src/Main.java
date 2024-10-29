/*
Author: Ahmed Essam Taj
Date: 29, October
Day 8 LAB 2

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

// Q1 Write a program to find all of the longest word in a given dictionary

String [] strArray = {"cat", "dog", "red", "is", "am"};

ArrayList<String> longest = arrayLongestStr (strArray);
        System.out.println(longest);

// Q2  Write a program that displays the number of occurrences of an element in the array

        System.out.println("Enter the number you want to check its occurrences : ");
        int checkNumber = scanner.nextInt();

        int [] originArray = {1,1,1,3,3,5};

        int numberOfOccurrences = calculateNumOfOccurrences(checkNumber,originArray);
        System.out.println(checkNumber+" occurs "+numberOfOccurrences+" times");


// Q3  Write a program to find the k largest elements in a given array.
// Elements in the array can be in any order

        System.out.println("Enter the number of largest elements you want to find : ");
        int numOfElements = scanner.nextInt();

        ArrayList <Integer> intArrayList = new ArrayList <>();
        intArrayList.add(1);
        intArrayList.add(4);
        intArrayList.add(17);
        intArrayList.add(7);
        intArrayList.add(25);
        intArrayList.add(3);
        intArrayList.add(100);

        int [] largestList = largestElements(intArrayList,numOfElements);
        System.out.println("the "+numOfElements+" largest elements of the said array are: "+Arrays.toString(largestList));

// Q4 Create a method to reverse an array of integers. Implement the method without creating a new
//array

         int[] arr = {5,4,3,2,1};
         reverseArray(arr);


// Q5 Write a menu driven Java program with option:

        int choice=-1;
        System.out.println("Please enter the size of the array : ");
        int size = scanner.nextInt();
        int [] q5Array = new int[size];
        boolean stop = false;
        while (!stop) {

            showMenu();

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    q5Array = populateArray (q5Array);
                    break;

                    case 2:
                        System.out.println(Arrays.toString(q5Array));
                        break;

                        case 3:
                            System.out.println("Please enter the element you want to search for : ");
                            int searchElement = scanner.nextInt();
                            searchArray (q5Array , searchElement);
                            break;

                            case 4:
                                System.out.println("Please enter (1) to sort the array for largest to smallest");
                                System.out.println("Please enter (2) to sort the array for smallest to largest");
                                int order = scanner.nextInt();

                                if (order == 1)
                                    q5Array = sortDescending (q5Array);
                                else
                                    q5Array = sortAscending (q5Array);

                                break;

                                case 5:
                                    System.out.println("Please enter the size of the array to quit! ");
                                    int quit = scanner.nextInt();
                                    if (quit == q5Array.length) {
                                        stop = true;
                                        System.out.println("Thank you for using this program");
                                    }else
                                        System.out.println("Wrong size try again");
                                    break;

                                    default:
                                        System.out.println("Please enter a valid choice");
                                        break;


            }

        }

// Q6 Create a method that generates a random number within a given range. Allow the user to
//specify the range and call the method to display random numbers

        System.out.println("Enter the minimum value of the range: ");
        int minValue = scanner.nextInt();
        System.out.println("Enter the maximum value of the range: ");
        int maxValue = scanner.nextInt();
        System.out.println("Enter the number of random numbers to generate: ");
        int numOfRandom = scanner.nextInt();

        int [] randomArray = generateRandom (minValue, maxValue, numOfRandom);
        System.out.println(Arrays.toString(randomArray));

// Q7 Write a program that checks the strength of a password. Create a method that evaluates a
//password based on criteria like length, inclusion of special characters, and
//uppercase/lowercase letters

        System.out.println("Enter a password: ");
        String password = scanner.next();

        int score = checkLength(password);
       score += checkSpecialCharacters(password);
      score += checkUpperCaseLowerCase(password);

      if (score >= 8)
          System.out.println("Password is strong");
      else if (score >= 5)
          System.out.println("Password is moderately strong");
      else
          System.out.println("Password is weak");

// Q8 Create a method that generates the Fibonacci sequence up to a specified number of terms

        System.out.println("Enter the number of Fibonacci terms to generate: ");
        int numOfFibonacci = scanner.nextInt();

        System.out.println(fibonacciSeq(numOfFibonacci));


    }




// --- Method Q1 -----
    public static ArrayList <String> arrayLongestStr (String[] strArray) {

        ArrayList <String> longestArray = new ArrayList <> ();
        String longestStr = "";
        int longestLength = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length() >= longestLength) {
                longestLength = strArray[i].length();

            }
        }

            for (int j = 0; j < strArray.length; j++) {
                if (strArray[j].length() == longestLength) {
                    longestArray.add(strArray[j]);
                }
            }


        return longestArray;
    }

   // -------- Method Q2 -----------
    public static int calculateNumOfOccurrences (int checkNumber, int[] originArray) {
        int occurrences = 0;
        for (int i = 0; i < originArray.length; i++) {
            if (originArray[i] == checkNumber) {
                occurrences++;
            }
        }
        return occurrences;
    }

    // ------------ Method Q3 --------------

    public static int[] largestElements (ArrayList<Integer> arr, int num) {


        int [] newArray = new int[num];

        for (int i = 0; i < newArray.length; i++) {
          int temp = arr.getFirst();
          int index=0;
          for (int j =1; j<arr.size(); j++) {
              if (arr.get(j) >= temp) {
                  temp = arr.get(j);
                   index=j;
        }
    }
            newArray[i]=temp;
            arr.remove(index);


}
        return newArray;
    }


 // ------ Method Q4 --------
    public static void reverseArray (int[] arr) {
        int tempEL ;
        int j = (arr.length-1);
        for (int i = 0; i <j ; i++) {

            tempEL = arr[i];
            arr[i] = arr[j];
            arr[j] = tempEL;
            j--;
        }
        System.out.println("Reversed Array: "+Arrays.toString(arr));
    }

// ------ Methods Q5 --------
public static void showMenu() {

    System.out.println("1. Accept elements of an array");
    System.out.println("2. Display elements of an array");
    System.out.println("3. Search the element within array");
    System.out.println("4. Sort the array");
    System.out.println("5. To Stop! the size of the array should be entered by the user");

}

public static int[] populateArray (int [] arr) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter the element["+i+"] to add to the array : ");
            arr[i] = scanner.nextInt();
        }
        return arr;
}

public static void searchArray (int[] arr, int searchElement) {
        int index = 0;
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchElement) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            System.out.println("Element found at index : "+index);
        }else
            System.out.println("Element not found");

}

public static int[] sortDescending (int[] arr) {

    Arrays.sort(arr);
    int tempEL ;
    int j = (arr.length-1);
    for (int i = 0; i <j ; i++) {

        tempEL = arr[i];
        arr[i] = arr[j];
        arr[j] = tempEL;
        j--;
    }

        return arr;
}

public static int[] sortAscending (int[] arr) {
    Arrays.sort(arr);
        return arr;
}

// ------ Methods Q6 --------

public static int[] generateRandom (int min, int max, int num) {

    int[] randomArray = new int[num];
    for (int i = 0; i < num; i++) {
        randomArray[i] = (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
    return randomArray;
}

// ------ Methods Q7 --------

 public static int checkLength(String string) {
        if (string.length() >= 8)
            return 3;
        else if (string.length() >=6)
            return 2;
        else
            return 0;
 }

 public static int checkSpecialCharacters(String string) {

     for (int i = 0; i < string.length(); i++) {
         char c = string.charAt(i);
         int ascii = (int) c;

         // Check if the ASCII value is within alphanumeric ranges
         if (!(ascii >= 48 && ascii <= 57) && !(ascii >= 65 && ascii <= 90) &&
                 !(ascii >= 97 && ascii <= 122)) {
             return 2;
         }
     }
     return 0;
 }

 public static int checkUpperCaseLowerCase(String string) {

        boolean upperCase = false;
        boolean lowerCase = false;

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (Character.isUpperCase(c)) {
                upperCase = true;
            }
            if (Character.isLowerCase(c)) {
                lowerCase = true;
            }
        }
        if (upperCase && lowerCase) {
            return 3;
        }
        return 0;
 }

 // // ------ Methods Q8 --------

    public static ArrayList <Integer> fibonacciSeq(int n) {
      ArrayList<Integer> list = new ArrayList<>();
        if (n >0) {


            int a = 0;
            int b = 1;
            list.add(a);

            if (n > 1) {
                list.add(b);
            }

            for (int i = 3; i <= n; i++) {
                int temp = a + b;
                list.add(temp);
                a = b;
                b = temp;
            }
        }else
            return list;
        return list;
    }


}