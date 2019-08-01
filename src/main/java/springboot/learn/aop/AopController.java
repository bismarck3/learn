package springboot.learn.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class AopController {


	@Autowired
	private AopService aopService;
	
	@RequestMapping("/")
	@ResponseBody
	public Object getTest() {
		System.out.println(aopService.getString1());
		System.out.println("-------------------------------");
		System.out.println(aopService.getString2());
		System.out.println("-------------------------------");
		System.out.println(aopService.String3());
		return "ok";
	}
}
