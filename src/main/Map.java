package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.Action;

public class Map {
	  static char dir;
	  static String eventText;
	  static int player;
	  static int structure;
	  static int enemy;
	  static int key;
	  static int tile;
	  static int wall;
	  static int explored;
	  static int back;
	  static int waterCount = 20;
	  static Scanner scan = new Scanner(System.in);

	  static int[][] map = new int[][]{
	      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
	      {1,0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,3,2,2,4,4,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,4,2,2,4,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,3,2,2,2,2,2,2,2,2,2,2,4,4,4,4,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,4,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,2,2,2,2,2,2,4,2,4,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,2,2,2,2,2,2,2,2,2,2,4,4,4,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,4,4,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,4,2,4,2,2,2,3,2,2,2,2,2,2,2,2,2,2,3,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},
	      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	      };

	      
	      //
	      
	      
	      static int x= map[4][0];
	      static int y = map[0][4];
	      
	      static int playerPos = map[x][y];
	      static int life = 3;

	      
	 public static void s() {
		 if(x<38) {
   		  x++;
   		  playerPos = map[x][y];
         	  map[x][y] = 0;
	          map[x-1][y]=8;
	          }
   	  else {
   		  System.out.println("Can't go there");
   		  waterCount++;
   	  }
	 }
	 
	 public static Action w() {
		 System.out.println("ran w()");
		 
		 if(x>1) {
       	  x--;
       	  playerPos = map[x][y];
       	  map[x][y] = 0; 
	          map[x+1][y]=8;
	          }
         else {
   		  System.out.println("Can't go there");
   		  waterCount++;
   	  }
		return null;
	 }
	 
	 
	 public static void a() {
		 if(y>1) {
   		  y--;
   		  playerPos = map[x][y];
   		  map[x][y] = 0; 
   		  map[x][y+1]=8;
   	  }
   	  else {
   		  System.out.println("Can't go there");
   		  waterCount++;
   	  }
	 }
	 
	 public static void d() {
		 if(y<38) {
   		  y++;
         	  playerPos = map[x][y];
         	  map[x][y] = 0; 
       	  map[x][y-1]=8;
         }
   	  else {
   		  System.out.println("Can't go there");
   		  waterCount++;
   	  }
	 }
        

	 
/*	  public static void move(char dir){
		  
		  
	      switch (dir){
	      case 's' | 'S':
	    	  
	    	  if(x<38) {
	    		  x++;
	    		  playerPos = map[x][y];
	          	  map[x][y] = 0;
		          map[x-1][y]=8;
		          }
	    	  else {
	    		  System.out.println("Can't go there");
	    		  waterCount++;
	    	  }
	          map();
	          break;
	      case 'w' | 'W':
	          
	          if(x>1) {
	        	  x--;
	        	  playerPos = map[x][y];
	        	  map[x][y] = 0; 
		          map[x+1][y]=8;
		          }
	          else {
	    		  System.out.println("Can't go there");
	    		  waterCount++;
	    	  }
	          map();
	          break;
	      case 'a' | 'A':
	    	  
	    	  if(y>1) {
	    		  y--;
	    		  playerPos = map[x][y];
	    		  map[x][y] = 0; 
	    		  map[x][y+1]=8;
	    	  }
	    	  else {
	    		  System.out.println("Can't go there");
	    		  waterCount++;
	    	  }
	    	  
	          map();
	          break;
	      case 'd' | 'D':
	    	  
	    	  if(y<38) {
	    		  y++;
	          	  playerPos = map[x][y];
	          	  map[x][y] = 0; 
	        	  map[x][y-1]=8;
	          }
	    	  else {
	    		  System.out.println("Can't go there");
	    		  waterCount++;
	    	  }
	          map();
	          break;

	      }
	  }
*/

	  public static void map(){
	      wall = 1;
	      tile = 2;
	      enemy = 3;
	      structure = 4;
	      key = 5;
	      explored = 8;
	      player = 0;

	     

	      if(playerPos == wall){
	    	  eventText = "Thats a wall. Can't move there.";
	         
	      }
	      if(playerPos == tile){

	          eventText = "You move to a free tile";
	      }
	      if(playerPos == enemy){
	    	  
	          enemyEncounter();
	      }
	      if(playerPos == structure){
	    	  
	    	  eventText="You see a structure near...";
	          structureEvent();
	      }
	      if(playerPos == key){
	    	  
	    	  eventText="You find a key in the dust";
	      }
	      if(playerPos == explored){
	    	  
	    	  eventText="You have been here before";
	      }
	      waterCount--;
	      if(waterCount<0)waterCount=0;
	      if(waterCount == 0)life =life - 1;
	      if(life == 0) {
	    	  
	    	  death();
	      }
	      
	      Game.turn();
	      }
	  
	  
	  private static void structureEvent(){
		  waterCount = waterCount+20;
	 	
	  }

	  public static void death() {
		  eventText = "You Died";
		  try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		  System.exit(1);
	  }
	  
	public static void enemyEncounter(){
	     
		Display.battle();
		System.out.println("Run Display.battle()");

	  }
	  
}