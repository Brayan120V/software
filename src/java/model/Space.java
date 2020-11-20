package model;

import controller.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Space {

    private int id;
    private int cityArrival;
    private int cityDeparture;
    private String dateArrival;
    private String dateDeparture;
    private float weight;
    private float value;
    private float volume;
    private Truck truck = new Truck();

    Connect connect = new Connect();

    public Space() {
    }

    public Space(int id) {
        this.id = id;
    }

    public Space(Truck truck) {
        this.truck = truck;
    }

    public Space(int cityArrival, int cityDeparture, String dateArrival, String dateDeparture, float weight, float value, float volume, Truck truck) {
        this.cityArrival = cityArrival;
        this.cityDeparture = cityDeparture;
        this.dateArrival = dateArrival;
        this.dateDeparture = dateDeparture;
        this.weight = weight;
        this.value = value;
        this.volume = volume;
        this.truck = truck;
    }

    public Space(int id, int cityArrival, int cityDeparture, String dateArrival, String dateDeparture, float weight, float value, float volume, Truck truck) {
        this.id = id;
        this.cityArrival = cityArrival;
        this.cityDeparture = cityDeparture;
        this.dateArrival = dateArrival;
        this.dateDeparture = dateDeparture;
        this.weight = weight;
        this.value = value;
        this.volume = volume;
        this.truck = truck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityArrival() {
        return cityArrival;
    }

    public void setCityArrival(int cityArrival) {
        this.cityArrival = cityArrival;
    }

    public int getCityDeparture() {
        return cityDeparture;
    }

    public void setCityDeparture(int cityDeparture) {
        this.cityDeparture = cityDeparture;
    }

    public String getDateArrival() {
        return dateArrival;
    }

    public void setDateArrival(String dateArrival) {
        this.dateArrival = dateArrival;
    }

    public String getDateDeparture() {
        return dateDeparture;
    }

    public void setDateDeparture(String dateDeparture) {
        this.dateDeparture = dateDeparture;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public String create(Space space) throws Exception {
        String message = "";
        if (this.find(space.getId()) == null) {
            Statement statement = null;
            String sql = "insert into space(cityarrival, citydeparture, datearrival, "
                    + "datedeparture, weight, value, volume, truck_licenseplate) "
                    + "values(" + space.getCityArrival() + ","
                    + space.getCityDeparture() + ", '"
                    + space.getDateArrival() + "', '"
                    + space.getDateDeparture() + "', "
                    + space.getWeight() + ", "
                    + space.getValue() + ", "
                    + space.getVolume() + ", '"
                    + space.getTruck().getLicensePlate() + "');";
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

    public Space read(int id) throws Exception {
        Space space = this.find(id);
        return space;
    }

    public String update(Space space) throws Exception {
        String message = "";
        if (this.find(space.getId()) != null) {
            Statement statement = null;
            String sql = "update space "
                    + "set cityarrival = " + space.getCityArrival()
                    + ", citydeparture = " + space.getCityDeparture()
                    + ", datearrival = '" + space.getDateArrival()
                    + "', datedeparture = '" + space.getDateDeparture()
                    + "', weight = " + space.getWeight()
                    + ", value = " + space.getValue()
                    + ", volume = " + space.getVolume() + " "
                    + "where id = '" + space.getId() + "';";
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

    public String inactivate(int id) throws Exception {
        String message = "";
        if (this.find(id) != null) {
            Statement statement = null;
            String sql = "update space "
                    + "set status = 'disabled' "
                    + "where id = " + id + ";";
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

    public Space find(int id) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        Space space = null;
        String sql = "select cardid, name, phone, "
                + "highbodywork, longbodywork, widthbodywork, photo, maxweight, licenseplate, type, "
                + "id, cityarrival, citydeparture, "
                + "datearrival, datedeparture, weight, value, volume "
                + "from space, truck, transporter, person "
                + "where transporter_person_cardid = person_cardid "
                + "and person_cardid = cardid "
                + "and truck_licenseplate = licenseplate "
                + "and space.status = 'active' "
                + "and id = " + id + ";";

        /*
        String sql = "select cardid, name, phone, "
                + "highbodywork, longbodywork, widthbodywork, photo, maxweight, licenseplate, type"
                + "id, (select name from city where code = cityarrival) as cityarrival, "
                + "(select name from city where code = citydeparture), "
                + "datearrival, datedeparture, weight, value, volume "
                + "from space, truck, transporter, person "
                + "where transporter_person_cardid = person_cardid "
                + "and person_cardid = cardid "
                + "and truck_licenseplate = licenseplate "
                + "and id = " + id + ";";
         */
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
                    space = new Space(result.getInt("id"),
                            result.getInt("cityarrival"), result.getInt("citydeparture"),
                            result.getString("datearrival"), result.getString("datedeparture"),
                            result.getFloat("weight"), result.getFloat("value"), result.getFloat("volume"),
                            new Truck(result.getFloat("highbodywork"),
                                    result.getFloat("longbodywork"), result.getFloat("widthbodywork"),
                                    result.getString("photo"), result.getFloat("maxweight"),
                                    result.getString("licenseplate"), result.getString("type"),
                                    new Person(result.getInt("cardid"), result.getString("name"), null, result.getInt("phone"), null)));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        statement.close();
        return space;
    }

    public ArrayList<Space> findArray(int cardid) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        ArrayList<Space> spaces = new ArrayList<>();
        String sql = "select cardid, name, phone, "
                + "highbodywork, longbodywork, widthbodywork, photo, maxweight, licenseplate, type, "
                + "id, cityarrival, citydeparture, "
                + "datearrival, datedeparture, weight, value, volume "
                + "from space, truck, transporter, person "
                + "where transporter_person_cardid = person_cardid "
                + "and person_cardid = " + cardid + " "
                + "and truck_licenseplate = licenseplate "
                + "and space.status = 'active';";

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
                    Space space = new Space(result.getInt("id"),
                            result.getInt("cityarrival"), result.getInt("citydeparture"),
                            result.getString("datearrival"), result.getString("datedeparture"),
                            result.getFloat("weight"), result.getFloat("value"), result.getFloat("volume"),
                            new Truck(result.getFloat("highbodywork"),
                                    result.getFloat("longbodywork"), result.getFloat("widthbodywork"),
                                    result.getString("photo"), result.getFloat("maxweight"),
                                    result.getString("licenseplate"), result.getString("type"),
                                    new Person(result.getInt("cardid"), result.getString("name"), null, result.getInt("phone"), null)));
                    spaces.add(space);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        statement.close();
        return spaces;
    }

    public Person contract(int id) throws Exception {
        Space space = this.read(id);
        Person person = new Person(space.getTruck().getPerson().getName(), space.getTruck().getPerson().getPhone());
        return person;
    }

}
