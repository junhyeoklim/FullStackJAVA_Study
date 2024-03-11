package SalaryView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class WindowTwo extends JFrame {
	private int WIDTH = 700;
	private int HEIGHT = 500;
	private JButton btn1;
	private JPanel pan;
	
	public WindowTwo()
	{
		setTitle("관리자 모드");
		
		setLayout(new BorderLayout());
		btn1 = new JButton("로그아웃");
		pan = new JPanel();
		
		pan.add(btn1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("로그아웃에 성공하였습니다.");
				dispose();
				new SalaryJbutton();
				
			}
		});
		
		
		add("East",btn1);
		setBackground(Color.green);
		

		setTitle("관리자 모드");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		CenterLocation.location(WIDTH, HEIGHT);
		setBounds(CenterLocation.getX(),CenterLocation.getY(),WIDTH,HEIGHT);
	}

}
