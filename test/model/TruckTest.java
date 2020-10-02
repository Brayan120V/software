package model;

import org.junit.*;
import static org.junit.Assert.*;

public class TruckTest {

    public TruckTest() {
        System.out.println("Truck");
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

    /*
     @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Truck truck = new Truck(2, 8, 3, "alsdkfj", 10, "XCN132", "truck", 1047);
        Truck instance = new Truck();
        String expResult = "Success";
        String result = instance.create(truck);
        assertEquals(expResult, result);
    }
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        String licensePlate = "XCN132";
        Truck instance = new Truck();
        
        Truck expResult = new Truck(2, 8, 3, "alsdkfj", 10, "XCN132", "truck", new Person(1047, "Manuel Castro", null, 310272, null));
        Truck result = instance.read(licensePlate);
        assertEquals(expResult.getHighBodywork(), result.getHighBodywork(), 0.0);
        assertEquals(expResult.getLongBodywork(), result.getLongBodywork(), 0.0);
        assertEquals(expResult.getWidthBodywork(), result.getWidthBodywork(), 0.0);
        assertEquals(expResult.getPhoto(), result.getPhoto());
        assertEquals(expResult.getMaxWeight(), result.getMaxWeight(), 0.0);
        assertEquals(expResult.getLicensePlate(), result.getLicensePlate());
        assertEquals(expResult.getType(), result.getType());
        assertEquals(expResult.getPerson().getCardid(), result.getPerson().getCardid());
        assertEquals(expResult.getPerson().getName(), result.getPerson().getName());
        assertEquals(expResult.getPerson().getPhone(), result.getPerson().getPhone());
    }

    /*
     @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Truck truck = new Truck(2, 8, 2, "alsdkfj", 10, "XCN132", "truck", 1047);
        Truck instance = new Truck();
        String expResult = "Success";
        String result = instance.update(truck);
        assertEquals(expResult, result);
    }

    @Test
    public void testInactivate() throws Exception {
        System.out.println("inactivate");
        String licensePlate = "XCN132";
        Truck instance = new Truck();
        String expResult = "Success";
        String result = instance.inactivate(licensePlate);
        assertEquals(expResult, result);
    }
     */
}
