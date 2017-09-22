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
			displayRoster();
			}
		chooseStudent();
		}

	private static void importRoster() throws IOException
		{
		System.out.println("Which class is presenting?");
		System.out.println("(1) AP  (2) Java");
		Scanner userInput = new Scanner (System.in);
		int period = userInput.nextInt();
		if (period == 1)
			{
			file = new Scanner(new File("AP_2017-18.txt"));
			}
		else if (period == 2)
			{
			file = new Scanner(new File("Java_2017-18_tri1.txt"));
			}
		else
			{
			System.out.println("Sorry, but you must choose either (1) or (2)");
			takeVolunteer();
			}
		while (file.hasNext())
			{
			studentRoster.add(file.nextLine());
			}
		displayRoster();
		}
	
	private static void displayRoster()
		{
		for(int i = 0; i < studentRoster.size(); i++)
			{
			System.out.println((i + 1) + ")  " + studentRoster.get(i));
			}
		}

	private static void takeVolunteer()
		{	
		System.out.println();
		System.out.println("Select the volunteer or type \"0\" to choose a random student.");
		Scanner userInput = new Scanner (System.in);
		int volunteer = userInput.nextInt();
		if (volunteer != 0)
			{
			System.out.println("Let's look at the code of " + 
					studentRoster.get(volunteer - 1) + ".");
			System.out.println();
			studentRoster.remove(volunteer - 1);	
			}
		else
			{
			chooseStudent();
			}
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
		System.out.println("That's everyone - thank you!");
		System.exit(0);
		}
	}
