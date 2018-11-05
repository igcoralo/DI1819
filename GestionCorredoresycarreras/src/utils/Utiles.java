/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Utiles {

     public static class SDf {
         private static final String FORMATO ="dd/MM/yy";
         private static final SimpleDateFormat SDF = new SimpleDateFormat(FORMATO);
    
    public static String format(Date fecha){
    return SDF.format(fecha);
    } 
    public static Date parse(String fecha)throws ParseException{
    return SDF.parse(fecha);
    }
     }
}  

