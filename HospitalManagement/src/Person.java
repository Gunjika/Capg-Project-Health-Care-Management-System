import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;

public class Person 
{
	static ArrayList<Customerr> arl=new ArrayList<Customerr>();
	static String joindate;
	public static void main(String[] args) throws IOException,NumberFormatException
	{
		char l='i';
		Calendar currentDate=Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
		joindate = formatter.format(currentDate.getTime());
		
	
		Customerr p1 = new Customerr(1,"Raja", "Miyapur,Hyderabad", 40, 'm', "Fever", 250f, joindate,"12345");
		arl.add(p1);
		Customerr p2 = new Customerr(2,"Rani", "Madhapur,Hyderabad", 45, 'f', "Cough", 250f, joindate,"23456");
		arl.add(p2);
		Customerr p3 = new Customerr(3,"James", "Hydernagar,Hyderabad", 56, 'm', "Cancer", 250f, joindate, "74564");
		arl.add(p3);
		do
		{
			Customerr Customer=new Customerr();
			Adminn adminObj=new Adminn();
			System.out.println("Enter the person role \n1.Customer \n2.Admin");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			case 1:
				System.out.println("Customer");
				System.out.println("Enter 1 to register \nEnter 2 to login to make appointment");
				int ch=Integer.parseInt(br.readLine());
				switch(ch)
				{
				case 1:
					Customer.register();
					System.out.println("register successfully");
					Customer.showPatientDetails();
					break;
				case 2:
					System.out.println("enter name and password");
					Customer.login();
					System.out.println("Choose Center for appointment");
					try
					{
						Appointment.confirmAppointment();
						
					}
					catch (Exception e) {
						System.out.println(e.getMessage());
					}			
					break;
					
				default:
					Customer.login();
					break;
				}
				break;
			case 2:
				System.out.println("Admin");
				System.out.println("Enter 1 to login with center details \nEnter 2 to login with test details");
				int ch1=Integer.parseInt(br.readLine());
				switch(ch1)
				{
				case 1:
					System.out.println("enter name and password");
					boolean result=adminObj.Login();
					if(result==true)
					{
						try
						{
							DiagnosticCenter.centerDetails();
						}
						catch (Exception e) 
						{
							System.out.println(e.getMessage());
						}
					}
					else
					{
						adminObj.Login();
						
					}
					
				case 2:
					System.out.println("enter name and password");
					boolean resut=adminObj.Login();
					if(resut==true)
					{
						System.out.println("Choose Center");
						try
						{
							Test.testDetails();
						}
						catch (Exception e) {
							System.out.println(e.getMessage());
						}
					}
					else
					{
						adminObj.Login();
						
					}
					
				default:
					System.out.println("Try again");
					break;
				}	
			default:
				//System.out.println("Patient does not exist with the entered ID");
				System.out.println("Try again");
				break;
			}
			System.out.println("Do you want to continue selecting options (y/n):");
			l=(char)br.read();
		}while(l=='y');
	}
}
class Customerr  {
	int patientID;
	String patientName;
	String patientAddress;
	int age;
	char patientSex;
	String patientIllness;
	float amountForAppointment;
	String joindate;
	String pass;
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public Customerr(int patientID, String patientName, String patientAddress, int age, char patientSex, String patientIllness,float amountForAppointment, String joindate,String pass) {
		// TODO Auto-generated constructor stub
		this.patientID=patientID;
		this.patientName=patientName;
		this.patientAddress=patientAddress;
		this.age=age;
		this.patientSex=patientSex;
		this.patientIllness=patientIllness;
		this.amountForAppointment=amountForAppointment;
		this.joindate = joindate;
		this.pass=pass;
	}
	
	public Customerr() {
		// TODO Auto-generated constructor stub
	}

	Person p=new Person();
	public void register() throws IOException
	{
		int flag=0;
		Customerr pr=new Customerr();
		@SuppressWarnings("static-access")
		int patientID= p.arl.size();
		pr.patientID = patientID+1;
		
		System.out.println("Enter Patient name:");
		boolean f=true;
		re:while(f)
		{
			pr.patientName = br.readLine();
			if(pr.patientName.matches("^[a-zA-Z]*$"))
			{
				
				f=false;
				continue re;
			}
			else
			{
				f=true;
				System.out.println("not a valid name");
				System.out.println("Enter Patient name:");
				continue re;
			}
			
		}
		
		System.out.println("Enter Patient address:");
		boolean isNotValid=true; 
		restart: while(isNotValid)
		{

			pr.patientAddress = br.readLine();
			
			if(pr.patientAddress.matches("^[a-zA-Z]*$"))
			{
				isNotValid=false;
				continue restart;
			}
			else
			{
				isNotValid=true;
				System.out.println("not a valid address");
				System.out.println("Enter Patient address:");
				continue restart;
			}	
		}

		System.out.println("Enter Patient Age:");
		boolean isAge=true;
		sett:while(isAge)
		{
			pr.age = Integer.parseInt(br.readLine());
			if(pr.age==0)
			{
				System.out.println("Age should not be zero:");
				System.out.println("Enter Patient Age:");
				isAge=true;
				continue sett;
				
				
			}
			else
			{
				isAge=false;
				continue sett;
			}
		}
		
		
		System.out.println("Enter Patient Sex:");
		boolean isNot=true; 
		res: while(isNot)
		{
			String temp = br.readLine();
			if(temp.equals("female")||temp.equals("male"))
			{
				pr.patientSex =temp.charAt(0);
				isNot=false;
				continue res;
			}
			else
			{
				isNot=true;
				System.out.println("please enter male/female");
				System.out.println("Enter Patient Sex:");
				continue res;
			}
		}
		
		System.out.println("Enter Patient Illness:");
		boolean isNotIll=true;
		step:while(isNotIll)
		{
			pr.patientIllness = br.readLine();
			if(pr.patientIllness.length()<20)
			{
				
				isNotIll=false;
				continue step;
			}
			else
			{
				isNotIll=true;
				continue step;
			}
		}
		
		System.out.println("Enter the amount patient needs to pay for appointment:");
		boolean isNotpay=true;
		r1:while(isNotpay)
		{
			pr.amountForAppointment = Float.parseFloat(br.readLine());
			if(pr.amountForAppointment>100)
			{
			
			isNotpay=false;
			continue r1;
			}
			else
			{
				isNotpay=true;
				System.out.println("Enter the amount greater than 100");
				System.out.println("Enter the amount patient needs to pay for appointment:");
				continue r1;
			}
		}
		
		pr.joindate = p.joindate;
		System.out.println("Enter password:");
		boolean pa=true;
		tep:while(pa)
		{
			pr.pass = br.readLine();
			if(pr.pass.length()<=8)
			{
				pa=false;
				continue tep;
			}
			else
			{
				pa=true;
				System.out.println("Enter the pass length 8 or less than 8");
				System.out.println("Enter password:");
				continue tep;
			}
		}
		
		p.arl.add(pr);		
	}

	public void login() throws IOException 
	{
		Boolean isLoggedIn=false;
		Customerr pr=new Customerr();
		System.out.println("Enter name:");
		String patient_name = br.readLine();
		System.out.println("Enter password:");
		String password = br.readLine();
		for (int i = 0; i <Person.arl.size(); i++) 
		{
			if(Person.arl.get(i).patientName.equalsIgnoreCase(patient_name) && Person.arl.get(i).pass.equalsIgnoreCase(password))
			{
				isLoggedIn=true;
				
				break;
			}
			
		}
		if(isLoggedIn==true)
		{
			System.out.println("login Successfully");
		}
		else
		{
			System.out.println("wrong id or password");
		}
		
		// TODO Auto-generated method stub
		
	}
	public void showPatientDetails() {
		// TODO Auto-generated method stub
		System.out.println("patient-ID \t Patient-Name \t Address \t\t Age \t Sex \t Illness \t Fees \t Join-date");
		 
		for(int i=0; i<p.arl.size(); i++)
		{
		 
		System.out.println(p.arl.get(i).patientID + " \t\t "+p.arl.get(i).patientName+" \t\t "+p.arl.get(i).patientAddress+" \t "+p.arl.get(i).age+" \t "+p.arl.get(i).patientSex+" \t "+p.arl.get(i).patientIllness+" \t\t "+p.arl.get(i).amountForAppointment+" \t "+p.arl.get(i).joindate);
		}
		
	}
}
class Adminn
{
	String patientName;
	String pass;
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public Adminn(String patientName,String pass)
	{
		this.patientName=patientName;
		this.pass=pass;
	}
	public Adminn() {
		// TODO Auto-generated constructor stub
	}
	public boolean Login() throws IOException{
		Adminn ur=new Adminn();
		Boolean isLoggedIn=false;
		Customerr pr=new Customerr();
		System.out.println("Enter Admin name:");
		String patient_name = br.readLine();
		System.out.println("Enter password:");
		String password = br.readLine();
		if(patient_name.equalsIgnoreCase("gunjika")&&password.equalsIgnoreCase("123456"))
		{
			System.out.println("login successfully");
			return true;
		}
		else
		{
			System.out.println("wrong name and password");
			return false;
		}
		
	}
}
