//package salaryView;
//
//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Vector;
//
//import javax.swing.JButton;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//import salaryDATA.SalaryManDTO;
//
//
//public class SalaryHandlerView extends JPanel {
//	private ArrayList<SalaryManDTO> list = new ArrayList<>();
//	private Vector<String> vector;
//	private DefaultTableModel model;
//	private JTable table;
//	private JButton addBtn, delBtn;
//	private JPanel p; 
//	//생성자 호출
//
//	public void initView() {
//		setLayout(new BorderLayout());
//		list = new ArrayList<SalaryManDTO>();
//		p = new JPanel();
//		//타이틀 만들기
//		vector = new Vector<String>();
//		vector.addElement("이름");
//		vector.addElement("부서");
//		vector.add("직급");
//		vector.add("연봉");
//		//defaultTableModel 생성
//		model = new DefaultTableModel(vector, 0){
//			public boolean isCellEditable(int r, int c){
//				return (c!=0) ? true : false;
//			}
//		};
//
//		table = new JTable(model);
//		table.getColumnModel().getColumn(0).setPreferredWidth(10);
//		table.getColumnModel().getColumn(1).setPreferredWidth(20);
//		table.getColumnModel().getColumn(2).setPreferredWidth(20);
//		table.getColumnModel().getColumn(3).setPreferredWidth(20);
//
//		JScrollPane scroll = new JScrollPane(table);
//
//
//		scroll = new JScrollPane(table);
//		//버튼 추가
//		addBtn = new JButton("추가");
//		delBtn = new JButton("삭제");
//		//패널에 버튼 추가
//		p.add(addBtn);
//		p.add(delBtn);
//
//		//데이터를 Vector 리스트 형식으로 추가
//		for(SalaryManDTO data:list){
//			Vector<String> v= new Vector<String>();
//			v.add(data.getName());
//			v.add(data.getDepartment());
//			v.add(data.getRank());
//			v.add(data.getSalary());
//			model.addRow(v);
//		}
//
//		//이벤트 추가		
//		add("North",p);
//		add("Center",scroll);
//	}
//
////	콘솔로 입력하는 대신 JOptaionPane을 이용한 입력값 받기
//	public void insert(){
//		boolean value = false;
//		String name= JOptionPane.showInputDialog(this,"이름을 입력 하세요.");
//		//아이디가 없으면 그냥 나가기
//		if(!name.equals("")){
//			for(int i=0;i<model.getRowCount();i++){
//				//만약 id값들을 빅해서 같은 값이 존재할 때
//				if(name.equals(model.getValueAt(i,0))) {
//					JOptionPane.showMessageDialog(this,"이미 등록된 사원입니다."," ERROR",JOptionPane.ERROR_MESSAGE); 
//					value=true;
//					break;
//				}
//			}
//			if(value==false){
//				String department= JOptionPane.showInputDialog(this,"부서를 입력하세요.");
//				String rank= JOptionPane.showInputDialog(this,"직급을 입력하세요");
//				String salary= JOptionPane.showInputDialog(this,"연봉을 입력하세요");
//				//Vector에 값 추가하기
//				Vector<String> v= new Vector<String>();
//				v.add(name);
//				v.add(department);
//				v.add(rank);
//				v.add(salary);
//				model.addRow(v);
//			}
//		}
//	}
//	public void setSalaryList(ArrayList<SalaryManDTO> list) {
//		this.list = list;
//	}
//	
//	public ArrayList<SalaryManDTO> getSalaryList()
//	{
//		return list;
//	}
//
//	public JButton getBtnAdd() {
//		return addBtn;
//	}
//	public JButton getBtnDel() {
//		return delBtn;
//	}
//	public JTable getTable()
//	{
//		return table;
//	}
//
//	public DefaultTableModel getsetModel(DefaultTableModel model)
//	{
//		this.model = model;
//		return this.model;
//	}
//	
//	//테이블에서의 값을 삭제하는 메소드
//	public void delete(){
//		String name= JOptionPane.showInputDialog(this,"삭제할 사용자의 이름을 입력하세요");
//		if(!(name.equals(null)) && model.getRowCount() <= 0)
//			JOptionPane.showMessageDialog(this,"등록된 사원이 없습니다."," ERROR",JOptionPane.ERROR_MESSAGE);
//		else {
//			for(int i=0;i<model.getRowCount();i++){
//				if(name.equals(model.getValueAt(i,0)))
//				{
//					JOptionPane.showMessageDialog(this,"사원 정보를 삭제 했습니다.","삭제",JOptionPane.INFORMATION_MESSAGE);
//					model.removeRow(i);
//					break;
//				}
//			}
//		}
//	}
//}
//
//
