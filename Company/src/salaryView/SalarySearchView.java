package salaryView;

import java.awt.BorderLayout;
//import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public class SalarySearchView extends JPanel implements ActionListener{
	JTable table;
	DefaultTableModel model;
	//ArrayList<BookVO> bookVOList;

	String[] header = {"도서번호","도서명","출판사","저자명","도서가격","카테고리"};
	JLabel lbl;
	JTextField textSearch;
	JButton btnSearch;
	String searchWord = "";
	JPanel panN = new JPanel();
	String[] combostr = {"이름","부서","직급","연봉"};
	JComboBox<String> combo;



	public SalarySearchView() {
		setLayout(new BorderLayout());

		combo = new JComboBox<String>(combostr);		
		lbl = new JLabel("검색어: ");
		textSearch = new JTextField(20);
		btnSearch = new JButton("검색");
		btnSearch.addActionListener(this);
		panN.add(combo);
		panN.add(lbl);
		panN.add(textSearch);
		panN.add(btnSearch);
	}

	//ActionListener 오버라이드 
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btnSearch)
			search();
	}
	public void initView() {
		String name = textSearch.getText();	
		model = new DefaultTableModel(header,header.length) {
			@Override
			public boolean isCellEditable(int row,int colum) {
				return false;
			}

		};
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		//테이블의 컬럼의 너비를 조절
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		System.out.println(name);
		//	putSearchResult();
		add("North",panN);
		add("Center",scroll);

	}

	public void search(){
		String name = textSearch.getText();		

		for(int i=0;i<model.getRowCount();i++){
			if(name.equals(null) || name.equals(model.getValueAt(i,0)))
			{
				JOptionPane.showMessageDialog(this,"등록된 사원이 없습니다."," ERROR",JOptionPane.ERROR_MESSAGE);
			}
			else if(name.equals(model.getValueAt(i,0)))
			{
				JOptionPane.showMessageDialog(this,"사원 찾음"," ERROR",JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
	}
}


