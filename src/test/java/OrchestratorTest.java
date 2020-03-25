import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import stgeorge.orchestrator.Orchestrator;
import stgeorge.util.Trigger;
import utils.TestUtils;

public class OrchestratorTest extends TestCase {

    @Test
    public void testContactUs(){
        Orchestrator orchestrator = new Orchestrator(TestUtils.getTesEvent());
        orchestrator.orchestrate();
        Assert.assertEquals(Trigger.EMAIL,orchestrator.getTrigger());
    }
    
    @Test
    public void testContactUsEmailSubject(){
        Orchestrator orchestrator = new Orchestrator(TestUtils.getTesEvent());
        orchestrator.orchestrate();
        Assert.assertEquals(Trigger.EMAIL,orchestrator.getTrigger());
    }

    /*Write remaining tests*/
}
