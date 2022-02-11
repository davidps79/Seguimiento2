package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import exception.NegativeNumberException;

class RecipeTest {
	private Recipe recipe;
	
	// Stages

	public void setupStage1() {
		recipe = new Recipe();
	}
	
	public void setupStage2() {
		recipe = new Recipe();
		try {
			recipe.addIngredient("Cebolla", 315);
			recipe.addIngredient("Ajo", 58);
			recipe.addIngredient("Arroz", 520);
		} catch (NegativeNumberException e) {
			fail("No deberia producirse una excepcion de este tipo");
		}
	}
	
	@Test
	void test1() {
		setupStage1();
		try {
			recipe.addIngredient("Sal", 12);
			assertEquals(recipe.getIngredients().size(), 1);
			assertEquals(recipe.getIngredients().get(0).getName(), "Sal");
			assertEquals(recipe.getIngredients().get(0).getWeight(), 12);
		} catch (NegativeNumberException e) {
			fail("No deberia producirse una excepcion de este tipo");
		}
		
	}

	@Test
	void test2() {
		setupStage2();
		try {
			recipe.addIngredient("Pimienta", 6);
			assertEquals(recipe.getIngredients().size(), 4);
			assertEquals(recipe.getIngredients().get(3).getName(), "Pimienta");
			assertEquals(recipe.getIngredients().get(3).getWeight(), 6);
		} catch (NegativeNumberException e) {
			fail("No deberia producirse una excepcion de este tipo");
		}
		
	}
	
	@Test
	void test3() {
		setupStage2();
		try {
			recipe.addIngredient("Ajo", 21);
			assertEquals(recipe.getIngredients().size(), 3);
			assertEquals(recipe.getIngredients().get(1).getName(), "Ajo");
			assertEquals(recipe.getIngredients().get(1).getWeight(), 79);
		} catch (NegativeNumberException e) {
			fail("No deberia producirse una excepcion de este tipo");
		}

	}
	
	@Test
	void test4() {
		setupStage2();
		recipe.removeIngredient("Ajo");
		assertEquals(recipe.getIngredients().size(), 2);
		assertEquals(recipe.getIngredients().get(0).getName(), "Cebolla");
		assertEquals(recipe.getIngredients().get(1).getName(), "Arroz");
	}
}
