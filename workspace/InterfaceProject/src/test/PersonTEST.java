package test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.PersonDAO;

class PersonTEST {

	int size = 0;
	
	@BeforeEach
	void setUp() throws Exception {
		// size = PersonDAO.getInstance().selectPersonList().size();
	}

	@Test
	void test() {
		// assertEquals(2, size, "등록된 사람은 2명이 아니다.");
		
		// 123456 주민번호 검색
		assertNotNull(PersonDAO.getInstance().selectPersonBySno("654321"), "123456 주민번호는 없다.");
	}

}
