package TestPackages;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;

public class TestCaseForUnoGame {

    private static boolean checkLength(int number) {
        return false;
    }

    private static boolean checkLength(String name) {
        return false;
    }

    private static boolean checkUpper(String pass) {
        return false;
    }

    private static void startGame(Object object, boolean b) {
    }

    public TestCaseForUnoGame() {
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
    public void testInputValidNumberOfPlayer() {
        int number = 2;
        boolean result = TestCaseForUnoGame.checkLength(number);
        assertEquals(true, result);
    }

    public void testInputInvalidNumberOfPlayer() {
        int number = -1;
        boolean result = TestCaseForUnoGame.checkLength(number);
        assertEquals(true, result);
    }

    public void testPlayvalidCard() {
        String name = "Reverse";
        boolean result = TestCaseForUnoGame.checkLength(name);
        assertEquals(true, result);
    }

    public void testPlayInvalidCard() {
        String name = "5651";
        boolean result = TestCaseForUnoGame.checkLength(name);
        assertEquals(false, result);

    }

    public void testPlayvalidColor() {
        String name = "Red , green, blue, yellow";
        boolean result = TestCaseForUnoGame.checkLength(name);
        assertEquals(true, result);
    }

    public void testPlayInvalidColor() {
        String name = "Black";
        boolean result = TestCaseForUnoGame.checkLength(name);
        assertEquals(false, result);
    }
    
}
