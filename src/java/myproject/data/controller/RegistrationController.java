package myproject.data.controller;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;

import myproject.data.model.RegisterModel;
import myproject.data.service.RegitrationService;

@RestController
@RequestMapping("register")
public class RegistrationController {

	@Autowired
	private RegitrationService registrationService;
	Response response = new Response();

	@ResponseBody
	@RequestMapping(value = "user", method = { RequestMethod.POST })
	public Response register(@RequestBody RegisterModel registerModel) {
		if (Pattern.matches("[0-9]{10}", registerModel.getMobileNumber().toString())) {
			return registrationService.register(registerModel);
			
		} else {
			registerModel.setMobileNumber(null);
			response.setSuccessful(false);
			response.setResponseObject(registerModel);
		}
		return response;
	}
	@ResponseBody
	@RequestMapping(value = "checkMobile", method = { RequestMethod.POST })
	public Response checkMobile(@RequestBody RegisterModel registerModel) {
		if(registerModel.getTargetName().equals("mobile")){
			if (Pattern.matches("[0-9]{10}", registerModel.getMobileNumber().toString())) {
				response.setSuccessful(true);
				response.setResponseObject(registerModel);
			} else {
				response.setSuccessful(false);
				response.setResponseObject(registerModel);
			}
		}else if(registerModel.getTargetName().equals("email")){
			if (Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$", registerModel.getEmail().toString())) {
				response.setSuccessful(true);
				response.setResponseObject(registerModel);
			} else {
				response.setSuccessful(false);
				response.setResponseObject(registerModel);
			}
		}
		return response;
	}
	
	@ResponseBody
	@RequestMapping(value = "getAllUsers", method = { RequestMethod.POST })
	public Response getAllUsers() {
		return registrationService.getAllUsers();
	}

	@ResponseBody
	@RequestMapping(value = "update", method = { RequestMethod.POST })
	public Response update(@RequestBody RegisterModel registerModel) {
		return registrationService.update(registerModel);
	}

	@ResponseBody
	@RequestMapping(value = "deleteRegData", method = { RequestMethod.POST })
	public Response deleteData(@RequestBody String username) {
		System.out.println("=============>>>" + username);
		return registrationService.deleteData(username);
	}

}
