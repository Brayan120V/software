package run;

import model.Person;
import model.Space;
import model.Truck;

public class Init {
    
    public static void main(String[] args) throws Exception {
        Person personInstance = new Person(1032, "Mario Forero", "abc123", 312389);
        Truck truckInstance = new Truck(3, 12, 2, "base64", 10, "INS189", "truck", personInstance);
        Space spaceInstance = new Space(3, 201, "2020-10-09", "2020-10-10", 10, 30, 24, truckInstance);

//        personInstance.create(personInstance, "transporter");
//        truckInstance.create(truckInstance);
//        spaceInstance.create(spaceInstance);
        System.out.println(truckInstance.inactivate(truckInstance.getLicensePlate()));
        
    }
}
