import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import com.test.pact.PactProvider.PactProviderApplication;
import com.test.pact.PactProvider.Tester;
import com.test.pact.PactProvider.TesterService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRestPactRunner.class)
@SpringBootTest(classes = PactProviderApplication.class)
@ActiveProfiles("test")
@PactBroker(host="localhost",port="9292")
@Provider("tester_provider")
public class PactProviderTest {

    @MockBean
    private TesterService testerService;

    @TestTarget
    public final Target target = new HttpTarget(8089);

    @State("Tester app")
    public void createTesterState(){
        Tester tester = new Tester("myName", "Pune");
        when(testerService.getTester(any(Tester.class))).thenReturn(tester);

    }
}
