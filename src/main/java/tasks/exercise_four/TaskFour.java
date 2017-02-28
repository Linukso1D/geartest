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
package tasks.exercise_four;

import tasks.Helper;
import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.*;

/**
 * Created by maxxl on 15.09.2016.
 * Class description goes here.
 *
 * @version 1.0 15 Sep 2016
 * @author Sorokin Maksym
 */

public class TaskFour  implements Serializable {
    /** Collections points */
    private Map <String,MyPoint> matrix,outputMatrix;
    /**center point x && y  */
    private Point2D centerXY;

    /**
     * Constructor for first init collections points
     */
    public TaskFour() {
        matrix  = new LinkedHashMap<>();
        outputMatrix  = new LinkedHashMap<>();
    }

    /**
     * Method entryPoints need for adding points to matrix
     * @deprecated
     */
    public void entryPoints() {
        do {
            int x; int y;
            System.out.println("Enter new point: x(");
            System.out.println("x:");
            x = Helper.readInteger();
            System.out.println("y:");
            y = Helper.readInteger();
            matrix.put(x + ":" + y,
                                new MyPoint(x,y));
            System.out.println("Add new point now?");
        } while (!"n".equals(
                Helper.readString()));
    }

    /**
     *  Method findCenterPoint - create central point
     */
    public void findCenterPoint() {
        final int[] countP = {0};
        final double[] sumX = {0};
        final double[] sumY = {0};
        matrix.forEach((k, v)-> {
            countP[0]++;
            sumX[0]+= v.getX();
            sumY[0]+= v.getY();
        });
        centerXY = new Point2D.Double(sumX[0]/countP[0],sumY[0]/countP[0]);
    }

    /**
     * getCenterXY getter of central point
     * @return getter of this.array
     */
    public Point2D getCenterXY() {
        return centerXY;
    }

    /**
     * Method getAnglePoints set into the point his angel
     * @since JDK 1.8
     */
    public void getAnglePoints() {
        matrix.forEach((k, v)-> {
           v.setAngle(Math
                   .atan2(centerXY.getY()-v.getY(),v.getX()-centerXY.getX()));
        });
    }

    /**
     *  SmartSort point by angle
     *  @since JDK 1.8
     */
    public void createLine () {
        matrix.entrySet().stream()
                .sorted(Map.Entry.<String, MyPoint>comparingByValue()
                        .reversed()).forEachOrdered(e -> outputMatrix.put(e.getKey(), e.getValue()));
    }

    /**
     * Method getOutputMatrix
     * @return getter of this.array
     */
    public Map<String, MyPoint> getOutputMatrix() {
        return outputMatrix;
    }
}
