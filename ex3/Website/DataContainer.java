package Website;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sheld on 12/29/2017.
 */
public class DataContainer {
    private List<String> fields;
    private List<String> educations;
    private List<String> positions;
    private List<String> salarys;
    private List<String> titles;

    public DataContainer(){
        this.fields = new ArrayList<String>();
        this.educations = new ArrayList<String>();
        this.positions = new ArrayList<String>();
        this.salarys = new ArrayList<String>();
        this.titles = new ArrayList<String>();

        this.educations.add("");
        this.positions.add("");
        this.salarys.add("");

    }



    public void addField(String field) {
        if (!containsField(field))
            fields.add(field);
    }

    public void addEducation(String education) {
        if (!containsEducation(education))
            educations.add(education);
    }

    public void addPosition(String position) {
        if (!containsPosition(position))
            positions.add(position);
    }

    public void addSalary(String salary) {
        if (!containsSalary(salary))
            salarys.add(salary);
    }

    public void addTitle(String title) {
        if (!containsTitle(title))
            titles.add(title);
    }

    public boolean containsTitle(String title) {
        return titles.contains(title);
    }

    public boolean containsField(String field) {
        return  fields.contains(field);
    }

    public boolean containsEducation(String education) {
        return educations.contains(education);
    }

    public boolean containsPosition(String position) {
        return positions.contains(position);
    }

    public boolean containsSalary(String salary) {
        return salarys.contains(salary);
    }
}
