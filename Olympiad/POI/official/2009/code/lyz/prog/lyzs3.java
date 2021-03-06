/*************************************************************************
 *                                                                       *
 *                     XVI Olimpiada Informatyczna                       *
 *                                                                       *
 *   Zadanie:  Lyzwy (LYZ)                                               *
 *   Plik:     lyzs3.java                                                *
 *   Autor:    Juliusz Sompolski                                         *
 *   Opis:     Rozwiazanie wolniejsze O(n*m*d). Dla kazdego rozmiaru     *
 *             stopu probuje przydzielic lyzwy poczawszy od najmniejszych*
 *                                                                       *
 *************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lyzs3 {
	final static int MAX_N = 200001;
	
	static int n, m, k, d;
	static long t[] = new long[MAX_N],lyzwy[] = new long[MAX_N];

	static boolean spr() {
		int i,j;
		/* Inicjowanie wolnych lyzew */
		for(i = 1; i <= n; i++) lyzwy[i] = k;
		for(i = 1; i <= n-d; i++) {
			long ile = t[i]; /* Lyzwiarze ktorym trzeba jeszcze przydzielic lyzwy */
			for(j = i; ile != 0 && j <= i+d; j++) {
				long przydziel = Math.min(lyzwy[j],ile);
				ile -= przydziel; lyzwy[j] -= przydziel;
			}
			if(ile != 0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws java.io.IOException {
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(bufReader.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		k = Integer.parseInt(tokenizer.nextToken());
		d = Integer.parseInt(tokenizer.nextToken());
		
		for(int i = 0; i < m; i++) {
			tokenizer = new StringTokenizer(bufReader.readLine());
			int r = Integer.parseInt(tokenizer.nextToken());
			int x = Integer.parseInt(tokenizer.nextToken());
			t[r] += x;
			if (spr())
				System.out.println("TAK");
			else
				System.out.println("NIE");
		}
	}
}
