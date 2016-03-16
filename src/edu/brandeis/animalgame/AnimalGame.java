package edu.brandeis.animalgame;

import java.util.Scanner;

public class AnimalGame {
  GameKBNode kbRoot;
  GameKBNode current;
  Scanner console;

  public void setup() {
    console = new Scanner(System.in);
  }

  public void run() {
    print("Welcome to the Animal Game!");
    runStep();
  }

  private void runStep() {
    /*
     * Pseudocode: while (more prompts available) ask the differentiation
     * question end make the guess if right, win if wrong, ask for a new
     * differentiation question
     * 
     */
    while (!current.finalNode) {
      boolean b = askDifferentiationQuestion(current.promptQuestion);
      if (b) {
        current = current.yesBranch;
      } else {
        current = current.noBranch;
      }
    }
    takeGuess();
  }

  private void takeGuess() {
    print("We think that your animal is: " + current.guess);
    boolean b = ask("Is that correct? ");
    if (b) {
      print("Hooray. We Win!");
    } else {
      getNewDifferentiationQuestion();
    }
  }

  private void getNewDifferentiationQuestion() {
    print("We need your help. We want a new question to ask the right player.");
    print("Please give a question to which the answer is YES for your animal, ");
    print("... but NO for " + current.guess);
  }

  private boolean askDifferentiationQuestion(String s) {
    return ask(s);
  }

  private boolean printCurrentGuess() {
    print(current.guess);
    return ask("Is that correct? ");
  }

  private boolean printNextQuestion() {
    return ask(current.promptQuestion);
  }

  private boolean ask(String promptQuestion) {
    System.out.print(promptQuestion + ": ");
    String response = console.nextLine();
    return response.equals("yes");
  }

  private void print(String string) {
    System.out.println(string);
  }

  public void loadKB() {
    kbRoot = new GameKBNode(true, "giraffe");
    current = kbRoot;
  }

}
