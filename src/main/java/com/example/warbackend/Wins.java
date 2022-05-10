package com.example.warbackend;

public class Wins {
  private String id;
  private final long wins;

  public Wins(String id){
    //todo grab wins of id
    this.id = id;
    this.wins = -1;
  }

  long getWins(){
    return wins;
  }



}
