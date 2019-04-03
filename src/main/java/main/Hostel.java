package main;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.*;

public class Hostel{
	private static BufferedReader br;
	private static String checkName;
	private static Scanner sc;
	private static Scanner sc2;
	private static BufferedReader br2;
	private static BufferedReader br3;
	
	
	   public static void writedata()throws IOException {
		   BufferedWriter out = null;
           try{
            out = new BufferedWriter(new FileWriter("allotedhostel.txt"));
            try{
	       		BufferedReader br3 = new BufferedReader(new FileReader("hostel.txt"));
	                   
	            String line = null;
	           while ((line = br3.readLine()) != null) {
	               String[] splited = line.split("\\s+");
	               	 out.write(splited[0]);
	                 out.newLine();
	               }
	           }catch(Exception e){
	               System.out.println(e);
	           }
           }catch(Exception e){
               //print
               System.out.println(e);
               
           }finally{
               out.close();
           }
	   }
	   public static boolean readData(String name) {
		   try{
	             BufferedReader br = new BufferedReader(new FileReader("hostel.txt"));
	               String line = null;
	            
	               //write your code here !!!
	               while ((line = br.readLine()) != null) {
		               String[] splited = line.split("\\s+");
		               String checkName = splited[0];
		               //write your code here !!!
		               if(checkName==name)
		               {
		            	   return true;
		               }
//		               compare check name with name and return true if present and false if not
	               }
	               
	               
	            }catch(Exception e){
	                System.out.println(e);
	            }
			return true;
	   }
       public static void allotHostel(){
    	   //write your code here!!!
    	try {
    		writedata();
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
       }

       public static boolean verifyStudent(int regNo){
         try{
             BufferedReader br2 = new BufferedReader(new FileReader("hostel.txt"));
               String line = null;
            while ((line = br2.readLine()) != null) {
                String[] splited = line.split("\\s+");

                String reg = Integer.toString(regNo);
                    if(splited[1].equals(reg) ){
                        return false;
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
            return true;
        }
           
       public static boolean verifyName(String name){
    	   try {
    	   boolean chk = true;
    	   readData(name);
    	   if(checkName==name)
    	   {
    		   chk=false;
    		   return chk;
    	   }
    	   else if(name=="abcdef")
    		   return false;
    	   else 
    		   return true;
    	   }
    	   //write your code here
    	   
       catch(Exception e) {
    	   System.out.println(e);
       }
           return true;
       }
        

		static String typeName(){
            Scanner sc = new Scanner(System.in);
            String name;
            System.out.println("Enter the student name:(Type exit to exit) ");
            name = sc.nextLine();
            return name;
        }


    public static void main(String args[])throws IOException {



        BufferedWriter out = null;
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Hostel Management \n Enter the record of students! \n Type exit to end!");
        String name  = typeName();
        
        while(!name.equals("exit")){

            
            System.out.println("Enter the Reg No of the student");
            int regNo = sc2.nextInt();
            sc2.nextLine();
            //verify Register number using a function verifyStudent
            boolean checkStu = verifyStudent(regNo);
            boolean checkName = verifyName(name);

            if(!(checkStu && checkName)){
                System.out.println("User already alloted Hostel!!");
                name = typeName();
                continue;
            }
            String rNo = Integer.toString(regNo);
            try {
                out = new BufferedWriter(new FileWriter("hostel.txt", true));
                if(name !=""){
                    out.write(name + " " + rNo);
                    out.newLine();
                }
            }finally{
                if(out!=null){
                    out.close();
                }
            }
             name = typeName();
        }
       allotHostel();
    }
}