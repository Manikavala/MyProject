package myproject.data.service;

import java.util.List;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.andromeda.commons.model.Response;
import myproject.data.DAO.FeedbackDAO;
import myproject.data.model.FeedbackModel;

@Service
public class FeedbackService {
	@Autowired
	private FeedbackDAO fbDAO;
	Response response = new Response();

	public Response feedback(FeedbackModel fbModel) {
		if (Pattern.matches("[a-z]{10}", fbModel.getName())) {
			fbDAO.feedback(fbModel);
			response.setSuccessful(true);
		} else {
			fbModel.setName(null);
			response.setSuccessful(false);
			response.setResponseObject(fbModel);
		}

		return response;
	}

	public Response getData() {
		response.setSuccessful(false);
		List<FeedbackModel> list = fbDAO.getData();
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}

	public Response update(FeedbackModel fbModel) {
		response.setSuccessful(false);
		fbDAO.update(fbModel);
		response.setSuccessful(true);
		return response;
	}

	public Response delete(String name) {
		response.setSuccessful(false);
		fbDAO.delete(name);
		response.setSuccessful(true);
		return response;
	}

}
