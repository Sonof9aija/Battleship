public class Board {
    private int numBoats;
    private Battleboat[] boats;
    private Cell[][] gameBoard;
    private int[] boatSizes;

    public Board(int mode){
        switch (mode) {
            case 1:
                gameBoard = new Cell[3][3];
                for(int i = 0; i < gameBoard.length; i++) {
                    for(int j = 0; j< gameBoard[i].length; j++) {
                        gameBoard[i][j] = new Cell(i,j,'-');
                    }
                }
                boats = new Battleboat[1];
                boatSizes = new int[]{2};
                for(int i = 0; i < boats.length; i++) {
                    boats[i] = new Battleboat(boatSizes[i]);
                }
                break;
            case 3:
                gameBoard = new Cell[5][5];
                for(int i = 0; i < gameBoard.length; i++) {
                    for(int j = 0; j< gameBoard[i].length; j++) {
                        gameBoard[i][j] = new Cell(i,j,'-');
                    }
                }
                boats = new Battleboat[3];
                boatSizes = new int[]{2,3,4};
                for(int i = 0; i < boats.length; i++) {
                    boats[i] = new Battleboat(boatSizes[i]);
                }
                break;
            case 5:
                gameBoard = new Cell[9][9];
                for(int i = 0; i < gameBoard.length; i++) {
                    for(int j = 0; j < gameBoard[i].length; j++) {
                        gameBoard[i][j] = new Cell(i,j,'-');
                    }
                }
                boats = new Battleboat[5];
                boatSizes = new int[]{2,3,3,4,5};
                for(int i = 0; i < boats.length; i++) {
                    boats[i] = new Battleboat(boatSizes[i]);
                }
                break;
        }
    }

    public void placeBoats(){
        int size = gameBoard.length;
        switch (size){
            case 3:
                gameBoard[0][1].setStatus('B');
                gameBoard[1][1].setStatus('B');
                break;

            case 5:
                gameBoard[0][1].setStatus('B');
                gameBoard[1][1].setStatus('B');

                gameBoard[0][0].setStatus('B');
                gameBoard[1][0].setStatus('B');
                gameBoard[2][0].setStatus('B');

                gameBoard[1][2].setStatus('B');
                gameBoard[2][2].setStatus('B');
                gameBoard[3][2].setStatus('B');
                gameBoard[4][2].setStatus('B');
                break;

            case 9:
                gameBoard[0][1].setStatus('B');
                gameBoard[1][1].setStatus('B');

                gameBoard[0][0].setStatus('B');
                gameBoard[1][0].setStatus('B');
                gameBoard[2][0].setStatus('B');

                gameBoard[8][6].setStatus('B');
                gameBoard[8][7].setStatus('B');
                gameBoard[8][8].setStatus('B');

                gameBoard[1][2].setStatus('B');
                gameBoard[2][2].setStatus('B');
                gameBoard[3][2].setStatus('B');
                gameBoard[4][2].setStatus('B');

                gameBoard[6][4].setStatus('B');
                gameBoard[6][5].setStatus('B');
                gameBoard[6][6].setStatus('B');
                gameBoard[6][7].setStatus('B');
                gameBoard[6][8].setStatus('B');
                break;
        }
    }

    public int fire(int x, int y){
        if(gameBoard[x][y].getStatus()=='-') {
            gameBoard[x][y].setStatus('M');
            System.out.println("Miss");
        }
        else if(gameBoard[x][y].getStatus()=='B') {
            gameBoard[x][y].setStatus('H');
            System.out.println("Hit");
        }
        else if(gameBoard[x][y].getStatus()=='H') {

            System.out.println("Penalty");
        }
        else if(gameBoard[x][y].getStatus()=='M') {
            System.out.println("Penalty");
        }
        return -1;
    }

    public void display(){
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j< gameBoard[i].length; j++) {
                if(gameBoard[i][j].getStatus() == 'B'){
                    System.out.print("-");
                }
                else{
                    System.out.print(gameBoard[i][j].getStatus());
                }
            }
            System.out.println();
        }
    }

    public void print(){
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j< gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j].getStatus()+ " ");
            }
            System.out.println();
        }
    }

    public boolean victory(){
        boolean win = true;
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j< gameBoard[i].length; j++) {
                if(gameBoard[i][j].getStatus() == 'B'){
                    win = false;
                }
            }
        }
        return win;
    }

    public boolean validSpot(int x, int y){
        boolean valid = false;
        if(gameBoard.length > x || gameBoard.length > y){
            valid = true;
        }
        return valid;
    }

}
