package myproject.data.DAO;

import java.util.HashMap;
import java.util.List;

import com.andromeda.commons.dao.BaseDAO;

import myproject.data.model.FeedbackModel;

public class FeedbackDAO extends BaseDAO {

	public void feedback(FeedbackModel fbModel) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("p", fbModel);
		sqlSessionTemplate.insert("Feedback.data", params);
	}

	public List<FeedbackModel> getData() {
		List<FeedbackModel> list = sqlSessionTemplate.selectList("Feedback.getFeedbackData");
		return list;
	}

	public void update(FeedbackModel fbModel) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("p", fbModel);
		sqlSessionTemplate.update("Feedback.update", params);
	}

	public void delete(String name) {
		sqlSessionTemplate.delete("Feedback.delete", name);
	}

}
