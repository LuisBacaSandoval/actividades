package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HintGeneratorTest {
    private HintGenerator hintGenerator;

    @BeforeEach
    public void setUp() {
        hintGenerator = new HintGenerator();
    }

    //este test verifica que a palabra inicial tenga n letras, en este caso manzana tiene 7 letras
    @Test
    public void testGenerateInitialHint() {
        Word word = new Word("manzana");

        String hint = hintGenerator.generateInitialHint(word);

        assertEquals("La palabra tiene 7 letras.", hint, "La pista inicial deberia indicar el numero correcto de letras");
    }
    //test inicial del tdd, siempre pasará ya que el metodo generateHint() de la clase HintGenerator siempre nos devolvera
    //la cadena "Esta es una pista."
    /*@Test
    public void testGenerateHint() {
        String hint = hintGenerator.generateHint("manzana", "manzana");

        assertEquals("Esta es una pista.", hint, "La pista debería indicar todas las letras correctas en la posición correcta");
    }*/
    //este test verifica que la palabra sea la correcta, la palabra en este caso solo tiene una letra
    @Test
    public void testGenerateHintOneLetterCorrect() {
        String hint = hintGenerator.generateHint("a", "a");
        assertEquals("Tienes 1 letras correctas en la posicion correcta.", hint, "La pista deberia indicar todas las letras correctas en la posición correcta");
    }
    //este test verifica que la palabra sea la incorrecta, la palabra en este caso solo tiene una letra
    @Test
    public void testGenerateHintOneLetterIncorrect() {
        String hint = hintGenerator.generateHint("z", "a");
        assertEquals("Tienes 0 letras correctas en la posicion correcta.", hint, "La pista deberia indicar todas las letras correctas en la posición correcta");
    }
    //este test verifica que una palabra sea correcta, la palabra en este caso tiene longitud mayor a 1
    @Test
    public void testGenerateHint() {
        String hint = hintGenerator.generateHint("manzana", "manzana");
        assertEquals("Tienes 7 letras correctas en la posicion correcta.", hint, "La pista debería indicar todas las letras correctas en la posición correcta");
    }
    //este test verifica que una palabra sea parcialmente correcta, la palabra en este caso tiene longitud mayor a 1
    @Test
    public void testGenerateHintPartialMatch() {
        String hint = hintGenerator.generateHint("manzana", "banana");
        assertEquals("Tienes 2 letras correctas en la posicion correcta.", hint, "La pista debería indicar la cantidad correcta de letras en la posición correcta");
    }

}