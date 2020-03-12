public class Board {
    int size = 9;
    String[] grid = new String[size];
    //constructor initializes the whole
    // grid with 0's when created
    public Board() {
         for(int i = 0; i < size; i++){
             grid[i] = String.valueOf(i + 1);
         }
    }

    //printBoard will output a board to the console
    public void printBoard() {
        int count = 0;

        System.out.print("\n");
        for(int row = 0; row < Math.sqrt(size); row++) {
            for(int col = 0; col < Math.sqrt(size); col++) {
                System.out.print(grid[count] + "   |");
                count++;
            }
            System.out.print("\n");
            for(int col = 0; col < Math.sqrt(size); col++) {
                System.out.print("____|");
            }
            System.out.print("\n");
        }
    }

    public void setToken(int move, String token){
        grid[move - 1] = token;
    }

    public boolean checkValid(int move){
        if(move >= 1 && move <= 9){
            if (grid[move - 1].equals("O")  ||  grid[move - 1].equals("X")) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }

    }

    public boolean checkwin(){
        //check rows
        for(int i = 0; i < Math.sqrt(size); i++){
            if (grid[i*3] == grid[(i*3)+1] && grid[(i*3)+1] == grid[(i*3)+2]) {
                return false;
            }
        }
        //check columns
        for(int i = 0; i < Math.sqrt(size); i++){
            if (grid[i] == grid[i+3] && grid[i+3] == grid[i+6]) {
                return false;
            }
        }
        //check diagonals
        if (grid[0] == grid[4] && grid[4] == grid[8]) {
            return false;
        }
        if (grid[2] == grid[4] && grid[4] == grid[6]) {
            return false;
        }
        return true;
    }
}