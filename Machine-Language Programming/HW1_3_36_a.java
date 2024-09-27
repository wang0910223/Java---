import java.util.Scanner;
public class HW1_a
{
    static final int READ=10;
    static final int WRITE=11;
    static final int LOAD=20;
    static final int STORE=21;
    static final int ADD=30;
    static final int SUBTRACT=31;
    static final int DIVIDE=32;
    static final int MULTIPLY=33;
    static final int BRANCH=40;
    static final int BRANCHNEG=41;
    static final int BRANCHZERO=42;
    static final int HALT=43;
    static int[] memory=new int[100];
    static int counter=0,accumulator=0,operation,location;

    public static void main(String[] args) {

        set_instruction(memory);
        execute(memory);
    }
    
    public static void set_instruction(int[] memory) {
		//不確定題目是要以輸入10個數字做為終止條件還是以讀到負數為終止條件
		//所以兩個條件都納入考量了
		//讀到負數就會output負數以前的sum，並結束程式
		//或是讀滿10個正數就會結束程式

		memory[99]=10; // to store loop counter
        memory[98]=1;  // set 1 for counting
        memory[97]=0;  // to store sum
        
        memory[0]=1040; // read a number
        memory[1]=2040; // load the number
        memory[2]=4111; // if the number is negative, branch to instruction 11(write sum and end the program)
        memory[3]=2097; // load sum
        memory[4]=3040; // sum + the new read-in number
        memory[5]=2197; // store back to sum
        memory[6]=2099; // load loop_counter
        memory[7]=3198; // loop_counter - 1
        memory[8]=2199; // store back to loop_counter
        memory[9]=4211; // if(acccmulator==0) branch to instruction 11(write sum and end the program)
        memory[10]=4000; // back to instruction 0 to perform a loop 
        memory[11]=1197; // write the sum
        memory[12]=4300; //end
    }

	public static void execute(int[] memory){
	    Scanner input=new Scanner(System.in);
	    int trace=0;
	    operation=memory[trace]/100;
	    location=memory[trace++]%100;
	    
	    while(true){
	        switch(operation){
	            case READ:
	                System.out.println("please enter a number");
	                memory[location]=input.nextInt();
	                break;
	            case WRITE:
	                System.out.printf("sum is %d.%n",memory[location]);
	                break;
	            case LOAD:
	                accumulator=memory[location];
	                //System.out.printf("accumulator= %d.%n",accumulator);
	                break;
	            case STORE:
	                memory[location]=accumulator;
	                //System.out.printf("memory[%d]= %d.%n",location,memory[location]);
	                break;
	            case ADD:
	                accumulator+=memory[location];
	                break;
	            case SUBTRACT:
	                accumulator-=memory[location];
	                break;
	            case DIVIDE:
	                if(memory[location]==0){
	                    System.out.println("****divied by zero****%n");
	                    break;
	                }
	                accumulator/=memory[location];
	                break;
	            case MULTIPLY:
	                accumulator*=memory[location];
	                break;
	            case BRANCH:
	                trace=location;
	                break;
	            case BRANCHNEG:
	                if(accumulator<0)
	                    trace=location;
	                break;
	            case BRANCHZERO:
	                if(accumulator==0)
	                    trace=location;
	                break;
	            case HALT:
	                System.out.println("****execution end****");
	                break;
	        }
	        if(operation==HALT)
	            break;
	        operation=memory[trace]/100;
	        location=memory[trace++]%100;
	    }
	}
}