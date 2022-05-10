package com.example.warbackend;

import java.security.PublicKey;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class War {
  private LinkedList<Integer> humanplayer;
  private  LinkedList<Integer> npc1;
  private LinkedList<Integer> npc2;
  LinkedList<Integer> deck;
  public War(){


    deck = new LinkedList<Integer>(Arrays.asList(1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13));
    npc1 = new LinkedList<Integer>();
    npc2 = new LinkedList<Integer>();
    humanplayer = new LinkedList<Integer>();
    shuffle_deck_Start();
    play_round();
  }
  public War(int[] human, int[] p1,int[] p2){ // if a game is already started
    humanplayer = new LinkedList<Integer>();

  }
  public void play_round(){
    System.out.println( "firstplay");
  }

  public void shuffle_deck_Start(){

    Random rand = new Random();
    while(deck.size() > 0){

      if(deck.size()<=0)break;
      int nextcard = rand.nextInt(deck.size());
      humanplayer.add(deck.remove(nextcard));

      if(deck.size()<=0)break;
      nextcard = rand.nextInt(deck.size());
      npc1.add(deck.remove(nextcard));

      if(deck.size()<=0)break;
      nextcard = rand.nextInt(deck.size());
      npc2.add(deck.remove(nextcard));
    }
    // at this point the deck should be shuffled if this is a new game

  }

  public void getQueue(){

  }



}
