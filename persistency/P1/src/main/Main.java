package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileWriter;

public class Main {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void insert(ArrayList<Integer> a) throws IOException {
		
		
		ArrayList b = new ArrayList<Integer>();
		ArrayList c = new ArrayList<Integer>();
		String line;
		
		
		  try ( BufferedReader br = new BufferedReader(new FileReader("D:/school/v1dp/persistency/P1/src/main/data.csv"))) {

	            while ((line = br.readLine()) != null) {

	                
	                b.add(line);

	       
	
	            }
	      
	              br.close();

	        } catch (IOException e) {
	            e.printStackTrace();
	        
	            
	        }
		
		c.addAll(a);
		c.addAll(b);

	
		System.out.println(c);
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:/school/v1dp/persistency/P1/src/main/data.csv",false))){
			
		
		Integer j = 0;
		
		for (int i = 0; i < c.size(); i++) {
			
			bw.write( c.get(i)+ "\n");
			
		}
	bw.close();
		}
		catch (IOException e) {
        e.printStackTrace();
    }
		
	}
		
	public static void delete(int sd){
		String line;
		ArrayList b = new ArrayList<Integer>();
		try ( BufferedReader br = new BufferedReader(new FileReader("D:/school/v1dp/persistency/P1/src/main/data.csv"))) {

            while ((line = br.readLine()) != null) {

                
                b.add(line);

            }
      
              br.close();

        } catch (IOException e) {
            e.printStackTrace();
        
            
        }
	
	System.out.println("\n hier");
	System.out.println(sd);
	System.out.println(b);
		b.remove(sd);
		System.out.println(b);

	
	try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:/school/v1dp/persistency/P1/src/main/data.csv",false))){
		
	
	Integer j = 0;
	
	for (int i = 0; i < b.size(); i++) {
		bw.write( b.get(i)+ "\n");
		
	}
	
bw.close();
	}
	catch (IOException e) {
    e.printStackTrace();
}
	
		
	}
	public static void main(String[] args) throws IOException {
		ArrayList a = new ArrayList ();
		a.add(3);
		a.add(7);
		a.add(3);
		a.add(7);
		a.add(2);
		a.add(6);
		a.add(8);
		int s = 3;
insert(a);
delete(s);
insert(a);

}

}
