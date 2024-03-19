package salaryView;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import salaryDATA.SalaryManDTO;


public class SalaryInsertView extends JPanel implements ActionListener {
	private ArrayList<SalaryManDTO> list;
	private Vector<String> vector;
	private DefaultTableModel model;
	private JTable table;
	private JButton addBtn, delBtn;
	private JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));;
	//생성자 호출

	public void initView() {

		list = new ArrayList<SalaryManDTO>();
		//타이틀 만들기
		vector = new Vector<String>();
		vector.addElement("이름");
		vector.addElement("부서");
		vector.add("직급");
		vector.add("연봉");
		//defaultTableModel 생성
		model = new DefaultTableModel(vector, 0){
			public boolean isCellEditable(int r, int c){
				return (c!=0) ? true : false;
			}
		};
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		

		scroll = new JScrollPane(table);
		//버튼 추가
		addBtn = new JButton("추가");
		delBtn = new JButton("삭제");
		//패널에 버튼 추가
		
		
		//데이터를 Vector 리스트 형식으로 추가
		for(SalaryManDTO data:list){
			Vector<String> v= new Vector<String>();
			v.add(data.getName());
			v.add(data.getDepartment());
			v.add(data.getRank());
			v.add(data.getSalary());
			model.addRow(v);
		}
		//container에 추가

		//윈도우 설정

		//이벤트 추가
		add("Center",scroll);
		add("South",p);
		p.add(addBtn);
		p.add(delBtn);
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
	}
	//ActionListener 오버라이드 
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==addBtn){
			insert();	
		}  else if(e.getSource()==delBtn){
			delete();
		}
		
	}
	//콘솔로 입력하는 대신 JOptaionPane을 이용한 입력값 받기
	public void insert(){
		boolean value = false;
		String id= JOptionPane.showInputDialog(this,"아이디를 입력하세요");
		//아이디가 없으면 그냥 나가기
		if(!id.equals("")){
			for(int i=0;i<model.getRowCount();i++){
				//만약 id값들을 빅해서 같은 값이 존재할 때
				if(id.equals(model.getValueAt(i,0))) {
					JOptionPane.showMessageDialog(this,"사용중인 아이디입니다"); 
					value=true;
					break;
				}
			}
			if(value==false){
				String name= JOptionPane.showInputDialog(this,"이름을 입력하세요");
				String pwd= JOptionPane.showInputDialog(this,"비밀번호를 입력하세요");
				String tel= JOptionPane.showInputDialog(this,"전화번호를 입력하세요");
				//Vector에 값 추가하기
				Vector<String> v= new Vector<String>();
				v.add(id);
				v.add(name);
				v.add(pwd);
				v.add(tel);
				model.addRow(v);
			}
		}
	}
	//테이블에서의 값을 삭제하는 메소드
	public void delete(){
		String name= JOptionPane.showInputDialog(this,"삭제할 사용자의 이름을 입력하세요");
		for(int i=0;i<model.getRowCount() ;i++){
			if(name.equals(model.getValueAt(i,1))){
				model.removeRow(i);
				i=-1;
			}
		}
	}
}


