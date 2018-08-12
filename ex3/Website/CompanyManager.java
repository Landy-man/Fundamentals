package Website;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by sheld on 12/29/2017.
 */
public class CompanyManager {
    private List<Company> companys;
    private int newCompanyID = 1;

    public CompanyManager(){
        companys = new ArrayList<Company>();
    }

    public void addCompany(String companyName, String user, String pass, int quoto) {
        Company company = new Company(companyName, user, pass, newCompanyID++);
        company.addQuoto(quoto);
        companys.add(company);
    }

    public int getCompanyCredit(String user, String pass) {
        Company comp = getCompany(user,pass);
        if(comp != null)
            return comp.getQuoto();
        return -1;
    }

    public void newAdAdded(String user, String pass, int adId) {
        Company comp = getCompany(user,pass);
        if(comp == null) return;
        comp.adPublished(adId);
    }

    public List<Integer> getCompanyAds(String user, String pass) {
        Company comp = getCompany(user,pass);
        if(comp != null)
            return comp.getAds();
        return null;
    }

    public Company getCompany(String user, String pass){
        for (int i = 0; i < companys.size(); i++){
            Company comp = companys.get(i);
            if(comp.getUserName() == user && comp.getPassword() == pass)
                return comp;
        }
        return null;
    }
}
