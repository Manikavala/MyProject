package myproject.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;

import myproject.data.model.LoginModel;
import myproject.data.service.LoginService;

@RestController
@RequestMapping("login")
public class LoginController {
@Autowired
	private LoginService loginService;
// return the Object as response using @ResponseBody annotation
	@ResponseBody
	@RequestMapping(value="user", method={RequestMethod.POST})
	public Response login(@RequestBody LoginModel loginmodel){
		System.out.println("=========================Cntroller==============");
		return loginService.login(loginmodel);
	}
	
	@ResponseBody
	@RequestMapping(value="loggedin", method={RequestMethod.POST})
	public Response loggedin(@RequestBody LoginModel loginmodel){
		System.out.println("=========================Cntroller==============");
		return loginService.loggedin(loginmodel);
	}
}