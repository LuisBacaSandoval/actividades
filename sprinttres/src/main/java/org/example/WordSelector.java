package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordSelector implements IWordSelector{
    private List<Word> wordList;

    public WordSelector() {//constructor de la clase, añade 4 palabras
        wordList = new ArrayList<>();
        wordList.add(new Word("ciencias"));
        wordList.add(new Word("computacion"));
        wordList.add(new Word("desarrollo"));
        wordList.add(new Word("software"));
    }
    public Word selectWord() {//este método devolverá una palabra aleatoria de una lista dada
        Random random = new Random();
        return wordList.get(random.nextInt(wordList.size()));
    }
}
