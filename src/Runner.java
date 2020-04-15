//import the Scanner class used for user input
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        Computer c = new Computer("O");
        boolean valid = false;
        boolean humanFirst = Math.random() < 0.5;
        int hMove = 0;
        int cMove = 0;

        System.out.println("What is your name?");
        System.out.print("Name: ");
        String name = sc.next();
        Human h = new Human(name, "X");

        //game

        if (!humanFirst) {
            while (!valid) {
                cMove = c.determineMove(-1);
                valid = b.checkValid(cMove);
            }

            valid = false;
            b.setToken(cMove, c.token);

            b.printBoard();
        } else {
            b.printBoard();
        }

        while (!b.checkwin()) {
            while (!valid) {
                System.out.print("Move: ");
                hMove = sc.nextInt();
                valid = b.checkValid(hMove);
            }

            b.setToken(hMove, h.token);
            valid = false;

            if(b.checkwin()){
                b.printBoard();
                System.out.println(c.name + " wins!!!");
                return;
            }

            if(b.checkcats()){
                b.printBoard();
                System.out.println("Cat's Game!!!");
                return;
            }

        while (!valid) {
                cMove = c.determineMove(b.getdefense());
                valid = b.checkValid(cMove);
            }

            valid = false;
            b.setToken(cMove, c.token);

            b.printBoard();

            if(b.checkwin()){
                System.out.println(c.name + " wins!!!");
                return;
            }

            if(b.checkcats()){
                System.out.println("Cat's Game!!!");
            }
        }
    }
}