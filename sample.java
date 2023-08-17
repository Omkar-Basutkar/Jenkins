import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import com.offbytwo.jenkins.model.QueueReference;

import java.net.URI;
import java.util.Map;

public class JenkinsSample {

    public static void main(String[] args) {
        String jenkinsUrl = "http:http://35.154.153.145:8080/";
        String username = "omkar_basutkar";
        String password = "Basu@1234";

        try {
            JenkinsServer jenkins = new JenkinsServer(new URI(jenkinsUrl), username, password);

            String jobName = "your-job-name";
            Map<String, Job> jobs = jenkins.getJobs();
            if (jobs.containsKey(jobName)) {
                QueueReference queueReference = jenkins.getJob(jobName).build(true);
                System.out.println("Job triggered. Queue ID: " + queueReference.getQueueItemUrlPart());
            } else {
                System.out.println("Job not found: " + jobName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
