package model;

import org.junit.*;
import static org.junit.Assert.*;

public class PersonTest {

    public PersonTest() {
        System.out.println("Person");
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

    /*@Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Person person = new Person(1057, "Daniel Roa", "123", 320, null);
        Person instance = new Person();
        String expResult = "Success";
        String result = instance.create(person);
        System.out.println(expResult);
        System.out.println(result);
        assertEquals(expResult, result);
    }*/
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        Person instance = new Person();
        int cardid = 1056;
        Person expResult = new Person(1056, "Brayan Vargas", null, 312, null);
        Person result = instance.read(cardid);
        assertEquals(expResult.getCardid(), result.getCardid());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getPhone(), result.getPhone());
        assertEquals(expResult.getStatus(), result.getStatus());
    }

    /*
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Person person = new Person(1057, "Daniel Roa", "123", 320312, null);
        Person instance = new Person();
        String expResult = "Success";
        String result = instance.update(person);
        assertEquals(expResult, result);
    }

    @Test
    public void testInactivate() throws Exception {
        System.out.println("inactivate");
        int cardid = 1057;
        Person instance = new Person();
        String expResult = "Success";
        String result = instance.inactivate(cardid);
        assertEquals(expResult, result);
    }
     */
}
