/*
UserID_Profile:
Data:
1. UserID
2. Gender (1 = male, 2 = female, 0 = unknown)
3. Age (1 = (0,12], 2 = (12,18], 3 = (18,24], 4 = (24,30], 5 = (30,40], 6 = 40+)

*/

//if age (some range) and gender (some gender) then click

//accuracy: (# of cases covered by rule that results in click) / (# of cases covered by rule)
//coverage: (# of cases covered by rule) / (total # of cases)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class RuleTester 
{
	public static void main(String...args) throws FileNotFoundException
	{
		ArrayList<Record> records;
		records = readSampleFile();
		extractRules(records);
	}
	
	public static ArrayList<Record> readSampleFile() throws FileNotFoundException
	{
		String fileLine;
		ArrayList<Record> recList = new ArrayList<Record>();
		String filename = "C://tester/20ksamplefile.txt";
		File file = new File(filename);
		Scanner fr = new Scanner(file);
		String[] record = new String[4];
		
		while(fr.hasNext())
		{
			fileLine = fr.nextLine();
			String stringRecord[] = fileLine.split("\t");
			for(int i = 0; i < stringRecord.length; i++)
			{
				
				record[i] = stringRecord[i];

			}
			Record rec = new Record(record[0], record[1], record[2], record[3]);
			recList.add(rec);
		}

		return recList;
	}
	
	public static void extractRules(ArrayList<Record> records)
	{
		System.out.println("records size: " + records.size());
		int totalClicks;
		int userID;
		int ages1, ages2, ages3, ages4, ages5, ages6;
		int male, female, unknown;
		int age1Male, age2Male, age3Male, age4Male, age5Male, age6Male;
		int age1Female, age2Female, age3Female, age4Female, age5Female, age6Female;
		int age1Unknown, age2Unknown, age3Unknown, age4Unknown, age5Unknown, age6Unknown;
		int ages1Tot, ages2Tot, ages3Tot, ages4Tot, ages5Tot, ages6Tot;
		int maleTot, femaleTot, unknownTot;
		int age1MaleTot, age2MaleTot, age3MaleTot, age4MaleTot, age5MaleTot, age6MaleTot;
		int age1FemaleTot, age2FemaleTot, age3FemaleTot, age4FemaleTot, age5FemaleTot, age6FemaleTot;
		int age1UnknownTot, age2UnknownTot, age3UnknownTot, age4UnknownTot, age5UnknownTot, age6UnknownTot;
		
		totalClicks = countTotalClicks(records);
		System.out.println("total clicks: " + totalClicks);
		ages1 = countAgesThatClicked(records,1);
		ages2 = countAgesThatClicked(records,2);
		ages3 = countAgesThatClicked(records,3);
		ages4 = countAgesThatClicked(records,4);
		ages5 = countAgesThatClicked(records,5);
		ages6 = countAgesThatClicked(records,6);
		ages1Tot = countAges(records, 1);
		ages2Tot = countAges(records, 2);
		ages3Tot = countAges(records, 3);
		ages4Tot = countAges(records, 4);
		ages5Tot = countAges(records, 5);
		ages6Tot = countAges(records, 6);
		System.out.println(ages1 + " " + totalClicks + " " + ages1Tot);
		System.out.println("Rule: If user is 0-12 then they click on ad.  Coverage: " + coverage(ages1, totalClicks)  + " Accuracy: " + accuracy(ages1, ages1Tot));
		System.out.println("Rule: If user is 12-18 then they click on ad.  Coverage: " + coverage(ages2, totalClicks)  + " Accuracy: " + accuracy(ages2, ages2Tot));
		System.out.println("Rule: If user is 18-24 then they click on ad.  Coverage: " + coverage(ages3, totalClicks)  + " Accuracy: " + accuracy(ages3, ages3Tot));
		System.out.println("Rule: If user is 24-30 then they click on ad.  Coverage: " + coverage(ages4, totalClicks)  + " Accuracy: " + accuracy(ages4, ages4Tot));
		System.out.println(ages4 + " " + ages4Tot);
		System.out.println("Rule: If user is 30-40 then they click on ad.  Coverage: " + coverage(ages5, totalClicks)  + " Accuracy: " + accuracy(ages5, ages5Tot));
		System.out.println("Rule: If user is 40+ then they click on ad.  Coverage: " + coverage(ages6,totalClicks)  + " Accuracy: " + accuracy(ages6, ages6Tot));
		
		male = countGendersThatClicked(records, 1);
		female = countGendersThatClicked(records, 2);
		unknown = countGendersThatClicked(records, 3);
		maleTot = countGenders(records, 1);
		femaleTot = countGenders(records, 2);
		unknownTot = countGenders(records, 3);
		System.out.println("Rule: If user is male then they clicked on ad. Coverage: " + coverage(male, totalClicks) + " Accuracy: " + accuracy(male, maleTot));
		System.out.println("Rule: If user is female then they clicked on ad. Coverage: " + coverage(female, totalClicks) + " Accuracy: " + accuracy(female, femaleTot));
		System.out.println("Rule: If user is uknown gender then they clicked on ad. Coverage: " + coverage(unknown, totalClicks) + " Accuracy: " + accuracy(unknown, unknownTot));
		
		age1Male = countAgeGenderClicked(records, 1, 1);
		age2Male = countAgeGenderClicked(records, 1, 2);
		age3Male = countAgeGenderClicked(records, 1, 3);
		age4Male = countAgeGenderClicked(records, 1, 4);
		age5Male = countAgeGenderClicked(records, 1, 5);
		age6Male = countAgeGenderClicked(records, 1, 6);
		age1MaleTot = countAgeGender(records, 1, 1);
		age2MaleTot = countAgeGender(records, 1, 2);
		age3MaleTot = countAgeGender(records, 1, 3);
		age4MaleTot = countAgeGender(records, 1, 4);
		age5MaleTot = countAgeGender(records, 1, 5);
		age6MaleTot = countAgeGender(records, 1, 6);
		System.out.println("Rule: If user is male and aged 0-12 then they click on ad. Coverage: " + coverage(age1Male, totalClicks) + " Accuracy: " + accuracy(age1Male, age1MaleTot));
		System.out.println("Rule: If user is male and aged 12-18 then they click on ad. Coverage: " + coverage(age2Male, totalClicks) + " Accuracy: " + accuracy(age2Male, age2MaleTot));
		System.out.println("Rule: If user is male and aged 18-24 then they click on ad. Coverage: " + coverage(age3Male, totalClicks) + " Accuracy: " + accuracy(age3Male, age3MaleTot));
		System.out.println("Rule: If user is male and aged 24-30 then they click on ad. Coverage: " + coverage(age4Male, totalClicks) + " Accuracy: " + accuracy(age4Male, age4MaleTot));
		System.out.println("Rule: If user is male and aged 30-40 then they click on ad. Coverage: " + coverage(age5Male, totalClicks) + " Accuracy: " + accuracy(age5Male, age5MaleTot));
		System.out.println("Rule: If user is male and aged 40+ then they click on ad. Coverage: " + coverage(age6Male, totalClicks) + " Accuracy: " + accuracy(age6Male, age6MaleTot));
		
		age1Female = countAgeGenderClicked(records, 2, 1);
		age2Female = countAgeGenderClicked(records, 2, 2);
		age3Female = countAgeGenderClicked(records, 2, 3);
		age4Female = countAgeGenderClicked(records, 2, 4);
		age5Female = countAgeGenderClicked(records, 2, 5);
		age6Female = countAgeGenderClicked(records, 2, 6);
		age1FemaleTot = countAgeGender(records, 2, 1);
		age2FemaleTot = countAgeGender(records, 2, 2);
		age3FemaleTot = countAgeGender(records, 2, 3);
		age4FemaleTot = countAgeGender(records, 2, 4);
		age5FemaleTot = countAgeGender(records, 2, 5);
		age6FemaleTot = countAgeGender(records, 2, 6);
		System.out.println("Rule: If user is female and aged 0-12 then they click on ad. Coverage: " + coverage(age1Female, totalClicks) + " Accuracy: " + accuracy(age1Female, age1FemaleTot));
		System.out.println("Rule: If user is female and aged 12-18 then they click on ad. Coverage: " + coverage(age2Female, totalClicks) + " Accuracy: " + accuracy(age2Female, age2FemaleTot));
		System.out.println("Rule: If user is female and aged 18-24 then they click on ad. Coverage: " + coverage(age3Female, totalClicks) + " Accuracy: " + accuracy(age3Female, age3FemaleTot));
		System.out.println("Rule: If user is female and aged 24-30 then they click on ad. Coverage: " + coverage(age4Female, totalClicks) + " Accuracy: " + accuracy(age4Female, age4FemaleTot));
		System.out.println("Rule: If user is female and aged 30-40 then they click on ad. Coverage: " + coverage(age5Female, totalClicks) + " Accuracy: " + accuracy(age5Female, age5FemaleTot));
		System.out.println("Rule: If user is female and aged 40+ then they click on ad. Coverage: " + coverage(age6Female, totalClicks) + " Accuracy: " + accuracy(age6Female, age6FemaleTot));
		
		
		age1Unknown = countAgeGenderClicked(records, 3, 1);
		age2Unknown = countAgeGenderClicked(records, 3, 2);
		age3Unknown = countAgeGenderClicked(records, 3, 3);
		age4Unknown = countAgeGenderClicked(records, 3, 4);
		age5Unknown = countAgeGenderClicked(records, 3, 5);
		age6Unknown = countAgeGenderClicked(records, 3, 6);
		age1UnknownTot = countAgeGender(records, 3, 1);
		age2UnknownTot = countAgeGender(records, 3, 2);
		age3UnknownTot = countAgeGender(records, 3, 3);
		age4UnknownTot = countAgeGender(records, 3, 4);
		age5UnknownTot = countAgeGender(records, 3, 5);
		age6UnknownTot = countAgeGender(records, 3, 6);
		System.out.println("Rule: If user gender is uknown and aged 0-12 then they click on ad. Coverage: " + coverage(age1Unknown, totalClicks) + " Accuracy: " + accuracy(age1Unknown, age1UnknownTot));
		System.out.println("Rule: If user gender is uknown and aged 12-18 then they click on ad. Coverage: " + coverage(age2Unknown, totalClicks) + " Accuracy: " + accuracy(age2Unknown, age2UnknownTot));
		System.out.println("Rule: If user gender is uknown and aged 18-24 then they click on ad. Coverage: " + coverage(age3Unknown, totalClicks) + " Accuracy: " + accuracy(age3Unknown, age3UnknownTot));
		System.out.println("Rule: If user gender is uknown and aged 24-30 then they click on ad. Coverage: " + coverage(age4Unknown, totalClicks) + " Accuracy: " + accuracy(age4Unknown, age4UnknownTot));
		System.out.println("Rule: If user gender is uknown and aged 30-40 then they click on ad. Coverage: " + coverage(age5Unknown, totalClicks) + " Accuracy: " + accuracy(age5Unknown, age5UnknownTot));
		System.out.println("Rule: If user gender is uknown and aged 40+ then they click on ad. Coverage: " + coverage(age6Unknown, totalClicks) + " Accuracy: " + accuracy(age6Unknown, age6UnknownTot));
	}
	
	public static int countTotalClicks(ArrayList<Record> records)
	{
		int numClicks = 0;
		for(int i = 0; i < records.size(); i++)
		{
			if(records.get(i).getClick().equals("1"))
			{
				numClicks++;
			}
		}
		return numClicks;
	}
	
	public static int countAgesThatClicked(ArrayList<Record> records, int ageRange)
	{
		int numAgesClicked = 0;
		String age = ageRange + "";
		for(int i = 0; i < records.size(); i++)
		{
			if(records.get(i).getAge().equals(age) && records.get(i).getClick().equals("1"))
			{
				numAgesClicked++;
			}
		}
		return numAgesClicked;
	}
	
	public static int countAges(ArrayList<Record> records, int ageRange)
	{
		int numAges = 0;
		String age = ageRange + "";
		for(int i = 0; i < records.size(); i++)
		{
			if(records.get(i).getAge().equals(age))
			{
				numAges++;
			}
		}
		return numAges;
	}
	
	public static int countGendersThatClicked(ArrayList<Record> records, int gender)
	{
		int numGenders = 0;
		String gen = gender + "";
		for(int i = 0; i < records.size(); i++)
		{
			if(records.get(i).getGender().equals(gen) && records.get(i).getClick().equals(1))
			{
				numGenders++;
			}
		}
		return numGenders;
	}
	
	public static int countGenders(ArrayList<Record> records, int gender)
	{
		int numGenders = 0;
		String gen = gender + "";
		for(int i = 0; i < records.size(); i++)
		{
			if(records.get(i).getGender().equals(gen))
			{
				numGenders++;
			}
			
		}
		if(numGenders == 0)
		{
			return 1;
		}
		return numGenders;
	}
	
	
	
	public static int countAgeGenderClicked(ArrayList<Record> records, int gender, int ageRange)
	{
		int numAgeGenderClicked = 0;
		String gen = gender + "";
		String age = ageRange + "";
		for(int i = 0; i < records.size(); i++)
		{
			if(records.get(i).getGender().equals(gen) && records.get(i).getAge().equals(age) && records.get(i).getClick().equals(1))
			{
				numAgeGenderClicked++;
			}
		}
		return numAgeGenderClicked;
	}
	
	public static int countAgeGender(ArrayList<Record> records, int gender, int ageRange)
	{
		int numAgeGender = 0;
		String gen = gender + "";
		String age = ageRange + "";
		for(int i = 0; i < records.size(); i++)
		{
			if(records.get(i).getGender().equals(gen) && records.get(i).getAge().equals(age))
			{
				numAgeGender++;
			}
		}
		if(numAgeGender == 0)
		{
			return 1;
		}
		return numAgeGender;
	}
	
	public static String coverage(int numCaseRecords, int totalRecords)
	{
		String coverage = numCaseRecords/totalRecords + "";
		return coverage;

		
	}
	
	public static String accuracy(int numCaseRecordsClicked, int numCaseRecords)
	{
		System.out.println(numCaseRecords + " " + numCaseRecordsClicked);
		String accuracy = numCaseRecordsClicked/numCaseRecords + "";
		return accuracy;
	}
}



