/**
 * This program plays a computerized version of Rock-Paper-Scissors(RPS),
 * between the computer and a single player.
 * And show a summary about winning rate at the end.
 */

import java.util.Random;
import java.util.Scanner;

public class RPS {
    static Scanner in1 = new Scanner(System.in);
    static Scanner in2 = new Scanner(System.in);
    static Scanner in0 = new Scanner(System.in);

    // function: Get player's name from console.
    // arguments: (void)
    // return-value: (void)
    public static void getName(){

        System.out.print("> Input your name: ");
        String name = in1.nextLine();

        System.out.println("Hello, " + name + "!");
        System.out.println("Let's play Rock-Paper-Scissors!");
        System.out.println();
    }

    // function: Get player's throw(int, not string) from console.
    // arguments: (void)
    // return-value: number_player
    public static int getPlayerThrow(){
        System.out.print("> Throw and enters a word(Rock, Paper, Scissors): ");

        Boolean isBadWord = true;
        Boolean isFirstTry = true;
        int number_player = -1;

        while(isBadWord){
            if(!isFirstTry){
                System.out.println("You did not say Rock, Paper, or Scissors! No fair!");
                System.out.println();
                System.out.print("> Throw and enters a word: ");
            }

            String throw_player = in2.nextLine();
            number_player = RPSToNumber(throw_player);
            isFirstTry = false;
            if(number_player != -1){
                isBadWord = false;
            }
        }

        return number_player;
    }

    // function: Get computer's throw(int, not string) using Random.
    // arguments: (void)
    // return-value: number_computer
    public static int getComputerThrow(){
        Random r = new Random();
        int number_computer = r.nextInt(3);
        return number_computer;
    }

    // function: Convert a single number to a RPS throw, just like 0 -> "Rock".
    // arguments: number
    // return-value: throw_s
    public static String numberToRPS(int number){
        String throw_s = "";

        if(number == 0){
            throw_s = "Rock";
        }else if(number == 1){
            throw_s = "Paper";
        }else if(number == 2){
            throw_s = "Scissors";
        }

        return throw_s;
    }

    // function: Convert a RPS throw to a single number, just like "Rock" -> 0.
    // arguments: throw_s
    // return-value: number
    public static int RPSToNumber(String throw_s){
        int number = 0;

        if(throw_s.equalsIgnoreCase("Rock")){
            number = 0;
        }else if(throw_s.equalsIgnoreCase("Paper")){
            number = 1;
        }else if(throw_s.equalsIgnoreCase("Scissors")){
            number = 2;
        }else{
            number = -1;
        }

        return number;
    }

    // function: Print player's and computer's throw.
    // arguments: playerThrow, computerThrow
    // return-value: (void)
    public static void printThrow(int playerThrow, int computerThrow){
        System.out.println("* The computer picked: " + numberToRPS(computerThrow));
        System.out.println("* You picked: " + numberToRPS(playerThrow));
    }

    // function: Decide winner and return the winner-flag.
    // arguments: playerThrow, computerThrow
    // return-value: result as winner-flag.
    public static int decideWinnner(int playerThrow, int computerThrow){
        int result = 0;
        int temp = playerThrow - computerThrow;

        if(temp == 0){
            result = 0;
        }else if(temp == 1 || temp == -2){
            result = 1;
        }else if(temp == -1 || temp == 2){
            result = -1;
        }

        return result;
    }

    // function: Print the winner in console.
    // arguments: result
    // return-value: (void)
    public static void printWinnner(int result){
        if(result == 0){
            System.out.println("a Tie");
        }else if(result == -1){
            System.out.println("Computer wins!");
        }else if(result == 1){
            System.out.println("You win!");
        }
    }

    // function: Calculate and show the summary of the game in console.
    // arguments: countTotalTimes, countYouWin
    // return-value: (void)
    public static void summary(int countTotalTimes, int countYouWin){
        double winningRatePlayer = (1.0 *countYouWin) / (1.0 * countTotalTimes) * 100;

        System.out.println();
        System.out.println("===== Summary ====");
        System.out.println("You've tried " + countTotalTimes +" times.");
        System.out.println("Your winning rate: "+winningRatePlayer+ "%");
    }

    public  static void main(String[] args){
        getName();

        System.out.print("> Input the times you want to play: ");

        int countTotalTimes = in0.nextInt();
        int countYouWin = 0;

        for(int i = 0; i < countTotalTimes; i++){
            System.out.println();
            System.out.println("[No." + (i+1) + " Time]");
            int playerThrow = getPlayerThrow();
            int computerThrow = getComputerThrow();
            printThrow(playerThrow, computerThrow);

            int winner = decideWinnner(playerThrow, computerThrow);
            if(winner == 1){
                countYouWin++;
            }
            printWinnner(winner);
        }

        summary(countTotalTimes, countYouWin);

        System.out.println("Goodbye:)");
    }
}
