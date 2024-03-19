package salaryController;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import salaryView.SalarySearchView;
import salaryView.SalaryUpdateView;
import salaryView.SalaryInsertView;

public class AdminController extends JFrame {	
	private static final Component SalaryDeleteView = null;
	private static final Component SalaryListView = null;	
	private static final Component SalaryUpdateView = null;
	SalarySearchView searchPan;
	SalaryInsertView insertPan;
	SalaryUpdateView updatePan;
	private int WIDTH = 700;
	private int HEIGHT = 500;
	private JButton btn1;
	private JPanel pan;
	private JComboBox<String> combo;
	
	public AdminController()
	{
		setTitle("관리자 모드");
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);		
		
		searchPan = new SalarySearchView();
		
		
		combo = searchPan.getCombo();
//		searchPan.initView();
		

	
	
		insertPan = new SalaryInsertView();
		insertPan.initView();
		
		updatePan = new SalaryUpdateView();
		updatePan.initView();
		

//		JButton btnSearch = searchPan.getBtnSearch();
		tab.add("사원추가",insertPan);		
		tab.add("사원검색",searchPan);
		tab.add("사원정보변경",updatePan);
		tab.add("사원삭제",SalaryDeleteView);
		tab.add("사원목록조회",SalaryListView);
		
//		pan.add(btn1);
////		btnSearch.addActionListener(btnL);
//		btn1.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("로그아웃에 성공하였습니다.");
//				dispose();
//				new MainController();
//				
//			}
//		});
		
		add(tab);
		
		//add("North",btn1);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		CenterLocation.location(WIDTH, HEIGHT);
		setBounds(CenterLocation.getX(),CenterLocation.getY(),WIDTH,HEIGHT);
	}
	
//	ActionListener btnL = new ActionListener() {
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			bookVOList.clear();
//			//bookVOList = dao.select(searchPan.getSearchWord(),combo.getSelectedIndex());
////			searchPan.setBookVOList(bookVOList);
//			//searchPan.putSearchResult();
//			
//		}
//	};

}
