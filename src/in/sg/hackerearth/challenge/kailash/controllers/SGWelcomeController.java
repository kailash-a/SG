package in.sg.hackerearth.challenge.kailash.controllers;

import in.sg.hackerearth.challenge.kailash.services.MemberDetails;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;

@Controller
public class SGWelcomeController {

	@Autowired
	MemberDetails memberDetails;

	@RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
	public String execute(ServletRequest request, Model model)
			throws SQLException {
		model.addAttribute("members",
				memberDetails.getAllMembers().subList(1, 50));
		model.addAttribute("totalCount", memberDetails.getAllMembers().size());
		String date = new SimpleDateFormat("hh:mm a").format(new Date());
		if (date.contains("AM")) {
			model.addAttribute("greeting", "Good Morning !");
		} else {
			model.addAttribute("greeting", "Good Evening !");
		}

		return "welcome";
	}

	@RequestMapping(value = "/search.htm", method = RequestMethod.GET)
	public void search(ServletRequest request, ServletResponse response,
			Model model) throws Exception {
		String criteria = request.getParameter("search");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		out.print(gson.toJson(memberDetails.SearchDB(criteria)));

	}
}
