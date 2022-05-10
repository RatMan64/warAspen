package com.example.warbackend;

import java.util.Queue;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WarController {

  War game = new War();


  @GetMapping("/war")
  public War wargame(@RequestParam(value = "name", defaultValue = "null") String player,@RequestParam(value = "p1", defaultValue = "null")String p1,@RequestParam(value = "p2", defaultValue = "null")String p2,@RequestParam(value = "p3", defaultValue = "null")String p3){
     //

    return null;
  }


  @GetMapping("/getwinsfor")
  public long Wins(@RequestParam(value = "id")String query){
    Wins w = new Wins(query);
    return w.getWins();
  }





}
