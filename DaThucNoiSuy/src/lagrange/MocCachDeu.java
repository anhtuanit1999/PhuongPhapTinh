package lagrange;

import java.util.ArrayList;

public class MocCachDeu {
	public int giaiThua(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	public int toHop(int soLon, int soBe) {
		return giaiThua(soLon) / (giaiThua(soBe) * giaiThua(soLon - soBe));
	}
	
	public float hangSoTrongCongThuc(float n, int size) {
		float result = 1;
		for (int i = 0; i < size + 1; i++) {
			 result *= (n - i);
		}
		return result;
	}
	
	public float lagrangeCal(float[][] arr2d, float n) {
		n = ((n - Math.abs(arr2d[0][0] - arr2d[1][0])) / Math.abs(arr2d[0][0] - arr2d[1][0]));
		int size = arr2d.length - 1;
		float result = 0;
		for (int i = 0; i <= size; i++) {
	        result += (hangSoTrongCongThuc(n, size) * Math.pow(-1, size - i) * toHop(size, i) * arr2d[i][1]) / ((n - i) * giaiThua(size));
	    }
		return Math.round(result * 1000000.0f) / 1000000.0f;
	}
	
	public static void main(String[] args) {
		float[][] value = {
				{1, 1},
				{2, 5},
				{3, 21},
				{4, 55}
		};
		
		float[][] value2 = {
				{0.25f, 0.255307f},
				{0.5f, 0.544987f},
				{0.75f, 0.917916f},
				{1f, 1.462652f}
		};
		MocCachDeu mcd = new MocCachDeu();
		System.out.println(mcd.lagrangeCal(value, 3.5f));
		System.out.println(mcd.lagrangeCal(value2, 0.7f));
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 10-11-2020
* @version: 1.0
*/
