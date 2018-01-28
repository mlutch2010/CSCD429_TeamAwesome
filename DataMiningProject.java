import java.io.*;
import java.util.*;

public class DataMiningProject {

	public static void main(String[] args) throws IOException
	{

		File sampleFile = new File("50Samples.txt");
		File userProfileFile = new File("50userid.txt");
		infoReader(sampleFile,userProfileFile); 
		

	}
	
	public static void infoReader(File sampleFile, File userProfileFile) throws IOException//change to return User[]
	{
		String st;
		int click,impression,userId,gender,age;
		String[] info,userProfile;
		String[][] userInfo = new String[50][3];
		int x = 0;
		BufferedReader sampleReader = new BufferedReader(new FileReader(sampleFile));
		BufferedReader userReader = new BufferedReader(new FileReader(userProfileFile));
		
		while ((st = userReader.readLine()) != null)
		{
			userInfo[x] = st.split("\t");
			x++;
		}
		
		while ((st = sampleReader.readLine()) != null)
		{
		    info = st.split("\t");
		    click = Integer.parseInt(info[0]);
		    impression = Integer.parseInt(info[1]);
		    userId = Integer.parseInt(info[11]);
		    userProfile = userInfo[userId-1];
		    gender = Integer.parseInt(userProfile[1]);
		    age = Integer.parseInt(userProfile[2]);
		    //turn info into User
		    //add to User[]
		}
		//return User[]
		
		  
		  sampleReader.close();
		  userReader.close();
	}

}
