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

package tasks.exercise_one;

import static java.lang.Math.abs;

/**
 * Created by maxxl on 14.09.2016.
 * Class search sqrt without Java API function Math.sqrt && n^0.5
 *
 * @version 1.0 14 Sep 2016
 * @author Sorokin Maksym
 */

public class TaskOne {
    /** EPS epsilon > 0  */
    private final double EPS = 1e-10;
    /** Square = a*b */
    private  double s;
    /** a left side rectangle */
    private  double a;
    /** b bottom side rectangle */
    private  double b;

    /**
     * Constructs and initializes a rectangle
     */
    private TaskOne() {

    }
    /**
     * Constructs and initializes a rectangle
     * @param s - a square of rectangle
     */
    public TaskOne(double s) {
        this.s = s;
    }
    /**
     * Method mySqrt() search sqr by square
     * @return sqrt of input value k
     * @deprecated
     */
    public double mySqrt() {
        this.a = 1;
        this.b = this.s;
        while(abs(a-b)>EPS) {
            a=(a+b)/2;
            b = s / a;
        }
        return (a+b)/2;
    }
}
