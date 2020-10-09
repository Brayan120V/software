package model;

import org.junit.*;
import static org.junit.Assert.*;

public class SpaceTest {

    public SpaceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

//    @Test
//    public void testCreate() throws Exception {
//        System.out.println("create");
//        Space space = new Space(200, 201, "2020-10-20", "2020-10-20", 10, 35, 45,
//                new Truck("AEA123", new Person(1047, "Manuel Castro", null, 310272, null)));
//        Space instance = new Space();
//        String expResult = "Success";
//        String result = instance.create(space);
//        assertEquals(expResult, result);
//
//    }

//    @Test
//    public void testRead() throws Exception {
//        System.out.println("read");
//        int id = 2;
//        Space instance = new Space();
//        Space expResult = new Space(2, 1, 3, "2020-08-20", "2020-08-20", 10, 45, 45,
//                new Truck(2, 11, 2, "123121321", 10, "AEA123", "truck", new Person(1047, "Manuel Castro", null, 310272, null)));
//        Space result = instance.read(id);
//        assertEquals(expResult.getId(), result.getId());
//        assertEquals(expResult.getTruck().getLicensePlate(), result.getTruck().getLicensePlate());
//        assertEquals(expResult.getTruck().getPerson().getCardid(), result.getTruck().getPerson().getCardid());
//
//    }

    /*
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Space space = null;
        Space instance = new Space();
        String expResult = "";
        String result = instance.update(space);
        assertEquals(expResult, result);

    }
*/
    @Test
    public void testInactivate() throws Exception {
        System.out.println("inactivate");
        int id = 2;
        Space instance = new Space();
        String expResult = "Success";
        String result = instance.inactivate(id);
        assertEquals(expResult, result);

    }
     
}
