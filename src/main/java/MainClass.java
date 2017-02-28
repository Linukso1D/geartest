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

import tasks.Helper;
import tasks.R;
import tasks.exercise_four.TaskFour;
import tasks.exercise_one.TaskOne;
import tasks.exercise_three.CsvStructure;
import tasks.exercise_three.TaskThree;
import tasks.exercise_two.TaskTwo;

import static tasks.R.CONST.*;

/**
 * Created by maxxl on 14.09.2016.
 * Class description goes here.
 *
 * @version 1.0 14 Sep 2016
 * @author Sorokin Maksym
 */

public class MainClass {

    public static void main(String [] args) {
        /** Task one */
        System.out.println(R.STRING.EX_1);
        TaskOne obj = new TaskOne(Helper.readDouble());
        double value = obj.mySqrt();
        System.out.println(R.STRING.SQRT_TEXT + value);
        System.out.println(R.STRING.MIN_INT_VALUE + (int) value);
        /** Task one */

        /** Task two */
        System.out.println(R.STRING.EX_2);
        System.out.println(R.STRING.EX_2_ENTER_K);
        TaskTwo obj2 = new TaskTwo(Helper.readInteger());
        if(obj2.isCorrectObject()) {
            System.out.println(R.STRING.EX_2_ORIGINAL_ARRAY);
            Helper.printArrayInteger(
                    obj2.getArray());
            System.out.println(R.STRING.EX_2_K_BEFORE_SORT + obj2.getK_Array());
            System.out.println(R.STRING.EX_2_SORTED_ARRAY);
            obj2.sort();
            Helper.printArrayInteger(
                    obj2.getArray());
            System.out.println(R.STRING.EX_2_K_AFTER_SORT + obj2.getK_Array());
        } else {
            obj2 = null;
            System.out.println(R.STRING.EX_2_NOT_VALID_OBJECT);
        }
        /** Task two */

        /** Task Three */
        System.out.println(R.STRING.EX_3);
        CsvStructure csvEl1 = new CsvStructure(CODE_1);
        CsvStructure csvEl2 = new CsvStructure(CODE_2);
        CsvStructure csvEl3 = new CsvStructure(CODE_3);
        CsvStructure csvEl4 = new CsvStructure(CODE_4);
        CsvStructure csvEl5 = new CsvStructure(CODE_5);

        TaskThree csv = new TaskThree();
        csv.addRecordCodes(csvEl1);
        csv.addRecordCodes(csvEl2);
        csv.addRecordCodes(csvEl3);
        csv.addRecordCodes(csvEl4);
        csv.addRecordCodes(csvEl5);
        csv.writeCSV();
        /** Task Three */

        /** Task four */
        System.out.println(R.STRING.EX_4);
        TaskFour obj4 = new TaskFour();
        obj4.entryPoints();
        obj4.findCenterPoint();
        System.out.println(R.STRING.EX_4_CENTRAL_P_X + obj4.getCenterXY().getX());
        System.out.println(R.STRING.EX_4_CENTRAL_P_Y + obj4.getCenterXY().getY());
        System.out.println(R.STRING.EX_4_ANGLE_SEARCH);
        obj4.getAnglePoints();
        System.out.println(R.STRING.EX_4_LINE_START);
        obj4.createLine();
        System.out.println(R.STRING.EX_4_LINE_END);
        Helper.printArrayPoints(obj4.getOutputMatrix());
        /** Task four*/
    }
}
