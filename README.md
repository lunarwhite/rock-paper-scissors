# rock-paper-scissors

Simple Java console program: Rock, Paper Scissors (RPS) Game || 用Java写的简易控制台剪刀石头布（猜丁壳）游戏

## 1 Overview
- A computerized version of Rock, Paper Scissors (RPS).
- RPS is a popular game played between 2 individuals for decision making ("if you win, then I get the last cookie") or just for fun.
- This time is played between the computer and a single player.

## 2 Rules
- Rock beats Scissors (i.e., Rock wins)
- Scissors beats Paper
- Paper beats Rock
- If the players pick the same thing (e.g., Rock and Rock), then it is a Tie.

## 3 Guide
- Ask for the player's name. Say "Hello, <name>".
- Ask the player "How many times do you want to play?". Repeat the game that many times.
- The player is asked for a throw and enters "Rock", "Paper", or "Scissors". Upper case and lower case letter do not matter.
- The computer tells the player what their number corresponded to: rock, paper, or scissors.
- The computer picks a random number for rock, paper, or scissors.
- If the player enters a wrong word, like "Potato", the program will say "You did not say Rock, Paper, or Scissors! No fair!". Then, it should ask them to pick again.
- The computer tells the player what the computer picked: rock, paper, or scissors.
- The computer tells the player who won: the player or the computer or a Tie.
- Print the game summary to console.

## 4 To improve
- `decideWinner()`
```java
if (computerThrow == (playerThrow + 1) % 3) {
      System.out.println("Computer wins!");
}
```
- Only need one `Scanner`.
- `getPlayerThrow()`, the while loop is complicated. Use `Enum`.
- Clean the scanner input
```java
Scanner keyboard = new Scanner(System.in);

Keyboard.nextLine(); // clear line
```
