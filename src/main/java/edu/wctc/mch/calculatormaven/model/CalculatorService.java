/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.mch.calculatormaven.model;

import java.text.DecimalFormat;

/**
 *
 * @author Mike
 */
public class CalculatorService {
    DecimalFormat df = new DecimalFormat("#.00"); 
    
    public final String calculateRectangleArea(String length, String width)
    {
        return String.valueOf(Integer.parseInt(length) * Integer.parseInt(width));
    }
    
    public final String getResultForType(String[] values, GeometricShape shape)
    {
        String result = "";
        if (shape == GeometricShape.CIRCLE)
        {
            result =  String.valueOf(df.format(3.14 * Double.parseDouble(values[0]) * Double.parseDouble(values[0])));
        }
        else if (shape == GeometricShape.TRIANGLE)
        {
            double calculatedValue = (Double.parseDouble(values[0]) * Double.parseDouble(values[0])) + (Double.parseDouble(values[1]) * Double.parseDouble(values[1]));
            result = String.valueOf(df.format(Math.sqrt(calculatedValue)));
        }
        else if (shape == GeometricShape.RECTANGLE)
        {
            result = String.valueOf(df.format(Double.parseDouble(values[0]) * Double.parseDouble(values[1])));
        }
        return result;
    }
}
