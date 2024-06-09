package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    //este test verifica que el método verifyGuess() retorne false, ya que la palabra ingresada no es correcta
    @Test
    public void testVerifyGuessIncorrect(){
        Game game = new Game();
        String incorrectWord = "manzana";

        Boolean result = game.verifyGuess(incorrectWord);

        assertFalse(result);
    }
    //este test verifica que el método verifyGuess() retorne true, ya que la palabra ingresada es correcta
    @Test
    public void testVerifyGuessCorrect() {
        Game game = new Game();
        Word hiddenWord = game.getHiddenWord();

        Boolean result = game.verifyGuess(hiddenWord.getWord());

        assertTrue(result);
    }

}