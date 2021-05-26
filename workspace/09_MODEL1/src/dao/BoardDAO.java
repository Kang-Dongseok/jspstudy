package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.util.DBConnector;
import dto.BoardDTO;
import dto.PageVO;

public class BoardDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	private static BoardDAO dao = new BoardDAO();
	private BoardDAO() {
		con = DBConnector.getInstance().getConnection();
	}
	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	/* 1. 게시글 삽입 */
	public int insertBoard(BoardDTO dto) {
		int result = 0;
		try {
			sql = "INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAuthor());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
		return result;
	}
	
	/* 2. 전체 게시글 반환 */
	public List<BoardDTO> selectAll(PageVO pageVO){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			/********************************************
			SELECT b.rn, b.employee_id, b.first_name
			  FROM (SELECT ROWNUM AS rn, a.employee_id, a.first_name
			          FROM (select employee_id, first_name
			                  from employees
			                 order by hire_date) a) b
			 WHERE b.rn BETWEEN 11 AND 20;
			 -- a : 정렬한 테이블
			 -- b : a 테이블에 rn을 추가한 테이블
			 ********************************************/
			sql = "SELECT b.IDX, b.AUTHOR, b.TITLE, b.CONTENT, b.HIT, b.POSTDATE" +
				  "  FROM (SELECT ROWNUM AS rn, a.IDX, a.AUTHOR, a.TITLE, a.CONTENT, a.HIT, a.POSTDATE" +
				  "          FROM (SELECT IDX, AUTHOR, TITLE, CONTENT, HIT, POSTDATE" +
				  "                  FROM BOARD" +
				  "                 ORDER BY POSTDATE DESC) a ) b" +
				  " WHERE b.rn BETWEEN ? AND ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pageVO.getBeginRecord());
			ps.setInt(2, pageVO.getEndRecord());
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setIdx(rs.getLong(1));
				dto.setAuthor(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setHit(rs.getInt(5));
				dto.setPostdate(rs.getDate(6));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return list;
	}
	/* 3. 조회수 증가 */
	public void updateHit(long idx) {
		try {
			sql = "UPDATE BOARD SET HIT = HIT + 1 WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
	}
	/* 4. 게시글 반환 */
	public BoardDTO selectByIdx(long idx) {
		BoardDTO dto = null;
		try {
			sql = "SELECT AUTHOR, TITLE, CONTENT, HIT, POSTDATE FROM BOARD WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new BoardDTO();
				dto.setIdx(idx);
				dto.setAuthor(rs.getString(1));
				dto.setTitle(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setHit(rs.getInt(4));
				dto.setPostdate(rs.getDate(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return dto;
	}
	
	/* 5. 게시글 삭제 */
	public int deleteBoard(long idx) {
		int result = 0;
		try {
			sql = "DELETE FROM BOARD WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
		return result;
	}
	
	/* 6. 게시글 수정 */
	public int updateBoard(BoardDTO dto) {
		int result = 0;
		try {
			sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setLong(3, dto.getIdx());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, null);
		}
		return result;
	}
	
	/* 7. 전체 게시글의 개수 반환 */
	public int getTotalRecord() {
		int totalRecord = 0;
		try {
			sql = "SELECT COUNT(IDX) AS OA FROM BOARD";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				totalRecord =  rs.getInt(1);  // totalRecord = rs/etInt("TOTAL_RECORD"):
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return totalRecord;
	}
}
