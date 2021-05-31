package controller;

import command.board.BoardCommand;
import command.board.InsertBoardCommand;
import command.board.InsertBoardPageCommand;
import command.board.SelectListBoardCommand;

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
		case "selectListBoardPage.b":
			command = new SelectListBoardCommand();
			break;
		case "insertBoardPage.b":
			command = new InsertBoardPageCommand();
			break;
		case "insertBoard.b":
			command = new InsertBoardCommand();
			break;
		}
		return command;
	}
	
}