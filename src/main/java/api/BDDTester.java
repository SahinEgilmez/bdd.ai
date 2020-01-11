package api;

import io.cucumber.core.cli.Main;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;


public class BDDTester extends DefaultTask {
    public String message;
    public String recipient;

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }

    void sayGreeting() {
        System.out.printf("%s, %s!\n", getMessage(), getRecipient());
    }

    @TaskAction
    public void testRunner() {
        String[] arg = {"--plugin", "pretty", "--glue", "steps","--tags","@featureTag", "src/test/resources"};
        Main.run(arg,ClassLoader.getSystemClassLoader());
    }
}
