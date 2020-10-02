/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Truck;

/**
 *
 * @author brayan
 */
@WebServlet(name = "TruckController", urlPatterns = {"/truck"})
public class TruckController extends HttpServlet {
    
    Truck truck;
    Connect connect = new Connect();
    String sql;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String licensePlate = request.getParameter("licensePlate");
        if (licensePlate.equals("")) {
            String error = "Campos vacíos...";
        } else {
            truck = new Truck(licensePlate);
            read(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String highbodywork = request.getParameter("highBodywork");
        String longbodywork = request.getParameter("longBodywork");
        String widthbodywork = request.getParameter("widthBodywork");
        String photo = request.getParameter("photo");
        String maxweight = request.getParameter("maxWeight");
        String licenseplate = request.getParameter("licensePlate");
        String type = request.getParameter("type");
        String transporterPersonCardid = request.getParameter("transporterPersonCardid");
        
        if (highbodywork.equals("") || longbodywork.equals("") || widthbodywork.equals("") || photo.equals("") || maxweight.equals("") || licenseplate.equals("") || type.equals("") || transporterPersonCardid.equals("")) {
            String error = "Campos vacíos...";
        } else {
            try {
                float hb = Float.parseFloat(highbodywork);
                float lb = Float.parseFloat(longbodywork);
                float wb = Float.parseFloat(widthbodywork);
                float mw = Float.parseFloat(maxweight);
                int c = Integer.parseInt(transporterPersonCardid);
                truck = new Truck(hb, lb, wb, photo, mw, licenseplate, type, c);
                create(request, response);
            } catch (NumberFormatException e) {
                String error = "Ingrese solo números";
            }
        }
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String highbodywork = request.getParameter("highbodywork");
        String longbodywork = request.getParameter("longbodywork");
        String widthbodywork = request.getParameter("widthbodywork");
        String photo = request.getParameter("photo");
        String maxweight = request.getParameter("maxweight");
        String licenseplate = request.getParameter("licenseplate");
        String type = request.getParameter("type");
        String transporterPersonCardid = request.getParameter("transporterPersonCardid");
        
        if (highbodywork.equals("") || longbodywork.equals("") || widthbodywork.equals("") || photo.equals("") || maxweight.equals("") || licenseplate.equals("") || type.equals("") || transporterPersonCardid.equals("")) {
            String error = "Campos vacíos...";
        } else {
            try {
                float hb = Float.parseFloat(highbodywork);
                float lb = Float.parseFloat(longbodywork);
                float wb = Float.parseFloat(widthbodywork);
                float mw = Float.parseFloat(maxweight);
                int c = Integer.parseInt(transporterPersonCardid);
                truck = new Truck(hb, lb, wb, photo, mw, licenseplate, type, c);
                update(request, response);
            } catch (NumberFormatException e) {
                String error = "Ingrese solo números";
            }
        }
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String licensePlate = request.getParameter("licensePlate");
        if (licensePlate.equals("")) {
            String error = "Campos vacíos...";
        } else {
            try {
                truck = new Truck(licensePlate);
                inactivate(request, response);
            } catch (NumberFormatException e) {
                String error = "Ingrese solo números";
            }
        }
    }
    
    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String sql = truck.create(truck);
        int res = connect.create(sql);
        switch (res) {
            case 0:
                System.out.println("Error");
                break;
            case 1:
                System.out.println("Success");
                break;
            default:
                break;
        }
    }
    
    private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String sql = truck.read(truck.getLicensePlate());
        ResultSet res = connect.read(sql);
        
        if (res == null) {
            System.out.println("Error");
        } else {
            try {
                while (res.next()) {
                    truck = new Truck(res.getFloat("highbodywork"), res.getFloat("longbodywork"), res.getFloat("widthbodywork"), res.getString("photo"), res.getFloat("maxweight"), res.getString("licenseplate"), res.getString("type"), res.getInt("transporterpersoncardid"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TruckController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String sql = truck.update(truck);
        int res = connect.update(sql);
        switch (res) {
            case 0:
                System.out.println("Error");
                break;
            case 1:
                System.out.println("Success");
                break;
            default:
                break;
        }
    }
    
    private void inactivate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String sql = truck.inactivate(truck.getLicensePlate());
        int res = connect.inactivate(sql);
        switch (res) {
            case 0:
                System.out.println("Error");
                break;
            case 1:
                System.out.println("Success");
                break;
            default:
                break;
        }
    }
}
