package sevlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xamp.VocabularyItem;

@WebServlet("/project/DaySelectionServlet")
public class DaySelectionServlet extends HttpServlet {
	public DaySelectionServlet(){
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Search.jsp");
		dispatcher.forward(request, response);
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Nhận dữ liệu từ form
        String selectedDay = request.getParameter("selectedDay");
        System.out.println("DaySelectionServlet received selected day: " + selectedDay);
        // Tạo danh sách từ vựng tương ứng với ngày đã chọn
        List<VocabularyItem> vocabularyList = createVocabularyList(selectedDay);

        // Truyền danh sách từ vựng đến JSP
        request.setAttribute("vocabularyList", vocabularyList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/VocabularyQuiz.jsp");
        dispatcher.forward(request, response);
    }

    private List<VocabularyItem> createVocabularyList(String selectedDay) {
        // Tạo danh sách từ vựng tương ứng với ngày đã chọn
        // Dựa vào selectedDay, bạn có thể quyết định sử dụng danh sách từ vựng nào

        // Ví dụ cho ngày "月"
        if ("月".equals(selectedDay)) {
            List<VocabularyItem> vocabularyList = new ArrayList<>();
            vocabularyList.add(new VocabularyItem("メソッド", "Method"));
            vocabularyList.add(new VocabularyItem("変数", "Variable"));
            // Thêm các từ vựng khác
            return vocabularyList;
        }

        // Thêm các điều kiện khác cho các ngày khác
        // ...

        return new ArrayList<>();  // Trả về danh sách trống nếu không có ngày nào khớp
    }
}
