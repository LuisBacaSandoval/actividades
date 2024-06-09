package org.example;

public class HintGenerator {
    public String generateInitialHint(Word word) {//este método devolverá la primera pista, el numero de letras de la palabra
        return "La palabra tiene " + word.getWord().length() + " letras.";
    }
    public String generateHint(String hiddenWord, String guess) {//este método devolverá la pista, se implementará en el siguiente sprint
        int correctPositions = 0;

        for (int i = 0; i < Math.min(hiddenWord.length(), guess.length()); i++) {
            if (hiddenWord.charAt(i) == guess.charAt(i)) {
                correctPositions++;
            }
        }

        return "Tienes " + correctPositions + " letras correctas en la posicion correcta.";
    }
}