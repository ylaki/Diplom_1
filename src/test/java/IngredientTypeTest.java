import org.junit.Test;
import static org.junit.Assert.*;
import praktikum.IngredientType;

public class IngredientTypeTest {

    @Test
    public void testEnumSauce() {
        assertEquals("SAUCE", IngredientType.SAUCE.name());
    }

    @Test
    public void testEnumFilling() {
        assertEquals("FILLING", IngredientType.FILLING.name());
    }
}
