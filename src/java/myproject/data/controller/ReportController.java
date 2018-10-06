package myproject.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;

import myproject.data.service.ReportService;

@RestController
@RequestMapping("report")
public class ReportController {
@Autowired
private ReportService reportService;

@ResponseBody
@RequestMapping(value="getData", method={RequestMethod.GET,RequestMethod.POST})
public Response report(){
	return reportService.report();
	
}
}