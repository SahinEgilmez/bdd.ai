package api;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class BDDAIPlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.getTasks().create("bddTester", BDDTester.class, (task) -> {
            task.setMessage("Hello World");
            task.setRecipient("From BDDRunner");
        });
    }
}