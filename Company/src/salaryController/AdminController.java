package salaryController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import salaryVO.SalaryManVO;
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
	private ArrayList<SalaryManVO> man;
	private static AdminController sms;

	/*
	 *컨트롤러를 1개로 통합해서 adminView,userView,LoginView를 각각 구현해서 보여주자
	 *컨트롤러 여러개를 작성 하니 객체가 계속 생성되어 입력한 salary데이터 공유가 안되고 있다.
	 *-> 시도 해봤는데 AdminController객체를 공유해서 AdminController 뷰만 보여 준다
	 */
	//사용자 변경을 해도 입력한 데이터 유지를 위한 싱글톤을 ArrayList를 사용해서 구현
	private AdminController(int size)
	{
		man = new ArrayList<SalaryManVO>(size);
	}

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

		handlerPan = new SalaryHandlerView();
		handlerPan.setSalaryList(man);		
		handlerPan.initView();

		 ArrayList<SalaryManVO> dataList = handlerPan.getSalaryList();

		    // UserController에 전달
//		    UserController.getUser(dataList.size()).setSalaryList(dataList);
		
		
		JButton btnInsert = handlerPan.getBtnAdd();
		JButton btnDelete = handlerPan.getBtnDel();

		btnInsert.addActionListener(btnI);
		btnDelete.addActionListener(btnD);


		updatePan = new SalaryUpdateView();
		updatePan.initView();


		mHelp.add(admin);
		mbar.add(mHelp);
		setJMenuBar(mbar);
		admin.addActionListener(menuL);

		tab.add("사원정보관리",handlerPan);		
		tab.add("사원검색",searchPan);
		tab.add("사원정보변경",updatePan);

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

	ActionListener btnI = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {			
			handlerPan.insert();
		}
	};
	ActionListener btnD = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {			
			handlerPan.delete();
		}
	};

}
