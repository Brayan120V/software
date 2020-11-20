package model;

import controller.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Truck {

    private float highBodywork;
    private float longBodywork;
    private float widthBodywork;
    private String photo;
    private float maxWeight;
    private String licensePlate;
    private String type;
    private Person person = new Person();

    Connect connect = new Connect();

    public Truck() {
    }

    public Truck(String licensePlate, Person person) {
        this.licensePlate = licensePlate;
        this.person = person;
    }

    public Truck(float highBodywork, float longBodywork, float widthBodywork, String photo, float maxWeight, String licensePlate, String type, Person person) {
        this.highBodywork = highBodywork;
        this.longBodywork = longBodywork;
        this.widthBodywork = widthBodywork;
        this.photo = photo;
        this.maxWeight = maxWeight;
        this.licensePlate = licensePlate;
        this.type = type;
        this.person = person;
    }

    public float getHighBodywork() {
        return highBodywork;
    }

    public void setHighBodywork(float highBodywork) {
        this.highBodywork = highBodywork;
    }

    public float getLongBodywork() {
        return longBodywork;
    }

    public void setLongBodywork(float longBodywork) {
        this.longBodywork = longBodywork;
    }

    public float getWidthBodywork() {
        return widthBodywork;
    }

    public void setWidthBodywork(float widthBodywork) {
        this.widthBodywork = widthBodywork;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String create(Truck truck) throws Exception {
        String message = "";
        if (this.find(truck.getLicensePlate()) == null) {
            Statement statement = null;
            String sql = "insert into truck "
                    + "values(" + truck.getHighBodywork() + ", "
                    + truck.getLongBodywork() + ", "
                    + truck.getWidthBodywork() + ", '"
                    + truck.getPhoto() + "', "
                    + truck.getMaxWeight() + ", '"
                    + truck.getLicensePlate() + "', '"
                    + truck.getType() + "', "
                    + truck.getPerson().getCardid() + ");";
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

    public Truck read(String licensePlate) throws Exception {
        Truck truck = this.find(licensePlate);
        return truck;
    }

    public String update(Truck truck) throws Exception {
        String message = "";
        if (this.find(truck.getLicensePlate()) != null) {
            Statement statement = null;
            String sql = "update truck "
                    + "set highbodywork = " + truck.getHighBodywork()
                    + ", longbodywork = " + truck.getLongBodywork()
                    + ", widthbodywork = " + truck.getWidthBodywork()
                    + ", photo = '" + truck.getPhoto()
                    + "', maxweight = " + truck.getMaxWeight()
                    + ",type = '" + truck.getType() + "' "
                    + "where licenseplate = '" + truck.getLicensePlate() + "';";
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

    public String inactivate(String licensePlate) throws Exception {
        String message = "";
        if (this.find(licensePlate) != null) {
            Statement statement = null;
            String sql = "update truck "
                    + "set status = 'disabled' "
                    + "where licenseplate = '" + licensePlate + "';";
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

    public Truck find(String licensePlate) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        Truck truck = null;
        String sql = "select highbodywork, longbodywork, widthbodywork, photo, maxweight, licenseplate, type, "
                + "cardid, name, phone from truck, transporter, person "
                + "where licenseplate = '" + licensePlate + "' "
                + "and transporter_person_cardid = person_cardid "
                + "and truck.status = 'active' "
                + "and person_cardid = cardid;";
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

                    truck = new Truck(result.getFloat("highbodywork"),
                            result.getFloat("longbodywork"), result.getFloat("widthbodywork"),
                            result.getString("photo"), result.getFloat("maxweight"),
                            result.getString("licenseplate"), result.getString("type"),
                            new Person(result.getInt("cardid"), result.getString("name"), null, result.getInt("phone"), null));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        statement.close();
        return truck;
    }

    public ArrayList<Truck> findArray(int cardid) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        ArrayList<Truck> trucks = new ArrayList();
        String sql = "select highbodywork, longbodywork, widthbodywork, photo, maxweight, licenseplate, type, "
                + "cardid, name, phone from truck, transporter, person "
                + "where transporter_person_cardid = " + cardid + " "
                + "and transporter_person_cardid = person_cardid "
                + "and truck.status = 'active' "
                + "and person_cardid = cardid;";
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
                int i = 0;
                while (result.next()) {
                    System.out.println("" + ++i);
                    Truck truck = new Truck(result.getFloat("highbodywork"),
                            result.getFloat("longbodywork"), result.getFloat("widthbodywork"),
                            result.getString("photo"), result.getFloat("maxweight"),
                            result.getString("licenseplate"), result.getString("type"),
                            new Person(result.getInt("cardid"), result.getString("name"), null, result.getInt("phone"), null));
                    trucks.add(truck);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        statement.close();
        return trucks;
    }

}
