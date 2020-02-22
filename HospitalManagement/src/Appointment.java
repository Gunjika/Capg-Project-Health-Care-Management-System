import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Appointment{


	static void confirmAppointment() throws Exception
	{
		char l='i';

		Map<Integer,String> center=new HashMap<Integer,String>();
		center.put(1,"path lab");
		center.put(2, "Dr. Lal path Lab");
		center.put(3, "Apex Diagnostic");


		LinkedHashMap<String,Integer> AD= new LinkedHashMap<String,Integer>();
		AD.put("blood test",1);
		AD.put("x-ray",1);
		AD.put("ultrasound",1);

		LinkedHashMap<String,Integer> LP= new LinkedHashMap<String,Integer>();
		LP.put("blood test",2);
		LP.put("2D-Echo Test",2);
		LP.put("MRI Scan",2);

		LinkedHashMap<String,Integer> SH= new LinkedHashMap<String,Integer>();
		SH.put("blood test",3);
		SH.put("x-ray",3);
		SH.put("ultrasound",3);


		Set<Entry<Integer, String>> st = center.entrySet();
		for (Entry<Integer, String> me:st) 
		{
			System.out.print(me.getKey()+": "); 
			System.out.println(me.getValue());
		}

		do {
			System.out.println("Select center: ");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the center id");
			int numId=sc.nextInt();

			switch(numId)
			{
			case 1:
				Set<Entry<String,Integer>> First=AD.entrySet();
				for(Entry<String,Integer> me1:First)
				{
					if(me1.getValue()==1)
					{
					
						System.out.println(me1.getKey());
					}
				}
				break;
			case 2:
				Set<Entry<String,Integer>> Second=LP.entrySet();
				for(Entry<String,Integer> me1:Second)
				{
					if(me1.getValue()==2)
					{
						
						System.out.println(me1.getKey());
					}
				}
				break;
			case 3:
				Set<Entry<String,Integer>> Third=SH.entrySet();
				for(Entry<String,Integer> me1:Third)
				{
					if(me1.getValue()==3)
					{
					
						System.out.println(me1.getKey());
					}
				}
				break;

			default:
				System.out.println("Wrong Id");
				break;	
			}

			System.out.println("select test:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String test_name=br.readLine();
			
			
			Set<Entry<String,Integer>> testList=AD.entrySet();
			for(Entry<String,Integer> list:testList)
			{
				if(list.getKey().toString().equalsIgnoreCase(test_name))
				{
					//System.out.print((me1.getValue()+ "->"));
					System.out.println("you are selected for "+test_name);
					Scanner scanner = new Scanner(System.in);
					System.out.println("Enter the Date ");
					
					Scanner kb =new Scanner(System.in);
					System.out.println("Please enter a date (mm/dd/yyyy)");
					String uDate = kb.nextLine();
					String userdate=uDate;
					int length = uDate.length();
					if(length !=10)
					{
						System.out.println(uDate+"is a not valid date");
						
					}
					else
					{
						System.out.println("you are appointed for :"+" "+test_name+" on Date:"+userdate);
					}
					break;
				}
				else
				{
					System.out.println("this test is not valid");
					break;
				}
			}

			System.out.println("Do you want to continue selecting options (y/n):");
			l=(char)br.read();
		}
		while(l=='y');

	}

}