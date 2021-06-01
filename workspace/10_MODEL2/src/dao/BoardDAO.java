package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BoardDTO;

public class BoardDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private static DataSource dataSource;
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	/* 1. 접속 해제 */
	public void close(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) { con.close(); }
			if (ps != null) { ps.close(); }
			if (rs != null) { rs.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* 2. 게시글 삽입 */
	public int insertBoard(BoardDTO dto) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, 0, ?, ?, 0, SYSDATE, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getAuthor());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			ps.setString(4, dto.getIp());
			ps.setString(5, dto.getFilename());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/* 3. 전체 게시글 개수 구하기 */
	public int getTotalBoardCount() {
		int count = 0;
		try {
			con = dataSource.getConnection();
			sql = "SELECT COUNT(*) FROM BOARD";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return count;
	}
	
	/* 4. 게시글 목록 반환 */
	public List<BoardDTO> selectList(Map<String, Integer> map) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			con = dataSource.getConnection();
			sql = "SELECT B.IDX, B.AUTHOR, B.TITLE, B.CONTENT, B.HIT, B.IP, B.FILENAME, B.STATE, B.POSTDATE, B.LASTMODIFIED" + 
				  "  FROM (SELECT ROWNUM AS RN, A.IDX, A.AUTHOR, A.TITLE, A.CONTENT, A.HIT, A.IP, A.FILENAME, A.STATE, A.POSTDATE, A.LASTMODIFIED" + 
				  "          FROM (SELECT IDX, AUTHOR, TITLE, CONTENT, HIT, IP, FILENAME, STATE, POSTDATE, LASTMODIFIED" + 
				  "                  FROM BOARD" + 
				  "                 ORDER BY POSTDATE DESC) A ) B" + 
				  " WHERE B.RN BETWEEN ? AND ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, map.get("beginRecord"));
			ps.setInt(2, map.get("endRecord"));
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setIdx(rs.getLong(1));
				dto.setAuthor(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setHit(rs.getInt(5));
				dto.setIp(rs.getString(6));
				dto.setFilename(rs.getString(7));
				dto.setState(rs.getInt(8));
				dto.setPostdate(rs.getDate(9));
				dto.setLastmodified(rs.getDate(10));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	/* 5. 게시글 반환 */
	public BoardDTO selectOneBoardByIdx(long idx) {
		BoardDTO dto = null;
		try {
			con = dataSource.getConnection();
			sql = "SELECT IDX, AUTHOR, TITLE, CONTENT, HIT, IP, FILENAME, STATE, POSTDATE, LASTMODIFIED" +
				  "  FROM BOARD" +
				  " WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			rs = ps.executeQuery();
			if (rs.next()) {
				dto = new BoardDTO();
				dto.setIdx(rs.getLong(1));
				dto.setAuthor(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setHit(rs.getInt(5));
				dto.setIp(rs.getString(6));
				dto.setFilename(rs.getString(7));
				dto.setState(rs.getInt(8));
				dto.setPostdate(rs.getDate(9));
				dto.setLastmodified(rs.getDate(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return dto;
	}
	
	/* 6. 조회수 증가 */
	public void updateHit(long idx) {
		try {
			con = dataSource.getConnection();
			sql = "UPDATE BOARD SET HIT = HIT + 1 WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
	}
	
	/* 7. 검색 결과 개수 반환하기 */
	public int getFindBoardCount(Map<String, String> map) {
		int count = 0;
		try {
			con = dataSource.getConnection();
			/*
			sql = "SELECT COUNT(IDX) FROM BOARD WHERE ? LIKE ?";
			ps.setString(1, map.get("column").toString());
			ps.setString(2, map.get("query").toString());
			sql = "SELECT COUNT(IDX) FROM BOARD WHERE 'TITLE' LIKE '%글%'";
			칼럼명에 따옴표가 붙기 때문에 안 된다.
			*/
			String column = map.get("column").toString();
			String query = map.get("query").toString();
			
			sql = "SELECT COUNT(IDX) FROM BOARD WHERE " + column + " LIKE ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, query);
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return count;
	}
	
	/* 8. 검색 결과 목록 반환 */
	public List<BoardDTO> selectFindList(Map<String, String> map) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		try {
			con = dataSource.getConnection();
			String column = map.get("column").toString();
			String query = map.get("query").toString();
			int beginRecord = Integer.parseInt(map.get("beginRecord"));
			int endRecord = Integer.parseInt(map.get("endRecord"));
			sql = "SELECT B.IDX, B.AUTHOR, B.TITLE, B.CONTENT, B.HIT, B.IP, B.FILENAME, B.STATE, B.POSTDATE, B.LASTMODIFIED" + 
				  "  FROM (SELECT ROWNUM AS RN, A.IDX, A.AUTHOR, A.TITLE, A.CONTENT, A.HIT, A.IP, A.FILENAME, A.STATE, A.POSTDATE, A.LASTMODIFIED" + 
				  "          FROM (SELECT IDX, AUTHOR, TITLE, CONTENT, HIT, IP, FILENAME, STATE, POSTDATE, LASTMODIFIED" + 
				  "                  FROM BOARD" + 
				  "                 WHERE " + column + " LIKE ?" + 
				  "                 ORDER BY POSTDATE DESC) A) B" + 
				  " WHERE B.RN BETWEEN ? AND ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, query);
			ps.setInt(2, beginRecord);
			ps.setInt(3, endRecord);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setIdx(rs.getLong(1));
				dto.setAuthor(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setHit(rs.getInt(5));
				dto.setIp(rs.getString(6));
				dto.setFilename(rs.getString(7));
				dto.setState(rs.getInt(8));
				dto.setPostdate(rs.getDate(9));
				dto.setLastmodified(rs.getDate(10));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return list;
	}
	
	/* 9. 게시글 삭제 */
	public int deleteBoard(long idx) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "UPDATE BOARD SET STATE = -1 WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, idx);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/* 10. 게시글 수정 */
	public int updateBoard(BoardDTO dto) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, FILENAME = ?, LASTMODIFIED = SYSDATE WHERE IDX = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTitle());
			ps.setString(2, dto.getContent());
			ps.setString(3, dto.getFilename());
			ps.setLong(4, dto.getIdx());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}