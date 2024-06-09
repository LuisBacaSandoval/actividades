package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class WordSelectorTest {
    private WordSelector wordSelector;

    @BeforeEach
    public void setUp() {
        wordSelector = new WordSelector();
    }

    //este test verifica que la palabra que retorna la funcion, no sea nula
    @Test
    public void palabraSeleccionadaNoNula(){
        Word word = wordSelector.selectWord();//seleciona una palabra

        assertNotNull(word, "La palabra seleccionada no debería ser nula");
    }
    //este test verifica que la palabra seleccionada por el método selectWord() debe estar dentro de la lista de palabras
    @Test
    public void palabraSeleccionadaSeEncuentraEnLaLista() {
        String[] validWords = {"ciencias", "computacion", "desarrollo", "software"};//lista de palabras

        Word word = wordSelector.selectWord();//seleciona una palabra

        assertTrue(asList(validWords).contains(word.getWord()), "La palabra seleccionada debería estar en la lista de palabras");
    }
}