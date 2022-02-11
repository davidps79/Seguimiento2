package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.NegativeNumberException;

class IngredientTest {
	Ingredient ingredient;
	
	// Stages

	public void setupStage1() {
		ingredient = new Ingredient("Tomate", 245);
	}
	
	@BeforeEach
	void beforeEach(){
		setupStage1();
	}
	
	@Test
	void test1() {
		try {
			ingredient.addWeight(54);
			assertEquals(ingredient.getWeight(), 299);
		} catch(NegativeNumberException e) {
			fail("No se deberia producir la excepcion");
		}
	}
	
	@Test
	void test2() throws NegativeNumberException{
		try {
			ingredient.addWeight(-100);
			fail("No se produjo la excepcion");
		} catch (NegativeNumberException e) {
			assertEquals(ingredient.getWeight(), 245);
		}
	}
}
