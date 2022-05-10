package com.example.warbackend;

import java.awt.geom.RectangularShape;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WarController {




  @GetMapping("/war")
  public boolean wargame(@RequestParam(value = "id", defaultValue = "null") String player){
    String name = player;
    if(player.compareTo("null")==0) name =UUID.randomUUID().toString();
     War wp = new War();
     wp.play_round(new LinkedList<Integer>(), new LinkedList<Integer>());

    return wp.whoWon();
  }


  @GetMapping("/getwinsfor")
  public String getWins(@RequestParam(value = "id")String query){

    Wins wp = new Wins(query);

    return "{ id: "+query+", wins: "+wp.getWins()+"}";
  }





}
