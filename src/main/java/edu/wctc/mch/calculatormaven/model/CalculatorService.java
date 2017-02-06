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
            result = "The area of your circle is " + String.valueOf(df.format(3.14 * Double.parseDouble(values[0]) * Double.parseDouble(values[0]))) + " square feet";
        }
        else if (shape == GeometricShape.TRIANGLE)
        {
            double calculatedValue = (Double.parseDouble(values[0]) * Double.parseDouble(values[0])) + (Double.parseDouble(values[1]) * Double.parseDouble(values[1]));
            result = "The hypotenuse side of your triangle " + String.valueOf(df.format(Math.sqrt(calculatedValue)));
        }
        else if (shape == GeometricShape.RECTANGLE)
        {
            result = "The area of your rectangle is " + String.valueOf(df.format(Double.parseDouble(values[0]) * Double.parseDouble(values[1])));
        }
        return result;
    }
}
