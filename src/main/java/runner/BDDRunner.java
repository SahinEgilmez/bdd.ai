package runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.core.cli.Main;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;

//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources", glue = "steps", tags ={"@tag"})
public class BDDRunner {
    public static void main(String[] args) {
        String[] arg = {"--plugin", "pretty", "--glue", "steps","--tags","@featureTag", "src/test/resources"};
        Main.run(arg,ClassLoader.getSystemClassLoader());
    }
}
