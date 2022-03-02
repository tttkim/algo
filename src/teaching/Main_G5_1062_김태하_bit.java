package teaching;

import java.util.Scanner;

public class Main_G5_1062_김태하_bit {
	static int N, K;
	static String[] words;
	static int maxReadable;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		K = scanner.nextInt();
		maxReadable = 0;
		scanner.nextLine();
		words = new String[N];
		if (K < 5) {
			System.out.println("0");
			scanner.close();
			return;
		}
		
		int b_teaching = 0;
		b_teaching |= (1<<0);	// a
		b_teaching |= (1<<2);	// c
		b_teaching |= (1<<8);	// i
		b_teaching |= (1<<13);	// n
		b_teaching |= (1<<19);	// t
		
		for (int i = 0; i < N; i++) {
			String temp = scanner.nextLine();
			words[i] = temp.substring(4, temp.length() - 4);
		}
		
		getTeaching(0, b_teaching);
		
		System.out.println(maxReadable);
		
		scanner.close();
	}

	private static void getTeaching(int start, int b_teaching) {
		if (Integer.bitCount(b_teaching) == K) {
			int readable = 0;
			int b_word = 0;
			
			for (int i = 0; i < N; i++) {
				b_word = wordToBit(words[i]);
				
				if ((b_teaching & b_word) == b_word) {
					readable++;
				}
			}
			maxReadable = Math.max(maxReadable, readable);
			return;
		}
		
		for (int i = start; i < 26; i++) {
			b_teaching |= (1<<i);
			
			System.out.println(Integer.toBinaryString(b_teaching));
			getTeaching(i + 1, b_teaching);
		}
	}

	private static int wordToBit(String s) {
		char[] temp = s.toCharArray();
		int b_word = 0;
		
		for (int i = 0; i < temp.length; i++) {
			b_word |= 1 << ((int)temp[i] - 97);
		}
		
		return b_word;
	}
}
