package in.sg.hackerearth.challenge.kailash.DAO;

import in.sg.hackerearth.challenge.kailash.util.EthnicGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class DBImportDAO {

	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void initDB(ArrayList<HashMap<String, String>> list)
			throws SQLException {
		Connection con = dataSource.getConnection();
		con.setAutoCommit(false);
		String sql = "INSERT into member(id,status,race,weight,height,is_veg) VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		System.out.println(list.size());
		for (HashMap<String, String> m : list) {
			String id = m.get("id");
			String status = m.get("status");
			EthnicGroup race = EthnicGroup.get(Integer.parseInt(m.get("race")));
			String weight = m.get("weight");
			String height = m.get("height");
			String is_veg = m.get("is_veg");

			int w = (Integer.parseInt(weight) / 1000);
			String we=Integer.toString(w);

			pstmt.setString(1, id);
			pstmt.setString(2, status);
			pstmt.setString(3, race.name());
			pstmt.setString(4, we);
			pstmt.setString(5, height);
			pstmt.setString(6, is_veg);

			pstmt.addBatch();

		}

		pstmt.executeBatch();
		con.commit();

	}
}
