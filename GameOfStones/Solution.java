import java.io.*;
import java.util.*;

public class Solution {
    public static class Match{
    	private List<Boolean> stones;

        public Match(){
            this.stones = new ArrayList<Boolean>();
            this.stones.add(false);
            this.stones.add(true);
            this.stones.add(true);
            this.stones.add(true);
            this.stones.add(true);
        }

        public Boolean check(Integer value){
            if(this.stones.size() >= value){
              return this.stones.get(value - 1);
            }
            Integer pos = this.stones.size() - 1;
            if(this.stones.get(pos) &&  this.stones.get(pos - 2) && this.stones.get(pos -4)){
                this.stones.add(false);
                return check(value);
            }
            this.stones.add(true);
            return check(value);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        scan.nextDouble();
        Match match = new Match();
        while(scan.hasNextInt()){
            if(match.check(scan.nextInt())){
              System.out.println("First");
            } else {
              System.out.println("Second");
            }
        }

    }
}
