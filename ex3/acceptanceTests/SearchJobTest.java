package acceptanceTests;

import org.junit.Test;

public class SearchJobTest extends DrushimTests{
	
	private String[] ids;
	/**
	 * Set Up method
	 */
	protected void setUp() throws Exception {
		super.setUp();
		ids=new String[6];
		String intelUsr="intel";
		String intelPass="0inside";
		ids[0]= this.bridge.addNewAd(intelUsr, intelPass, "DBA team Leader","Software","Software Engineer","Full", "10000-12000","Minimum 5 years experience");
		ids[2]=this.bridge.addNewAd(intelUsr, intelPass, "Analyst","IT","Doctor","Part-Time", "22000-24000","");
        ids[4]=this.bridge.addNewAd(intelUsr, intelPass, "Testing Tools Developer","IT","Doctor","Part-Time", "10000-12000","");


        String elbitUsr="ebits";
		String elbitPass="bitsNbytes";
		ids[1]=this.bridge.addNewAd(elbitUsr, elbitPass, "Testing Tools Developer", "Software","Software Engineer","Full","8000-10000","");
		ids[3]=this.bridge.addNewAd(elbitUsr, elbitPass, "Support & Service", "Management","Secretary","Full","8000-10000","");
        ids[5]=this.bridge.addNewAd(elbitUsr, elbitPass, "Algorithms Developer", "IT","Doctor","Part-Time","22000-24000","");

	}

	private boolean containsIds(String id, String[] ary) {
		for(int i=0; i<ary.length; i++)
			if(ary[i].equals(id))
				return true;
		return false;
	}


  @Test
	public void testSearchByEducation(){
		String[] adsids;
		adsids = this.bridge.getAds("","", "Doctor", "", "");
        assertEquals(adsids.length, 3);


		assertTrue(containsIds(ids[2],adsids));
		assertTrue(containsIds(ids[4],adsids));
        assertTrue(containsIds(ids[5],adsids));


        adsids = this.bridge.getAds("","", "Software Engineer", "", "");
        assertEquals(adsids.length, 2);
        assertTrue(containsIds(ids[0],adsids));
        assertTrue(containsIds(ids[1],adsids));

        adsids = this.bridge.getAds("","", "Secretary", "", "");
        assertEquals(adsids.length, 1);
        assertTrue(containsIds(ids[3],adsids));
    }

	@Test
    public void testSearchByPosition(){
		String[] adsids;
		adsids = this.bridge.getAds("","","", "Full", "");
		assertEquals(adsids.length, 3);
		assertTrue(containsIds(ids[0],adsids));
        assertTrue(containsIds(ids[1],adsids));
		assertTrue(containsIds(ids[3],adsids));


        adsids = this.bridge.getAds("","","", "Part-Time", "");
        assertEquals(adsids.length, 3);
        assertTrue(containsIds(ids[2],adsids));
        assertTrue(containsIds(ids[4],adsids));
        assertTrue(containsIds(ids[5],adsids));


	}



    @Test
	public void testSearchBySalary(){
        String[] adsids;
        adsids = this.bridge.getAds("","","", "", "22000-24000");
        assertEquals(adsids.length, 2);
        assertTrue(containsIds(ids[2],adsids));
        assertTrue(containsIds(ids[5],adsids));


        adsids = this.bridge.getAds("","","", "", "8000-10000");
        assertEquals(adsids.length, 2);
        assertTrue(containsIds(ids[1],adsids));
        assertTrue(containsIds(ids[3],adsids));



    }

    @Test
	public void testSearchByTwo() {
		String[] adsids;
		adsids = this.bridge.getAds("","","Software Engineer", "", "8000-10000");
		assertEquals(adsids.length, 1);
		assertTrue(containsIds(ids[1],adsids));

	}

    @Test
    public void testSearchEmptyParamas(){
        String[] adsids;
        adsids = this.bridge.getAds("","","", "", "");
        assertEquals(adsids.length, 6);
        assertTrue(containsIds(ids[0],adsids));
        assertTrue(containsIds(ids[1],adsids));
        assertTrue(containsIds(ids[2],adsids));
        assertTrue(containsIds(ids[3],adsids));
        assertTrue(containsIds(ids[4],adsids));
        assertTrue(containsIds(ids[5],adsids));


    }



    @Test
	public void testSearchWithBadParams() {
		String[] adsids;
		adsids = this.bridge.getAds("Software","","", "", "");
		assertNull(adsids);


        adsids = this.bridge.getAds("","","Msc Computer Science", "", "");
        assertNull(adsids);

        adsids = this.bridge.getAds("","Software","Software Engineer","Freelancer", "10000-12000");
        assertNull(adsids);


        adsids = this.bridge.getAds("","Software","Software Engineer","", "7000");
        assertNull(adsids);

    }

}
