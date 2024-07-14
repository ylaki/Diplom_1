import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockBun;
    private Burger mockBurger;

    @Before
    public void setUp() {
        when(mockBun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        when(mockBun.getPrice()).thenReturn(988f);

        mockBurger = new Burger();
        mockBurger.setBuns(mockBun);
    }

    @Test
    public void testAddIngredientQuantity() {
        Ingredient mockIngredient = mock(Ingredient.class);

        mockBurger.addIngredient(mockIngredient);
        assertEquals(1, mockBurger.ingredients.size());
    }

    @Test
    public void testAddIngredient() {
        Ingredient mockIngredient = mock(Ingredient.class);
        mockBurger.addIngredient(mockIngredient);
        assertEquals(mockIngredient, mockBurger.ingredients.get(0));
    }

    @Test
    public void testRemoveIngredient() {
        Ingredient mockIngredient = mock(Ingredient.class);
        mockBurger.addIngredient(mockIngredient);
        mockBurger.removeIngredient(0);
        assertEquals(0, mockBurger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Ingredient mockIngredient1 = mock(Ingredient.class);
        Ingredient mockIngredient2 = mock(Ingredient.class);
//        when(mockIngredient1.getName()).thenReturn("Соус фирменный Space Sauce");
//        when(mockIngredient2.getName()).thenReturn("Биокотлета из марсианской Магнолии");
        mockBurger.addIngredient(mockIngredient1);
        mockBurger.addIngredient(mockIngredient2);
        mockBurger.moveIngredient(0, 1);
        assertEquals(mockIngredient1, mockBurger.ingredients.get(1));
        assertEquals(mockIngredient2, mockBurger.ingredients.get(0));
    }

    @Test
    public void testGetPrice() {
        Ingredient mockIngredient = mock(Ingredient.class);
        when(mockIngredient.getPrice()).thenReturn(80f);
        mockBurger.addIngredient(mockIngredient);
        float expectedPrice = mockBun.getPrice() * 2 + mockIngredient.getPrice();
        assertEquals(expectedPrice, mockBurger.getPrice(), 0.001);
}

    @Test
    public void testGetReceipt() {
        Ingredient mockIngredient = mock(Ingredient.class);
        when(mockIngredient.getName()).thenReturn("Соус фирменный Space Sauce");
        when(mockIngredient.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient.getPrice()).thenReturn(80f);
        mockBurger.addIngredient(mockIngredient);

        String expectedReceipt = String.format("(==== Флюоресцентная булка R2-D3 ====)%n") +
                String.format("= sauce Соус фирменный Space Sauce =%n") +
                String.format("(==== Флюоресцентная булка R2-D3 ====)%n") +
                String.format("%nPrice: 2056.000000%n");
        System.out.println(expectedReceipt);
        System.out.println(mockBurger.getReceipt());
        assertEquals(expectedReceipt, mockBurger.getReceipt());
    }
    }
