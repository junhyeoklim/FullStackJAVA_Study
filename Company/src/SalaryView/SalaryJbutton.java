package SalaryView;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SalaryJbutton extends JFrame {
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final long serialVersionUID = 1L;
	private Panel controlPanel, buttonPanel,loginPanel;	
	
	public SalaryJbutton() {
		
		Label namelabel = new Label("아이디 : ", Label.LEFT);
		Label passwordLabel = new Label("패스워드 : ", Label.CENTER);
		final TextField userText = new TextField(6);
		final TextField passwordText = new TextField(6);
		passwordText.setEchoChar('*');
		Button loginButton = new Button("Login");
		
		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());
		buttonPanel = new Panel();
		buttonPanel.setLayout(new FlowLayout());
		loginPanel = new Panel();
		loginPanel.setLayout(new FlowLayout());
		
		controlPanel.add(namelabel);
		controlPanel.add(userText);
		buttonPanel.add(passwordLabel);
		buttonPanel.add(passwordText);
		loginPanel.add(loginButton);
		
		
		add("North",controlPanel);
		add("Center",buttonPanel);
		add("East",loginPanel);
		
		
		setTitle("사원 정보 관리 시스템");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		CenterLocation.location(WIDTH, HEIGHT);
		setBounds(CenterLocation.getX(),CenterLocation.getY(),WIDTH,HEIGHT);
		setVisible(true);
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SalaryJbutton();
	}

}
