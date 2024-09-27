import java.util.Scanner;
public class HW1_c
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
    static int counter=0,accumulator=0,operation,location,number;

    public static void main(String[] args) {
        set_instruction(memory);
        execute(memory);
    }
    public static void set_instruction(int[] memory) {
        memory[99]=1;
        
        memory[0]=1040; // read the number of numbers
        memory[1]=1041; // read the first number(use memory[41] to store the largest existing number)
        memory[2]=2040; // load counter
        memory[3]=3199; // counter-=1
        memory[4]=2140; // store counter back
        
        memory[5]=2040; // load counter
        memory[6]=3199; // counter-=1
        memory[7]=2140; // store counter back
        memory[8]=4117; // if counter<0, goto [18]
        
        memory[9]=2041; // load the largest existing number
        memory[10]=1042; // read new number
        memory[11]=3142; // largest existing number - new number
        
        memory[12]=4114; // if negative, goto instruction [15]
        memory[13]=4005; // if positive, back to instruction [5] to continue the loop
        
        memory[14]=2042; // load the new number 
        memory[15]=2141; // store to memory[41](which containing the largest existing number)
        memory[16]=4005; // back to instruction [5] to continue the loop
        
        memory[17]=1141; // write result
        memory[18]=4300; //end
        
    }

	public static void execute(int[] memory){
	    Scanner input=new Scanner(System.in);
	    int trace=0;
	    operation=memory[trace]/100;
	    location=memory[trace++]%100;
	    
	    while(true){
	        switch(operation){
	            case READ:
	                System.out.printf("please enter a number%n");
	                memory[location]=input.nextInt();
	                break;
	            case WRITE:
	                System.out.printf("The largest number is %d.%n",memory[location]);
	                break;
	            case LOAD:
	                accumulator=memory[location];
	                //System.out.printf("accumulator= %d.%n",accumulator);
	                break;
	            case STORE:
	                memory[location]=accumulator;
	                //System.out.printf("store memory[%d]= %d.%n",location,memory[location]);
	                break;
	            case ADD:
	                accumulator+=memory[location];
	                break;
	            case SUBTRACT:
	                accumulator-=memory[location];
	                break;
	            case DIVIDE:
	                if(memory[location]==0){
	                    System.out.println("****divied by zero**** %n");
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