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
            for (int i = this.stones.size(); i <= value; i++) {
                this.stones.add(!(this.stones.get(i - 2) && this.stones.get(i - 3) && this.stones.get(i - 5)));
            }
            return this.stones.get(value-1);
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
