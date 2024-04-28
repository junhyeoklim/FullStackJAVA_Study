package book.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.Book;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import book.dao.BookDAO;
import book.dao.JDBCConnector;
import book.view.BookInsertView;
import book.view.BookSearchView;
import book.view.BookUpdateView;
import book.vo.BookVO;
import book.controller.*;

public class BookController extends JFrame {	
	BookSearchView searchPan;
	BookInsertView insertPan;
	BookUpdateView updatePan;
	BookDAO dao;
	ArrayList<BookVO> bookVOList;
	JComboBox<String> combo;
	JTable table;
	
	public BookController() {
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);		
		
		searchPan = new BookSearchView();
		
		
		combo = searchPan.getCombo();
		dao = new BookDAO();
		bookVOList = dao.select( searchPan.getSearchWord(),0);
		searchPan.setBookVOList(bookVOList);
		searchPan.initView();
			
	
		JButton btnSearch = searchPan.getBtnSearch();
		
		
		btnSearch.addActionListener(btnL);
		
		//도서추가 패널
		insertPan = new BookInsertView();		
		bookVOList = dao.select("",0);
		insertPan.setBookVOList(bookVOList);
		insertPan.initView();
		
		JButton btnAdd = insertPan.getBtnAdd();
		
		btnAdd.addActionListener(btnAddL);
		
		//도서 수정
		updatePan = new BookUpdateView();
		bookVOList = dao.select("", 0);
		updatePan.setBookVOList(bookVOList);
		updatePan.initView();
		JButton btnUpdate = updatePan.getBtnUpdate();
		btnUpdate.addActionListener(btnUpdateL);
		table = updatePan.getTdable();
		table.addMouseListener(tableL);
		
		tab.add("도서검색",searchPan);
		tab.add("도서추가",insertPan);
		tab.add("도서수정 및 삭제",updatePan);	
			
		
		add(tab);
		
		int w = 700;
		int h = 500;
		
		setTitle("도서관리시스템");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		CenterLocation.location(w, h);
		setBounds(CenterLocation.getX(),CenterLocation.getY(),w,h);
	}
	
	MouseAdapter tableL = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {			
			if(e.getClickCount() == 1)
			{
			int rowIndex = table.getSelectedRow();
			updatePan.setTextField(rowIndex);
			}
			else if(e.getClickCount() == 2)
			{
				int result = JOptionPane.showConfirmDialog(BookController.this, "정말로 삭제 하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
				
				if(result == 0) //{예: 0 ,아니오: 1}
				{
					BookVO vo = updatePan.neededInsertData();
					dao.delete(vo);
					bookVOList = dao.select("",0);
					updatePan.setBookVOList(bookVOList);
					updatePan.putSearchResult();	
				}
			}
			
			
		}
	}; 
	
	
	ActionListener btnL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			bookVOList.clear();
			bookVOList = dao.select(searchPan.getSearchWord(),combo.getSelectedIndex());
			searchPan.setBookVOList(bookVOList);
			searchPan.putSearchResult();
			
		}
	};
	
	ActionListener btnAddL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			BookVO vo = insertPan.neededInsertData();
			dao.insert(vo);
			bookVOList = dao.select("",0);
			insertPan.setBookVOList(bookVOList);
			insertPan.putSearchResult();
			insertPan.initInsertData();
		}
	};
	
	ActionListener btnUpdateL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			BookVO vo = updatePan.neededInsertData();
			dao.update(vo);
			bookVOList = dao.select("",0);
			updatePan.setBookVOList(bookVOList);
			updatePan.putSearchResult();			
			
		}
	};
	
	public static void main(String[] args) {
		
		new BookController();
	}

}
