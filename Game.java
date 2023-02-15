import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner gameInput = new Scanner(System.in);
        System.out.println("What mode do you want?");
        String mode = gameInput.nextLine();
        mode.toLowerCase();

        while (!mode.equals("hard") && !mode.equals("medium") && !mode.equals("easy")){
            System.out.println("Not available, try again");
            mode = gameInput.nextLine();
        }
        int size = 0;

        switch (mode) {
            case "hard":
                size = 5;
                break;
            case "medium":
                size = 3;
                break;
            case "easy":
                size = 1;
                break;
        }
        System.out.println("Debug mode?");
        String gMode = gameInput.nextLine();
        int turns = 0;
        gMode.toLowerCase();
        boolean boatsUp = true;



        if(gMode.equals("yes")){
            Board game = new Board(size);
            game.placeBoats();
            game.print();
            while(boatsUp){
                System.out.println("What are your x and y coordinates to target?");
                int xTarget = gameInput.nextInt();
                int yTarget = gameInput.nextInt();
                if(!game.validSpot(xTarget,yTarget)){
                    System.out.println("Out of bounds, penalty of extra turn imposed");
                    turns++;
                } else {
                    game.fire(xTarget,yTarget);
                    turns++;
                }
                game.print();
                if(game.victory() == true){
                    boatsUp = false;
                    System.out.println("Congrats, you win!");
                    System.out.println("It took " + turns + " turns.");
                }
            }


        }



        if(gMode.equals("no")){
            Board game = new Board(size);
            game.placeBoats();
            while(boatsUp){
                System.out.println("What are your x and y coordinates to target?");
                int xTarget = gameInput.nextInt();
                int yTarget = gameInput.nextInt();
                if(!game.validSpot(xTarget,yTarget) == false){
                    System.out.println("Out of bounds, penalty of extra turn imposed");
                    turns++;
                } else {
                    game.fire(xTarget,yTarget);
                    turns++;
                }
                game.display();
                if(game.victory()){
                    boatsUp = false;
                    System.out.println("Congrats, you win!");
                    System.out.println("It took " + turns + " turns.");
                }
            }


        }
    }
}
