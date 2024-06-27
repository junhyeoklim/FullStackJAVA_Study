package company.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import company.command.ChartCommand;
import company.command.Command;
import company.command.InsertCommand;
import company.command.CompanyListCommand;
import company.command.LoginCommand;
import company.command.SearchListCommand;
import company.command.UpdateCommand;

@WebServlet("*.do")
public class CompanyFrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String ADMIN_VIEW = "/Admin_View";
    private static final String USER_VIEW = "/User_View";

    public CompanyFrontController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        String commandName = request.getServletPath();
        String viewPage = null;
        Command command = null;

        if (isListCommand(commandName)) {
            command = handleListCommand(request, response);
            viewPage = getViewPageForList(commandName);
        } 
        else if (isSearchCommand(commandName)) {
            command = new SearchListCommand();
            command.excute(request, response);
            viewPage = getViewPageForList(commandName);
        } 
        else if (isRegisterCommand(commandName)) {
            viewPage = getViewPageForRegister(commandName);
        } 
        else if (isRegisterOKCommand(commandName)) {
            command = new InsertCommand();
            command.excute(request, response);
            redirectToListPage(request, response, commandName);
            return;
        } 
        else if (commandName.equals("/login.do")) {
            viewPage = "LoginUI.jsp";
        } 
        else if (commandName.equals("/loginOK.do")) {
            command = new LoginCommand();
            command.excute(request, response);
            response.sendRedirect(request.getContextPath() + "/AlertView/alert.jsp");
            return;
        } 
        else if (isModifyCommand(commandName)) {
            command = new SearchListCommand();
            command.excute(request, response);
            viewPage = getViewPageForModify(commandName);
        } 
        else if (isModifyOKCommand(commandName)) {
            command = new UpdateCommand();
            command.excute(request, response);
            redirectToListPage(request, response, commandName);
            return;
        } 
        else if (commandName.equals(USER_VIEW + "/chart.do")) {
            command = new ChartCommand();
            command.excute(request, response);
            viewPage = "../Admin_View/chartEX.jsp";
        } 
        else if (commandName.equals(USER_VIEW + "/newboard.do")) {
            viewPage = "BoardCreateView.jsp";
        } 
        else if (isLogoutCommand(commandName)) {
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/LoginUI.jsp");
            return;
        }

        if (viewPage != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
            dispatcher.forward(request, response);
        }
    }

    private boolean isListCommand(String commandName) {
        return commandName.equals(ADMIN_VIEW + "/list.do") || commandName.equals(USER_VIEW + "/list.do");
    }

    private boolean isSearchCommand(String commandName) {
        return commandName.equals(ADMIN_VIEW + "/search.do") || commandName.equals(USER_VIEW + "/search.do");
    }

    private boolean isRegisterCommand(String commandName) {
        return commandName.equals(ADMIN_VIEW + "/register.do") || commandName.equals(USER_VIEW + "/register.do");
    }

    private boolean isRegisterOKCommand(String commandName) {
        return commandName.equals(ADMIN_VIEW + "/registerOK.do") || commandName.equals(USER_VIEW + "/registerOK.do");
    }

    private boolean isModifyCommand(String commandName) {
        return commandName.equals(ADMIN_VIEW + "/modify.do") || commandName.equals(USER_VIEW + "/modify.do");
    }

    private boolean isModifyOKCommand(String commandName) {
        return commandName.equals(ADMIN_VIEW + "/modifyOK.do") || commandName.equals(USER_VIEW + "/modifyOK.do");
    }

    private boolean isLogoutCommand(String commandName) {
        return commandName.equals(ADMIN_VIEW + "/logout.do") || commandName.equals(USER_VIEW + "/logout.do");
    }

    private Command handleListCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String select = request.getParameter("select-box");
        String search = request.getParameter("search");

        if (select != null && search != null && !search.isEmpty()) {
            Command command = new SearchListCommand();
            command.excute(request, response);
            return command;
        } else {
            Command command = new CompanyListCommand();
            command.excute(request, response);
            return command;
        }
    }

    private String getViewPageForList(String commandName) {
        if (commandName.equals(ADMIN_VIEW + "/list.do")) {
            return "CompanyList.jsp";
        } else {
            return "../Admin_View/CompanyList.jsp";
        }
    }

    private String getViewPageForRegister(String commandName) {
        if (commandName.equals(ADMIN_VIEW + "/register.do")) {
            return "RegisterUI.jsp";
        } else {
            return "../Admin_View/RegisterUI.jsp";
        }
    }

    private String getViewPageForModify(String commandName) {
        if (commandName.equals(ADMIN_VIEW + "/modify.do")) {
            return "ModifyUI.jsp";
        } else {
            return "../Admin_View/ModifyUI.jsp";
        }
    }

    private void redirectToListPage(HttpServletRequest request, HttpServletResponse response, String commandName) throws IOException {
        if (commandName.equals(ADMIN_VIEW + "/registerOK.do") || commandName.equals(ADMIN_VIEW + "/modifyOK.do")) {
            response.sendRedirect(request.getContextPath() + ADMIN_VIEW + "/list.do");
        } else {
            response.sendRedirect(request.getContextPath() + USER_VIEW + "/list.do");
        }
    }


}
