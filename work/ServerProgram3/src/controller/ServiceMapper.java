package controller;

import command.JoinCommand;
import command.LoginCommand;
import command.LogoutCommand;
import command.MemberService;

public class ServiceMapper {

	private static ServiceMapper instance = new ServiceMapper();
	private ServiceMapper() {}
	public static ServiceMapper getInstance() {
		if (instance == null) {
			instance = new ServiceMapper();
		}
		return instance;
	}
	
	// Command를 반환하는 메소드
	// 모든 Command는 인터페이스 MemberCommand를 구현하는 클래스이므로,
	// 모든 Command는 MemberCommand 타입을 가진다.
	public MemberService getCommand(String cmd) {
		MemberService command = null;
		switch (cmd) {
		case "login.do":
			command = new LoginCommand();
			break;
		case "logout.do":
			command = new LogoutCommand();
			break;
		case "join.do":
			command = new JoinCommand();
			break;
		case "delete.do":
			command = new DeleteCommand();
			break;
		}
		return command;
	}
	
	
}