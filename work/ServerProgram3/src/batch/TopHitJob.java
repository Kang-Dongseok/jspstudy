package batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.BoardDAO;
import dto.BoardDTO;

public class TopHitJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		BoardDTO board = BoardDAO.getInstance().topHit();
		System.out.println("====최대 조회수 게시글====");
		System.out.println("제목: " +board.getTitle());
		System.out.println("내용: " +board.getContent());
		System.out.println("조회수: " +board.getHit());
		
	}
	
}