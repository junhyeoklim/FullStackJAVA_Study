package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.command.Command;
import board.command.InsertBoardCommand;
import board.command.ListBoardCommand;
import board.command.SearchBoardCommand;
import board.command.ViewBoardCommand;


@WebServlet("*.board")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String ADMIN_VIEW = "/Admin_View";
    private static final String USER_VIEW = "/User_View";
    
    public BoardFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	public void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String commandName = request.getServletPath();
		String viewPage = null;
		Command command = null;	
		
		if(commandName.equals("/BoardList.board")) {
			command = new ListBoardCommand();
			command.excute(request, response);
			viewPage = USER_VIEW+"/BoardListView.jsp";
		}
		else if(commandName.equals("/SubmitPost.board")) {
			command = new InsertBoardCommand();
			command.excute(request, response);
			response.sendRedirect(request.getContextPath() + USER_VIEW + "/BoardList.board");
            return;
		}
		else if(commandName.equals("/Newboard.board")) {
			viewPage = USER_VIEW+"/BoardCreateView.jsp";
		}
		else if (commandName.equals("/Search.board")) {
            command = new SearchBoardCommand();
            command.excute(request, response);
            viewPage = USER_VIEW + "/BoardListView.jsp";
        }
		else if(commandName.equals("/view.board")) {
			command = new ViewBoardCommand();
			command.excute(request, response);
			viewPage = USER_VIEW + "/BoardView.jsp";
		}

        if (viewPage != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
            dispatcher.forward(request, response);
        }
	}
}
