package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Space;

public class SpaceController extends HttpServlet {

    Space space;
    Connect connect = new Connect();
    String sql;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id.equals("")) {
            String error = "Campos vacíos...";
        } else {
            int i = Integer.parseInt(id);
            space = new Space(i);
            read(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cityArrival = request.getParameter("cityArrival");
        String cityDeparture = request.getParameter("cityDeparture");
        String dateArrival = request.getParameter("dateArrival");
        String dateDeparture = request.getParameter("dateDeparture");
        String weight = request.getParameter("weight");
        String value = request.getParameter("value");
        String volume = request.getParameter("volume");
        String tranporterCardid = request.getParameter("tranporterCardid");

        if (cityArrival.equals("") || cityDeparture.equals("") || dateArrival.equals("") || dateDeparture.equals("") || weight.equals("") || value.equals("") || volume.equals("") || tranporterCardid.equals("")) {
            String error = "Campos vacíos...";
        } else {
            try {
                int ca = Integer.parseInt(cityArrival);
                int cd = Integer.parseInt(cityDeparture);
                float w = Float.parseFloat(weight);
                float va  = Float.parseFloat(value);
                float vo = Float.parseFloat(volume);
                space = new Space((null), ca, cd, dateArrival, dateDeparture, w, va, vo, tranporterCardid);
                create(request, response);
            } catch (NumberFormatException e) {
                String error = "Ingrese solo números";
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        String cityArrival = request.getParameter("cityArrival");
        String cityDeparture = request.getParameter("cityDeparture");
        String dateArrival = request.getParameter("dateArrival");
        String dateDeparture = request.getParameter("dateDeparture");
        String weight = request.getParameter("weight");
        String value = request.getParameter("value");
        String volume = request.getParameter("volume");
        String tranporterCardid = request.getParameter("tranporterCardid");

        if (id.equals("") || cityArrival.equals("") || cityDeparture.equals("") || dateArrival.equals("") || dateDeparture.equals("") || weight.equals("") || value.equals("") || volume.equals("") || tranporterCardid.equals("")) {
            String error = "Campos vacíos...";
        } else {
            try {
                int i = Integer.parseInt(id);
                int ca = Integer.parseInt(cityArrival);
                int cd = Integer.parseInt(cityDeparture);
                float w = Float.parseFloat(weight);
                float va  = Float.parseFloat(value);
                float vo = Float.parseFloat(volume);
                space = new Space(i, ca, cd, dateArrival, dateDeparture, w, va, vo, tranporterCardid);
                update(request, response);
            } catch (NumberFormatException e) {
                String error = "Ingrese solo números";
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id.equals("")) {
            String error = "Campos vacíos...";
        } else {
            try {
                int i = Integer.parseInt(id);
                space = new Space(i);
                inactivate(request, response);
            } catch (NumberFormatException e) {
                String error = "Ingrese solo números";
            }
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sql = space.create(space);
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

        String sql = space.read(space.getId());
        ResultSet res = connect.read(sql);

        if (res == null) {
            System.out.println("Error");
        } else {
            try {
                while (res.next()) {
                    space = new Space(res.getInt("id"), res.getInt("cityarrival"), res.getInt("citydeparture"), res.getString("datearrival"), res.getString("datedeparture"), res.getFloat("weight"), res.getFloat("value"), res.getFloat("volume"), res.getString("truck_licenseplate"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(SpaceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sql = space.update(space);
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

        String sql = space.inactivate(space.getId());
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
