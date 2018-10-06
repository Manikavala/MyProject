package myproject.data.DAO;
import java.util.HashMap;
import java.util.List;

import com.andromeda.commons.dao.BaseDAO;

import myproject.data.model.RegisterModel;
public class RegisterDAO extends BaseDAO{

	public void register(RegisterModel registerModel) {
		System.out.println("--------------------DAO--------------" +registerModel.getUsername());
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("p", registerModel);
		sqlSessionTemplate.insert("Register.Reg", params);	
	}

	public List<RegisterModel> getAllUsers() {
		
		List<RegisterModel> list=sqlSessionTemplate.selectList("Register.getAllUsers");
		return list;	
	}

	public void update(RegisterModel registerModel) {
		HashMap<String, Object> params = new HashMap<String,Object>();
		params.put("p", registerModel);
		sqlSessionTemplate.update("Register.updateRegData", params);
		
	}

	public void deleteData(String username) {
		sqlSessionTemplate.delete("Register.deleteRegData", username);
	}

	
}
