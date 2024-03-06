package SalaryController;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SalaryDATA.SalaryManSet;

public class SalaryJbutton extends JFrame {
	private JTextField Tf1,Tf2,Tf3;
	private JPanel Pan1,Pan2,Pan3,Pan4;
	private JLabel Lab1,Lab2,Lab3;
	private JButton btn1;	
	private int WIDTH = 500;
	private int HEIGHT = 140;
	private SalaryManSet sms;
	
	public SalaryJbutton() {
		setTitle("사원 정보 관리 시스템");
		setLayout(new BorderLayout());
		
		
		Tf1 = new JTextField(10);
		Tf2 = new JTextField(10);
		
		Lab1 = new JLabel("ID: ");
		Lab2 = new JLabel("PWD: ");
		
		btn1 = new JButton("로그인");
		
		
		Pan1 = new JPanel();
		Pan2 = new JPanel();		
		Pan4 = new JPanel();
		
		
		Pan1.add(Lab1);
		Pan1.add(Tf1);
		
		Pan2.add(Lab2);
		Pan2.add(Tf2);
		
		
		add("North",Pan1);
		add("Center",Pan2);
		add("South",Pan3);
		
		Pan4.add(btn1);		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
	
		add("East",Pan4);
		
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
