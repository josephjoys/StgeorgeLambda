import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import stgeorge.orchestrator.Orchestrator;
import stgeorge.util.Trigger;
import utils.TestUtils;

import java.util.HashMap;
import java.util.Map;

public class OrchestratorTest extends TestCase {

    @Test
    public void testContactUs(){
        Orchestrator orchestrator = new Orchestrator(TestUtils.getTesEvent());
        orchestrator.orchestrate();
        Assert.assertEquals(Trigger.EMAIL,orchestrator.getTrigger());
    }

    @Test
    public void testQurbanaNomination(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","qurbananominations");
        d.put("service","perunnalshare");
        d.put("message","perunnalshare");
        Orchestrator orchestrator = new Orchestrator(d);
        orchestrator.orchestrate();
        Assert.assertEquals(Trigger.EMAIL,orchestrator.getTrigger());
    }

    @Test
    public void testPerunnalshare(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","perunnalshare");
        d.put("perunnal","perunnalshare");
        d.put("message","perunnalshare");
        Orchestrator orchestrator = new Orchestrator(d);
        orchestrator.orchestrate();
        Assert.assertEquals(Trigger.EMAIL,orchestrator.getTrigger());
    }

    @Test
    public void testPrayerRequest(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","prayerrequest");
        d.put("message","perunnalshare");
        Orchestrator orchestrator = new Orchestrator(d);
        orchestrator.orchestrate();
        Assert.assertEquals(Trigger.EMAIL,orchestrator.getTrigger());
    }
    @Test
    public void testOnlineGiving(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","onlinegiving");
        d.put("amount","perunnalshare");
        Orchestrator orchestrator = new Orchestrator(d);
        orchestrator.orchestrate();
        Assert.assertEquals(Trigger.EMAIL,orchestrator.getTrigger());
    }

}
