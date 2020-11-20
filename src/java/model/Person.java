package model;

import controller.Connect;
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

    public Person(int cardid) {
        this.cardid = cardid;
    }

    public Person(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public Person(int cardid, String name, String password, int phone) {
        this.cardid = cardid;
        this.name = name;
        this.password = password;
        this.phone = phone;
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

    public String create(Person person, String role) throws Exception {
        String message = null;
        Statement statement = null;
        Connection connection = null;
        if (this.find(person.getCardid()) == null) {
            String finalSql = "begin transaction; ";
            String sql = "insert into person "
                    + "values("
                    + person.getCardid() + ",'"
                    + person.getName() + "','"
                    + person.getPassword() + "',"
                    + person.getPhone() + ");";
            if (role.equals("transporter")) {
                finalSql += sql + "insert into transporter(person_cardid) values(" + person.getCardid() + "); ";
            } else if (role.equals("client")) {
                finalSql += sql + "insert into client values(" + person.getCardid() + "); ";
            } else {
                return message = "Error creating transaction";
            }
            finalSql += "commit;";
            try {
                connection = (Connection) connect.connect();
                statement = connection.createStatement();
                int res = statement.executeUpdate(finalSql);

                if (this.find(person.getCardid()) == null) {
                    message = "Error saving person";
                } else {
                    message = "Success";
                }
            } catch (SQLException ex) {
                message = "Error " + ex;
                System.err.println(ex);
            }
            statement.close();
            connection.close();
        }

        return message;
    }

    public Person read(int cardid) throws Exception {
        Person person = this.find(cardid);
        System.out.println(person.password);
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
        System.out.println(cardid);
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
        String sql = "select cardid, name, password, phone from person "
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
                    person = new Person(result.getInt("cardid"), result.getString("name"), result.getString("password"), result.getInt("phone"), null);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        statement.close();
        return person;
    }

    public boolean login(Person person) throws Exception {
        Person dbPerson = this.find(person.getCardid());
        return dbPerson.getCardid() == person.getCardid() && dbPerson.getPassword().equals(person.getPassword());
    }

}
