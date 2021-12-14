import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Dmitry Lysyy\\IdeaProjects\\SoftwareTests\\src\\test\\java",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class FeatureTest {


}