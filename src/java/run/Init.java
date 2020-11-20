package run;

import model.Person;
import model.Space;
import model.Truck;

public class Init {

    public static void main(String[] args) throws Exception {
        Person personInstance = new Person(1038, "Mario Forero", "abc123", 312399);
        Truck truck = new Truck(1, 1, 1, "base32", 1, "tor123", "truck", personInstance);

        personInstance.create(personInstance, "transporter");
        String res = truck.create(truck);
        System.out.println(res);

    }
}
