import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentChooser
	{
	static Scanner file;
	static ArrayList <String> studentRoster = new ArrayList <String>();

	public static void main(String[] args) throws IOException
		{
		importRoster();
		boolean areVolunteering = true;
		while(areVolunteering)
			{
			takeVolunteer();
			}
		chooseStudent();
		}

	private static void importRoster() throws IOException
		{
		System.out.println("Please choose the class.");
		System.out.println("(1) AP  (2) Java");
		Scanner userInput = new Scanner (System.in);
		int edition = userInput.nextInt();
		if (edition == 1)
			{
			file = new Scanner(new File("AP_2017-18.txt"));
			}
		else if (edition == 2)
			{
			file = new Scanner(new File("Java_2017-18_tri1.txt"));
			}
		else
			{
			System.out.println("Sorry, but you must choose either (1) or (2)");
			takeVolunteer();
			}
		
		}

	private static void takeVolunteer()
		{	
		System.out.println("Select the student volunteer.");
		Scanner userInput = new Scanner (System.in);
		int volunteer = userInput.nextInt();
		System.out.println("Let's look at the code of " + 
				studentRoster.get(volunteer - 1) + ".");
		studentRoster.remove(volunteer - 1);
		}

	private static void chooseStudent()
		{
		while (studentRoster.size() > 0)
			{
			int randomNumber = (int) (Math.random() * studentRoster.size());
			System.out.println("Let's look at the code of " + 
					studentRoster.get(randomNumber) + ".");
			studentRoster.remove(randomNumber);
			Scanner fake = new Scanner(System.in);
			String fakeVariable = fake.nextLine(); 
			}
		}
	}
