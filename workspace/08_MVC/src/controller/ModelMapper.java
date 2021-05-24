package controller;

import model.HomeCommand;
import model.ResultCommand;

public class ModelMapper {

	private static ModelMapper mapper = new ModelMapper();
	private ModelMapper() {}
	public static ModelMapper getInstance() {
		if (mapper == null) {
			mapper = new ModelMapper();
		}
		return mapper;
	}
	
	public HomeCommand getModel(String cmd) {
		HomeCommand command = null;
		switch(cmd) {
		case "inquiry.do":
			command = new ResultCommand();
			break;
		}
		return command;
	}
}
