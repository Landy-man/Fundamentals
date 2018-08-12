package Website;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by sheld on 12/29/2017.
 */
public class AdHandler {
    private DataContainer dc;
    private List<Ad> ads;
    private int newAdId = 1;

    public AdHandler(){
        dc = new DataContainer();
        ads = new ArrayList<Ad>();
    }

    public void addField(String field) {
        dc.addField(field);
    }

    public void addEducation(String education) {
        dc.addEducation(education);
    }

    public void addPosition(String position) {
        dc.addPosition(position);
    }

    public void addSalary(String salary) {
        dc.addSalary(salary);
    }

    public void addTitle(String title) {
        dc.addTitle(title);
    }

    public int addNewAd(String title, String field, String education, String position, String salary, String description) {
        if(dc.containsTitle(title) &&
                dc.containsField(field) &&
                dc.containsEducation(education) &&
                dc.containsPosition(position) &&
                dc.containsSalary(salary))
        {
            ads.add(new Ad(title, field, education, position, salary, description,newAdId++));
            return newAdId - 1;
        }

        return -1;
    }

    public List<Ad> getAds(String title, String field, String education, String position, String salary) {
        Stream<Ad> foundAds = ads.stream();
        if (title.length() != 0) foundAds = foundAds.filter(ad -> ad.getTitle().equals(title));
        if (field.length() != 0) foundAds = foundAds.filter(ad -> ad.getField().equals(field));
        if (education.length() != 0) foundAds = foundAds.filter(ad -> ad.getEducation().equals(education));
        if (position.length() != 0) foundAds = foundAds.filter(ad -> ad.getPosition().equals(position));
        if (salary.length() != 0) foundAds = foundAds.filter(ad -> ad.getSalary().equals(salary));


        foundAds = foundAds.sorted((ad1, ad2) -> ad1.compareSalary(ad2));
        List<Ad> ans = foundAds.collect(Collectors.toList());
        if(ans.size() == 0) return null;
        return ans;
    }

    public void removeAds(List<Integer> ads) {
        ads.stream().forEach(adId -> removeAd(adId));
    }

    private void removeAd(int adId){
        for(int i = 0; i < ads.size(); i++){
            if(ads.get(i).getAdId() == adId) {
                ads.remove(i);
                return;
            }
        }
    }


}
