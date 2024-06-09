package org.example;

// Interfaz IHintGenerator
public interface IHintGenerator {
    String generateHint(String hiddenWord, String guess);
    public String generateInitialHint(Word word);
}
