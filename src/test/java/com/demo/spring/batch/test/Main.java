package com.demo.spring.batch.test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String[] str = {"spring/context-config.xml","spring/job-config.xml"};
		ApplicationContext ctx = new ClassPathXmlApplicationContext(str);
		Job job = (Job) ctx.getBean("myJob");
		JobLauncher jobLauncher = (JobLauncher) ctx.getBean("jobLauncher");
		try{
			JobExecution execution = jobLauncher.run(job, new JobParameters());
			System.out.println("Execution Status: "+ execution.getStatus());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
