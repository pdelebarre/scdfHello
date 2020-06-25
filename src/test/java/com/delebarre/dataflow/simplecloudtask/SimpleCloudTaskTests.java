package com.delebarre.dataflow.simplecloudtask;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureRule; //OuputCapture deprecated since spring boot 2.2.0 https://javadoc.io/static/org.springframework.boot/spring-boot-test/2.2.0.RELEASE/deprecated-list.html
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
@RunWith(SpringRunner.class)
@SpringBootTest
class SimpleCloudTaskTests {

    @Rule
    public OutputCaptureRule outputCapture = new OutputCaptureRule();
    @Test
    public void itCountsToTen() {
        SpringApplication.run(SimpleCloudTask.class);
        String output = this.outputCapture.toString();
        String lineSeparator = System.getProperty("line.separator");
        assertTrue(
                output.contains("1"
                        + lineSeparator + "2"
                        + lineSeparator + "3"
                        + lineSeparator + "4"
                        + lineSeparator + "5"
                        + lineSeparator + "6"
                        + lineSeparator + "7"
                        + lineSeparator + "8"
                        + lineSeparator + "9"
                        + lineSeparator + "10"));
    }
}
