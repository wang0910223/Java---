import java.util.Scanner;
public class HW1_37
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
	    welcome();
	    set_instruction(memory);
	    execution(memory);
	    computer_dump(memory);
	}
	public static void welcome(){
	    System.out.println("*** Welcome to Simpletron!                       ***");
        System.out.println("*** Please enter your program one instruction    ***");
        System.out.println("*** (or data word) at a time. I will display     ***");
        System.out.println("*** the location number and a question mark (?). ***");
        System.out.println("*** You then type the word for that location.    ***");
        System.out.println("*** Type -99999 to stop entering your program.   ***");
	}
	public static void set_instruction(int[] memory){
	    Scanner input= new Scanner(System.in);
	    while(true){
	        System.out.printf("%02d ? ",counter);
	        memory[counter++] = input.nextInt();
	        if(memory[counter-1]==-99999){
	            memory[counter-1]=0;
	            counter-=2;
	            System.out.println("*** Program loading completed ***");
	            System.out.println("*** Program execution begins  ***");
	            break;
	        }
	    }
	}
	public static void execution(int[] memory){
	    Scanner input=new Scanner(System.in);
	    int trace=0;
	    boolean default_v=false;
	    operation=memory[trace]/100;
	    location=memory[trace++]%100;
	    
	    while(!default_v){
	        switch(operation){
	            case READ:
	                System.out.println("please enter a number");
	                memory[location]=input.nextInt();
	                break;
	            case WRITE:
	                System.out.printf("number is %d.%n",memory[location]);
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
	                System.out.println("*** Simpletron execution terminated ***");
	                break;
	            default:
	                System.out.printf("*** operation %d is not an instruction! ***%n",operation);
	                default_v=true;
	                break;
	        }
	        if(operation==HALT)
	            break;
	           //System.out.printf("trace= %d%n",trace);
	        else{
	            operation=memory[trace]/100;
	            location=memory[trace++]%100;
	        }
	    }
	}
	public static void computer_dump(int[] memory){
	     System.out.printf("REGISTERS:%n");
	     System.out.printf("accumulator           %+05d%n",accumulator);
	     System.out.printf("instructionCouter     %02d%n",counter);
	     System.out.printf("instructionRegister   %+05d%n",memory[counter]);
	     System.out.printf("operationCode         %02d%n",operation);
	     System.out.printf("operand               %02d%n%n",location);
	     System.out.printf("MEMORY:%n  ");
	     for(int i=0;i<10;i++){
	         System.out.printf("%7d",i);
	     }
	     System.out.printf("%n");
	     for(int i=0;i<10;i++){
	         System.out.printf("%2d ",i*10);
	         for(int j=0;j<10;j++){
	             System.out.printf(" %+05d ",memory[j+i*10]);
	         }
	         System.out.printf("%n");
	         
	         
	     }
	}
	
}