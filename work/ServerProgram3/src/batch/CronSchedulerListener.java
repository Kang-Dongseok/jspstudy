package batch;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.SchedulerException;

@WebListener
public class CronSchedulerListener implements ServletContextListener {
    
	// field
	CronScheduler cronScheduler;
	
	// constructor
	public CronSchedulerListener() { }
	
	// method
	@Override
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("=====WEB SERVICE STOP!=====");
    	try {
    		cronScheduler.scheduler.clear();
    		cronScheduler.scheduler.shutdown();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
    }
	@Override
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("=====WEB SERVICE START!=====");
    	cronScheduler = new CronScheduler("0 0/1 * 1/1 * ? *", TopHitJob.class);
    	cronScheduler.execute();
    }
	
}