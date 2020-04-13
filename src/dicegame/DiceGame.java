package dicegame;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @Tissan Joel
 * program 2
 * fall 2017
 * In this program, you will be rolling 3 dice 5 times. In an attempt to beat the computer,
   your number of die matches must be more than the computers generated.
   if you beat the computer when its matches are 5 you will get double your money
   and if you beat the computer, when its matches are 10 you will get triple your money
   else you will only get back the amount you bet.
 */
public class DiceGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // here  the dice object is set
        dice die1 = new dice();
        dice die2 = new dice();
        dice die3 = new dice();
        // this object takes in bet input
        dice bett = new dice(0, 100);

        // all defined variables
        int total; // this is for total number of matches
        int x; // this makes the computer rolls loops
        int y; // this makes the players rolls loop
        int defBet; // this is the default amount in players pocket $100
        int z;
        // description of program

        JDialog.setDefaultLookAndFeelDecorated(true);

        JOptionPane.showMessageDialog(null, "In this program, you will"
                + " be rolling 3 dice 5 times. In an atttempt to beat the computer,\n"
                + "your number of die matches must be more than the computers generated.\n"
                + "if you beat the computer when its matches are 5 you will get double your money\n"
                + "and if you beat the computer, when its matches are 10 you will get triple your money\n"
                + " else you will only get back the amount you bet.\n"
                + "$100 have been assigned for you to start\n GoooD LucK!");
// here the computer starts to generates its rolls
       
        do {  JOptionPane.showMessageDialog(null, "computer is generating rolls......");
             total = 0; //  counter for computer's total matches
            x = 0; // counter for loop
            do {
                
                // random dice are generated
                 die1.rollDice() ;
                 die2.rollDice();
                 die3.rollDice();
            // this checks if the dice matches
                 if (die1.getRoll() == die2.getRoll() || die1.getRoll() == die3.getRoll() || die2.getRoll() == die3.getRoll()) {
                        total += 2;
                 }
                  else if (die1.getRoll() == die2.getRoll() && die2.getRoll() == die3.getRoll()) {
                        total += 3;
                 }
                  else { total += 0 ;
                  }
                  
               JOptionPane.showMessageDialog(null, "The computer rolled"
                        + die1.getRoll() + " " + die2.getRoll() + " " + die3.getRoll() + "  " + total + "matches");

                x++;

            } while (x < 5);
            // this shows the total matches of dice computer had
            JOptionPane.showMessageDialog(null, "The computer had " + total + " matches");

            // computer roll ends here
            // players roll begins here
             defBet = bett.getdefBet();
            // this input dialog accepts the players bet
            String go = (JOptionPane.showInputDialog("Enter bet you have " + bett.getdefBet() + "$"));
            int bet = Integer.parseInt(go);
            // this sets the players bet to the bettting object
            bett.setBet(bet);

            // this checks if the amount enetered is greater
            // than amount in wallet or less than the amount in wallet
            // then it cancels 
            if (!(bett.getBet() >  bett.getdefBet() || bett.getBet() <= 0)) {
                y = 0; //  loop counter for players dice roll
                int yourTotal = 0; //  counter for player's dice match
                do {
                 die1.rollDice() ;
                 die2.rollDice();
                 die3.rollDice();

                      if (die1.getRoll() == die2.getRoll() || die1.getRoll() == die3.getRoll() || die2.getRoll() == die3.getRoll()) {
                        yourTotal += 2;
                 }
                  else if (die1.getRoll() == die2.getRoll() && die2.getRoll() == die3.getRoll()) {
                        yourTotal += 3;
                 }
                  else { yourTotal += 0 ;
                  }
                    // modify for else

                    JOptionPane.showMessageDialog(null, "The computer rolled "
                            + die1.getRoll() + "  " + die2.getRoll() + "  " + die3.getRoll() + " ~ " + yourTotal + " matches");

                    y++;
                } while (y < 5);
                JOptionPane.showMessageDialog(null, "You had " + yourTotal + " matches");
               
                // if player's total number of matches is higher than computers player wins win your money back
               
                if (yourTotal > total ) {
                    defBet += bett.getBet();
                } 
                // if the computer's matches is greater than player's, player looses
                else if (total > yourTotal) {
                    defBet -= bett.getBet();
                }
                // if you beat the computer when its total match is 5 or greater you get double your bet
              else if (total == 5  && yourTotal > total) {
                    defBet += bett.getBet() * 2;
                    // modify this
                
            } // if you beat the computer when its total is 10 or greater you get tripple your bet 
                 else if (total == 10  && yourTotal > total) {
                    defBet += bett.getBet() * 3;
                    // modify this
                
            }
                 
               // if player's total matches is equals computer's no one wins
            else if(yourTotal == total) {
                     JOptionPane.showMessageDialog(null, "you still have " + bett.getdefBet() + "$ in your wallet");
                     
                 }
            else{
                // modify for else
            }
              }
             else {
                //modify this 69 else
            }
            bett.setdefBet(defBet); // this modifies the default bet to current amount in pocket
            JOptionPane.showMessageDialog(null, "you are walking away with  " + bett.getdefBet() + "$ in your wallet");

        } // this checks if the player wants to play again and allows the player if pocket is not empty
        while( (JOptionPane.showConfirmDialog(null, "would you like to play again", "Play Again!",
                 JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) && (bett.getdefBet() != 0));
        
        JDialog.setDefaultLookAndFeelDecorated(true);
         // if players pocket is empty he cant play
          if ( bett.getdefBet() == 0){
           JOptionPane.showMessageDialog(null, "sorry you can't play with only " + bett.getdefBet() + "$ in your wallet");
        }
          // final message
        JOptionPane.showMessageDialog(null, "Thank you for playing !! Dont forget to bring your friends next time!!!");
               
        }
        
        }
        