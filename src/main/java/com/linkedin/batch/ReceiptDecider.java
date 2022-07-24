package com.linkedin.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

import java.util.Random;

public class ReceiptDecider implements JobExecutionDecider {

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {

        Random random = new Random();
        int value = random.nextInt(11);
        if(value <= 7) {
            System.out.println("Item delivered is correct");
            return new FlowExecutionStatus("CORRECT");
        } else {
            System.out.println("Item delivered is incorrect");
            return new FlowExecutionStatus("INCORRECT");
        }
    }
}
