package Website;

/**
 * Created by sheld on 12/29/2017.
 */
public class Ad {
    private int adId;
    private String title;
    private String field;
    private String education;
    private String position;
    private String salary;
    private String description;

    public Ad(String title, String field, String education, String position, String salary, String description, int id) {
        this.title = title;
        this.field = field;
        this.education = education;
        this.position = position;
        this.salary = salary;
        this.description = description;
        this.adId = id;
    }

    public String getTitle() {
        return title;
    }

    public String getField() {
        return field;
    }

    public String getEducation() {
        return education;
    }

    public String getPosition() {
        return position;
    }

    public String getSalary() {
        return salary;
    }

    public int compareSalary(Ad ad2) {
        return Integer.parseInt(this.salary.split("-")[0]) - Integer.parseInt(ad2.getSalary().split("-")[1]);
    }

    public int getAdId() {
        return adId;
    }
}
