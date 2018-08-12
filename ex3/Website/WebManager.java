package Website;

import bridge.DrushimBridge;

import java.util.List;

/**
 * Created by sheld on 12/29/2017.
 */
public class WebManager  {
    private CompanyManager compManager;
    private AdHandler adHandler;


    public WebManager(){
        this.compManager = new CompanyManager();
        this.adHandler = new AdHandler();
    }

    public void addField(String field) {
        adHandler.addField(field);
    }


    public void addEducation(String education) {
        adHandler.addEducation(education);
    }


    public void addPosition(String position) {
        adHandler.addPosition(position);
    }


    public void addSalary(String salary) {
        adHandler.addSalary(salary);
    }


    public void addTitle(String title) {
        adHandler.addTitle(title);
    }


    public void addCompany(String companyName, String user, String pass, int numOfAds) {
        compManager.addCompany(companyName,user,pass,numOfAds);
    }


    public int getMyCredit(String user, String pass) {
        return compManager.getCompanyCredit(user,pass);
    }


    public  int addNewAd(String user, String pass, String title, String field, String education, String position, String salary, String description) {
        if (compManager.getCompanyCredit(user,pass) <= 0)
            return -1;

        int adId = adHandler.addNewAd(title, field, education, position, salary, description);
        if(adId != -1)
            compManager.newAdAdded(user,pass,adId);

        return adId;
    }


    public List<Integer> getMyAdsIds(String user, String pass) {
        return compManager.getCompanyAds(user,pass);
    }


    public List<Ad> getAds(String title, String field, String education, String position, String salary) {
        return adHandler.getAds(title,field,education,position,salary);
    }

    public void removeCompany(String user, String pass){
        List<Integer> ads = compManager.getCompanyAds(user,pass);

        if(ads != null){
            adHandler.removeAds(ads);
        }

    }
}
