package salaryController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import salaryDATA.SalaryManDTO;
import salaryView.SalaryListView;
import salaryView.SalarySearchView;
import salaryView.SalaryUpdateView;

public class UserController extends JFrame {
	private SalarySearchView searchPan;
	private SalaryListView listPan;
	private int WIDTH = 700;
	private int HEIGHT = 500;
	private JMenuBar mbar;
	private JMenu mHelp;
	private JMenuItem admin;
	private Vector<SalaryManDTO> man;
	private static UserController sms;

	private UserController(int size)
	{
		man = new Vector<SalaryManDTO>(size);
	};

	public static UserController getUser(int size)
	{
		if(sms == null)
			sms = new UserController(size);
		return sms;
	}		
	public void startUser()
	{

		setTitle("사용자 모드");
		mbar = new JMenuBar();
		mHelp = new JMenu("도움말");
		admin = new JMenuItem("로그아웃");
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);	
		
		searchPan = new SalarySearchView();
		searchPan.initView();
		
		listPan = new SalaryListView();
		listPan.initView();

		



		mHelp.add(admin);
		mbar.add(mHelp);
		setJMenuBar(mbar);
		admin.addActionListener(menuL);
		
		tab.add("사원목록",listPan);
		tab.add("사원검색",searchPan);
		

		add(tab);


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
