package spencer_playground;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import Dao.MemberDao;
import DaoImpl.MemberDaoImpl;
import android.bean.Member;


@WebServlet("/test_for_memberDAO")
public class test_for_memberDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final MemberDao memberDaoImple = new MemberDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = Gson.fromJson(req.getReader(), Member.class);
		int result = memberDaoImple.updateById(member);
		JsonObject resBody = new JsonObject();
		resBody.addProperty("redult", result);
		resp.getWriter().write(resBody.toString());
	}
}
