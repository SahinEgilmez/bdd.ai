package runner;

import cucumber.runtime.Env;
import io.cucumber.core.cli.Main;
import org.apache.commons.io.FileUtils;
import settings.Environment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

public class BDDRunner {
    public static void main(String[] args) throws IOException {
        FileUtils.deleteDirectory(new File("test-results"));
        FileUtils.deleteDirectory(new File("test-report"));

        String[] arg = {"--plugin", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm", "--glue", "steps",
                "--tags", Environment.getInstance().tags, "--threads", Environment.getInstance().threadCount.toString(),
                "src/test/resources"};
        Main.run(arg, ClassLoader.getSystemClassLoader());

        Files.move(new File("allure-results").toPath(), new File( "test-results").toPath(),
                StandardCopyOption.REPLACE_EXISTING);
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("allure generate test-results -o test-report");
            if(pr.waitFor()==0 && Environment.getInstance().quickReport){
                Process pr2 = rt.exec("allure open test-report");
                pr2.waitFor(3, TimeUnit.SECONDS);
            }
        }catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
