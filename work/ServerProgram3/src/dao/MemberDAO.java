package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import db.DBConnector;
import dto.MemberDTO;

public class MemberDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {
		con = DBConnector.getInstance().getConnection();
	}
	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	
	/* 1. 로그인 */
	public MemberDTO login(MemberDTO dto) {
		MemberDTO loginDTO = null;
		try {
			sql = "SELECT NO, ID, NAME, GRADE, POINT FROM MEMBER_TABLE WHERE ID = ? AND NAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getName());
			rs = ps.executeQuery();
			if (rs.next()) {
				loginDTO = new MemberDTO();
				loginDTO.setNo(rs.getLong(1));
				loginDTO.setId(rs.getString(2));
				loginDTO.setName(rs.getString(3));
				loginDTO.setGrade(rs.getString(4));
				loginDTO.setPoint(rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return loginDTO;
	}
	
	
	/* 2. 회원가입 */
	public int join(String id, String name) {
		int result = 0;
		try {
			sql = "INSERT INTO MEMBER_TABLE VALUES (MEMBER_SEQ.NEXTVAL, ?, ?, 'bronze', 1000)";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return result;
	}
	
	
	/* 3. 회원 탈퇴 */
	public int deleteMember(long no) {
		int result = 0;
		try {
			sql = "DELETE FROM MEMBER_TABLE WHERE NO = ?";
			ps = con.prepareStatement(sql);
			ps.setLong(1, no);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.getInstance().close(ps, rs);
		}
		return result;
	}
	
}

