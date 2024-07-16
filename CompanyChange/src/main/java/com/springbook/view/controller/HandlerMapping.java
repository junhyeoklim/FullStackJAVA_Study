package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.DeleteBoardController;
import com.springbook.view.board.DeleteCommentController;
import com.springbook.view.board.IncreaseViewCountController;
import com.springbook.view.board.InsertBoardController;
import com.springbook.view.board.InsertCommentController;
import com.springbook.view.board.ListBoardController;
import com.springbook.view.board.ModifyCommentController;
import com.springbook.view.board.SearchBoardController;
import com.springbook.view.board.UpdateBoardController;
import com.springbook.view.board.ViewBoardController;
import com.springbook.view.salary.ChartController;
import com.springbook.view.salary.CompanyListController;
import com.springbook.view.salary.InsertController;
import com.springbook.view.salary.LoginController;
import com.springbook.view.salary.LogoutController;
import com.springbook.view.salary.SearchListController;
import com.springbook.view.salary.UpdateController;

public class HandlerMapping {
    private Map<String, Controller> mappings;
    
    public HandlerMapping() {
        mappings = new HashMap<>();
        
        // Salary related mappings
        mappings.put("/chart.do", new ChartController());
        mappings.put("/companyList.do", new CompanyListController());
        mappings.put("/insert.do", new InsertController());
        mappings.put("/loginOK.do", new LoginController());
        mappings.put("/searchList.do", new SearchListController());
        mappings.put("/update.do", new UpdateController());
        mappings.put("/logout.do", new LogoutController());
        
        // Board related mappings
        mappings.put("/deleteComment.do", new DeleteCommentController());
        mappings.put("/increaseViewCount.do", new IncreaseViewCountController());
        mappings.put("/insertBoard.do", new InsertBoardController());
        mappings.put("/insertComment.do", new InsertCommentController());
        mappings.put("/listBoard.do", new ListBoardController());
        mappings.put("/modifyComment.do", new ModifyCommentController());
        mappings.put("/searchBoard.do", new SearchBoardController());
        mappings.put("/updateBoard.do", new UpdateBoardController());
        mappings.put("/viewBoard.do", new ViewBoardController());
        mappings.put("/deleteBoard.do", new DeleteBoardController());
    }
    
    public Controller getController(String path) {
        return mappings.get(path);
    }
}
