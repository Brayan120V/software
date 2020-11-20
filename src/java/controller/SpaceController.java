package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Person;
import model.Space;
import model.Truck;

public class SpaceController extends HttpServlet {

    private Space space;

    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("option");
        String method = request.getParameter("method");

        System.out.println(id);
        if (method.equals("unit")) {
            if (id.equals("")) {
                String error = "Datos nulos";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                try {
                    int iD = Integer.parseInt(id);
                    space = new Space(iD);
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
                    space = new Space(new Truck(null, new Person(card)));
                    readAll(request, response);
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        }
    }

    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("_method").equals("put")) {
            processRequestPut(request, response);
        } else if (request.getParameter("_method").equals("delete")) {
            processRequestDelete(request, response);
        } else {

            String license = request.getParameter("license");
            String volume = request.getParameter("volume");
            String weight = request.getParameter("weight");
            String value = request.getParameter("value");
            String cityDeparture = request.getParameter("citydeparture");
            String cityArrival = request.getParameter("cityarrival");
            String dateDeparture = request.getParameter("datedeparture");
            String dateArrival = request.getParameter("datearrival");

            if (volume.equals("") || weight.equals("") || value.equals("")
                    || cityDeparture.equals("") || cityArrival.equals("") || dateDeparture.equals("") || dateArrival.equals("")) {

                String error = "Datos nulos";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);

            } else {

                try {

                    float vol = Float.parseFloat(volume);
                    float wei = Float.parseFloat(weight);
                    float val = Float.parseFloat(value);
                    int cityD = Integer.parseInt(cityDeparture);
                    int cityA = Integer.parseInt(cityArrival);
                    int cardid = Integer.parseInt((String) request.getSession().getAttribute("cardid"));
                    space = new Space(cityA, cityD, dateArrival, dateDeparture, wei, val, vol, new Truck(license, new Person()));
                    create(request, response);

                } catch (Exception e) {

                    System.out.println(e);

                }
            }
        }

    }

    protected void processRequestPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("option");
        String volume = request.getParameter("volume");
        String weight = request.getParameter("weight");
        String value = request.getParameter("value");
        String cityDeparture = request.getParameter("citydeparture");
        String cityArrival = request.getParameter("cityarrival");
        String dateDeparture = request.getParameter("datedeparture");
        String dateArrival = request.getParameter("datearrival");

        if (id.equals("") || volume.equals("") || weight.equals("") || value.equals("")
                || cityDeparture.equals("") || cityArrival.equals("") || dateDeparture.equals("") || dateArrival.equals("")) {

            String error = "Datos nulos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } else {

            try {

                float vol = Float.parseFloat(volume);
                float wei = Float.parseFloat(weight);
                float val = Float.parseFloat(value);
                int cityD = Integer.parseInt(cityDeparture);
                int cityA = Integer.parseInt(cityArrival);
                int iD = Integer.parseInt(id);
                int cardid = Integer.parseInt((String) request.getSession().getAttribute("cardid"));
                space = new Space(iD, cityA, cityD, dateArrival, dateDeparture, wei, val, vol, new Truck());
                create(request, response);

            } catch (Exception e) {

                System.out.println(e);

            }
        }
    }

    protected void processRequestDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Space sp = (Space) request.getSession().getAttribute("space");

        System.out.println(sp.getId());

        if (sp.getId() == 0) {
            String error = "Datos nulos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            try {
                space = sp;
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
            Space instance = new Space();
            String message = instance.create(space);
            System.out.println(message);
            request.getSession().setAttribute("message", message);
            request.getRequestDispatcher("listSpace.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al guardar";
            System.out.println(e);
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void readUnit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        try {
            Space instance = new Space();
            Space res = instance.find(space.getId());
            request.getSession().setAttribute("space", res);
            request.getRequestDispatcher("updateSpace.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al buscar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void readAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        try {
            Space instance = new Space();
            ArrayList<Space> res = instance.findArray(space.getTruck().getPerson().getCardid());
            System.out.println(res);
            request.getSession().setAttribute("spaces", res);
            System.out.println(res.get(0).getId());
            //request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al buscar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        try {
            Space instance = new Space();
            String res = instance.update(space);
            request.getSession().setAttribute("res", res);
            request.getRequestDispatcher("listSpace.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al buscar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        Space instance = new Space();
        String res = instance.inactivate(space.getId());
        if (res.equals("Success")) {
            request.getRequestDispatcher("listSpace.jsp").forward(request, response);
        }
    }
}
