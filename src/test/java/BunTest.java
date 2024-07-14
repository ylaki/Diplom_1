import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;

    @Before
    public void setUp() {
    bun = new Bun("Флюоресцентная булка R2-D3", 1976f);
    }

    @Test
    public void testGetName() {
        assertEquals("Флюоресцентная булка R2-D3", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(1976f, bun.getPrice(), 0.001);
    }
}