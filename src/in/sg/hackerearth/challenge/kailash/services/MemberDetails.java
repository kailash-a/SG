package in.sg.hackerearth.challenge.kailash.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sg.hackerearth.challenge.kailash.DAO.MemberDetailsDAO;
import in.sg.hackerearth.challenge.kailash.beans.DataBean;

@Service
public class MemberDetails implements MemberDetailsService {

	@Autowired
	MemberDetailsDAO memberDAO;
	
	@Override
	public List<DataBean> getAllMembers() throws SQLException {
		return memberDAO.getAllMembers(); 
	}

	@Override
	public List<DataBean> SearchDB(String criteria) throws Exception {
		return memberDAO.searchDB(criteria);
	}

}
