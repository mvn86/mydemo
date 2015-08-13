package org.demo.json2;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		for (int i = 2; i < 1000; i++) {
			if (isPrime(i)) {
				//System.out.println(i);
			}
		}
	}

	public static boolean isPrime(long n) {
		//判断出“2”的情况
		if (n <= 3) {
			return n > 1;
		}
		//是否能被质数“2”或者“3”整除
		if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
}