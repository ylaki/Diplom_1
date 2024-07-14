import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {

        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        // Scenario 1: Single sauce
                        {IngredientType.SAUCE, "Соус Spicy-X", 90f},
                        // Scenario 2: Single filling
                        {IngredientType.FILLING, "Мясо бессмертных моллюсков Protostomia", 1337f}
                }
        );
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(type,name,price);
        assertEquals(price, ingredient.getPrice(),0.001);
        }

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(type,name,price);
            assertEquals(name, ingredient.getName());
        }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(type,name,price);
            assertEquals(type, ingredient.getType());
        }
    }
