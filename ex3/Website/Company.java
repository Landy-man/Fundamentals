package Website;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sheld on 12/29/2017.
 */
public class Company {
    private String companyName;
    private String userName;
    private String password;
    private int quoto;
    private int companyId;
    private List<Integer> publishedAdds;

    public Company(String companyName, String userName, String password, int companyId){
        this.companyName = companyName;
        this.userName = userName;
        this.password = password;
        this.companyId = companyId;
        this.quoto = 0;
        this.publishedAdds = new ArrayList<Integer>();
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public String getUserName() {
        return this.userName;
    }


    public int getQuoto() {
        return quoto;
    }

    public String getPassword() {
        return password;
    }

    public void addQuoto(int numOfAds) {
        this.quoto+=numOfAds;
    }


    public void adPublished(int adId) {
        publishedAdds.add(adId);
        quoto--;
    }

    public List<Integer> getAds() {
        return publishedAdds;
    }


}
