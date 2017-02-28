/*
 *
 *  * Maksym Sorokin
 *  *
 *  * Copyright © 2010 - 2016 SysGears. All rights reserved.
 *  *
 *  * This software is the confidential and proprietary information of SysGears
 *  *
 *
 */

package tasks.exercise_three;


/**
 * Created by maxxl on 16.09.2016.
 */
public class CsvStructure {
    private String code, driverCode,travelSheetCode , name;
    private boolean dangerous, fragile;
    private int temperature , index;



    private CsvStructure() {

    }
    public CsvStructure(String code) {
        this.code = code;
        dangerous = false;
        fragile = false;
        name="";
        driverCode = code.substring(0,4);
        findDriverCode();
        findTemperature();
        nameEncode();
    }

    private void findDriverCode () {
        index = 4;
        int idr = code.indexOf("r",4);
        int idR = code.indexOf("R",4);
        index = idr > idR ? (idR !=-1 ? idR : idr) : (idr != -1 ? idr : idR) ;

        int startTravelSheetCode = index;
        // takes 4 symbol after index

        boolean nextStep = true;
        while (nextStep) {
            switch (code.charAt(++index)) {
                case 'd':
                    dangerous = true;
                    break;
                case 'f':
                    fragile = true;
                    break;
                default:
                    nextStep = false;
                    break;
            }
        }

        if(dangerous || fragile) {
            index+=3;
        } else {
            index+=4;
        }
        travelSheetCode = code.substring(startTravelSheetCode,index);
    }

    private void findTemperature() {
        boolean  access = false ;
        if(code.indexOf('+')!=-1) {
            index = code.indexOf('+');
            access = true;
        } else if(code.indexOf('-')!=-1) {
            index = code.indexOf('-');
            access = true;
        }

        if(access) {
            int freeCounter = 4; // for negative value
            String temperature="";
            for (int i = index; i < code.length(); i++) {
              //  if(code.charAt(i)!='0') {
                    index = i;
                    temperature+=code.charAt(i);
                    freeCounter--;
             //   }
                if(freeCounter==0) {
                    break;
                }
            }
            this.temperature = Integer.valueOf(temperature);
            index++;
        }
    }

    private void nameEncode() {
        while (!Character.isDigit(this.code.charAt(index))) {
            index++;
        }

        int k = 0;
        String tmp = "";
        for (int i = index; i<code.length(); i++,k++) {
            tmp += String.valueOf(code.charAt(i));

            if (k%3 == 2) {
                this.name += Character.toString ((char) systemConvert(tmp));
                tmp="";
            }
        }
    }

    @Override
    public String toString() {
        return "CsvStructure{" +
                "code='" + code + '\'' +
                ", driverCode='" + driverCode + '\'' +
                ", travelSheetCode='" + travelSheetCode + '\'' +
                ", name='" + name + '\'' +
                ", dangerous=" + dangerous +
                ", fragile=" + fragile +
                ", temperature=" + temperature +
                ", index=" + index +
                '}';
    }

    private int systemConvert(String number) {
        return Integer.parseInt(number, 8);
    }

    public String getCode() {
        return code;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public String getTravelSheetCode() {
        return travelSheetCode;
    }

    public String getName() {
        return name;
    }

    public boolean isDangerous() {
        return dangerous;
    }

    public boolean isFragile() {
        return fragile;
    }

    public int getTemperature() {
        return temperature == 0 ? Integer.MIN_VALUE : temperature;
    }


}
