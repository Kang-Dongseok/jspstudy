package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.StudentDTO;
import mybatis.config.DBService;

public class StudentDAO {

	private SqlSessionFactory factory;
	private static StudentDAO instance;
	
	private StudentDAO() {
		factory = DBService.getInstance().getFactory();
	}
	
	public static StudentDAO getInstance() {
		if (instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}
	
	public List<StudentDTO> selectStudentList() {
		SqlSession ss = factory.openSession();
		List<StudentDTO> list = ss.selectList("dao.student.selectStudentList");
		ss.close();
		return list;
	}
	
	public int insertStudent(StudentDTO dto) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.student.insertStudent", dto);
		if (result > 0) ss.commit();
		ss.close();
		return result;
	}
	
	public List<StudentDTO> top3StudentList() {
		SqlSession ss = factory.openSession();
		List<StudentDTO> list = ss.selectList("dao.student.top3StudentList");
		ss.close();
		return list;
	}
	
	
	
	
	
	
	
	
	
}