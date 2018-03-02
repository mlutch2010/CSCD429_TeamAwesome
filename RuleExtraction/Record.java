
public class Record 
{
	private String userID;
	private String gender;
	private String age;
	private String click;
	
	public Record(String userID, String gender, String age, String click)
	{
		this.userID = userID;
		this.gender = gender;
		this.age = age;
		this.click = click;
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

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}
	
	public String toString()
	{
		String record = "UserID: " + this.userID + " Gender: " + this.gender  + " Age: " + this.age + " Click: "  + this.click;
		return record;
	}
	
}
