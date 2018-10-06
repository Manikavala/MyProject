package myproject.data.DAO;

import java.util.List;

import com.andromeda.commons.dao.BaseDAO;

import myproject.data.model.ReportModel;

public class ReportDAO extends BaseDAO{
	
		public List<ReportModel> getData() {
			List<ReportModel> list=sqlSessionTemplate.selectList("Report.getData");
			return list;	
		}
}
