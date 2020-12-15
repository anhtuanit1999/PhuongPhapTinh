package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import lagrange.MocCachDeu;
import newton.MocBatKy;

public class GiaoDien_UngDung implements ActionListener, KeyListener {

	private JFrame frame;
	private JTextField txtGiaTriX;
	private JTextField txtGiaTriY;
	private JTextField txtGiaTriN;
	private JTextField txtKetQua;
	private JTable table;
	private JButton btnTinh;
	private JButton btnXoaTrang;
	private JButton btnThem;
	private JComboBox comboBoxTieuChi;
	private MocCachDeu mocCachDeu;
	private MocBatKy mocBatKy;
	private JButton btnXoaBang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GiaoDien_UngDung window = new GiaoDien_UngDung();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GiaoDien_UngDung() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mocCachDeu = new MocCachDeu();
		mocBatKy = new MocBatKy();
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 634, 457);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnChung = new JPanel();
		frame.getContentPane().add(pnChung, BorderLayout.CENTER);
		pnChung.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTieuDe = new JLabel("\u1EE8ng d\u1EE5ng");
		lblTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		pnChung.add(lblTieuDe, BorderLayout.NORTH);
		
		JPanel pnCenter = new JPanel();
		pnChung.add(pnCenter, BorderLayout.CENTER);
		pnCenter.setLayout(null);
		
		JLabel lblGiaTriX = new JLabel("Gi\u00E1 tr\u1ECB x:");
		lblGiaTriX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaTriX.setBounds(35, 30, 74, 19);
		pnCenter.add(lblGiaTriX);
		
		txtGiaTriX = new JTextField();
		txtGiaTriX.setBounds(119, 31, 193, 20);
		pnCenter.add(txtGiaTriX);
		txtGiaTriX.setColumns(10);
		
		JLabel lblGiaTriY = new JLabel("Gi\u00E1 tr\u1ECB y:");
		lblGiaTriY.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaTriY.setBounds(322, 30, 74, 19);
		pnCenter.add(lblGiaTriY);
		
		txtGiaTriY = new JTextField();
		txtGiaTriY.setColumns(10);
		txtGiaTriY.setBounds(406, 31, 193, 20);
		pnCenter.add(txtGiaTriY);
		
		JLabel lblTieuChi = new JLabel("Ti\u00EAu ch\u00ED: ");
		lblTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTieuChi.setBounds(35, 70, 74, 19);
		pnCenter.add(lblTieuChi);
		
		comboBoxTieuChi = new JComboBox();
		comboBoxTieuChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBoxTieuChi.setModel(new DefaultComboBoxModel(new String[] {"Lagrange m\u1ED1c c\u00E1ch \u0111\u1EC1u", "Newton m\u1ED1c b\u1EA5t k\u1EF3"}));
		comboBoxTieuChi.setBounds(119, 71, 193, 20);
		pnCenter.add(comboBoxTieuChi);
		
		JLabel lblGiaTriN = new JLabel("Gi\u00E1 tr\u1ECB n: ");
		lblGiaTriN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiaTriN.setBounds(322, 74, 74, 19);
		pnCenter.add(lblGiaTriN);
		
		txtGiaTriN = new JTextField();
		txtGiaTriN.setColumns(10);
		txtGiaTriN.setBounds(406, 71, 193, 20);
		pnCenter.add(txtGiaTriN);
		
		btnThem = new JButton("Th\u00EAm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(58, 150, 89, 23);
		pnCenter.add(btnThem);
		
		btnXoaTrang = new JButton("X\u00F3a tr\u1EAFng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTrang.setBounds(194, 150, 105, 23);
		pnCenter.add(btnXoaTrang);
		
		btnTinh = new JButton("T\u00EDnh");
		btnTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTinh.setBounds(489, 150, 89, 23);
		pnCenter.add(btnTinh);
		
		JLabel lblKetQua = new JLabel("K\u1EBFt qu\u1EA3: ");
		lblKetQua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKetQua.setBounds(35, 110, 74, 19);
		pnCenter.add(lblKetQua);
		
		txtKetQua = new JTextField();
		txtKetQua.setEditable(false);
		txtKetQua.setColumns(10);
		txtKetQua.setBounds(119, 111, 480, 20);
		pnCenter.add(txtKetQua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 184, 608, 211);
		pnCenter.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Gi\u00E1 tr\u1ECB x", "Gi\u00E1 tr\u1ECB y"
			}
		));
		scrollPane.setViewportView(table);
		
		btnXoaBang = new JButton("Xóa bảng");
		btnXoaBang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaBang.setBounds(341, 150, 105, 23);
		pnCenter.add(btnXoaBang);
		
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoaBang.addActionListener(this);
		btnTinh.addActionListener(this);
		
		txtGiaTriY.addKeyListener(this);
		txtGiaTriN.addKeyListener(this);
	}
	
	public void xoaTrang() {
		txtGiaTriX.setText("");
		txtGiaTriY.setText("");
		txtGiaTriN.setText("");
		txtKetQua.setText("");
	}
	
	public void xoaBang() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
	}
	
	public boolean kiemTraTextField(int n) {
		String regex = "^-?\\d+\\.?\\d*$";
		if(n == 1) {
			if(!txtGiaTriN.getText().trim().matches(regex)) {
				JOptionPane.showMessageDialog(frame, "Chỉ chấp nhập số nguyên và số thập phân");
				txtGiaTriN.requestFocus();
				txtGiaTriN.selectAll();
				return false;
			}
		} else {
			if(!txtGiaTriX.getText().trim().matches(regex)) {
				JOptionPane.showMessageDialog(frame, "Chỉ chấp nhập số nguyên và số thập phân");
				txtGiaTriX.requestFocus();
				txtGiaTriX.selectAll();
				return false;
			} else if(!txtGiaTriY.getText().trim().matches(regex)) {
				JOptionPane.showMessageDialog(frame, "Chỉ chấp nhập số nguyên và số thập phân");
				txtGiaTriY.requestFocus();
				txtGiaTriY.selectAll();
				return false;
			}
		}
		return true;
	}
	
	public void eventThem() {
		if(kiemTraTextField(0)) {
			String giaTriX = txtGiaTriX.getText().trim();
			String giaTriY = txtGiaTriY.getText().trim();
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			String[] rowData = {
					giaTriX,
					giaTriY
			};
			model.addRow(rowData);
			xoaTrang();
			txtGiaTriX.requestFocus();
		}
	}
	
	public void eventTinh() {
		if(kiemTraTextField(1)) {
			float giaTriN = Float.parseFloat(txtGiaTriN.getText().trim());
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			if(model.getRowCount() < 1) {
				return;
			}
			String tieuChi = comboBoxTieuChi.getSelectedItem().toString();
			float[][] list = new float[model.getRowCount()][2];
			
			for (int i = 0; i < model.getRowCount() ; i++) {
				list[i] = new float[] {Float.parseFloat(table.getValueAt(i, 0).toString()), Float.parseFloat(table.getValueAt(i, 1).toString())}; 
			}
			
			if(tieuChi.equals("Lagarange mốc cách đều")) {
				txtKetQua.setText(mocCachDeu.lagrangeCal(list, giaTriN) + "");
			} else {
				txtKetQua.setText(mocBatKy.Newton(list, giaTriN) + "");
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnXoaTrang)) {
			xoaTrang();
		} else if(o.equals(btnThem)) {
			eventThem();
		} else if(o.equals(btnTinh)) {
			eventTinh();
		} else if(o.equals(btnXoaBang)) {
			xoaBang();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		Object o = e.getSource();
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(o.equals(txtGiaTriY)) {
				eventThem();
			} else if(o.equals(txtGiaTriN)) {
				eventTinh();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

/*
* (C) Copyright 2020 IUH. All rights reserved.
*
* @author: AnhTuanIT
* @date: 26-11-2020
* @version: 1.0
*/
