package edu.brandeis.animalgame;

public class GameKBNode {
  boolean finalNode;
  String guess;
  String promptQuestion;
  GameKBNode yesBranch;
  GameKBNode noBranch;
  
  public GameKBNode(boolean b, String string) {
    finalNode = b;
    guess = string;
  }
}
