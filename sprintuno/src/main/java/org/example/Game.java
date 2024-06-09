package org.example;

public class Game {//Metodo principal, en él se podrá jugar
    private WordSelector wordSelector;
    private HintGenerator hintGenerator;
    private Word hiddenWord;//atributo que almacena la palabra aleatoria
    private int attemptsLeft;//atributo que almacena el numero de intentos

    public Game() {
        this.wordSelector = new WordSelector();
        this.hintGenerator = new HintGenerator();
        this.hiddenWord = wordSelector.selectWord();
        this.attemptsLeft = 2; // Numero de intentos
    }

    public void start() {//metodo para comenzar el juego
        System.out.println("¡Bienvenido al juego de adivinanza de palabras!");
        System.out.println("Pista inicial: " + hintGenerator.generateInitialHint(hiddenWord));
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}