/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.mch.calculatormaven.controller;

import edu.wctc.mch.calculatormaven.model.CalculatorService;
import edu.wctc.mch.calculatormaven.model.GeometricShape;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mike
 */
@WebServlet(name = "CalculatorController", urlPatterns = {"/CalcController"})
public class CalculatorController extends HttpServlet {
    private static final String LAB2_RESULT_PAGE = "labTwo.jsp";
    private static final String LAB3_RESULT_PAGE = "labThree.jsp";
    private static final String ERROR_MSG = "ERROR";
    private static final String CALC_TYPE = "calcType";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String destination = LAB3_RESULT_PAGE;
        String calcType = request.getParameter(CALC_TYPE);
        
        CalculatorService calculatorService = new CalculatorService();
        String[] values = new String[2];
        
        try 
        {
            if(calcType.equalsIgnoreCase("Circle"))
            {
                values[0] = request.getParameter("radiusString");
                request.setAttribute("area", "The area of your circle is " + calculatorService.getResultForType(values, GeometricShape.CIRCLE) + " square feet");
            }
            else if(calcType.equalsIgnoreCase("Triangle"))
            {
                values[0] = request.getParameter("aSideString");
                values[1] = request.getParameter("bSideString");
                request.setAttribute("area", "The hypotenuse side of your triangle " + calculatorService.getResultForType(values, GeometricShape.TRIANGLE));
            }
            else if(calcType.equalsIgnoreCase("Rectangle"))
            {
                values[0] = request.getParameter("lengthString");
                values[1] = request.getParameter("widthString");
                request.setAttribute("area", "The area of your rectangle is " + calculatorService.getResultForType(values, GeometricShape.RECTANGLE) + " square feet");
            }
            else
            {
                destination = LAB2_RESULT_PAGE;
                String length = request.getParameter("lengthString");
                String width = request.getParameter("widthString");
                request.setAttribute("area", "The area of your rectangle is " + calculatorService.calculateRectangleArea(length, width) + " square feet");
            }
        } 
        catch (Exception e) 
        {
            request.setAttribute("area", ERROR_MSG);
        }
        
        RequestDispatcher view =
                request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
