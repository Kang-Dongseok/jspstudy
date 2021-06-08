package batch;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class CronScheduler {
	
	private String cronExpression;
	private Class<? extends Job> job;
	Scheduler scheduler;  // 접근권한 default로 처리하면 같은 패키지에서 사용 가능
	
	public CronScheduler(String cronExpression, Class<? extends Job> job) {
		super();
		this.cronExpression = cronExpression;
		this.job = job;
	}
	
	public void execute() {
		try {
			JobDetail jobDetail = JobBuilder.newJob(job)
					.withIdentity("job", "group1")
					.build();
			CronTrigger cronTrigger = TriggerBuilder.newTrigger()
					.withIdentity("trigger", "group1")
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
					.build();
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			scheduler.scheduleJob(jobDetail, cronTrigger);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}