
/*
 * 
 Random Sample File:
Data:

1. Click (0 = no, 1 = yes)
2. Impression 
3. DisplayURL
4. AdID
5. AdvertiserID
6. Depth (# of impressions per session)
7. Position
8. QueryID
9. KeywordID
10. TitleID
11. DescriptionID
12. UserID


UserID_Profile:
Data:
1. UserID
2. Gender (1 = male, 2 = female, 0 = unknown)
3. Age (1 = (0,12], 2 = (12,18], 3 = (18,24], 4 = (24,30], 5 = (30,40], 6 = 40+)

*/
import java.util.*;
import java.io.*;

public class Tester 
{
	public static void main(String ... args) throws FileNotFoundException 
	{
		ArrayList<LargeRecord> largeRecList = readSampleFile();
		ArrayList<Record> recList = readUserFile(largeRecList);
		writeArrayToFile(recList);
	}
	
	public static  ArrayList<LargeRecord> readSampleFile() throws FileNotFoundException
	{
		String filename = "C://tester/randomSample.txt";
		File sampleFile  = new File(filename);
		Scanner input = new Scanner(sampleFile);
		String fileLine;
		String[] record = new String[12];
		ArrayList<LargeRecord> largeRecList = new ArrayList<LargeRecord>();
		
		while(input.hasNextLine())
		{
			fileLine = input.nextLine();
			String stringRecord[] = fileLine.split("\t");
			for(int i = 0; i < stringRecord.length; i++)
			{
				/*if(i % 100 == 0)
				{
					System.out.println("Reading line " + i + " of Large Record File");
				}*/
				record[i] = stringRecord[i];
				//System.out.println(record[i].toString());
			}
			LargeRecord lRec = new LargeRecord(record[0], record[1], record[2], record[3], record[4], record[5], record[6], record[7], record[8], record[9], record[10], record[11]);
			largeRecList.add(lRec);
		}
		System.out.println("List size is: " + largeRecList.size());
		return largeRecList;
	}
	
	
	//read user file, pull all records with same userID as in largeRecList
	public static ArrayList<Record> readUserFile(ArrayList<LargeRecord> largeRecList) throws FileNotFoundException
	{
		ArrayList<Record> completeRecord = new ArrayList<Record>();
		String filename = "C://tester/userid_profile.txt";
		File userFile = new File(filename);
		Scanner input = new Scanner(userFile);
		String fileLine;
		//small record;
		String record[] = new String[3];
		ArrayList<SmallRecord>smallRecList = new ArrayList<SmallRecord>();
		
			int i = 0;
			while(input.hasNextLine() && i < 20000)
			{
				fileLine = input.nextLine();
				String stringRecord[] = fileLine.split("\t");
				for(int j = 0; j < stringRecord.length; j++)
				{
					record[j] = stringRecord[j];
				}
				SmallRecord sRec = new SmallRecord(record[0], record[1], record[2]);
				smallRecList.add(sRec);
				if(smallRecList.size() % 1000000 == 0)
				{
					System.out.println("On line " + smallRecList.size() + " of User_profile.txt");
				}
				i++;
			}
			completeRecord = mergeSmallLarge(smallRecList, largeRecList);
			return completeRecord;
		
	}
	
	
	private static ArrayList<Record> mergeSmallLarge(ArrayList<SmallRecord> smallRecList, ArrayList<LargeRecord> largeRecList) 
	{
		ArrayList<Record> completeRecords = new ArrayList<Record>();
		
		for(int i = 0; i < smallRecList.size(); i++)
		{
			if(i%1000 == 0)
			{
				System.out.println("Currently at line " + i + " in smallRecList");
			}
			for(int j = 0; j < largeRecList.size(); j++)
			{
				if(smallRecList.get(i).getUserID().equals(largeRecList.get(j).getUserID()))
				{
					
					SmallRecord sRec = smallRecList.get(i);
					LargeRecord lRec = largeRecList.get(j);
					String ID = sRec.getUserID();
					String gender = sRec.getGender();
					String age = sRec.getAge();
					String click = lRec.getClick();
					
					Record record = new Record(ID, gender, age, click);
					completeRecords.add(record);
				}
			}
		}
		return completeRecords;
	}
	
	
	public static void writeArrayToFile(ArrayList<Record> list) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter("C://tester/mergedFile.txt");
		for(int i = 0; i < list.size(); i++)
		{
			Record record = list.get(i);
			writer.println(record.getUserID() + '\t'+ record.getGender() + '\t'+ record.getAge() + '\t' + record.getClick());
		}
		
	}
	
	
	
	
	
/*
	//just read user file, no comparison
	public static ArrayList<Record> readUserFile() throws FileNotFoundException
	{
		String filename = "C://tester/"
	}
*/
}








