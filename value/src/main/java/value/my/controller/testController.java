package value.my.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import value.my.service.*;

@Controller
public class testController {
	
	private final testService testService;
	
	@Autowired
	public testController(testService testService) {
		this.testService = testService;
	}

	@GetMapping("/test")
	public String dbTest(Model model) {
		
		List<Map<?,?>> list = testService.getList();
			
		model.addAttribute("list",list);
			
		return "test";
	}
}
