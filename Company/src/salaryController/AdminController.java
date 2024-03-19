package salaryController;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import salaryDATA.SalaryManDTO;
import salaryView.SalarySearchView;
import salaryView.SalaryUpdateView;
import salaryView.SalaryHandlerView;

public class AdminController extends JFrame {	
	private SalarySearchView searchPan;
	private SalaryHandlerView handlerPan;
	private SalaryUpdateView updatePan;
	private JMenuBar mbar;
	private JMenu mHelp;
	private JMenuItem admin;
	private int WIDTH = 700;
	private int HEIGHT = 500;
	private Vector<SalaryManDTO> man;
	private static AdminController sms;

	
	//사용자 변경을 해도 입력한 데이터 유지를 위한 싱글톤을 vector를 사용해서 구현
	private AdminController(int size)
	{
		man = new Vector<SalaryManDTO>(size);
	};

	public static AdminController getAdmin(int size)
	{
		if(sms == null)
			sms = new AdminController(size);
		return sms;
	}	

	public void startAdmin()
	{
		
		setTitle("관리자 모드");
		mbar = new JMenuBar();
		mHelp = new JMenu("도움말");
		admin = new JMenuItem("로그아웃");
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);		
		
		searchPan = new SalarySearchView();
		searchPan.initView();
		
//		combo = searchPan.getCombo();
		
		

	
	
		handlerPan = new SalaryHandlerView();
		handlerPan.initView();
		
		updatePan = new SalaryUpdateView();
		updatePan.initView();
		

		mHelp.add(admin);
		mbar.add(mHelp);
		setJMenuBar(mbar);
		admin.addActionListener(menuL);
		
		tab.add("사원정보관리",handlerPan);		
		tab.add("사원검색",searchPan);
		tab.add("사원정보변경",updatePan);
		
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
	
	ActionListener menuL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "로그아웃");
			dispose();
			new MainController();
		}
	};

}
