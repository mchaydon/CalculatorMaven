/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.mch.calculatormaven.model;

/**
 *
 * @author Mike
 */
public class CalculatorService {
    
    public final String calculateRectangleArea(String length, String width)
    {
        return String.valueOf(Integer.parseInt(length) * Integer.parseInt(width));
    }
}
