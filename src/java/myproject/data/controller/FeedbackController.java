package myproject.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.andromeda.commons.model.Response;

import myproject.data.model.FeedbackModel;
import myproject.data.service.FeedbackService;

@RestController	//@Cntroller + @ResponceBody
@RequestMapping("feedback")
public class FeedbackController {
	@Autowired		//Context:annotation-config   --will externally support this annotation
	private FeedbackService fbService;

	@ResponseBody //JSON to Object		@RequestBody--> Object to JSON
	@RequestMapping(value = "user", method = { RequestMethod.POST })
	public Response feedback(@RequestBody FeedbackModel fbModel) {
		return fbService.feedback(fbModel);

	}

	@ResponseBody
	@RequestMapping(value = "getFeedbackData", method = { RequestMethod.POST })
	public Response getData() {
		return fbService.getData();

	}

	@ResponseBody
	@RequestMapping(value = "updateFb", method = { RequestMethod.POST })
	public Response update(@RequestBody FeedbackModel fbModel) {
		return fbService.update(fbModel);
	}
	
	@ResponseBody
	@RequestMapping(value="delete",method={RequestMethod.POST})
	public Response delete(@RequestBody String name){
		return fbService.delete(name);
	}
}



















