import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class DiagnosticCenter 
{
	static ArrayList<AddCenter> arl=new ArrayList<AddCenter>();
	static String joindate;
	public static void centerDetails() throws IOException
	{
		char l='i';
		Calendar currentDate=Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
		joindate = formatter.format(currentDate.getTime());
		
		AddCenter a1 = new AddCenter(1,"Path Lab", "Delhi", "8847936592",joindate);
		arl.add(a1);
		AddCenter a2 = new AddCenter(2,"Dr. Lal path Lab", "Hyderabad", "5763454782",joindate);
		arl.add(a2);
		AddCenter p3 = new AddCenter(3,"Apex Diagnostic", "Agra", "2345216745",joindate);
		arl.add(p3);
		do {
			AddCenter a=new AddCenter();
			System.out.println("Enter 1 to add center details \nEnter 2 to show details \nEnter 3 to remove details");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			case 1:
				a.addDetails();
				System.out.println("center added successfully");
				break;
			case 2:
				a.showDetails();
				break;
			case 3:
				a.showDetails();
				a.removeDetails();
				break;
			default:
				System.out.println("Try again");
				break;
			}
			System.out.println("Do you want to continue selecting options (y/n):");
			l=(char)br.read();
		}while(l=='y');
	}
}
class AddCenter
{
	int id;
	String name;
	String address;
	String contact;
	String joindate;
	DiagnosticCenter dc=new DiagnosticCenter();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private String date;
	
	public AddCenter(int id, String name, String address, String contact,String joindate) {
		// TODO Auto-generated constructor stub
		this.id=id;
		this.name=name;
		this.address=address;
		this.contact=contact;
		this.joindate=joindate;
	}
	public AddCenter() {
		// TODO Auto-generated constructor stub
	}
	public void addDetails() throws IOException
	{
		AddCenter ad1=new AddCenter();
		int id=dc.arl.size();
		ad1.id=id+1;		
		System.out.println("Enter center name:");
		ad1.name = br.readLine();
		System.out.println("Enter center Address:");
		ad1.address = br.readLine();
		System.out.println("Enter center number:");
		ad1.contact = br.readLine();
		System.out.println("Enter the date");
		ad1.joindate = br.readLine();
		if(ad1.contact.length()>10)
		{
			System.out.println("contact number should be less than 10");
		}
		dc.arl.add(ad1);
	}
	public void showDetails() {
		// TODO Auto-generated method stub
		System.out.println("Center-ID \t Center-Name \t Address \t\t Contact \t date");
		 
		for(int i=0; i<dc.arl.size(); i++)
		{
		 
		System.out.println(dc.arl.get(i).id + " \t\t "+dc.arl.get(i).name+" \t\t "+dc.arl.get(i).address+" \t "+dc.arl.get(i).contact+" \t "+dc.arl.get(i).joindate);
		}
		
	}
	public void removeDetails() throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Center ID to be deleted:");
		int id2 = Integer.parseInt(br.readLine());
		for(int i=0;i<dc.arl.size();i++)
		{
			if(id2 == dc.arl.get(i).id)
			{
				dc.arl.remove(i);
				System.out.println("center deleted successfully ");
			}
			
		}
		
	}
		
	}