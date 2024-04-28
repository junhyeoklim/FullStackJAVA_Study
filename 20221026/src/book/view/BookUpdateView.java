package book.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.Book;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import book.vo.BookVO;

public class BookUpdateView extends JPanel {
	JTable table;
	DefaultTableModel model;
	ArrayList<BookVO> bookVOList;
	String[] header = {"도서번호","도서명","출판사","저자명","도서가격","카테고리"};	
	JTextField textSearch;	
	String searchWord = "";
	JPanel panS;
	JComboBox<String> categoryCombo;
	String[] categoryName = {"IT도서","소설","비소설","경제","사회"};
	JLabel[] lbls = new JLabel[header.length];
	JTextField[] tfs = new JTextField[header.length-1];
	JButton btnUpdate;
	
	
	
	public BookUpdateView() {
		setLayout(new BorderLayout());	
		
		
		
		categoryCombo = new JComboBox<String>(categoryName);
		btnUpdate = new JButton("도서수정");
		panS = new JPanel(new GridLayout(4,4));
		
		for(int i = 0; i < header.length; i++)
		{
			lbls[i] = new JLabel(header[i]);
			panS.add(lbls[i]);

			
			if(i < header.length - 1)
			{
				tfs[i] = new JTextField(15);
				panS.add(tfs[i]);
			}
			else
			{				
				panS.add(categoryCombo);
			}			
		}
		tfs[0].setEditable(false);
		
		for(int i = 0; i < 3; i++)
		{
			panS.add(new JLabel(" "));
		}		
		panS.add(btnUpdate);
	}
	
	public void setTextField(int rowIndex) {
		for (int i = 0; i < categoryName.length; i++) {
			tfs[i].setText(model.getValueAt(rowIndex, i)+"");	
		}
		categoryCombo.setSelectedItem((String)model.getValueAt(rowIndex, 5));
	}
	
	public void initView() {
		model = new DefaultTableModel(header,bookVOList.size()) {
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
	
	putSearchResult();	
	add("Center",scroll);
	add("South",panS);
	}
	//DeafaultTableModel에 도서정보들을 설정한다.
	public void putSearchResult() {
		model.setRowCount(bookVOList.size());
		//검색한 결과행의 개수만큼 테이블의 행을 설정하기 위해서
		
		BookVO vo = null;
		for(int i = 0; i< bookVOList.size(); i++) {
			
			vo = bookVOList.get(i);
			
			model.setValueAt(vo.getIsbn(), i, 0);
			model.setValueAt(vo.getName(), i, 1);
			model.setValueAt(vo.getPublish(), i, 2);
			model.setValueAt(vo.getAuthor(), i, 3);
			model.setValueAt(vo.getPrice(), i, 4);
			model.setValueAt(vo.getCategoryName(), i, 5);
		}
	}	

	public void setBookVOList(ArrayList<BookVO> bookVOList) {
		this.bookVOList = bookVOList;
	}


	public JButton getBtnAdd() {
		return btnUpdate;
	}
	public BookVO neededInsertData() {
		BookVO vo = new BookVO();
		vo.setIsbn(Integer.parseInt(tfs[0].getText()));
		vo.setName(tfs[1].getText());
		vo.setPublish(tfs[2].getText());
		vo.setAuthor(tfs[3].getText());
		vo.setPrice(Integer.parseInt(tfs[4].getText()));
		vo.setCategoryName((String)categoryCombo.getSelectedItem());
		return vo;
	}
	
	public void initInsertData() {
		for(int i = 0; i < tfs.length; i++) {
			tfs[i].setText("");
		}
		categoryCombo.setSelectedIndex(0);
	}
	
	public JTable getTdable() {
		return table;
	}
	
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
}





