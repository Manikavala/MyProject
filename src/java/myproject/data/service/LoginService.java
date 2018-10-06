package myproject.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;

import myproject.data.DAO.LoginDAO;
import myproject.data.model.LoginModel;

@Service
public class LoginService {

	@Autowired
	private LoginDAO loginDAO;

	Response response = new Response();

	public Response login(LoginModel loginModel) {
		response.setSuccessful(false);
		LoginModel login = loginDAO.login(loginModel);

		if (login != null && login.getUserName() != null) {
			response.setSuccessful(true);
			response.setResponseObject(login);
		} else {
			response.setSuccessful(false);
		}
		return response;
	}

	public Response loggedin(LoginModel loginmodel) {
		response.setSuccessful(false);
		Integer i = loginDAO.loggedin(loginmodel);
		if (i != 0) {
			response.setSuccessful(true);
		} else {
			response.setSuccessful(false);
		}
		return response;

	}
}