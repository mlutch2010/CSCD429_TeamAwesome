public class User
{
   private int click;
   private int impression;
   private int userID;
   private int userProfile;
   private int gender;
   private int age;
   
   public User()
   {
   this.click = 0;
   this.impression = 0;
   this.userID = 0;
   this.userProfile = 0;
   this.gender = 0;
   this.age = 0;
   }
   public User(int userID, int gender, int age)
   {
	   this.userID = userID;
	   this.gender = gender;
	   this.age = age;
   }
   
   public User(int click,int impression,int userID,int userProfile,int gender,int age)
   {
     this.click = click;
     this.userID = userID;
     this.userProfile = userProfile;
     this.gender = gender;
     this.age = age;
   }
   
   public void setAll(int click,int impression,int userID,int userProfile,int gender,int age)
   {
     this.click = click;
     this.userID = userID;
     this.userProfile = userProfile;
     this.gender = gender;
     this.age = age;
   }
   
   @Override
   public String toString()
   {
	String st = this.click + " " + this.impression + " " + this.userID;
	return st;
	   
   }
   
   
   
   public void setClick(int click)
   {
      this.click = click;
   }
   
   public void setImpression(int impression)
   {
      this.impression = impression;
   }
   
   public void setUserID(int userID)
   {
      this.userID = userID;
   }
   
   public void setUserProfile(int userProf)
   {
      this.userProfile = userProf;  
   }
   
   public void setGender(int gender)
   {
      this.gender = gender;
   }
   
   public void setAge(int age)
   {
      this.age = age;
   }
   
   public int getClick()
   {
      return this.click;
   }
   
   public int getImpression()
   {
      return this.impression;
   }
   
   public int getUserID()
   {
      return this.userID;
   }
   
   public int getUserProfile()
   {
      return this.userProfile;
   }
   
   public int getGender()
   {
      return this.gender;
   }
   
   public int getAge()
   {
      return this.age;
   }
}