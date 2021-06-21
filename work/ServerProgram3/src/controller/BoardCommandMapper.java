package controller;

import command.BoardCommand;
import command.DeleteBoardCommand;
import command.InsertBoardCommand;
import command.InsertBoardPageCommand;
import command.InsertReplyCommand;
import command.SelectBoardListCommand;
import command.SelectOneBoardCommand;

public class BoardCommandMapper {

	private static BoardCommandMapper instance = new BoardCommandMapper();
	private BoardCommandMapper() {}
	public static BoardCommandMapper getInstance() {
		if (instance == null) {
			instance = new BoardCommandMapper();
		}
		return instance;
	}
	
	public BoardCommand getCommand(String cmd) {
		BoardCommand command = null;
		switch (cmd) {
		
		case "selectBoardList.do":
			command = new SelectBoardListCommand();
			break;
		case "goInsertBoard.do":
			command = new InsertBoardPageCommand();
			break;
		case "insertBoard.do":
			command = new InsertBoardCommand();
			break;
		case "selectOneBoard.do":
			command = new SelectOneBoardCommand();
			break;
		case "insertReply.do":
			command = new InsertReplyCommand();
			break;
		case "deleteBoard.do":
			command = new DeleteBoardCommand();
			break;
			
		}
		return command;
	}
	
	
}