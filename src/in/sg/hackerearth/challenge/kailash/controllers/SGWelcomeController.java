package in.sg.hackerearth.challenge.kailash.controllers;

import in.sg.hackerearth.challenge.kailash.services.MemberDetails;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/welcome.htm")
public class SGWelcomeController {

	@Autowired
	MemberDetails memberDetails;
	
	@RequestMapping(value = "/welcome.htm",method = RequestMethod.GET)
	public String execute(ServletRequest request,Model model) throws SQLException{
		model.addAttribute("members",memberDetails.getAllMembers());
		model.addAttribute("totalCount", memberDetails.getAllMembers().size());
		String date =new SimpleDateFormat("hh:mm a").format(new Date());
		if(date.contains("AM")){
			model.addAttribute("greeting", "Good Morning !");
		}else{
			model.addAttribute("greeting", "Good Evening !");
		}
		
		return "welcome";
	}
}
