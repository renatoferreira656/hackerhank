import java.io.*;
import java.util.*;

public class Solution {
    public static class Match{
        public static final String FIRST = "First";
        public static final String SECOND = "Second";
        public static final Double FIVE = 5.0;
        public static final Double TWO = 2.0;
        public static final Double THREE = 3.0;

        private String currentPlayer;
        private Double stones;

        public Match(Double stones){
            this.stones = stones;
            this.currentPlayer = FIRST;
        }

        public void print(String ... objs){
          Iterator<String> it = Arrays.asList(objs).iterator();
          while(it.hasNext()){
            System.out.print(it.next());
            if(it.hasNext()){
              System.out.print(" - ");
            }
          }
          System.out.println("");
        }

        public void start(){
            Double a = this.stones / FIVE;
            Double b = this.stones % FIVE;
            print(a.toString(), b.toString());
            if(b == 1 || b == 0){
              print(FIRST);
              return;
            }
            a = this.stones / THREE;
            b = this.stones % THREE;
            print(a.toString(), b.toString());
            if(b == 1 || b == 0){
              print(FIRST);
              return;
            }
            a = this.stones / TWO;
            b = this.stones % TWO;
            print(a.toString(), b.toString());
            if(b == 1 || b == 0){
              print(FIRST);
              return;
            }
            print(SECOND);
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
        scan.nextDouble();
        while(scan.hasNextDouble()){
            Match match = new Match(scan.nextDouble());
            match.start();
        }

    }
}
