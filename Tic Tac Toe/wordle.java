import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.Random;


public class wordle {
        public void wordleGame(){
            Scanner scnr;
                try{
                    Random rndm = new Random();
                    FileInputStream wordList = new FileInputStream("wordList.txt");
                    scnr = new Scanner(wordList);
                    String[] words = scnr.nextLine().split(" ");
                    String secretWord = words[rndm.nextInt(words.length+1)];
                    String currentGuess = "";
                    int guessNum = 0;
                    Scanner userInput = new Scanner(System.in);
                    while(!currentGuess.equalsIgnoreCase(secretWord) && guessNum < 6){
                        System.out.println("Guess a 5 letter word:");
                        String hintword = "";
                        currentGuess = userInput.nextLine();
                        while(currentGuess.length() != 5){
                            System.out.println("The word must be 5 letters long! Try again.");
                            currentGuess = userInput.nextLine();
                        }
                        for(int i = 0; i<5; i++){
                            if(Character.toUpperCase(currentGuess.charAt(i)) == secretWord.charAt(i)){
                                hintword = hintword + Character.toUpperCase(currentGuess.charAt(i));
                            }
                            else if(secretWord.indexOf(Character.toUpperCase(currentGuess.charAt(i))) != -1){
                                hintword = hintword + "(" + Character.toUpperCase(currentGuess.charAt(i)) + ")";
                            }
                            else{
                                hintword = hintword + "0";
                            }
                        }
                        
                        System.out.println(hintword);
                        guessNum ++;
                    }
                    if(secretWord.equalsIgnoreCase(currentGuess)){
                        System.out.println("Congratulations! You guessed the word!");
                    }
                    else{
                        System.out.println("Better luck next time!");
                        System.out.println("The secret word was "+ secretWord);
                    }
                }
                catch(IOException e){
                    System.out.println("Whoops you done goofed up you're on your own for this one :)");
                    System.out.println(e);
                }
        }
}
