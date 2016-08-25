package com.sumit.myapp;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sumit.model.User;
import com.sumit.model.UserInfo;
//import com.sumit.service.UserInfoService;
import com.sumit.service.UserService;

@Controller

//@RequestMapping(value = "/nonSecured")
public class UserController {

	@Autowired
	//private UserInfoService detailService;
	UserService userService;
	

	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewShop(@ModelAttribute @Valid User user,@Valid UserInfo userInfo,
			BindingResult result, final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("common");

		ModelAndView mav = new ModelAndView();
		
		//userService.create(user);
		
		return mav;
	}

	

	
}
