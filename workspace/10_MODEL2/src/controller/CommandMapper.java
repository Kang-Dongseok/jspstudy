package controller;

import command.member.LoginPageCommand;
import command.member.MemberCommand;
import command.member.joinPageCommand;

public class CommandMapper {

	private static CommandMapper instance = new CommandMapper();
	private CommandMapper() {}
	public static CommandMapper getInstance() {
		if (instance == null) {
			instance = new CommandMapper();
		}
		return instance;
	}
	
	// Command를 반환하는 메소드
	// 모든 Command는 인터페이스 MemberCommand를 구현하는 클래스이므로,
	// 모든 Command는 MemberCommand 타입을 가진다.
	public MemberCommand getCommand(String cmd) {
		MemberCommand command = null;
		switch (cmd) {
		case "loginPage.m":
			command = new LoginPageCommand();
			break;
		case "joinPage.m":
			command = new joinPageCommand();
			break;
		}
		return command;
	}
	
}
