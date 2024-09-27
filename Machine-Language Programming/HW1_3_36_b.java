import java.util.Scanner;
public class HW1_b
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
        memory[99]=7; // to store loop counter
        memory[96]=7; // copy original loop_counter
        memory[98]=1;  // set 1 for counting
        memory[97]=0;  // to store sum
        
        memory[0]=1040; // read a number
        memory[1]=2097; // load sum
        memory[2]=3040; // sum + the new read-in number
        memory[3]=2197; // store back to sum
        memory[4]=2099; // load loop_counter
        memory[5]=3198; // loop_counter - 1
        memory[6]=2199; // store back to loop_counter
        memory[7]=4209; // if(acccmulator==0) branch to instruction 9
        memory[8]=4000; // goto instruction 0 to perform a loop 
        memory[9]=2097; // load sum
        memory[10]=3296; // calculate average
        memory[11]=2196; // store the average back 
        memory[12]=1196; // write the average
        memory[13]=4300; //end
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
	                System.out.printf("average is %d.%n",memory[location]);
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
