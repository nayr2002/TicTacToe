public class Board {
    int size = 9;
    String[] grid = new String[size];

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
            if (grid[i*3].equals(grid[(i*3)+1]) && grid[(i*3)+1].equals(grid[(i*3)+2])) {
                return true;
            }
        }
        //check columns
        for(int i = 0; i < Math.sqrt(size); i++){
            if (grid[i].equals(grid[i+3]) && grid[i+3].equals(grid[i+6])) {
                return true;
            }
        }
        //check diagonals
        if (grid[0].equals(grid[4]) && grid[4].equals(grid[8])) {
            return true;
        }
        if (grid[2].equals(grid[4]) && grid[4].equals(grid[6])) {
            return true;
        }
        return false;
    }

    public boolean checkcats(){
        //check cat's game
        for(int i = 0; i < size; i++){
            if(!grid[i].equals("X") && !grid[i].equals("O")){
                return false;
            }
        }
        return true;
    }

    public int getdefense(){
        //check diagonal 1
        if (grid[0].equals("X") && grid[4].equals("X") && !grid[8].equals("X") && !grid[8].equals("O")) {
            return 8;
        }
        if (grid[0].equals("X") && !grid[4].equals("X") && !grid[4].equals("O") && grid[8].equals("X")) {
            return 4;
        }
        if (!grid[0].equals("X") && !grid[0].equals("O") && grid[4].equals("X") && grid[8].equals("X")) {
            return 0;
        }
        //check diagonal 2
        if (grid[2].equals("X") && grid[4].equals("X") && !grid[6].equals("X") && !grid[6].equals("O")) {
            return 6;
        }
        if (grid[2].equals("X") && !grid[4].equals("X") && !grid[4].equals("O") && grid[6].equals("X")) {
            return 4;
        }
        if (!grid[2].equals("X") && !grid[2].equals("O") && grid[4].equals("X") && grid[6].equals("X")) {
            return 2;
        }
        //check rows
        for(int i = 0; i < Math.sqrt(size); i++){
            if (grid[i*3].equals("X") && grid[(i*3)+1].equals("X") && !grid[(i*3)+2].equals("X") && !grid[(i*3)+2].equals("O")) {
                return (i*3)+2;
            }
            if (grid[i*3].equals("X") && !grid[(i*3)+1].equals("X") && !grid[(i*3)+1].equals("O") && grid[(i*3)+2].equals("X")) {
                return (i*3)+1;
            }
            if (!grid[i*3].equals("X") && !grid[i*3].equals("O") && grid[(i*3)+1].equals("X") && grid[(i*3)+2].equals("X")) {
                return i*3;
            }
        }
        //check columns
        for(int i = 0; i < Math.sqrt(size); i++){
            if (grid[i].equals("X") && grid[i + 3].equals("X") && !grid[i + 6].equals("X") && !grid[i + 6].equals("O")) {
                return i+6;
            }
            if (grid[i].equals("X") && !grid[i + 3].equals("X") && !grid[i + 3].equals("O") && grid[i + 6].equals("X")) {
                return i+3;
            }
            if (!grid[i].equals("X") && !grid[i].equals("O") && grid[i + 3].equals("X") && grid[i + 6].equals("X")) {
                return i;
            }
        }
        //else
        return -1;
    }
}