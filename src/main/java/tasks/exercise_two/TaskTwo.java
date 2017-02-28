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

package tasks.exercise_two;

import tasks.R;
import tasks.Helper;

/**
 * Created by maxxl on 14.09.2016
 * Class searched index k in new sorted matrix.
 *
 * @version 1.0 14 Sep 2016
 * @author Sorokin Maksym
 */
public class TaskTwo {
    /** k  index */
    private int k;
    /** array input array can be entered in to random values or by keyboard */
    private Integer[] array;
    /** array length */
    private int length;
    /** correctObject documentation comment */
    private boolean correctObject = false;

    /**
     * Closed constructor without init array
     */
    private TaskTwo() {

    }

    /**
     * Init object with default array values
     * @param k an index of input array
     */
    public TaskTwo(int k) {
        this.k=k;
        this.array = Helper.getRandomNumbers(   R.CONST.TASK_TWO_ARRAY_SIZE,
                                                R.CONST.TASK_TWO_ARRAY_MIN_RANDOM_VALUE,
                                                R.CONST.TASK_TWO_ARRAY_MAX_RANDOM_VALUE  );

        this.length = array.length;
        this.correctObject = checkK(k);
    }

    /**
     * Init object with custom array value
     * @param k an index of input array
     * @param size size array
     */
    public TaskTwo(int k,int size) {
            this.k = k;
            this.array = Helper.inputArrayInteger(size);
            this.length = size;
            this.correctObject = checkK(k);
    }

    /**
     * Access or denied work with this object - flag
     * @return valid || none-valid object
     */
    public boolean isCorrectObject() {
        return correctObject;
    }

    /**
     * Method getArray getter of array
     * @return this.array
     */
    public Integer[] getArray() {
        return array;
    }

    /**
     * Method checkK valid value k by this.array
     * @param k an index of input array
     * @return validate index of array <= k <= array.length()
     */
    private boolean checkK(int k) {
        return k > 0 && k <= length;
    }

    /**
     * Delegate sort on SortLeo (Complexity is O(n log n), for all)
     * @return description
     */
    public boolean sort() {
        if(correctObject) {
            SortLeo.smoothSort(this.array,0,length-1);
            return true;
        }
        return false;
    }

    /**
     * Method getK_Array returned value by index-k of this.array (or -1)
     * @return get element of array by index k
     */
    public int getK_Array() {
        if(correctObject) {
            return array[k];
        }
        return -1;
    }
}
