import java.util.Scanner;

public class Matran{
	static int[][] a =new int[100][100];
	static int tongMaxHang;
	static int tongMaxCot;
	static int dongMax;
	
	void nhap( int m, int n){
		Scanner sc = new Scanner(System.in);
		for(int i=0 ; i<m;i++){
			for(int j =0; j<n ; j++){
				
				System.out.println("a["+(i+1)+","+(j+1)+"]=");
				a[i][j] = sc.nextInt();
			}
		}
	}
	void in(int m, int n, boolean inTong){
		if(inTong){
			for(int i=0 ; i<m;i++){
				for(int j =0; j<n ; j++){
					if((i+j) ==(m+n-2)){
						System.out.print("");
					}else{
						System.out.print(a[i][j]+"  ");
					}
				}
				System.out.println("");
			}
			
		}else{
			for(int i=0 ; i<m;i++){
				for(int j =0; j<n ; j++){
					System.out.print(a[i][j]+"  ");
				}
				System.out.println("");
				
			}
		}
		System.out.println("");
	}
	void tongHangtongCot(int m, int n){
		int tongHang = 0; int tongCot =0;
		dongMax =0;
		
		tongMaxHang = a[0][0];
		for ( int i=0; i<m;i++){
			
			tongHang = 0;
			int j;
			for(j =0;j<n;j++)
			{
				tongHang = tongHang + a[i][j];
			}
			a[i][j] = tongHang;
			if(tongHang > tongMaxHang)
			{
				tongMaxHang = tongHang;	
				dongMax =i;
			}	
		}
		tongMaxCot = a[0][0];
		for ( int j = 0; j<n;j++)
		{
	
			tongCot = 0;
			int i;
			for(i = 0;i<m;i++){
				tongCot = tongCot + a[i][j];
				
			}
			a[i][j] = tongCot;
			if(tongCot > tongMaxCot){
				tongMaxCot = tongCot;
			}
		}

		
	}
	public static void main(String []args){
		int m,n;
		Scanner sc =  new Scanner(System.in);
		System.out.print("Nhap so hang m= ");
		m =sc.nextInt();
		System.out.print("Nhap so cot n= ");
		n = sc.nextInt();
		Matran mt = new Matran();
		mt.nhap(m,n);
		mt.in(m,n,false);
		mt.tongHangtongCot(m,n);
		System.out.println("Mang co ket qua tong hang cot");
		mt.in(m+1,n+1, true);
		System.out.println("Tong hang lon nhat la: "+tongMaxHang);
		System.out.println("Tong cot lon nhat la: "+tongMaxCot);
		
	}
	
}