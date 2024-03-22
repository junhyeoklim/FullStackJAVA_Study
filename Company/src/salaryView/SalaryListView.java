package salaryView;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import salaryDATA.SalaryManDTO;

public class SalaryListView extends JPanel {
	private ArrayList<SalaryManDTO> list = new ArrayList<>();
	private Vector<String> vector;
	private SalaryHandlerView handler = new SalaryHandlerView();
	private DefaultTableModel model;
	private JTable table;
	private JButton addBtn, delBtn;
	private JPanel p; 
	
	public void initView() {
	setLayout(new BorderLayout());
	list = handler.getSalaryList();
	p = new JPanel();
	
	//타이틀 만들기
	vector = new Vector<String>();
	vector.addElement("이름");
	vector.addElement("부서");
	vector.add("직급");
	vector.add("연봉");
	//defaultTableModel 생성
	model = handler.getsetModel(new DefaultTableModel(vector, 0) {
	    public boolean isCellEditable(int r, int c) {
	        return (c != 0) ? true : false;
	    }
	});

	
	table = new JTable(model);
	table.getColumnModel().getColumn(0).setPreferredWidth(10);
	table.getColumnModel().getColumn(1).setPreferredWidth(20);
	table.getColumnModel().getColumn(2).setPreferredWidth(20);
	table.getColumnModel().getColumn(3).setPreferredWidth(20);
	JScrollPane scroll = new JScrollPane(table);


	scroll = new JScrollPane(table);


	//데이터를 Vector 리스트 형식으로 추가
	for(SalaryManDTO data:list){
		Vector<String> v= new Vector<String>();
		v.add(data.getName());
		v.add(data.getDepartment());
		v.add(data.getRank());
		v.add(data.getSalary());
		model.addRow(v);
	}

	//이벤트 추가		
	add("Center",scroll);
	}
	public void setSalaryList(ArrayList<SalaryManDTO> list) {
		this.list = list;
	}

}
