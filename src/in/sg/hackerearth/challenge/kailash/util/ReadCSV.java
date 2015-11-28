package in.sg.hackerearth.challenge.kailash.util;

import in.sg.hackerearth.challenge.kailash.DAO.DBImportDAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

@Component
public class ReadCSV {

	static DBImportDAO dbImport;

	public static void setDbImport(DBImportDAO dbImport) {
		ReadCSV.dbImport = dbImport;
	}

	static ServletContext servletContext;

	public static void readCSV(BufferedReader breader) throws SQLException {

		BufferedReader br = null;
		ArrayList<HashMap<String, String>> memberDetailsList = null;
		try {

			br = breader;
			CSVReader reader = new CSVReader(br);
			memberDetailsList = new ArrayList<HashMap<String, String>>();
			String[] member;
			while ((member = reader.readNext()) != null) {
				if (member != null) {
					HashMap<String, String> map = new HashMap<String, String>();
					map.put("id", member[0]);
					map.put("status", member[1]);
					map.put("race", member[2]);
					map.put("weight", member[3]);
					map.put("height", member[4]);
					map.put("is_veg", member[5]);
					memberDetailsList.add(map);
				}
			}

			initDB(memberDetailsList);
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String initDB(ArrayList<HashMap<String, String>> list)
			throws SQLException {
		dbImport.initDB(list);
		return "";

	}
}
