package myproject.data.DAO;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.andromeda.commons.dao.BaseDAO;

import myproject.data.model.LoginModel;
@Repository
public class LoginDAO extends BaseDAO{

	public LoginModel login(LoginModel loginModel) {
		System.out.println("--------------------DAO--------------" +loginModel.getUserName());
		HashMap<String, LoginModel> params = new HashMap<String, LoginModel>();
		params.put("p", loginModel);
		LoginModel lm=sqlSessionTemplate.selectOne("login.validUser", params);
		System.out.println("================="+lm);
		return lm;
	}
	
	public Integer loggedin(LoginModel loginModel) {
		System.out.println("--------------------DAO--------------" +loginModel.getUserName());
		HashMap<String, LoginModel> params = new HashMap<String, LoginModel>();
		params.put("p", loginModel);
		Integer lm=sqlSessionTemplate.selectOne("login.loggedin", params);
		System.out.println("================="+lm);
		return lm;
	}
}