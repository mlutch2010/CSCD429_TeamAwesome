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
		String filename = "C://tester/newTrainingSet.txt";
		File file = new File(filename);
		Scanner fr = new Scanner(file);
		String[] record = new String[9];
		
		//while(fr.hasNext())
		for(int j = 0; j < 200000; j++)
		{
			fileLine = fr.nextLine();
			String stringRecord[] = fileLine.split("\t");
			for(int i = 0; i < stringRecord.length; i++)
			{
				
				record[i] = stringRecord[i];

			}
			Record rec = new Record(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8]);
			recList.add(rec);
		}

		return recList;
	}
	
	public static void extractRules(ArrayList<Record> records)
	{
		System.out.println("records size: " + records.size());
		int totalClicks;
		int userID;
		int ages[] = new int[6];
		int male, female, unknown;
		int agesMale[] = new int[6];
		int agesFemale[] = new int[6];
		int agesUnknown[] = new int[6];
		int agesTot[] = new int[6];
		int maleTot, femaleTot, unknownTot;
		int agesMaleTot[] = new int[6];
		int agesFemaleTot[] = new int[6];
		int agesUnknownTot[] = new int[6];
	
		
		totalClicks = countTotalClicks(records);
		System.out.println("total clicks: " + totalClicks);
		ages[0] = countAgesThatClicked(records,1);
		ages[1] = countAgesThatClicked(records,2);
		ages[2] = countAgesThatClicked(records,3);
		ages[3] = countAgesThatClicked(records,4);
		ages[4] = countAgesThatClicked(records,5);
		ages[5] = countAgesThatClicked(records,6);
		agesTot[0] = countAges(records, 1);
		agesTot[1] = countAges(records, 2);
		agesTot[2] = countAges(records, 3);
		agesTot[3] = countAges(records, 4);
		agesTot[4] = countAges(records, 5);
		agesTot[5] = countAges(records, 6);
		
		
		
		System.out.println("totalClicks is: " + totalClicks);
		System.out.println("Rule: If user is 0-12 then they click on ad.  Coverage: " + coverage(ages[0], totalClicks)  + " Accuracy: " + accuracy(ages[0], agesTot[0]));
		System.out.println("Rule: If user is 12-18 then they click on ad.  Coverage: " + coverage(ages[1], totalClicks)  + " Accuracy: " + accuracy(ages[1], agesTot[1]));
		System.out.println("Rule: If user is 18-24 then they click on ad.  Coverage: " + coverage(ages[2], totalClicks)  + " Accuracy: " + accuracy(ages[2], agesTot[2]));
		System.out.println("Rule: If user is 24-30 then they click on ad.  Coverage: " + coverage(ages[3], totalClicks)  + " Accuracy: " + accuracy(ages[3], agesTot[3]));
		System.out.println(ages[3] + " " + agesTot[3]);
		System.out.println("Rule: If user is 30-40 then they click on ad.  Coverage: " + coverage(ages[4], totalClicks)  + " Accuracy: " + accuracy(ages[4], agesTot[4]));
		System.out.println("Rule: If user is 40+ then they click on ad.  Coverage: " + coverage(ages[5],totalClicks)  + " Accuracy: " + accuracy(ages[5], agesTot[5]));
		
		male = countGendersThatClicked(records, 1);
		female = countGendersThatClicked(records, 2);
		unknown = countGendersThatClicked(records, 0);
		maleTot = countGenders(records, 1);
		femaleTot = countGenders(records, 2);
		unknownTot = countGenders(records, 0);
		System.out.println("Rule: If user is male then they clicked on ad. Coverage: " + coverage(male, totalClicks) + " Accuracy: " + accuracy(male, maleTot));
		System.out.println("Rule: If user is female then they clicked on ad. Coverage: " + coverage(female, totalClicks) + " Accuracy: " + accuracy(female, femaleTot));
		System.out.println("Rule: If user is uknown gender then they clicked on ad. Coverage: " + coverage(unknown, totalClicks) + " Accuracy: " + accuracy(unknown, unknownTot));
		
		agesMale[0] = countAgeGenderClicked(records, 1, 1);
		agesMale[1] = countAgeGenderClicked(records, 1, 2);
		agesMale[2] = countAgeGenderClicked(records, 1, 3);
		agesMale[3] = countAgeGenderClicked(records, 1, 4);
		agesMale[4] = countAgeGenderClicked(records, 1, 5);
		agesMale[5] = countAgeGenderClicked(records, 1, 6);
		agesMaleTot[0] = countAgeGender(records, 1, 1);
		agesMaleTot[1] = countAgeGender(records, 1, 2);
		agesMaleTot[2] = countAgeGender(records, 1, 3);
		agesMaleTot[3] = countAgeGender(records, 1, 4);
		agesMaleTot[4] = countAgeGender(records, 1, 5);
		agesMaleTot[5] = countAgeGender(records, 1, 6);
		System.out.println("Rule: If user is male and aged 0-12 then they click on ad. Coverage: " + coverage(agesMale[0], totalClicks) + " Accuracy: " + accuracy(agesMale[0], agesMaleTot[0]));
		System.out.println("Rule: If user is male and aged 12-18 then they click on ad. Coverage: " + coverage(agesMale[1], totalClicks) + " Accuracy: " + accuracy(agesMale[1], agesMaleTot[1]));
		System.out.println("Rule: If user is male and aged 18-24 then they click on ad. Coverage: " + coverage(agesMale[2], totalClicks) + " Accuracy: " + accuracy(agesMale[2], agesMaleTot[2]));
		System.out.println("Rule: If user is male and aged 24-30 then they click on ad. Coverage: " + coverage(agesMale[3], totalClicks) + " Accuracy: " + accuracy(agesMale[3], agesMaleTot[3]));
		System.out.println("Rule: If user is male and aged 30-40 then they click on ad. Coverage: " + coverage(agesMale[4], totalClicks) + " Accuracy: " + accuracy(agesMale[4], agesMaleTot[4]));
		System.out.println("Rule: If user is male and aged 40+ then they click on ad. Coverage: " + coverage(agesMale[5], totalClicks) + " Accuracy: " + accuracy(agesMale[5], agesMaleTot[5]));
		
		agesFemale[0] = countAgeGenderClicked(records, 2, 1);
		agesFemale[1] = countAgeGenderClicked(records, 2, 2);
		agesFemale[2] = countAgeGenderClicked(records, 2, 3);
		agesFemale[3] = countAgeGenderClicked(records, 2, 4);
		agesFemale[4] = countAgeGenderClicked(records, 2, 5);
		agesFemale[5] = countAgeGenderClicked(records, 2, 6);
		agesFemaleTot[0] = countAgeGender(records, 2, 1);
		agesFemaleTot[1] = countAgeGender(records, 2, 2);
		agesFemaleTot[2] = countAgeGender(records, 2, 3);
		agesFemaleTot[3] = countAgeGender(records, 2, 4);
		agesFemaleTot[4] = countAgeGender(records, 2, 5);
		agesFemaleTot[5] = countAgeGender(records, 2, 6);
		System.out.println("Rule: If user is female and aged 0-12 then they click on ad. Coverage: " + coverage(agesFemale[0], totalClicks) + " Accuracy: " + accuracy(agesFemale[0], agesFemaleTot[0]));
		System.out.println("Rule: If user is female and aged 12-18 then they click on ad. Coverage: " + coverage(agesFemale[1], totalClicks) + " Accuracy: " + accuracy(agesFemale[1], agesFemaleTot[1]));
		System.out.println("Rule: If user is female and aged 18-24 then they click on ad. Coverage: " + coverage(agesFemale[2], totalClicks) + " Accuracy: " + accuracy(agesFemale[2], agesFemaleTot[2]));
		System.out.println("Rule: If user is female and aged 24-30 then they click on ad. Coverage: " + coverage(agesFemale[3], totalClicks) + " Accuracy: " + accuracy(agesFemale[3], agesFemaleTot[3]));
		System.out.println("Rule: If user is female and aged 30-40 then they click on ad. Coverage: " + coverage(agesFemale[4], totalClicks) + " Accuracy: " + accuracy(agesFemale[4], agesFemaleTot[4]));
		System.out.println("Rule: If user is female and aged 40+ then they click on ad. Coverage: " + coverage(agesFemale[5], totalClicks) + " Accuracy: " + accuracy(agesFemale[5], agesFemaleTot[5]));
		
		
		agesUnknown[0] = countAgeGenderClicked(records, 0, 1);
		agesUnknown[1] = countAgeGenderClicked(records, 0, 2);
		agesUnknown[2] = countAgeGenderClicked(records, 0, 3);
		agesUnknown[3] = countAgeGenderClicked(records, 0, 4);
		agesUnknown[4] = countAgeGenderClicked(records, 0, 5);
		agesUnknown[5] = countAgeGenderClicked(records, 0, 6);
		agesUnknownTot[0] = countAgeGender(records, 0, 1);
		agesUnknownTot[1] = countAgeGender(records, 0, 2);
		agesUnknownTot[2] = countAgeGender(records, 0, 3);
		agesUnknownTot[3] = countAgeGender(records, 0, 4);
		agesUnknownTot[4] = countAgeGender(records, 0, 5);
		agesUnknownTot[5] = countAgeGender(records, 0, 6);
		System.out.println("Rule: If user gender is unknown and aged 0-12 then they click on ad. Coverage: " + coverage(agesUnknown[0], totalClicks) + " Accuracy: " + accuracy(agesUnknown[0], agesUnknownTot[0]));
		System.out.println("Rule: If user gender is unknown and aged 12-18 then they click on ad. Coverage: " + coverage(agesUnknown[1], totalClicks) + " Accuracy: " + accuracy(agesUnknown[1], agesUnknownTot[1]));
		System.out.println("Rule: If user gender is unknown and aged 18-24 then they click on ad. Coverage: " + coverage(agesUnknown[2], totalClicks) + " Accuracy: " + accuracy(agesUnknown[2], agesUnknownTot[2]));
		System.out.println("Rule: If user gender is unknown and aged 24-30 then they click on ad. Coverage: " + coverage(agesUnknown[3], totalClicks) + " Accuracy: " + accuracy(agesUnknown[3], agesUnknownTot[3]));
		System.out.println("Rule: If user gender is unknown and aged 30-40 then they click on ad. Coverage: " + coverage(agesUnknown[4], totalClicks) + " Accuracy: " + accuracy(agesUnknown[4], agesUnknownTot[4]));
		System.out.println("Rule: If user gender is unknown and aged 40+ then they click on ad. Coverage: " + coverage(agesUnknown[5], totalClicks) + " Accuracy: " + accuracy(agesUnknown[5], agesUnknownTot[5]));
	}
	
	public static int countTotalClicks(ArrayList<Record> records)
	{
		int numClicks = 0;
		for(int i = 0; i < records.size(); i++)
		{
			if(records.get(i).getClicks().equals("1"))
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
			if(records.get(i).getAge().equals(age) && records.get(i).getClicks().equals("1"))
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
			if(records.get(i).getGender().equals(gen) && records.get(i).getClicks().equals("1"))
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
		return numGenders;
	}
	
	
	
	public static int countAgeGenderClicked(ArrayList<Record> records, int gender, int ageRange)
	{
		int numAgeGenderClicked = 0;
		String gen = gender + "";
		String age = ageRange + "";
		for(int i = 0; i < records.size(); i++)
		{
			if(records.get(i).getGender().equals(gen) && records.get(i).getAge().equals(age) && records.get(i).getClicks().equals("1"))
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
		return numAgeGender;
	}
	
	public static double coverage(int numCaseRecords, int totalRecords)
	{
		double result = (double) numCaseRecords/totalRecords;
		//double result2 = Math.log10(result);
		//String coverage = numCaseRecords/totalRecords + "";
		//String coverage = result + "";
		return result;

		
	}
	
	public static double accuracy(int numCaseRecordsClicked, int numCaseRecords)
	{
		System.out.println(numCaseRecords + " " + numCaseRecordsClicked);
		double accuracy = (double) numCaseRecordsClicked/numCaseRecords;
		return accuracy;
	}
}



