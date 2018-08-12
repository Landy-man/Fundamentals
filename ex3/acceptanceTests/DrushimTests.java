package acceptanceTests;
import bridge.DrushimBridge;
import   driver.Driver;
import junit.framework.TestCase;


public class DrushimTests extends TestCase {


    protected DrushimBridge bridge;

    public DrushimTests(){
        super();
    }

    public DrushimTests(String name){
        super(name);
    }

    /**
     * Set Up method
     */
    protected void setUp() throws Exception {

        super.setUp();

        this.bridge= Driver.getBridge();
        this.initFields();
        this.addTitles();
        this.initEducation();
        this.initSalary();
        this.initPosition();
        this.initCompanies();

    }

    private void addTitles() {
        this.bridge.addTitle("Integration Tools Developer");
        this.bridge.addTitle("DBA team Leader");
        this.bridge.addTitle("Webmaster");
        this.bridge.addTitle("Analyst");
        this.bridge.addTitle("Nursing");
        this.bridge.addTitle("Internet Infrastructures");
        this.bridge.addTitle("Infrastructure Development");
        this.bridge.addTitle("Algorithms Developer");
        this.bridge.addTitle("Testing Tools Developer");
        this.bridge.addTitle("Support & Service");
    }


    /**
     * Insert values of fields
     */
    private void initFields(){
        this.bridge.addFields("Hardware");
        this.bridge.addFields("Management");
        this.bridge.addFields("Software");
        this.bridge.addFields("Internet");
        this.bridge.addFields("System");
        this.bridge.addFields("QA");
        this.bridge.addFields("IT");
        this.bridge.addFields(" Health ");
    }

    /**
     * Insert values of educations
     */
    private void initEducation(){
        this.bridge.addEducation("Doctor");
        this.bridge.addEducation("Software Engineer");
        this.bridge.addEducation("PHP developer");
        this.bridge.addEducation("Nurse");
        this.bridge.addEducation("Secretary");
        this.bridge.addEducation("B.SC Computer Science");
    }

    /**
     * Insert values of positions
     */

    private void initPosition() {
        this.bridge.addPosition("Full");
        this.bridge.addPosition("Part-Time");
        this.bridge.addPosition("Student");


    }




    private void initSalary() {
       this.bridge.addSalary("5000-6000");
       this.bridge.addSalary("8000-10000");
        this.bridge.addSalary("10000-12000");
        this.bridge.addSalary("22000-24000");
    }




    private void initCompanies() {
        this.bridge.addCompany("Google", "google", "goog1234", 0);
        this.bridge.addCompany("HP", "hp", "hp1234", 1);
        this.bridge.addCompany("Intel", "intel", "0inside", 100);
        this.bridge.addCompany("Elbit","ebits","bitsNbytes",100);
        this.bridge.addCompany("Soroka", "soroka","soroka1",50);
    }

    /**
     * Tear Down method
     */
    protected void tearDown() throws Exception {
        bridge.cleanAllData();
        super.tearDown();


    }


}
