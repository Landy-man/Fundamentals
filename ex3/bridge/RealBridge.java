package bridge;

import Website.Ad;
import Website.WebManager;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by sheld on 12/29/2017.
 */
public class RealBridge implements DrushimBridge {
    private WebManager wm = new WebManager();

    @Override
    public void addFields(String string) {
        wm.addField(string);

    }

    @Override
    public void addEducation(String string) {
        wm.addEducation(string);
    }

    @Override
    public void addPosition(String s) {
        wm.addPosition(s);
    }

    @Override
    public void addSalary(String s) {
        wm.addSalary(s);
    }

    @Override
    public void addTitle(String s) {
        wm.addTitle(s);
    }

    @Override
    public void addCompany(String name, String user, String pass, int numOfAds) {
        wm.addCompany(name , user, pass,numOfAds);
    }

    @Override
    public int getMyCredit(String user, String pass) {
        return wm.getMyCredit(user,pass);
    }

    @Override
    public String addNewAd(String user, String pass, String title, String field, String education, String position, String salary, String description) {
        int adId = wm.addNewAd(user,pass,title,field,education,position,salary,description);
        if(adId == -1) return null;
        return "" + adId;
    }

    @Override
    public String[] getMyAdsIds(String user, String pass) {
        List<Integer> adIds =  wm.getMyAdsIds(user,pass);
        if(adIds == null) return null;
        String[] ans = new String[adIds.size()];
        for(int i = 0; i < adIds.size(); i++){
            ans[i] = adIds.get(i).toString();
        }
        return ans;
    }

    @Override
    public String[] getAds(String title, String field, String education, String position, String salary) {
        List<Ad> ads =  wm.getAds(title,field,education,position,salary);
        if(ads == null) return null;
        String[] ans = new String[ads.size()];
        for(int i = 0; i < ads.size(); i++){
            ans[i] = "" + ads.get(i).getAdId();
        }
        return ans;
    }

    @Override
    public void cleanAllData() {
        this.wm = null;
    }
}
