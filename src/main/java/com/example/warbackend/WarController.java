package com.example.warbackend;

import java.awt.geom.RectangularShape;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;


@RestController
public class WarController {

  private final DynamoDbTable<DBItem> DB = (new DataBase()).get_client();


  @GetMapping("/war")
  public String wargame(@RequestParam(value = "id", defaultValue = "null") String player){
    String name = player;
    if(player.compareTo("null")==0) name =UUID.randomUUID().toString();
    War wp = new War();
    boolean newsub = false;

    var result = DB.getItem(Key.builder().partitionValue(name).build()); // search for name

    if (result == null){ // make a new item to put in
      newsub = true;
    }



    boolean w = wp.whoWon();
    // figure out if this name already exists in the db


    if(w){
      // update score on db
      if(newsub) {
        var item = new DBItem();
        item.setId(name);
        item.setwins(1);
        DB.putItem(item);

      }else{
        result.setwins(result.getWins()+1);
        DB.updateItem(result);
      }
      return "you won "+ name;
    }else{
      if(newsub){
        var item = new DBItem();
        item.setId(name);
        item.setwins(0);
        DB.putItem(item);
      }
     return "you lost " + name;
    }
  }


  @GetMapping("/getwinsfor")
  public String getWins(@RequestParam(value = "id",defaultValue = "null")String query){
    if(query.compareTo("null") == 0){
      return "invalid input";
    }
    var result =  DB.getItem(Key.builder().partitionValue(query).build()); // search for name
    if(result.getid() == null){
      return "No such player";
    }else{
      return "{ id: "+query+", wins: "+result.getWins()+"}";

    }


  }





}
