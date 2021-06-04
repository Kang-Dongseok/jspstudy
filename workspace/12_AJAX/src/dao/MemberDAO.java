package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.Member;
import mybatis.config.DBService;

public class MemberDAO {

	private SqlSessionFactory factory;
	private static MemberDAO instance;
	
	private MemberDAO() {
		factory = DBService.getInstance().getFactory();
	}
	
	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}
	
	public Member login(Member member) {
		SqlSession ss = factory.openSession();
		Member loginUser = ss.selectOne("dao.member.login", member);
		ss.close();
		return loginUser;
	}
	
	public boolean idCheck(String id) {
		SqlSession ss = factory.openSession();
		Member member = ss.selectOne("dao.member.idCheck", id);
		ss.close();
		return member == null;  // 일치하는 id를 가진 member가 없다 == 사용 가능한 아이디
	}
	
	public int join(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.member.join", member);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int updatePw(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.member.updatePw", member);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int updateMember(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.member.updateMember", member);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
	public int deleteMember(long no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.member.deleteMember", no);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	
}