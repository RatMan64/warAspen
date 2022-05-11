package com.example.warbackend;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;


@DynamoDbBean
public class DBItem {
  private String id;
  private int wins;

  @DynamoDbPartitionKey
  public String getid(){return id;}
  public void setId(String id){this.id = id;}


  public void setwins(int wins){this.wins = wins;}
  public int getWins(){return wins;}

}
