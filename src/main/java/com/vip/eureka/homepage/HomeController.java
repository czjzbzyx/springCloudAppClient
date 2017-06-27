/**
 * 
 */
package com.vip.eureka.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author fang08.li
 *
 */

@Controller
public class HomeController {

	// work well (-1) do not need to add any method except put index.html to
	// /src/main/resources/static/index.html

	// work well (0)
	@GetMapping("/")
	public ModelAndView toIndex() {
		ModelAndView mav = new ModelAndView("forward:index.html");
		System.out.println("access come in");
		return mav;
	}

	// work well (1)
	// @GetMapping("/")
	// public String toIndex(){
	//
	// return "forward:index.html";
	// }

	// not work (2)
	// @GetMapping("/")
	// public String toIndex2(){
	//
	// return "index";
	// }
	//

	// @GetMapping("/") (3)
	// public ModelAndView toIndex2(){
	//
	// ModelAndView mav=new ModelAndView("index");
	//
	// return mav;
	//
	// }
}
