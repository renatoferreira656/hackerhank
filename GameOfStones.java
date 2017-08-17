import java.io.*;
import java.util.*;

public class GameOfStones {
    public static class Match{
        public static final String FIRST = "First";
        public static final String SECOND = "Second";
        public static final Long FIVE = 5l;
        public static final Long TWO = 2l;
        public static final Long THREE = 3l;

        private String currentPlayer;
        private Long stones;

        public Match(Long stones){
            this.stones = stones;
            this.currentPlayer = FIRST;
        }

        public void start(){

            if(stones.equals(1l)){
                this.currentPlayer = SECOND;
                return;
            }

            while(this.stones > 1l){
                if(checkVictory()){
                   return;
                }

                executeRound();

                if(checkNextPlayerLoses()){
                    return;
                }

                changePlayer();
            }
        }

        public void executeRound(){
            Long calc = this.stones - FIVE;
            if( calc > FIVE || (calc == 1 || calc == 0) ){
                this.stones = this.stones - FIVE;
                return;
            }
            calc =  this.stones - THREE;
            if( calc > THREE || (calc == 1 || calc == 0) ){
                this.stones = this.stones - THREE;
                return;
            }
            this.stones = this.stones - TWO;
        }


        public boolean checkVictory(){
            return this.stones==0 || (this.stones - FIVE == 0l) || (this.stones - THREE == 0l)|| (this.stones - TWO == 0l);
        }

        public boolean checkNextPlayerLoses(){
            return this.stones == 1;
        }

        public void changePlayer(){
            if(this.currentPlayer.equals(SECOND)){
                this.currentPlayer = FIRST;
                return;
            }
            this.currentPlayer = SECOND;
        }

        public String winner(){
            return this.currentPlayer;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.nextLong();
        while(scan.hasNextLong()){
            Long l = scan.nextLong();
            Match match = new Match(l);
            match.start();
            System.out.println(match.winner());
        }

    }
}
