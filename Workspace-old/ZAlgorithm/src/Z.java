
import java.util.ArrayList;

/*
 * 													Z Algorithms
 * 
 * Dalam algoritma ini kita akan membuat Z array. Z array berisi panjang dari substring terpanjang dalam string[i]. mulai dari string[i] 
 * yang juga merupakan prefix dari string[0 sampai n-1]. substring yang dimulai dari index 0 dalam string[i] akan selalu menjadi prefix
 * dari array itu sendiri.
 * 
 * string[i] (concatenated string) disini adalah penggabungan dari Pattern + "SpecialCharacter" + Text. maka panjang Z array
 * menjadi panjang pattern digabungkan dengan text + 1.
 * 
 * misalkan : 	pattern 			: ac
 * 				text    			: bac
 * 				special character   : $
 *
 * maka concatenated string menjadi : ac$bac
 * 
 * Cara mencari Z value dari setiap Z[i] dari concatenated string "ac$bac" :
 * 
 * i         | 0  1  2  3  4  5 |
 * string[i] | a  c  $  b  a  c |
 * Z[i]      | x  0  0  0  1  0 |
 * 
 * Z[0] : tidak ada (x) karena substring yang dimulai dari index 0 dalam string[i] akan selalu menjadi prefix
 * 		  dari array itu sendiri.
 * 
 * Z[1] : 0
 * 		  Substring mulai dari index 1 	| prefix dari string[0 sampai n-1]
 * 		  c	 						   	| a
 * 		  c$							| ac
 * 		  c$b							| ac$
 * 		  c$ba							| ac$b
 * 		  c$bac							| ac$ba
 *										| ac$bac
 *			Tidak ditemukan substring yang merupakan prefix dari string[0 sampai n-1] maka Z[1] = 0.
 *
 *Z[2] : 0
 *		  Substring mulai dari index 2 	| prefix dari string[0 sampai n-1]
 * 		  $	 						   	| a
 * 		  $b							| ac
 * 		  $ba							| ac$
 * 		  $bac							| ac$b
 * 		      							| ac$ba
 *										| ac$bac
 *			Tidak ditemukan substring yang merupakan prefix dari string[0 sampai n-1] maka Z[2] = 0
 *
 *Z[3] : 0
 *		  Substring mulai dari index 3 	| prefix dari string[0 sampai n-1]
 * 		  b	 						   	| a
 * 		  ba							| ac
 * 		  bac							| ac$
 * 		    							| ac$b
 * 		      							| ac$ba
 *										| ac$bac
 * 			Tidak ditemukan substring yang merupakan prefix dari string[0 sampai n-1] maka Z[3] = 0
 * 
 * Z[4] : 1
 * 		  Substring mulai dari index 4 	| prefix dari string[0 sampai n-1]
 * 		  a	 						   	| a
 * 		  ac							| ac
 * 		    							| ac$
 * 		    							| ac$b
 * 		      							| ac$ba
 *										| ac$bac
 *			Ditemukan substring yang merupakan prefix dari string[0 sampai n-1] maka Z[3] yang panjanya adalah 1 maka Z[4] = 1
 *
 * Z[5] : 0
 * 		  Substring mulai dari index 5 	| prefix dari string[0 sampai n-1]
 * 		  c	 						   	| a
 * 		    							| ac
 * 		    							| ac$
 * 		    							| ac$b
 * 		      							| ac$ba
 *										| ac$bac
 *			Tidak ditemukan substring yang merupakan prefix dari string[0 sampai n-1] maka Z[5] = 0
 *
 *Jadi Z array dari concatenated string = "ac$bac" adalah Z = {x,0,0,0,1,0}.
 *
 *===============================Pencarian Pattern pada text=====================================================================
 *untuk pencarian pattern pada text adalah dengan cara mencari nilai panjang pattern dan jika nilai dari panjang pattern tersebut
 *sama dengan Z value pada array Z pada index ke - i, maka pattern ditemukan pada index ke-i pada array Z. 
 *atau pada index ke-[i - panjang pattern - 1] pada array text.
 *
 */										




public class Z {
	
	public static int search(String txt,String pat){
		int result = 0;
		String concat = pat + "$" + txt;
		
		int[] Z = new int[concat.length()];
		Z = getZ(concat);
		
		for(int i = 0 ; i < concat.length() ; i++) {
			if(Z[i] == pat.length()) {
				result = i - pat.length()-1;
				break;
			}
		}
		return result;
	}
	
	private static int[] getZ(String concat) {
		
		int N = concat.length();
		int[] result = new int[N];
		int L,R,k;
		
		
		L = R = 0;
		for(int i = 1 ; i < N ; ++i) {
			if(i > R) {
				L = R = i;
				while(R < N && concat.charAt(R-L) == concat.charAt(R)) {
					R++;
				}
				result[i] = R-L;
				R--;
			}
			else {
				k = i-L;
				if(result[k] < R-i+1) {
					result[i] = result[k];
				}
				else {
					L = i;
					while(R<N && concat.charAt(R-L) == concat.charAt(R)) {
						R++;
					}
					result[i] = R-L;
					R--;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String text = "LAH APA INI SAYA TIDAK TAU APA APA";
	    String pattern = "APA";
	    System.out.println("Pattern found at index : ");
	    System.out.println(search(text, pattern));
	    
	    
	    
		
	}
}

