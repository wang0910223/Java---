public class hugeIntTest
{
	public static void main(String[] args) {
	    boolean res;
	    hugeInt test1=new hugeInt();
	    hugeInt test2=new hugeInt();
	    
	    System.out.print("***parse***\n");
	    test1.parse("999987977777989856");
	    test2.parse("000000999987977777");
	    System.out.print("test1: ");
	    test1.printHugeInt();
	    System.out.print("test2: ");
	    test2.printHugeInt();
	    
	    System.out.print("\n***to_string***\n");
	    char str[]=new char[40];
	    str=test1.toString(test1);
	    System.out.printf("test1 string= ");
	    for(int i=0;str[i]!='\0';i++)
	        System.out.printf("%c", str[i]); 
	    
	    System.out.print("\n\n****add****\n");
	    test1.add(test2);
	    System.out.print("test1 += test2: ");
	    test1.printHugeInt();
	    
	    System.out.print("\n***subtract***\n");
	    test1.subtract(test2);
	    System.out.print("test1 -= test2: ");
	    test1.printHugeInt();
	    
	    System.out.print("\n****isEqualTo****\n");
	    res=test1.isEqualTo(test1);
	    System.out.printf("test1 == test1: %b%n",res);
	    res=test1.isEqualTo(test2);
	    System.out.printf("test1 == test2: %b%n",res);
	    
	    System.out.print("\n****isNotEqualTo****\n");
	    res=test1.isNotEqualTo(test1);
	    System.out.printf("test1 != test1: %b%n",res);
	    res=test1.isNotEqualTo(test2);
	    System.out.printf("test1 != test2: %b%n",res);
	    
	    System.out.print("\n****isLessThan****\n");
	    res=test1.isLessThan(test2);
	    System.out.printf("test1 < test2: %b%n",res);
	    
	    System.out.print("\n****isLessThanOrEqualTo****\n");
	    res=test1.isLessThanOrEqualTo(test2);
	    System.out.printf("test1 <= test2: %b%n",res);
	    
	    System.out.print("\n****isGreaterThan****\n");
	    res=test1.isGreaterThan(test2);
	    System.out.printf("test1 > test2: %b%n",res);
	    
	    System.out.print("\n****isGreaterThanOrEqualTo****\n");
	    res=test1.isGreaterThanOrEqualTo(test2);
	    System.out.printf("test1 >= test2: %b%n",res);
	    
	    System.out.print("\n****isZero****\n");
	    res=test2.isZero();
	    System.out.printf("test2 == 0: %b%n",res);
	}
	
}
class hugeInt{
    
    private int[] arr=new int[40];
    boolean neg=false;
    
    public void parse(String str){
        int length=str.length();
        
        for(int i=length-1,j=0;i>=0;i--,j++){  
            char temp=str.charAt(i);           
            arr[j]=temp-'0';
        }
	}
	public char[] toString(hugeInt n){   
	    char[] tempstr= new char[40];
	    int digit_num=0;
	    for(int i=39;i>=0;i--){
	        if(arr[i]!=0){
	            digit_num=i;
	            break;
	        }
	    }
	    for(int i=digit_num,j=0;i>=0;i--,j++){
	        tempstr[j]=(char)(arr[i]+'0'); 
	    }
	    tempstr[digit_num+1]='\0';
	    return tempstr;
	}
	public void add(hugeInt n){
	    int digit_num=0;
	    for(int i=39;i>=0;i--){
	        if(arr[i]!=0 || n.arr[i]!=0){
	            digit_num=i;
	            break;
	        }
	    }
	    int carry=0;
	    for(int i=0;i<=digit_num+1;i++){
	        arr[i]= (arr[i]+n.arr[i]+carry);
	        carry = arr[i]/10;
	        arr[i]%= 10;
	    }
	}
	public void subtract(hugeInt n){
	    int digit_num=0;
	    boolean is_neg=isLessThan(n);
	    neg=is_neg;
	    
	    
	    for(int i=39;i>=0;i--){
	        if(arr[i]!=0 || n.arr[i]!=0){
	            digit_num=i;
	            break;
	        }
	    }
	    
	    boolean bout=false;
	    for(int i=0;i<=digit_num+1;i++){
	        if(is_neg){
	            if(bout){
	                arr[i]= n.arr[i]-arr[i]-1;
	                if(arr[i]<0){
	                    arr[i]+=10;
	                    bout=true;
	                }
	                else
	                    bout=false;
	                
	            }
	            else{
	                arr[i]= n.arr[i]-arr[i];
	                if(arr[i]<0){
	                    arr[i]+=10;
	                    bout=true;
	                }
	                else
	                    bout=false;
	            }
	        }
	        else{
	            if(bout){
	                arr[i]= arr[i]-n.arr[i]-1;
	                if(arr[i]<0){
	                    arr[i]+=10;
	                    bout=true;
	                }
	                else
	                    bout=false;
	            }
	            else{
	                arr[i]= arr[i]-n.arr[i];
	                if(arr[i]<0){
	                    arr[i]+=10;
	                    bout=true;
	                }
	                else
	                    bout=false;
	            }
	        }
	    }
	    
	} 
	public boolean isEqualTo(hugeInt n){
	    for(int i=0;i<40;i++){
	        if(arr[i]!=n.arr[i]){
	            return false;
	        }
	    }
	    return true;
	}
	public boolean isNotEqualTo(hugeInt n){
	    if(isEqualTo(n)) return false;
	    else return true;
	}
	public boolean isGreaterThan(hugeInt n){
	    if(isEqualTo(n)) return false;
	    for(int i=39;i>=0;i--){
	        if(arr[i]>n.arr[i]){
	            return true;
	        }
	        else if(n.arr[i]>arr[i]){
	            return false;
	        }
	    }
	    return true;
	}
	public boolean isLessThan(hugeInt n){
	    if(isEqualTo(n)) return false;
	    for(int i=39;i>=0;i--){
	        if(n.arr[i]>arr[i]){
	            return true;
	        }
	        else if(n.arr[i]<arr[i]){
	            return false;
	        }
	    }
	    return false;
	}
	public boolean isGreaterThanOrEqualTo(hugeInt n){
	    if(isGreaterThan(n)||isEqualTo(n))
	        return true;
	    else return false;
	}
	public boolean isLessThanOrEqualTo(hugeInt n){
	    if(isLessThan(n)||isEqualTo(n))
	        return true;
	    else return false;
	}
	public boolean isZero(){
	    for(int i=0;i<40;i++){
	        if(arr[i]!=0)
	            return false;
	    }
	    return true;
	}
	public void printHugeInt(){
	    if(neg) System.out.printf("-");
	    boolean start=false;
	    for(int i=39;i>=0;i--){
	        if(arr[i]!=0)
	            start=true;
	        if(start)
	            System.out.printf("%d",arr[i]);
	    }
	    if(!start) System.out.printf("0");
	    System.out.printf("%n");
	}
}