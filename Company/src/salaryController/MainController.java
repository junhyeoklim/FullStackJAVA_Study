package salaryController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import salaryVO.IdPwdDATA;

public class MainController extends JFrame {	
	private JTextField ID;
	private JPasswordField PWD;
	private JPanel Pan1,Pan2;
	private JLabel Lab1,Lab2;
	private JButton btn1;
	private JMenuBar mbar;
	private JMenu mHelp;
	private JMenuItem admin,user;
	private int WIDTH = 450;
	private int HEIGHT = 120;	
	private IdPwdDATA id = new IdPwdDATA();
	
	
	public MainController() {


		setTitle("사원 정보 관리 시스템");
		setLayout(new BorderLayout(0,0));
		mbar = new JMenuBar();
		ID = new JTextField(10);
		PWD = new JPasswordField(10);
		Lab1 = new JLabel("ID: ",JLabel.CENTER);
		Lab2 = new JLabel("PWD: ",JLabel.CENTER);
		btn1 = new JButton("로그인");		
		mHelp = new JMenu("도움말");
		admin = new JMenuItem("Admin정보");
		user = new JMenuItem("User정보");


		btn1.setPreferredSize(new Dimension(100,20));
		Pan1 = new JPanel();
		Pan2 = new JPanel();		

		Pan1.add(Lab1);
		Pan1.add(ID);
		Pan1.add(Lab2);
		Pan1.add(PWD);
		Pan2.add(btn1);
		mHelp.add(admin);
		mHelp.add(user);
		mbar.add(mHelp);

		add("Center",Pan1);
		add("East",Pan2);
		setJMenuBar(mbar);


		btn1.addActionListener(itemL);
		admin.addActionListener(itemL);
		user.addActionListener(itemL);


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		CenterLocation.location(WIDTH, HEIGHT);
		setBounds(CenterLocation.getX(),CenterLocation.getY(),WIDTH,HEIGHT);
		setVisible(true);
	}

	
	//버튼 및 메뉴 클릭시 호출 되는 리스너
	ActionListener itemL =  new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btn1)
			{
				String password = new String(PWD.getPassword());				
				
				//공백이 입력되는 경우를 대비하여 trim()을 사용
				if(id.adminLogin(ID.getText().trim(), password))
				{
					JOptionPane.showMessageDialog(null, "관리자 모드로 진입합니다.");
					dispose();
					AdminController.getAdmin(1).startAdmin();
				}
				else if(id.userLogin(ID.getText().trim(), password))
				{
					JOptionPane.showMessageDialog(null, "사용자 모드로 진입합니다.");
					dispose();
//					UserController.getUser(1).startUser();
				}
				else
				{
					System.out.println(ID.getText()+ password);					
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 일치 하지 않습니다","ERROR",JOptionPane.ERROR_MESSAGE);
					ID.setText("");
					PWD.setText("");
				}
			}
			else if(e.getSource() == admin)
				JOptionPane.showMessageDialog(null, "관리자 아이디 : admin\n비밀번호 : 1234","Admin", JOptionPane.INFORMATION_MESSAGE);
			else if(e.getSource() == user)
				JOptionPane.showMessageDialog(null, "유저 아이디 : user\n비밀번호 : 1111","User", JOptionPane.INFORMATION_MESSAGE);
			
		}
	};



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainController mct =  new MainController();
	}

}
