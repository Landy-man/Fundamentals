package acceptanceTests;

import junit.framework.*;

/**
 * Created with IntelliJ IDEA.
 * User: Suha
 * Date: 17/12/13
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
public class AllTests {

    public static Test suite(){
        TestSuite suite= new TestSuite("SearchingJob");
        suite.addTest( new TestSuite(PublishAdTest.class));
        suite.addTest(new TestSuite(SearchJobTest.class));



        return suite;
    }
}
