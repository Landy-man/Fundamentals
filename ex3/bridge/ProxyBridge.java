package bridge;
public class ProxyBridge implements DrushimBridge{

	public DrushimBridge real;
	

		
	public ProxyBridge() {
		this.real=null;
	}
	


    @Override
    public void addPosition(String s) {
        if(this.real!=null)
            this.real.addPosition(s);
    }

    @Override
    public void addSalary(String s) {
        if(this.real!=null)
            this.real.addSalary(s);
    }

    @Override
    public void addTitle(String s) {
        if(this.real!=null)
            this.real.addTitle(s);
    }

    @Override
	public void addCompany(String name, String user, String pass, int numOfAds) {
		if(this.real!=null)
			this.real.addCompany(name,user,pass,numOfAds);


	}

	@Override
	public void addFields(String string) {
		if(this.real!=null)
			this.real.addFields(string);
	}




	@Override
	public void addEducation(String string) {
		if(this.real !=null)
			this.real.addEducation(string);
	}



	@Override
	public String[] getMyAdsIds(String user, String pass) {
		if(this.real!=null)
			return this.real.getMyAdsIds(user, pass);

        return new String[] { };
	}

	@Override
	public int getMyCredit(String user, String pass) {
		if(this.real!=null)
			return this.real.getMyCredit(user, pass);
		else return 0;
	}

    @Override
    public String addNewAd(String user, String pass, String title, String field, String education, String position, String salary, String description) {
        if(this.real!=null)
            return this.real.addNewAd(user,pass,title,field,education,position,salary,description);
        else
        return "";  
    }



    @Override
    public void cleanAllData() {
        if(this.real !=null)
            this.real.cleanAllData();
    }




    @Override
	public String[] getAds(String title, String field, String education, String position, String salary) {
		if(this.real!=null)
			return this.real.getAds(title,  field,  education, position, salary);
        else return new String[]{""};

	}




	
}