package myproject.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;

import myproject.data.DAO.RegisterDAO;
import myproject.data.model.RegisterModel;

@Service
public class RegitrationService {

	@Autowired
	private RegisterDAO registerDAO;

	Response response = new Response();

	public Response register(RegisterModel registerModel) {
		response.setSuccessful(false);
		registerDAO.register(registerModel);
		response.setSuccessful(true);
		return response;
	}

	public Response getAllUsers() {
		response.setSuccessful(false);
		List<RegisterModel> list = registerDAO.getAllUsers();
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}

	public Response update(RegisterModel registerModel) {
		response.setSuccessful(false);
		registerDAO.update(registerModel);
		response.setSuccessful(true);
		return response;
	}

	public Response deleteData(String username) {
		response.setSuccessful(false);
		registerDAO.deleteData(username);
		response.setSuccessful(true);
		return response;
	}

}
