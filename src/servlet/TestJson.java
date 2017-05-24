package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TestJson extends HttpServlet {

	public TestJson() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			String url = "jdbc:postgresql://192.168.1.189:5432/stone";
			String user="stone";
			String password="stone";
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url,user,password);
			String sql = "select * from web_user ";
			Statement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(rs);
			/* 把取出来的数据 转换出json对象格式 */
			JSONArray ja = new JSONArray();
			JSONObject jo = new JSONObject();
			while (rs.next()) {
				jo.put("用户名", rs.getString("username"));
				jo.put("手机", rs.getString("mobile"));
				ja.add(jo);
			}
			out.println(ja);

			rs.close();
			stmt.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}

}
