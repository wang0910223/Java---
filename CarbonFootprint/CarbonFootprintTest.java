import java.util.ArrayList;

public class CarbonFootprintTest
{
	public static void main(String[] args) {
	    ArrayList<CarbonFootprint> list = new ArrayList<>();

        // 分別為三個類別建立物件，並加入Arraylist
	    list.add(new car(200000,200,100));
		list.add(new building(5,3000,5));
		list.add(new bicycle(30,10,"ABC"));


		// 印出Arraylist中物件的CarbonFootprint資訊 和個別的其他資訊
		for(CarbonFootprint i : list){
		    System.out.printf("%-8s   carbon: %-10d", i.getClass().getName(),i.getCarbonFootprint());
		    if(i.getClass().getName()=="car"){
		        car a=(car)i;
		        System.out.printf("price= %d%n",a.getprice());

		    }
		    else if(i.getClass().getName()=="building"){
		        building a=(building)i;
		        System.out.printf("floor number= %d%n",a.getfloor_num());

		    }
		    else if(i.getClass().getName()=="bicycle"){
		        bicycle a=(bicycle)i;
		        System.out.printf("brand= %s%n",a.getbrand());

		    }
		}
	}
}

interface CarbonFootprint {
	int getCarbonFootprint();
}
class car implements CarbonFootprint {
    private int price,miles,carbon_per_mile;
    private static int base=10000; // carbon for produce a car
    
    car(int p,int m,int c_m){
        price=p; miles=m; carbon_per_mile=c_m;
    }
    car(){
        price=0; miles=0; carbon_per_mile=0;
    }

    // 計算Carbonfootprint 計算方法為 base(製造車輛過程的碳排放量)+每mile造成的碳排放*miles數
    public int getCarbonFootprint() { return miles*carbon_per_mile + base; }
    public int getprice(){return price;}
    
}
class building implements CarbonFootprint {
    private int floor_num, carbon_per_year,years;
    private static int base= 1000000; // carbon for construct a building
    
    building(int f,int c_y,int y){
        floor_num=f; carbon_per_year=c_y; years=y;
    }
    building(){
        floor_num=1; carbon_per_year=1000; years=1;
    }

    // 計算Carbonfootprint 計算方法為 base(製造building過程的碳排放量)+每年碳排放量*年數
    public int getCarbonFootprint() { return carbon_per_year*years + base; }
    // 取得building的樓層數
    public int getfloor_num(){return floor_num;}
    
}
class bicycle implements CarbonFootprint {
    private static int base=500; // carbon for produce a bike
    private int miles,carbon_per_mile;
    private String brand;
    
    bicycle(int m,int c_m, String b){
        miles=m; carbon_per_mile=c_m; brand=b;
    }
    bicycle(){
        miles=0; carbon_per_mile=0; brand="none";
    }
    
    // 計算Carbonfootprint 計算方法為 base(製造腳踏車過程的碳排放量)+騎乘每mile造成的碳排放*miles數
    public int getCarbonFootprint() { return miles*carbon_per_mile + base; }
    // 取得腳踏車品牌資訊
    public String getbrand(){return brand;}

}