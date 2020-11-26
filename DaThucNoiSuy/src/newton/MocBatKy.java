package newton;

import java.util.ArrayList;

public class MocBatKy {
	
	public float tinhTSP(float x0, float x, float y0, float y) {
	    return (y - y0) / (x - x0);
	}
	
	public float Newton(float[][] arr2d, float n) {
		int size = arr2d.length;
		int soTSP = size - 1;
		ArrayList<ArrayList<Float>> arrTSP = new ArrayList<>();
		for (int i = 0; i < soTSP + 2; i++) {
			arrTSP.add(new ArrayList<>());
		}
		for (int i = 0; i < size; i++) {
			arrTSP.get(0).add(arr2d[i][0]);
			arrTSP.get(1).add(arr2d[i][1]);
		}
		
		for (int i = 1; i <= soTSP; i++) {
	        for (int j = 0; j < soTSP + 1 - i; j++) {
	            float x0 = arrTSP.get(0).get(j),
	            	x = arrTSP.get(0).get(j + i),
	            	y0 = arrTSP.get(i).get(j),
	            	y = arrTSP.get(i).get(j + 1);
	            arrTSP.get(i + 1).add(tinhTSP(x0, x, y0, y));
	        }
	    }
		
		float result = arrTSP.get(1).get(0);
	    float temp = 1;
	    for (int i = 0; i < soTSP; i++) {
	        temp *= (n - i);
	        result += temp * arrTSP.get(i + 2).get(0);
	    }
		return result;
	}
	
	public static void main(String[] args) {
		float[][] value = {
				{0, 0},
				{1, 1},
				{2, 8},
				{4, 64}
		};
		
		float[][] value2 = {
				{0, -5},
				{1, 2},
				{2, 5},
				{3, 10},
				{4, 30}
		};
		
		MocBatKy mbk = new MocBatKy();
		System.out.println(mbk.Newton(value, 3));
		
		System.out.println(mbk.Newton(value2, 2.5f));
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 10-11-2020
* @version: 1.0
*/
