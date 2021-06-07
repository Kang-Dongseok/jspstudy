package dao;

import java.util.List;

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
	
	/* 1. 회원 목록 가져오기 */
	public List<Member> selectMemberList() {
		SqlSession ss = factory.openSession();
		List<Member> list = ss.selectList("dao.member.selectMemberList");
		ss.close();
		return list;
	}
	/* 2. 회원 정보 가져오기 */
	public Member selectMemberByNo(long no) {
		SqlSession ss = factory.openSession();
		Member member = ss.selectOne("dao.member.selectMemberByNo", no);
		ss.close();
		return member;
	}
	/* 3. 회원 정보 수정하기 */
	public int updateMember(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.update("dao.member.updateMember", member);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	/* 4. 회원 삽입하기 */
	public int insertMember(Member member) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.member.insertMember", member);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	/* 5. 회원 삭제하기 */
	public int deleteMember(long no) {
		SqlSession ss = factory.openSession(false);
		int result = ss.delete("dao.member.deleteMember", no);
		if (result > 0) {
			ss.commit();
		}
		ss.close();
		return result;
	}
	/* 6. 전체 회원 수 반환하기 */
	public int getMemberCount() {
		SqlSession ss = factory.openSession();
		int count = ss.selectOne("dao.member.getMemberCount");
		ss.close();
		return count;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}