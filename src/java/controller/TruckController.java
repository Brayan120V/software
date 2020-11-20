/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Person;
import model.Truck;

@MultipartConfig
public class TruckController extends HttpServlet {

    private Truck truck;

    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String licensePlate = request.getParameter("option");
        String method = request.getParameter("method");

        System.out.println(licensePlate);
        if (method.equals("unit")) {
            if (licensePlate.equals("")) {
                String error = "Datos nulos";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                try {
                    truck = new Truck(licensePlate, new Person());
                    readUnit(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(TruckController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            String cardid = (String) request.getSession().getAttribute("cardid");
            if (cardid.equals("")) {
                String error = "Datos nulos";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                try {
                    int card = Integer.parseInt(cardid);
                    truck = new Truck(null, new Person(card));
                    readAll(request, response);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }
    }
//

    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("_method").equals("put")) {
            processRequestPut(request, response);
        } else if (request.getParameter("_method").equals("delete")) {
            processRequestDelete(request, response);
        } else {

            Part image = request.getPart("image");
            String licensePlate = request.getParameter("license");
            String type = request.getParameter("type");
            String widthBodywork = request.getParameter("width");
            String highBodywork = request.getParameter("high");
            String longBodywork = request.getParameter("long");
            String maxWeight = request.getParameter("max");

            InputStream is = image.getInputStream();
            String path = "assets/" + System.currentTimeMillis() + ".png";
            String outputfile = this.getServletContext().getRealPath(path);
            FileOutputStream os = new FileOutputStream(outputfile);

            int ch = is.read();
            while (ch != -1) {
                os.write(ch);
                ch = is.read();
            }
            os.close();

            if (licensePlate.equals("") || type.equals("") || widthBodywork.equals("")
                    || highBodywork.equals("") || longBodywork.equals("") || maxWeight.equals("")) {

                String error = "Datos nulos";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);

            } else {

                try {

                    int widthB = Integer.parseInt(widthBodywork);
                    int highB = Integer.parseInt(highBodywork);
                    int longB = Integer.parseInt(longBodywork);
                    int maxW = Integer.parseInt(maxWeight);
                    int cardid = Integer.parseInt((String) request.getSession().getAttribute("cardid"));
                    truck = new Truck(highB, longB, widthB, path, maxW, licensePlate, type, new Person(cardid));
                    create(request, response);

                } catch (Exception e) {

                    System.out.println(e);

                }
            }
        }

    }

    protected void processRequestPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String licensePlate = ((Truck) request.getSession().getAttribute("truck")).getLicensePlate();
        String type = request.getParameter("type");
        String widthBodywork = request.getParameter("width");
        String highBodywork = request.getParameter("high");
        String longBodywork = request.getParameter("long");
        String maxWeight = request.getParameter("max");

        if (licensePlate.equals("") || type.equals("") || widthBodywork.equals("")
                || highBodywork.equals("") || longBodywork.equals("") || maxWeight.equals("")) {

            String error = "Datos nulos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } else {

            try {

                float widthB = Float.parseFloat(widthBodywork);
                float highB = Float.parseFloat(highBodywork);
                float longB = Float.parseFloat(longBodywork);
                float maxW = Float.parseFloat(maxWeight);
                int cardid = Integer.parseInt((String) request.getSession().getAttribute("cardid"));
                truck = new Truck(highB, longB, widthB, type, maxW, licensePlate, type, new Person(cardid));
                update(request, response);

            } catch (Exception e) {

                System.out.println(e);

            }
        }

    }

    protected void processRequestDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Truck tk = (Truck) request.getSession().getAttribute("truck");

        System.out.println(tk.getLicensePlate());

        if (tk.getLicensePlate().equals("")) {
            String error = "Datos nulos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            try {
                truck = tk;
                delete(request, response);
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestPost(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        try {
            Truck instance = new Truck();
            String message = instance.create(truck);
            System.out.println(message);
            request.getSession().setAttribute("message", message);
            request.getRequestDispatcher("listTruck.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al guardar";
            System.out.println(e);
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void readUnit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        try {
            Truck instance = new Truck();
            Truck res = instance.find(truck.getLicensePlate());
            request.getSession().setAttribute("truck", res);
            request.getRequestDispatcher("updateTruck.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al buscar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void readAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        try {
            Truck instance = new Truck();
            ArrayList<Truck> res = instance.findArray(truck.getPerson().getCardid());
            System.out.println(res);
            request.getSession().setAttribute("trucks", res);
            System.out.println(res.get(0).getLicensePlate());
            //request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al buscar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        try {
            Truck instance = new Truck();
            String res = instance.update(truck);
            request.getSession().setAttribute("res", res);
            request.getRequestDispatcher("listTruck.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al buscar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        Truck instance = new Truck();
        String res = instance.inactivate(truck.getLicensePlate());
        if (res.equals("Success")) {
            request.getRequestDispatcher("listTruck.jsp").forward(request, response);
        }
    }
}
