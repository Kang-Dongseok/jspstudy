package batch;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.StudentDAO;
import dto.StudentDTO;

public class Top3StudentJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		List<StudentDTO> top3 = StudentDAO.getInstance().top3StudentList();
		try {
			File file = new File("D:" + File.separator +
								 "spring0303" + File.separator + 
								 "jspstudy" + File.separator + 
								 "workspace" + File.separator +
								 "14_BATCH", "포상자명단.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < top3.size(); i++) {
				bw.write((i + 1) + ", ");
				bw.write(top3.get(i).getSno() + ", ");
				bw.write(top3.get(i).getName() + ", ");
				bw.write(top3.get(i).getKor() + ", ");
				bw.write(top3.get(i).getEng() + ", ");
				bw.write(top3.get(i).getMat() + ", ");
				bw.write(top3.get(i).getAve() + ", ");
				bw.write(top3.get(i).getGrade() + "\n");
			}
			System.out.println("포상자.txt 파일이 생성되었습니다.");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}