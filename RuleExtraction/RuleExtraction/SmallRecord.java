
public class SmallRecord 
{
	private String userID;
	private String gender;
	private String age;
	
	public SmallRecord(String userID, String gender, String age)
	{
		this.userID = userID;
		this.gender = gender;
		this.age = age;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public String toString()
	{
		String record = "UserID: " + this.userID + " Gender: " + this.gender  + " Age: " + this.age;
		return record;
	}
}
