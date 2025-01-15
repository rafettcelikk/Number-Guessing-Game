package defaultt;

import java.util.Random;
import java.util.Scanner;

public class SayiTahminOyunu {

	public static void main(String[] args) {
		int tahmin, can = 10, i = 0;
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		int sayi = rand.nextInt(100);
		boolean oyunDurumu = false, hata = false;
		int[] tahminler = new int[10];
		System.out.println("Sayı tahmin oyununa hoşgeldiniz!");
		System.out.println("0-99 arası sayı tuttum.");
		
		while(can > 0) {
			System.out.print("Tahmininiz: ");
			tahmin = scan.nextInt();
			
			if(tahmin < 0 || tahmin > 99) {
				if(hata) {
					System.out.println("Üst üste çok hata yaptınız canınız azaldı.");
					System.out.println("Kalan canınız: " + --can);
				}
				else {
					hata = true;
					System.out.println("Lütfen 0-99 arası bir sayı giriniz!");
				}
				continue;
			}
			else {
				tahminler[i++] = tahmin;
				if(tahmin == sayi) {
					oyunDurumu = true;
					break;
				}
				else {
					System.out.println("Yanlış tahmin! Kalan canınız: " + --can);
					
					int fark = Math.abs(sayi - tahmin); 
					if(fark <= 10) {
						System.out.println("Çok sıcak!"); 
					} 
					else if(fark <= 20) {
						System.out.println("Sıcak!"); 
					} 
					else if(fark <= 30) {
						System.out.println("Ilık!"); 
					} 
					else {
						System.out.println("Soğuk!"); 
					}
				}
			}
		}
		if(oyunDurumu) {
			System.out.println("Tebrikler doğru tahmin!");
			System.out.println("Tuttuğumuz sayı: " + sayi);
			System.out.println("Kalan can: " + can);
		}
		else {
			System.out.println("Bir sonraki sefere D:");
			System.out.println("Tuttuğumuz sayı: " + sayi);
		}
		System.out.print("Tahminleriniz: ");
		for(int j = 0; j < i; j++) {
			if(j == i - 1) {
				System.out.print(tahminler[j]); 
			} 
			else {
				System.out.print(tahminler[j] + ", "); 
			} 
		}
	}
}
