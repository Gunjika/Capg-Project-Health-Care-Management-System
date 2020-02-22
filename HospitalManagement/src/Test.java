import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test {
	static ArrayList<TestDetails> testdt=new ArrayList<TestDetails>();
	static String joindate;
	public static void testDetails() throws IOException{
		char l='i';
		
		TestDetails t1=new TestDetails(1,"Blood test");
		testdt.add(t1);
		TestDetails t2=new TestDetails(2,"x-ray");
		testdt.add(t2);
		TestDetails t3=new TestDetails(3,"diabtese");
		testdt.add(t3);
		
		do {
			TestDetails td=new TestDetails();
			System.out.println("Enter 1 to add test details \nEnter 2 to remove details");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int choice = Integer.parseInt(br.readLine());
			
			switch(choice)
			{
			case 1:
				td.addTestDetails();
				td.showTestDetails();
				break;
			case 2:
				td.showTestDetails();
				td.removeTestDetails();
				td.showTestDetails();
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
class AddTest{
	int id;
	String name;
	String address;
	String contact;
	Test test=new Test();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public AddTest(int id, String name, String address, String contact) {
		this.id=id;
		this.name=name;
		this.address=address;
		this.contact=contact;
		// TODO Auto-generated constructor stub
	}

	public AddTest() {
		// TODO Auto-generated constructor stub
	}
}
 class TestDetails
{
	int id;
	String testName;
	Test test=new Test();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public TestDetails(int id, String testName) {
		this.id=id;
		this.testName=testName;
		// TODO Auto-generated constructor stub
	}
	public void removeTestDetails() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter test ID:");
		int id1 = Integer.parseInt(br.readLine());
		System.out.println("test "+id1+" selected"); 
		for(int i=0; i<test.testdt.size(); i++)
		{
			if(id1 == test.testdt.get(i).id)
			{
				test.testdt.remove(i);
				System.out.println("test deleted successfully ");
			}
		}
		
	}
	public TestDetails() {
		// TODO Auto-generated constructor stub
	}
	public void addTestDetails() throws IOException
	{	
		TestDetails td1=new TestDetails();
		int id=Test.testdt.size();
		td1.id=id+1;		
		System.out.println("Enter test name:");
		td1.testName = br.readLine();
		if(td1.testName.matches("^[a-zA-Z]*$") && td1.testName.length()<8) 
		{
		test.testdt.add(td1);
		System.out.println("test added successfully");
		}
		else
		{
			System.out.println("Try Again \nPlease enter only alphabets \n or Test name must be less than 8 characters");
		}
	}
	public void showTestDetails() {
		// TODO Auto-generated method stub
		System.out.println("Test-ID \t test-Name");
		 
		for(int i=0; i<Test.testdt.size(); i++)
		{
		 
		System.out.println(Test.testdt.get(i).id + " \t\t "+Test.testdt.get(i).testName);
		}
		
	// TODO Auto-generated method stub
	}
	
}
