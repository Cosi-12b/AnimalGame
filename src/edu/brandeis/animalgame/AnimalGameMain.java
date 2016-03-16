package edu.brandeis.animalgame;

public class AnimalGameMain {
  public static void main(String[] args) {
    AnimalGame game = new AnimalGame();
    game.setup();
    game.loadKB();
    game.run();
  }
}
