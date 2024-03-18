package salaryView;

import java.awt.BorderLayout;
//import java.util.ArrayList;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;




public class SalarySearchView extends JPanel {
	JTable table;
//	DefaultTableModel model;
	//ArrayList<BookVO> bookVOList;
	
	String[] header = {"도서번호","도서명","출판사","저자명","도서가격","카테고리"};
	JLabel lbl;
	JTextField textSearch;
	JButton btnSearch;
	String searchWord = "";
	JPanel panN = new JPanel();
	String[] combostr = {"도서명","출판사","저자명"};
	JComboBox<String> combo;



	public SalarySearchView() {
		setLayout(new BorderLayout());

		combo = new JComboBox<String>(combostr);		
		lbl = new JLabel("검색어: ");
		textSearch = new JTextField(20);
		btnSearch = new JButton("검색");
		panN.add(combo);
		panN.add(lbl);
		panN.add(textSearch);
		panN.add(btnSearch);

	}

	public void initView() {
		table = new JTable();
		//테이블의 컬럼의 너비를 조절
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);

		JScrollPane scroll = new JScrollPane();

		add("North",panN);
		add("Center",scroll);
	}

	public String getSearchWord() {

		searchWord = textSearch.getText();

		return searchWord;
	}


	public JButton getBtnSearch() {
		return btnSearch;
	}

//	public void setBookVOList(ArrayList<BookVO> bookVOList) {
//		this.bookVOList = bookVOList;
//	}
	public JComboBox<String> getCombo() {
		return combo;
	}




}
