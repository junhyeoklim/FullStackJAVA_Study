package Controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import SalaryView.SalaryDeleteView;
import SalaryView.SalaryInsertView;
import SalaryView.SalarySearchView;


public class AdminController extends JFrame {
	private static final Component SalaryInsertView = null;
	private static final Component SalarySearchView = null;
	private static final Component SalaryDeleteView = null;
	private int WIDTH = 700;
	private int HEIGHT = 500;
	private JButton btn1;
	private JPanel pan;
	
	public AdminController()
	{
		setTitle("관리자 모드");
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);	
		
		setLayout(new BorderLayout());
		btn1 = new JButton("로그아웃");
		pan = new JPanel();
		

		tab.add("사원추가",SalaryInsertView);
		
		tab.add("사원검색",SalarySearchView); 
		tab.add("사원삭제",SalaryDeleteView);
		 
			
		
		add(tab);
		
		add("East",btn1);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		CenterLocation.location(WIDTH, HEIGHT);
		setBounds(CenterLocation.getX(),CenterLocation.getY(),WIDTH,HEIGHT);
	}

}
