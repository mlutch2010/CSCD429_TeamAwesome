import java.io.*;
import java.util.*;

public class DataMiningProject {

	public static void main(String[] args) throws IOException
	{

		File sampleFile = new File("randomSample.txt");
		File userProfileFile = new File("userid_profile.txt");
		infoReader(sampleFile,userProfileFile); 
		

	}
	
	public static void infoReader(File sampleFile, File userProfileFile) throws IOException//change to return User[]
	{
		Data data = new Data();
		User cur;
		String st;
		int click,impression,userId,x = 0 ;
		ArrayList<User>  userInfo = new ArrayList<User>(23907634); //actual size is 23907634
		String[] info,userProfile;
		BufferedReader sampleReader = new BufferedReader(new FileReader(sampleFile));
		BufferedReader userReader = new BufferedReader(new FileReader(userProfileFile));
		
		while ((st = userReader.readLine()) != null)
		{
			userProfile = st.split("\t");
			while(x != Integer.parseInt(userProfile[0])-1)
			{
				userInfo.add(x, null);
			}
			userInfo.add(Integer.parseInt(userProfile[0])-1, new User(Integer.parseInt(userProfile[0]),Integer.parseInt(userProfile[1]),Integer.parseInt(userProfile[2])));
			x++;
		}
		
		while ((st = sampleReader.readLine()) != null)//actual number of lines is 149,639,106
		{
		    info = st.split("\t");
		    click = Integer.parseInt(info[0]);
		    impression = Integer.parseInt(info[1]);
		    userId = Integer.parseInt(info[11]);
		    cur = userInfo.get(userId-1);
		    cur.setClick(click);
		    cur.setImpression(impression);
		    System.out.println(userInfo.get(userId-1).toString());
		    data.addDate(cur.getGender(), cur.getAge(), click, impression);

		}
		//return User[]
		
		  data.printToFile();
		  sampleReader.close();
		  userReader.close();
	}

}
