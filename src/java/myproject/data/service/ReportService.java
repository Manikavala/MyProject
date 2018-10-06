package myproject.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andromeda.commons.model.Response;

import myproject.data.DAO.ReportDAO;
import myproject.data.model.ReportModel;

@Service
public class ReportService {
@Autowired
private ReportDAO reportDAO;
Response response=new Response();
	public Response report() {
		response.setSuccessful(false);
		List<ReportModel> list=reportDAO.getData();
		response.setSuccessful(true);
		response.setResponseObject(list);
		return response;
	}

}
