import java.util.Scanner;
public class TicTacToeGame
{
	public static void main(String[] args) {
	    
		TicTacToe play = new TicTacToe();
		play.printgame();
		while(true){
		    play.player1();
    		play.printgame();
    		if(play.judge()) break;
	    	play.player2();
		    play.printgame();
		    if(play.judge()) break;
		}
		
	}
}
class TicTacToe
{
    enum symbol{X,O,EMPTY};  
    private symbol game[]=new symbol[9];
    
    public TicTacToe(){
        for(int i=0;i<9;i++){
            game[i]=symbol.EMPTY;
        }
    }
    public void printgame(){
        for(int i=0;i<9;i++){
            if(i%3==0)
                System.out.println("------");
            if(game[i]==symbol.EMPTY)
                System.out.print(i);
            else
                System.out.print(game[i]);
            System.out.print("|");
            
            if(i==2||i==5||i==8)
                System.out.print("\n");
            if(i==8)
                System.out.println("------");

        }
    }
    public void player1(){
        Scanner input = new Scanner(System.in);
        System.out.println("player1: please choose an empty space");
        int choose=input.nextInt();
        if(game[choose]==symbol.EMPTY)
            game[choose]=symbol.X;
        else{
            System.out.print("The space has been ocupied! please choose again\n");
            player1();
        }
        
    }
    public void player2(){
        Scanner input = new Scanner(System.in);
        System.out.println("player2: please choose an empty space");
        int choose=input.nextInt();
        if(game[choose]==symbol.EMPTY)
            game[choose]=symbol.O;
        else{
            System.out.print("The space has been ocupied! please choose again\n");
            player2();
        }
        
    }
    public boolean judge(){
        if(game[0]==game[1]&&game[1]==game[2]&&game[0]!=symbol.EMPTY){
            if(game[0]==symbol.O) System.out.println("player2 win!");
            else System.out.println("player1 win!");
            return true;
        }
        if(game[3]==game[4]&&game[4]==game[5]&&game[3]!=symbol.EMPTY){
            if(game[3]==symbol.O) System.out.println("player2 win!");
            else System.out.println("player1 win!");
            return true;
        }
        if(game[6]==game[7]&&game[7]==game[8]&&game[6]!=symbol.EMPTY){
            if(game[6]==symbol.O) System.out.println("player2 win!");
            else System.out.println("player1 win!");
            return true;
        }
        if(game[0]==game[3]&&game[3]==game[6]&&game[0]!=symbol.EMPTY){
            if(game[0]==symbol.O) System.out.println("player2 win!");
            else System.out.println("player1 win!");
            return true;
        }
        if(game[1]==game[4]&&game[4]==game[7]&&game[1]!=symbol.EMPTY){
            if(game[1]==symbol.O) System.out.println("player2 win!");
            else System.out.println("player1 win!");
            return true;
        }
        if(game[2]==game[5]&&game[5]==game[8]&&game[2]!=symbol.EMPTY){
            if(game[2]==symbol.O) System.out.println("player2 win!");
            else System.out.println("player1 win!");
            return true;
        }
        if(game[0]==game[4]&&game[4]==game[8]&&game[0]!=symbol.EMPTY){
            if(game[0]==symbol.O) System.out.println("player2 win!");
            else System.out.println("player1 win!");
            return true;
        }
        if(game[2]==game[4]&&game[4]==game[6]&&game[2]!=symbol.EMPTY){
            if(game[2]==symbol.O) System.out.println("player2 win!");
            else System.out.println("player1 win!");
            return true;
        }
        boolean draw=true;
        for(int i=0;i<9;i++){
            if(game[i]==symbol.EMPTY)
                draw=false;
        }
        if(draw){
            System.out.println("The game ended in a draw!");
            return true;
        }
        return false;
    }
}