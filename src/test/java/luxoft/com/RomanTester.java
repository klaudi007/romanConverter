package luxoft.com;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RomanTester {

    private static final Logger log = LoggerFactory.getLogger(RomanTester.class);

    private RomanService roman;

    @Before
    public void init(){
        roman = new RomanService();
    }

    @Test
    public void testI(){
        Assert.assertEquals(2006, roman.convert("MMVI") );
    }

    @Test
    public void testPrecede(){
        Assert.assertEquals(1944,roman.convert("MCMXLIV"));
    }

    @Test(expected = RomanException.class)
    public void testException(){
        roman.convert("MCMXLIVQQQ");
    }


}
