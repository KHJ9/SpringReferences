package day02;

public class MyLotto {

	public static void main(String[] args) {
		String[] arr45 = {
				"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
				"41", "42", "43", "44", "45"
		};
		
		for(int i=0; i<100; i++) {
			int rnd = (int)(Math.random()*45);
			String a = arr45[0];
			String b = arr45[1];
			arr45[0] = b;
			arr45[rnd] = a;
		}
		
		System.out.println(arr45[0]+","+arr45[1]+","+arr45[2]+","+arr45[3]+","+arr45[4]+","+arr45[5]);
		
	}
	
}
