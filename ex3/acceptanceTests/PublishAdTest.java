package acceptanceTests;


import org.junit.Test;

public class PublishAdTest extends DrushimTests {

	@Test
    public void testUpdateNumAd() {
		String user99="intel";
		String pass99="0inside";
		this.bridge.addNewAd(user99, pass99, "DBA team Leader","Software","Software Engineer","Full", "10000-12000","Minimum 5 years experience");

		assertEquals(this.bridge.getMyCredit(user99, pass99), 99);

	this.bridge.addNewAd(user99, pass99,"","","","","","");
		assertEquals(this.bridge.getMyCredit(user99, pass99),99);

		String user0="google";
		String pass0="goog1234";

        this.bridge.addNewAd(user0, pass0, "Algorithms Developer","Software","Doctor","Full", "10000-12000","Minimum 5 years experience");
       	assertEquals(this.bridge.getMyCredit(user0, pass0),0);
	}	

	@Test
    public void testPublishAd(){
		String user99="intel";
		String pass99="0inside";
		String id;
        id=this.bridge.addNewAd(user99, pass99, "Testing Tools Developer","QA","Software Engineer","Student", "5000-6000","");
		assertNotNull(id); // got id for ad
		assertEquals(this.bridge.getMyAdsIds(user99, pass99).length,1); // have only one ad

      id=this.bridge.addNewAd(user99, pass99, "Integration Tools Developer","Hardware","Software Engineer","Student", "5000-6000","");
        assertNotNull(id); // got id for ad
        assertEquals(this.bridge.getMyAdsIds(user99, pass99).length,2); // have 2 ad

        user99="hp";
        pass99="hp1234";
        id=this.bridge.addNewAd(user99, pass99, "Internet Infrastructures","Hardware","Doctor","Part-Time", "22000-24000","");
        assertNotNull(id); // got id for ad
        assertEquals(this.bridge.getMyAdsIds(user99, pass99).length,1);

        id=this.bridge.addNewAd(user99, pass99, "Webmaster","Software","B.SC Computer Science","Part-Time", "10000-12000","");
        assertNull(id); // got id for ad
        assertEquals(this.bridge.getMyAdsIds(user99, pass99).length,1);

	}

    @Test
	public void testPublishAdMissingArgs() {


        String user100="ebits";
		String pass100="bitsNbytes";
		String id;


        //Missing Title
      id=this.bridge.addNewAd(user100, pass100, "","QA","Software Engineer","Student", "5000-6000","");
        assertNull(id);
        assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
        assertEquals(this.bridge.getMyCredit(user100, pass100),100);


         //Missing  position and salary
        id=this.bridge.addNewAd(user100, pass100, "DBA team Leader","Software","","", "5000-6000","");
        assertNotNull(id);
        assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,1);
        assertEquals(this.bridge.getMyCredit(user100, pass100),99);

        user100="soroka";
        pass100="soroka1";


        //Missing Field
        id=this.bridge.addNewAd(user100, pass100, "Nursing","","Nurse","Part-Time", "8000-10000","");
        assertNull(id);
        assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
        assertEquals(this.bridge.getMyCredit(user100, pass100),50);

	}

    @Test
	public void testPublishAdBadValueArgs() {
		String user100="ebits";
		String pass100="bitsNbytes";
		String id;


        //bad title
        id=this.bridge.addNewAd(user100, pass100, "ASP Programmer","Software","Software Engineer","Student", "5000-6000","");
        assertNull(id);
        assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
        assertEquals(this.bridge.getMyCredit(user100, pass100),100);


         //invalid field

        id=this.bridge.addNewAd(user100, pass100, "Analyst","Security","Software Engineer","Student", "5000-6000","");
        assertNull(id);
        assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
        assertEquals(this.bridge.getMyCredit(user100, pass100),100);

        //invalid education

        id=this.bridge.addNewAd(user100, pass100, "DBA team Leader","Software","MSc Computer Science","Student", "5000-6000","");
        assertNull(id);
        assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
        assertEquals(this.bridge.getMyCredit(user100, pass100),100);

       //invalid position
        id=this.bridge.addNewAd(user100, pass100, "DBA team Leader","Software","Software Engineer","Freelancer", "5000-6000","");
        assertNull(id);
        assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
        assertEquals(this.bridge.getMyCredit(user100, pass100),100);

       //invalid salary

        id=this.bridge.addNewAd(user100, pass100, "DBA team Leader","Software","Software Engineer","Full", "25000","");
        assertNull(id);
        assertEquals(this.bridge.getMyAdsIds(user100, pass100).length,0);
        assertEquals(this.bridge.getMyCredit(user100, pass100),100);
	}

    @Test
	public void testPublishAdNoCredit() {
		String user0="google";
		String pass0="goog1234";

		String id =this.bridge.addNewAd(user0, pass0, "Algorithms Developer","Software","Doctor","Full", "10000-12000","Minimum 5 years experience");
		assertNull(id);
		assertEquals(this.bridge.getMyAdsIds(user0, pass0).length,0);
	}

}
