package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;

public class LoginController extends HttpServlet {

    private Person person;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cardid = request.getParameter("cardid");
        String password = request.getParameter("password");

        if (cardid.equals("") || password.equals("")) {
            String error = "Datos nulos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            try {
                int card = Integer.parseInt(cardid);
                person = new Person(card, null, password, 0);
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try {
            login(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {

        try {
            Person instance = new Person();
            boolean message = instance.login(person);
            if (message) {
                response.addCookie(new Cookie("cardid", "" + person.getCardid()));
                request.getSession().setAttribute("cardid", "" + person.getCardid());
                request.getRequestDispatcher("listTruck.jsp").forward(request, response);
            } else {
                System.out.println("Datos incorrectos");
            }

        } catch (SQLException e) {
            String error = "Error al guardar";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}
