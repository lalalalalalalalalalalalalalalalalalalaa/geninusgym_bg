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

import Dao.NotifyDao;
import Dao.SportBigIdDao;
import DaoImpl.NotifyDaoImpl;
import DaoImpl.SportBigIdDaoImpl;
import android.bean.Notify;
import android.bean.SportBigId;

@WebServlet("/Test_for_insert")
public class Test_for_insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Gson Gson = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();
	private static final NotifyDao notifyDaoImpl = new NotifyDaoImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Notify notify = Gson.fromJson(req.getReader(), Notify.class);
		//String id = req.getReader().readLine();
		int result = notifyDaoImpl.insert(notify);
		JsonObject resBody = new JsonObject();
		resBody.addProperty("result", result);
		resp.getWriter().write(resBody.toString());
	}
}
