import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testValidDates() {
        assertEquals("17/5/2000", App.getNextDate(16, 5, 2000));
        assertEquals("2/1/2012", App.getNextDate(1, 1, 2012));
        assertEquals("1/1/2003", App.getNextDate(31, 12, 2002));
        assertEquals("1/4/2024", App.getNextDate(31, 3, 2024));
        assertEquals("1/3/2021", App.getNextDate(28, 2, 2021));
    }

    @Test
    public void testInvalidDates() {
        assertEquals("ERROR: Date is not valid.", App.getNextDate(15, 14, 2002));
        assertEquals("ERROR: Date is not valid.", App.getNextDate(1, 2, 2213));
        assertEquals("ERROR: Date is not valid.", App.getNextDate(29, 2, 2006));
        assertEquals("ERROR: Date is not valid.", App.getNextDate(3, 3, 1810));
        assertEquals("ERROR: Date is not valid.", App.getNextDate(32, 3, 2023));
    }

    @Test
    public void testLeapYearDates() {
        assertEquals("29/2/2024", App.getNextDate(28, 2, 2024));
        assertEquals("1/3/2020", App.getNextDate(29, 2, 2020));
    }
}
