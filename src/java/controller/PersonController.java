package controller;

import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Person;

@WebServlet(name = "PersonController", urlPatterns = {"/person"})
public class PersonController extends HttpServlet {

    Person person;
    Connect connect = new Connect();
    String sql;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cardid = request.getParameter("cardid");
        if (cardid.equals("")) {
            String error = "Campos vacíos...";
        } else {
            int c = Integer.parseInt(cardid);
            person = new Person(c, null, null, 1, "active");

            try {
                person = person.read(person.getCardid());
                System.out.println(person.getName());
            } catch (Exception ex) {
                Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cardid = request.getParameter("cardid");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        if (cardid.equals("") || name.equals("") || password.equals("") || phone.equals("")) {
            String error = "Campos vacíos...";
        } else {
            try {
                int c = Integer.parseInt(cardid);
                int p = Integer.parseInt(phone);
                person = new Person(c, name, password, p, "active");
                String res = person.create(person);
                System.out.print(res);
            } catch (NumberFormatException e) {
                String error = "Ingrese solo números";
            } catch (Exception ex) {
                Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cardid = request.getParameter("cardid");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        System.out.println(cardid);
        System.out.println(CharStreams.toString(new InputStreamReader(request.getInputStream(), "UTF-8")));
        System.out.println(password);
        System.out.println(phone);
        /*
        if (cardid.equals("") || name.equals("") || password.equals("") || phone.equals("")) {
            String error = "Campos vacíos...";
        } else {
            try {
                int c = Integer.parseInt(cardid);
                int p = Integer.parseInt(phone);
                person = new Person(c, name, password, p, null);
                String sql = person.update(person);

            } catch (NumberFormatException e) {
                String error = "Ingrese solo números";
            } catch (Exception ex) {
                Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         */
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cardid = request.getParameter("cardid");
        System.out.println("asdlfjk");
        if (cardid.equals("")) {
            String error = "Campos vacíos...";
        } else {
            try {
                int c = Integer.parseInt(cardid);
                person = new Person(c, null, null, 0, "disabled");

                String sql = person.inactivate(person.getCardid());
                System.out.println(sql);
            } catch (NumberFormatException e) {
                String error = "Ingrese solo números";
            } catch (Exception ex) {
                Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
