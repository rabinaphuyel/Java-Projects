
package dicegame ;

import java.util.Random;

public class dice {
    public int roll ; //  roll
    public int bet ; // bet
            
   public int defBet ; // default bet
   
    public dice(){
     
    }
    
     public dice(int b1 , int db1 ){
         bet = b1 ;
         defBet = db1 ;
     }
      // this set the bet as an argument
     public void setBet(int b){
         bet = b;
     }
     // this mutator sets the default bet as and argument
     public void setdefBet(int db){
         defBet = db ;
     }
     // this returns the player's bet
     public int getBet(){
         return bet ;
     }
     // this returns the default bet  which is initialy $100
     public int getdefBet(){
         return defBet ;
     }
      // this is the method that rolls the Dice m
      public void rollDice(){
        
           Random random = new Random();
           roll = random.nextInt(6)+1;
                 
               }
      // this method returns a dice roll 
      public int getRoll(){
          return roll ;
      }
      }

