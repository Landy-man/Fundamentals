package bridge;
public interface DrushimBridge {
	
	public void addFields(String string);
	public void addEducation(String string);
	public void addPosition(String s);
    public void addSalary(String s);
    public void addTitle(String s);
	
	/**
	 *
     * @param name - Company name
     * @param user - Username
     * @param pass - Password
     * @param numOfAds - number of ads
     * @return company ID if succeed. Otherwise null
	 */
	public void addCompany(String name, String user, String pass, int numOfAds);



	/**
	 * Get your company credit
	 * @param user - company username
	 * @param pass - company password
	 * @return amount of ads can be published
	 */
	public int getMyCredit(String user, String pass);
	
	/**
	 * Add new ad
	 * @param user - company username
	 * @param pass - company password
	 * @param title - title
	 * @param field - ad field
	 * @param education - education
	 * @param position - job position
     * @param   salary
     * @param description
	 * @return ad ID if succeed. Otherwise null.
	 */
	public String addNewAd(String user, String pass,  String title, String field, String education, String position, String salary, String description);

	/**
	 * get all company's ads ids
	 * @param user - company username
	 * @param pass - company password
	 * @return array of ads' ids.
	 */
	public String[] getMyAdsIds(String user, String pass);
	
	/**
	 * Filter all open ads by role/doamin/area
	 * If a filter field is not null the returned ads' fields must be equal to filter fields. 
	 * Example: search by role:  searchAds("...",null,null)
	 * Example: search by area and role:  searchAds("...",null,"...")
	 * Example: get all open ads:  searchAds(null,null,null)
	 *
     * @param title
     * @param field
     * @param education
     *@param position
     * @param salary @return Array of ads' ids. If one of the arguments are wrong, return NULL.
	 */
	public String[] getAds(String title, String field, String education, String position, String salary);





    public void cleanAllData();


    //public void cleadDB();
}
