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
   
   public User(click, impression, userID, userProfile, gender, age)
   {
     this.click = click;
     this.userID = userID;
     this.userProfile = userProfile;
     this.gender = gender;
     this.age = age;
   }
   
   public void setAll(click, impression, userID, userProfile, gender, age)
   {
     this.click = click;
     this.userID = userID;
     this.userProfile = userProfile;
     this.gender = gender;
     this.age = age;
   }
   
   public void setClick(click)
   {
      this.click = click;
   }
   
   public void setImpression(impression)
   {
      this.impression = impression;
   }
   
   public void setUserID(userID)
   {
      this.userID = userID;
   }
   
   public void setUserProfile(userProf)
   {
      this.userProfile = userProf;  
   }
   
   public void setGender(gender)
   {
      this.gender = gender;
   }
   
   public void setAge(age)
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