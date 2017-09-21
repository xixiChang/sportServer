package com.tcl.work.sport.utils;

import java.util.Random;

/**
 * Created by Emcc on 17-9-13.
 */
public class Tools {

    public static String getrandnum(){
        int[] tempcode =  new int[4];
        String tempcodeString;
        for(int i=0; i<4; i++){
            tempcode[i]=(int) (Math.random()*9);
        }
        tempcodeString = ""+tempcode[0]+tempcode[1]+tempcode[2]+tempcode[3];
        return tempcodeString;
    }
}
