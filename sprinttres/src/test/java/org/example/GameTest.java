package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {
    @Mock
    private DependencyInjector dependencyInjector;
    @Mock
    private IHintGenerator hintGenerator;
    @Mock
    private IWordSelector wordSelector;
    @InjectMocks
    private Game game;

    //este test verifica que el método verifyGuess() retorne la cadena dada, ya que la palabra ingresada no es correcta
    @Test
    public void testVerifyGuessIncorrect(){
        //utilizamos mockito para la inyección de dependencias
        when(dependencyInjector.getDependency(IHintGenerator.class)).thenReturn(new HintGenerator());
        when(dependencyInjector.getDependency(IWordSelector.class)).thenReturn(new WordSelector());

        String incorrectWord = "abcxyz";
        game = new Game(dependencyInjector);
        game.start();

        assertEquals("Tienes 0 letras correctas en la posicion correcta.", game.verifyGuess(incorrectWord));
    }
    //este test verifica que el método verifyGuess() retorne la cadena dada, ya que la palabra ingresada es correcta
    @Test
    public void testVerifyGuessCorrect() {
        //utilizamos mockito para la inyección de dependencias
        when(dependencyInjector.getDependency(IHintGenerator.class)).thenReturn(hintGenerator);
        when(dependencyInjector.getDependency(IWordSelector.class)).thenReturn(wordSelector);

        String correctWord = "platano";
        game = new Game(dependencyInjector);
        //mockeamos el comportamiento del método selectWord(), este retornará "platano" como palabra aleatoria
        when(wordSelector.selectWord()).thenReturn(new Word("platano"));

        game.start();

        assertEquals("¡Felicidades! Adivinaste la palabra correcta.", game.verifyGuess(correctWord));
    }
    //este test verifica que cuando ingresas una palabra incorrecta por 5 vez, el juego debe decir que no lograste
    //adivinar la palabra y terminar su ejecución
    @Test
    public void testVerifyZeroAttempts(){
        //utilizamos mockito para la inyección de dependencias
        when(dependencyInjector.getDependency(IHintGenerator.class)).thenReturn(hintGenerator);
        when(dependencyInjector.getDependency(IWordSelector.class)).thenReturn(wordSelector);

        String correctWord = "platano";
        game = new Game(dependencyInjector);
        //mockeamos el comportamiento del método selectWord(), este retornará "ciencias" como palabra aleatoria
        when(wordSelector.selectWord()).thenReturn(new Word("ciencias"));

        game.start();
        String result="";

        for (int i=1;i<=5;i++){
            result = game.verifyGuess("platano");
        }

        assertEquals("Lo siento, no adivinaste la palabra. La palabra era: ciencias", result);
    }
    //test para verificar que el número de intentos sea 5
    @Test
    public void testGetAttemptsLeft(){
        //utilizamos mockito para la inyección de dependencias
        when(dependencyInjector.getDependency(IHintGenerator.class)).thenReturn(new HintGenerator());
        when(dependencyInjector.getDependency(IWordSelector.class)).thenReturn(new WordSelector());

        game = new Game(dependencyInjector);

        assertEquals(5, game.getAttemptsLeft());
    }

}