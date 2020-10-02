package model;

import controller.Connect;
import controller.PersonController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Person {

    private int cardid;
    private String name;
    private String password;
    private int phone;
    private String status;

    Connect connect = new Connect();

    public Person() {
    }

    public Person(int cardid, String name, String password, int phone, String status) {
        this.cardid = cardid;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.status = status;
    }

    public int getCardid() {
        return cardid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String create(Person person) throws Exception {
        String message = null;
        if (this.find(person.getCardid()) == null) {
            Statement statement = null;
            String sql = "insert into person "
                    + "values("
                    + person.getCardid() + ",'"
                    + person.getName() + "','"
                    + person.getPassword() + "',"
                    + person.getPhone() + ");";
            try {
                Connection connection = (Connection) connect.connect();
                statement = connection.createStatement();
                int res = statement.executeUpdate(sql);
                switch (res) {
                    case 0:
                        message = "Error";
                        break;
                    case 1:
                        message = "Success";
                        break;
                    default:
                        break;
                }
            } catch (SQLException ex) {
                message = "Error";
                System.err.println(ex);
            }
            statement.close();
        }
        return message;
    }

    public Person read(int cardid) throws Exception {
        Person person = this.find(cardid);
        return person;
    }

    public String update(Person person) throws Exception {
        String message = "";
        if (this.read(person.getCardid()) != null) {
            Statement statement = null;
            String sql = "update person "
                    + "set " + "name = '" + person.getName()
                    + "', password = '" + person.getPassword()
                    + "', phone = " + person.getPhone() + " "
                    + "where cardid = " + person.getCardid() + ";";
            try {
                Connection connection = (Connection) connect.connect();
                statement = connection.createStatement();
                int res = statement.executeUpdate(sql);
                switch (res) {
                    case 0:
                        message = "Error";
                        break;
                    case 1:
                        message = "Success";
                        break;
                    default:
                        break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
            }
            statement.close();
        }
        return message;
    }

    public String inactivate(int cardid) throws Exception {
        String message = "";
        if (this.read(cardid) != null) {
            Statement statement = null;
            String sql = "update person "
                    + "set status = 'disabled' "
                    + "where cardid = " + cardid + ";";
            try {
                Connection connection = (Connection) connect.connect();
                statement = connection.createStatement();
                int res = statement.executeUpdate(sql);
                switch (res) {
                    case 0:
                        message = "Error";
                        break;
                    case 1:
                        message = "Success";
                        break;
                    default:
                        break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            }
            statement.close();
        }
        return message;
    }

    public Person find(int cardid) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        Person person = null;
        String sql = "select cardid, name, phone from person "
                + "where cardid = " + cardid + ";";
        try {
            connection = (Connection) connect.connect();
            statement = connection.createStatement();
            result = statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            System.out.println("Error");
        } else {
            try {
                while (result.next()) {
                    person = new Person(result.getInt("cardid"), result.getString("name"), null, result.getInt("phone"), null);
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        statement.close();
        return person;
    }
}
