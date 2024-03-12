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
import javax.swing.table.DefaultTableModel;





public class SalarySearchView extends JPanel {
	JTable table;
	DefaultTableModel model;
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
		model = new DefaultTableModel(header,header.length) {
			@Override
			public boolean isCellEditable(int row,int colum) {
				return false;
			}

		};

		table = new JTable(model);
		//테이블의 컬럼의 너비를 조절
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(50);

		JScrollPane scroll = new JScrollPane(table);

		//	putSearchResult();
		add("North",panN);
		add("Center",scroll);
	}
	//DeafaultTableModel에 도서정보들을 설정한다.
	//	public void putSearchResult() {
	////		model.setRowCount(bookVOList.size());
	//		//검색한 결과행의 개수만큼 테이블의 행을 설정하기 위해서
	//		
	//		BookVO vo = null;
	//		for(int i = 0; i< bookVOList.size(); i++) {
	//			
	//			vo = bookVOList.get(i);
	//			
	//			model.setValueAt(vo.getIsbn(), i, 0);
	//			model.setValueAt(vo.getName(), i, 1);
	//			model.setValueAt(vo.getPublish(), i, 2);
	//			model.setValueAt(vo.getAuthor(), i, 3);
	//			model.setValueAt(vo.getPrice(), i, 4);
	//			model.setValueAt(vo.getCategoryName(), i, 5);
	//		}
	//	}

	public String getSearchWord() {

		searchWord = textSearch.getText();

		return searchWord;
	}

	//	public void setBookVOList(ArrayList<BookVO> bookVOList) {
	//		this.bookVOList = bookVOList;
	//	}

	public JButton getBtnSearch() {
		return btnSearch;
	}


	public JComboBox<String> getCombo() {
		return combo;
	}




}
