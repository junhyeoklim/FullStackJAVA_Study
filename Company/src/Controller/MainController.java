package Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import salaryDATA.IdPwdDATA;

public class MainController extends JFrame {
	private JTextField ID;
	private JPasswordField PWD;
	private JPanel Pan1,Pan2;
	private JLabel Lab1,Lab2;
	private JButton btn1;	
	private int WIDTH = 450;
	private int HEIGHT = 120;	
	private IdPwdDATA id = new IdPwdDATA();

	public MainController() {

		
		setTitle("사원 정보 관리 시스템");
		setLayout(new BorderLayout(0,0));
		
		ID = new JTextField(10);
		PWD = new JPasswordField(10);		
		
		Lab1 = new JLabel("ID: ",JLabel.CENTER);
		Lab2 = new JLabel("PWD: ",JLabel.CENTER);
		
		btn1 = new JButton("로그인");
		btn1.setPreferredSize(new Dimension(100,20));
		
		Pan1 = new JPanel();
		Pan2 = new JPanel();		

		Pan1.add(Lab1);
		Pan1.add(ID);
		Pan1.add(Lab2);
		Pan1.add(PWD);
		
		Pan2.add(btn1);

		add("Center",Pan1);
		add("East",Pan2);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String password = new String(PWD.getPassword());				
				
				if(id.adminLogin(ID.getText(), password))
				{
					System.out.println("관리자 모드로 진입합니다.");
					dispose();
					new AdminController();
				}
				else if(id.userLogin(ID.getText(), password))
				{
					System.out.println("사용자 모드로 진입합니다.");
					dispose();
					new UserController();
				}
				else
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 일치 하지 않습니다","ERROR",JOptionPane.ERROR_MESSAGE);

			}
		});

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		CenterLocation.location(WIDTH, HEIGHT);
		setBounds(CenterLocation.getX(),CenterLocation.getY(),WIDTH,HEIGHT);
		setVisible(true);
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainController();
	}

}
