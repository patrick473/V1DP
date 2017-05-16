package week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;

public class Main {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void insert(ArrayList<Integer> a) throws IOException {
		
		
		ArrayList b = new ArrayList<String>();
		ArrayList c = new ArrayList<String>();
		String line;
		
		BufferedReader br = new BufferedReader(new FileReader("data.csv"));
		while ((line = br.readLine()) != null){
			b.add(line);
		}
		br.close();
		
		c.addAll(a);
		c.addAll(b);
		
		Collections.sort(c);
		
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("data.csv",false));
		Integer j = 0;
		while (c.size()>j){
		String d = c.get(j);
			bw.write();
	}
	
	
	
	
	
}
