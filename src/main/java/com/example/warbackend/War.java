package com.example.warbackend;

import java.net.HttpURLConnection;
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
  boolean won;
  boolean hadties;
  public War(){
    won = false;
    hadties = false;

    deck = new LinkedList<Integer>(Arrays.asList(1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,11,11,11,11,12,12,12,12,13,13,13,13));
    npc1 = new LinkedList<Integer>();
    npc2 = new LinkedList<Integer>();
    humanplayer = new LinkedList<Integer>();
    shuffle_deck_Start();
    System.out.println(humanplayer);
    System.out.println(npc1);
    System.out.println(npc2);

    while(true){
      play_round(new LinkedList<Integer>(), new LinkedList<Integer>());
      if(humanplayer.size() == 52 || humanplayer.size() == 0 )break;
    }
  }

  public void play_round(LinkedList<Integer> table, LinkedList<Integer> used){ // play a round of war and replay if
//    System.out.println( "round played");
    if(humanplayer.size() == 52 ){
      won = true;
      return;
    }
//    if(npc1.size() == 0 && npc2.size() == 0 && used.size() != 0){
//      humanplayer.addAll(used);
//      used.clear();
//      won = true;
//      return;
//    }

    System.out.println(hadties);
    int npc1size = npc1.size();
    int npc2size = npc2.size();
    System.out.println(humanplayer);
    System.out.println(npc1);
    System.out.println(npc2);
    if(humanplayer.size() == 0){
      return;
    }

    table.add(humanplayer.remove());
    if(npc1size != 0){

      table.add(npc1.remove());

    }
    if(npc2size!=0){

      table.add(npc2.remove());

    }
    System.out.println(table);



    // everyone has played at this point
    if(npc1size == 0 && npc2size != 0){ // one npc is dead lol
      int h = table.getFirst();
      int n = table.getLast();
      if(h == n){
        hadties = true;
        System.out.println("tie");
        if(humanplayer.size()!=0){
          used.addAll(table);
          table.clear();
          used.add(humanplayer.remove());

          if(npc1.size()!=0){
            used.add(npc1.remove());
          }else{
            humanplayer.addAll(used);
            used.clear();
            return;
          }



          play_round(table,used);

        }else{
          return;
        }

      }else if(h<n){
        if(used.size() != 0){
          used.addAll(table);
          table.clear();
          npc2.addAll(used);
          used.clear();
        }else {
          npc2.addAll(table);
          table.clear();

        }

      }else{

        if(used.size() != 0){
          used.addAll(table);
          table.clear();
          humanplayer.addAll(used);
          used.clear();
        }else{
          humanplayer.addAll(table);
          table.clear();
        }
      }

    }else if(npc2size == 0 && npc1size!=0){// other npc is dead
      int h = table.getFirst();
      int n = table.getLast();
      if(h == n){
        hadties = true;
        System.out.println("tie");
        if(humanplayer.size()!=0){

          used.addAll(table);
          table.clear();
          used.add(humanplayer.remove());
          if(npc2.size()!=0){
            used.add(npc2.remove());
          }else{
            humanplayer.addAll(used);
            used.clear();
            return;
          }

          play_round(table,used);

        }else{
          return;
        }

      }else if(h<n){
        if(used.size() != 0){
          used.addAll(table);
          table.clear();
          npc1.addAll(used);
          used.clear();
        }else {
          npc1.addAll(table);
          table.clear();

        }


      }else{

        if(used.size() != 0){
          used.addAll(table);
          table.clear();
          humanplayer.addAll(used);
          used.clear();
        }else{
          humanplayer.addAll(table);
          table.clear();
        }
      }

    }else{// all players are still in the game
      int h = table.getFirst();
      int n1 = table.get(1);
      int n2 = table.getLast();
        if(h == n1 && n2 == h){// tie
          hadties = true;
          System.out.println("tie");

          used.addAll(table);
          table.clear();

          used.add(humanplayer.remove());
          if(npc1.size() != 0){
            used.add(npc1.remove());

          }
          if(npc2.size() != 0){
            used.add(npc2.remove());
          }

          play_round(table, used);

        }else if(h< n1 && n2 < n1){// n1 wins
          if(used.size() != 0){
            used.addAll(table);
            table.clear();
            npc1.addAll(used);
            used.clear();
          }else{
            npc1.addAll(table);
            table.clear();

          }

        }else if(h<n2 && n1 < n2){// n2 wins
          if(used.size() != 0){
            used.addAll(table);
            table.clear();
            npc2.addAll(used);
            used.clear();
          }else{
            npc2.addAll(table);
            table.clear();
          }



        }else{// human wins
          if(used.size() != 0){
            used.addAll(table);
            table.clear();
            humanplayer.addAll(used);
            used.clear();
          }else{
            humanplayer.addAll(table);
            table.clear();
          }

        }

    }
    System.out.println("human: " + humanplayer.size()+ " npc1: " + npc1.size() +" npc2:"+ npc2.size());
    if (npc1.size() == 0 && npc2.size() == 0){
      won = true;
    }

  }
  public boolean whoWon(){
    return won;
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
