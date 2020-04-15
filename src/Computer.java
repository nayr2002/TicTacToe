public class Computer extends Player {

    public Computer(String token) {
        super("Bit Bucket", token);
    }

    //very basic random move algorithm for now
    public int determineMove(int move) {
        if(move != -1){
            return move+1;
        } else {
            int position = (int)(Math.random() * 9) + 1;

            return position;
        }
    }
}