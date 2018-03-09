
public class Record 
{
	private String clicks;
	private String impressions;
	private String adverID;
	private String depth;
	private String position;
	private String someNumber;
	private String userID;
	private String gender;
	private String age;
	
	
	
	public Record(String clicks, String impressions, String adverID, String depth, String position, String someNumber,
			String userID, String gender, String age) 
	{
		this.clicks = clicks;
		this.impressions = impressions;
		this.adverID = adverID;
		this.depth = depth;
		this.position = position;
		this.someNumber = someNumber;
		this.userID = userID;
		this.gender = gender;
		this.age = age;
	}

	
	public String getClicks() {
		return clicks;
	}


	public void setClicks(String clicks) {
		this.clicks = clicks;
	}


	public String getImpressions() {
		return impressions;
	}


	public void setImpressions(String impressions) {
		this.impressions = impressions;
	}


	public String getAdverID() {
		return adverID;
	}


	public void setAdverID(String adverID) {
		this.adverID = adverID;
	}


	public String getDepth() {
		return depth;
	}


	public void setDepth(String depth) {
		this.depth = depth;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getSomeNumber() {
		return someNumber;
	}


	public void setSomeNumber(String someNumber) {
		this.someNumber = someNumber;
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
		String record = "UserID: " + this.userID + " Gender: " + this.gender  + " Age: " + this.age + " Click: "  + this.clicks;
		return record;
	}
	
}
