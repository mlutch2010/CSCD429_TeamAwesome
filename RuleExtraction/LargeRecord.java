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
*/
public class LargeRecord 
{
	private String click;
	private String impression;
	private String displayURL;
	private String adID;
	private String advertiserID;
	private String depth;
	private String position;
	private String queryID;
	private String keywordID;
	private String titleID;
	private String descriptionID;
	private String userID;
	
	public LargeRecord(String click, String impression, String displayURL, String adID, String advertiserID, String depth, String position,
			String queryID, String keywordID, String titleID, String descriptionID, String userID) 
	{
		this.click = click;
		this.impression = impression;
		this.displayURL = displayURL;
		this.adID = adID;
		this.advertiserID = advertiserID;
		this.depth = depth;
		this.position = position;
		this.queryID = queryID;
		this.keywordID = keywordID;
		this.titleID = titleID;
		this.descriptionID = descriptionID;
		this.userID = userID;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getDisplayURL() {
		return displayURL;
	}

	public void setDisplayURL(String displayURL) {
		this.displayURL = displayURL;
	}

	public String getAdID() {
		return adID;
	}

	public void setAdID(String adID) {
		this.adID = adID;
	}

	public String getAdvertiserID() {
		return advertiserID;
	}

	public void setAdvertiserID(String advertiserID) {
		this.advertiserID = advertiserID;
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

	public String getQueryID() {
		return queryID;
	}

	public void setQueryID(String queryID) {
		this.queryID = queryID;
	}

	public String getKeywordID() {
		return keywordID;
	}

	public void setKeywordID(String keywordID) {
		this.keywordID = keywordID;
	}

	public String getTitleID() {
		return titleID;
	}

	public void setTitleID(String titleID) {
		this.titleID = titleID;
	}

	public String getDescriptionID() {
		return descriptionID;
	}

	public void setDescriptionID(String descriptionID) {
		this.descriptionID = descriptionID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	
}
