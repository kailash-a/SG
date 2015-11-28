package in.sg.hackerearth.challenge.kailash.controllers;

import java.sql.SQLException;

import in.sg.hackerearth.challenge.kailash.services.MemberDetails;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class DBController {
	
	@Autowired
	MemberDetails memberDetails;
	
	
	public String getAllMembers(ServletRequest request,Model model) throws SQLException{
		model.addAttribute("members",memberDetails.getAllMembers());
		return "details";
	}
}
