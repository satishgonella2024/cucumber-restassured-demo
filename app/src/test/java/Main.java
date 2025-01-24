package runners;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    public static void main(String[] args) {
        // Run the ApiTestRunner class
        Result result = JUnitCore.runClasses(ApiTestRunner.class);

        // Print test results
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        // Print overall test status
        System.out.println("All tests successful: " + result.wasSuccessful());
    }
}