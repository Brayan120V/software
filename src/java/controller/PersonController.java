package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;

public class PersonController extends HttpServlet {

    private Person person;
    private String role;

    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie ck[] = request.getCookies();

        for (int i = 0; i < ck.length; i++) {
            System.out.println(ck[i].getName() + " " + ck[i].getValue());
            if (true) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
                i = ck.length;
            }
        }

        String cardid = ck[0].getValue();

        if (cardid.equals("")) {
            String error = "Datos nulos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            try {
                int card = Integer.parseInt(cardid);
                person = new Person(card, null, null, 0);
                read(request, response);
            } catch (Exception e) {
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
            String cardid = request.getParameter("cardid");
            String name = request.getParameter("name");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            role = request.getParameter("role");

            if (cardid.equals("") || name.equals("") || password.equals("") || phone.equals("") || role.equals("")) {
                String error = "Datos nulos";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                try {
                    int card = Integer.parseInt(cardid);
                    int ph = Integer.parseInt(phone);
                    person = new Person(card, name, password, ph);
                    create(request, response);
                } catch (Exception e) {
                }
            }
        }

    }

    protected void processRequestPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie ck[] = request.getCookies();

        String cardid = ck[0].getValue();

        if (cardid == null || cardid.equals("")) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        if (cardid.equals("") || name.equals("") || password.equals("") || phone.equals("")) {
            String error = "Datos nulos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            try {
                int card = Integer.parseInt(cardid);
                int ph = Integer.parseInt(phone);
                person = new Person(card, name, password, ph);
                update(request, response);
            } catch (Exception e) {
            }
        }

    }

    protected void processRequestDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie ck[] = request.getCookies();

        String cardid = ck[0].getValue();

        if (cardid == null || cardid.equals("")) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        if (cardid.equals("")) {
            String error = "Datos nulos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            try {
                int card = Integer.parseInt(cardid);
                person = new Person(card, null, null, 0);
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
            Person instance = new Person();
            String message = instance.create(person, role);
            request.getSession().setAttribute("message", message);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al guardar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void read(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        try {
            Person instance = new Person();
            Person res = instance.read(person.getCardid());
            request.getSession().setAttribute("person", res);
            System.out.println(res.getName());
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al buscar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        try {
            Person instance = new Person();
            String res = instance.update(person);
            request.getSession().setAttribute("res", res);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (SQLException e) {
            String error = "Error al buscar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        Person instance = new Person();
        String res = instance.inactivate(person.getCardid());
        if (res.equals("Success")) {
            Cookie cookie = new Cookie("cardid", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}
