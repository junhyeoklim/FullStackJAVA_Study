package salaryController;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class UserController extends JFrame {
	private static final Component SalaryInsertView = null;
	private static final Component SalarySearchView = null;
	private static final Component SalaryDeleteView = null;
	private static final Component SalaryListView = null;
	private int WIDTH = 700;
	private int HEIGHT = 500;
	private JButton btn1;
	private JPanel pan;
	
	public UserController()
	{
		
		setTitle("사용자 모드");
		
		setLayout(new BorderLayout());
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);	
		
		btn1 = new JButton("로그아웃");
		pan = new JPanel();
				
		tab.add("사원검색",SalarySearchView);
		tab.add("사원목록",SalaryListView);
		
		pan.add(btn1);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("로그아웃에 성공하였습니다.");
				dispose();
				new MainController();
				
			}
		});
		
		add(tab);
		
		add("East",btn1);		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		CenterLocation.location(WIDTH, HEIGHT);
		setBounds(CenterLocation.getX(),CenterLocation.getY(),WIDTH,HEIGHT);
	}

}
