package suite;
import core.BaseTeste;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"Tests"})
public class Runner extends BaseTeste {

}