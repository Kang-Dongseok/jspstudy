package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.MemberDTO;

public class MemberDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private static DataSource dataSource;  // 커넥셕풀 관리
	// static 필드의 초기화 : static 블록에서 처리
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/oracle");  // 톰캣용(java:comp/env), Resource이름(jdbc/oracle)
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	// singleton
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
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
	
	/* 2. 로그인 */
	/* 커넥션(Connection)은 메소드마다 열고 닫는 것이 가장 좋다. */
	public MemberDTO login(MemberDTO dto) {
		MemberDTO loginDTO = null;
		try {
			con = dataSource.getConnection();  // Connection을 가지고 있는 dataSource로부터 con을 가져온다.
			sql = "SELECT NO, ID, PW, NAME, EMAIL, REGDATE FROM MEMBER WHERE ID = ? AND PW = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			rs = ps.executeQuery();
			if (rs.next()) {
				loginDTO = new MemberDTO();
				loginDTO.setNo(rs.getLong(1));
				loginDTO.setId(rs.getString(2));
				loginDTO.setPw(rs.getString(3));
				loginDTO.setName(rs.getString(4));
				loginDTO.setEmail(rs.getString(5));
				loginDTO.setRegdate(rs.getDate(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return loginDTO;
	}
	
	/* 3. 로그인 로그 남기기 */
	public void loginLog(MemberDTO dto) {
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO MEMBER_LOG VALUES (MEMBER_LOG_SEQ.NEXTVAL, ?, SYSDATE, NULL)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
	}
	
	/* 4. 로그아웃 로그 남기기 */
	public void logoutLog(String id) {
		try {
			con = dataSource.getConnection();
			sql = "UPDATE MEMBER_LOG SET LOGOUT = SYSDATE WHERE ID = ? AND LOGOUT IS NULL";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
	}
	
	/* 5. 회원가입 */
	public int join(MemberDTO dto) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "INSERT INTO MEMBER VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getEmail());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/* 6. 비밀번호 변경 */
	public int updatePw(MemberDTO dto) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "UPDATE MEMBER SET PW = ? WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getPw());
			ps.setLong(2, dto.getNo());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/* 7. 회원정보 변경 */
	public int updateMember(MemberDTO dto) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "UPDATE MEMBER SET NAME = ?, EMAIL = ? WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getEmail());
			ps.setLong(3, dto.getNo());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/* 8. 회원 탈퇴(삭제) */
	public int deleteMember(long no) {
		int result = 0;
		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM MEMBER WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		return result;
	}
	
	/* 9. 회원 접속 정보 삭제 */
	public void deleteMemberLog(String id) {
		try {
			con = dataSource.getConnection();
			sql = "DELETE FROM MEMBER_LOG WHERE ID = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
	}
	
}

