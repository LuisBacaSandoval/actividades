package org.example;

import java.util.Scanner;

public class Game {//Metodo principal, en él se podrá jugar
    private IWordSelector wordSelector;
    private IHintGenerator hintGenerator;
    private Word hiddenWord;//atributo que almacena la palabra aleatoria
    private int attemptsLeft = 5;//atributo que almacena el numero de intentos

    public Game(DependencyInjector dependencyInjector) {//constructor, inyecta depencias
        /*
        this.wordSelector = wordSelector;
        this.hintGenerator = hintGenerator;
        */
        this.wordSelector = dependencyInjector.getDependency(IWordSelector.class);
        this.hintGenerator = dependencyInjector.getDependency(IHintGenerator.class);
    }

    public void start() {//metodo para comenzar el juego
        this.hiddenWord = wordSelector.selectWord();
        System.out.println(hiddenWord.getWord());
        System.out.println("Pista inicial: " + hintGenerator.generateInitialHint(hiddenWord));
    }

    public String verifyGuess(String guess){//este método verifica si la palabra ingresada por el usuario es correcta
        if (guess.equalsIgnoreCase(hiddenWord.getWord())){//true si adivinó, false si no adivinó
            attemptsLeft=-1;
            return "¡Felicidades! Adivinaste la palabra correcta.";//se retorna la cadena si adivinaste la palabra
        }else{
            attemptsLeft--;
            if (attemptsLeft == 0) {
                return "Lo siento, no adivinaste la palabra. La palabra era: " + hiddenWord.getWord();//se retorna la cadena si no adivinaste la palabra
            }
            return  hintGenerator.generateHint(hiddenWord.getWord(), guess);//se retorna retroalimentación si aun quedan intentos
        }
    }

    public int getAttemptsLeft(){
        return this.attemptsLeft;
    }

    public static void main(String[] args) {
        /*
        IWordSelector wordSelector = new WordSelector();
        IHintGenerator hintGenerator = new HintGenerator();
        Game game = new Game(wordSelector, hintGenerator);
        */
        System.out.println("¡Bienvenido al juego de adivinanza de palabras!");

        DependencyInjector dependencyInjector = new DependencyInjector();
        dependencyInjector.addDependency(IWordSelector.class, new WordSelector());
        dependencyInjector.addDependency(IHintGenerator.class, new HintGenerator());

        Game game = new Game(dependencyInjector);
        game.start();

        Scanner scanner = new Scanner(System.in);

        //lógica del juego
        while (game.getAttemptsLeft()>0){
            System.out.println();
            System.out.println("Número de intentos: "+game.getAttemptsLeft());
            System.out.print("Ingresa tu adivinanza: ");
            String guess = scanner.nextLine();
            String result = game.verifyGuess(guess);
            System.out.println(result);
        }
    }
}