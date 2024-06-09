package org.example;

public class HintGenerator {
    public String generateInitialHint(Word word) {//este método devolverá la primera pista, el numero de letras de la palabra
        return "La palabra tiene " + word.getWord().length() + " letras.";
    }
    public String generateHint(String hiddenWord, String guess) {//este método devolverá la pista, se implementará en el siguiente sprint
        return "Esta es una pista.";
    }
}