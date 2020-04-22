package stgeorge.validator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import stgeorge.util.Trigger;
import utils.TestUtils;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestValidationResultTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }
    @Test
    public void testValidRequest(){
        RequestValidate validate = new RequestValidate(getValidRequest());
        List<RequestValidationResult> results = validate.validateRequest();
        Assert.assertSame(results.size(),0);
    }

    private Map<String, String>  getValidRequest() {
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("service","perunnal");
        return d;

    }
}