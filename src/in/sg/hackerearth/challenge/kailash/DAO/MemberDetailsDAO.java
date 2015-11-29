package in.sg.hackerearth.challenge.kailash.DAO;

import in.sg.hackerearth.challenge.kailash.beans.DataBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberDetailsDAO {

	DataSource dataSource;
	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Autowired
	DataBean dataBean;
	
	public List<DataBean> getAllMembers() throws SQLException{
		
		List<DataBean> lst=new ArrayList();
		Connection con=dataSource.getConnection();
		String sql="select * from member";
		ResultSet rs=con.createStatement().executeQuery(sql);
		while(rs.next()){
			dataBean=new DataBean();
			dataBean.setId(rs.getString("id"));
			dataBean.setStatus(rs.getString("status"));
			dataBean.setRace(rs.getString("race"));
			dataBean.setWeight(rs.getString("weight"));
			dataBean.setHeight(rs.getString("height"));
			dataBean.setIs_veg(rs.getString("is_veg"));
			lst.add(dataBean);
		}
		
		return lst;
	}
	
	public List<DataBean> searchDB(String criteria) throws SQLException{
		List<DataBean> lst=new ArrayList();
		Connection con=dataSource.getConnection();
		String sql="select * from member where status like ? OR race like ?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, "%"+criteria+"%");
		pstmt.setString(2,"%"+criteria+"%");
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			dataBean=new DataBean();
			dataBean.setId(rs.getString("id"));
			dataBean.setStatus(rs.getString("status"));
			dataBean.setRace(rs.getString("race"));
			dataBean.setWeight(rs.getString("weight"));
			dataBean.setHeight(rs.getString("height"));
			dataBean.setIs_veg(rs.getString("is_veg"));
			lst.add(dataBean);
		}
		
		return lst;
	}

}
