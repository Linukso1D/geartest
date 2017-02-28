/*
 *
 * Maksym Sorokin
 *
 * Copyright © 2010 - 2016 SysGears. All rights reserved.
 *
 * This software is the confidential and proprietary information of SysGears
 *
 *
 */

package tasks;

import tasks.exercise_four.MyPoint;
import java.util.*;

/**
 * Created by maxxl on 14.09.2016.
 * Class description goes here.
 *
 * @version 1.0 14 Sep 2016
 * @author Sorokin Maksym
 */
public class Helper {
    /** A simple text scanner which can parse primitive types and strings using regular expressions. */
    private static final Scanner s = new Scanner(System.in);
    /** An instance of this class is used to generate a stream of pseudorandom numbers. */
    private static final Random random = new Random();

    /**
     * Method reaadDouble - need to read entered double-value from console/
     * @return input string
     * */
    public static double readDouble() {
        double userInput = 0;
        while (true) {
            System.out.println("Type a double-type number:");
            try {
                userInput = Double.parseDouble(s.next());
                break; // will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
        return userInput;
    }

    /**
     * Method reaadInteger - need to read entered int-value from console/
     * @return input string
     * */
    public static int readInteger() {
        int userInput = 0;
        while (true) {
            System.out.println("Type a int-type number:");
            try {
                userInput = Integer.parseInt(s.next());
                break; // will only get to here if input was a double
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
        return userInput;
    }

    /**
     * Method reaadString - need to read entered string from console/
     * @return input string
     * */
    public static String readString() {
        s.nextLine(); // If you're expecting the user to hit enter when done.
        return s.next();
    }

    /**
     * Method getRandomNumbers create random array (typeof Integer)
     * @return array with integer values
     * @param range size of returned array
     * @param low min number element
     * @param high max number element
     * @since JDK 1.8
     * */
    public static Integer [] getRandomNumbers(int range , int low,int high) {
        return  Arrays.stream(
                random.ints(range, low, high).toArray())
                .boxed()
                .toArray(Integer[]::new );
    }

    public static int getRandomNumbers(int limit) {
        return random.nextInt(limit);
    }

    /**
     * Method printArrayInteger printed integer []
     * @param array - it'll be printed to the console.
     * @since JDK 1.8
     * */
    public static void printArrayInteger(Integer [] array) {
        Arrays.stream(array).forEach(System.out::println);
    }

    /**
     * Method printArrayPoints it's print to the console elements of array-points
     * @param array map of unique points
     * @since JDK 1.8
     * */
    public static void printArrayPoints(Map<String,MyPoint> array) {
        array.forEach((k, v)->
            System.out.println("point: x "+v.getX()+
                    " y "+v.getY()+
                    " angle"+v.getAngle())
        );
    }

    /**
     * Method inputArrayInteger need for quick entered array Integer[]
     * @param sizeArray - array size
     * @return array of integer values
     * @deprecated
     * */
    public static Integer[] inputArrayInteger(int sizeArray) {
        Integer[] array = new Integer[sizeArray];
        System.out.println("Enter array size of "+sizeArray);
        for(int i = 0; i<sizeArray; i++) {
            System.out.print("Input "+i+" element of array ");
            try {
                Integer value =  s.nextInt();
                array[i] = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.print ("Not a number, please try again");
                Integer value =  s.nextInt();
                array[i] = s.nextInt();
            }
        }
        return array;
    }

}
