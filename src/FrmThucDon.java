import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bo.thucdonbo;
import dao.DungChung;

import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;

public class FrmThucDon extends JFrame {
	
	thucdonbo tdbo = new thucdonbo();
	DungChung dc = new DungChung();
	private JPanel contentPane;
	private JTable table;
	private JTextField etTMH;
	private JTextField etGIA;
	private JTextField etGiamGia;
	private JTextField etTK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmThucDon frame = new FrmThucDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ResultSet timkiem(String tenMH) throws Exception{
		String sql=" select * from ThucDon where tenMH like N'%"+tenMH+"%'";
		PreparedStatement cmd= dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		return rs;
	}

	/**
	 * Create the frame.
	 */
	public FrmThucDon() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					tdbo.gettd();
					table.setModel(tdbo.napbang("thucdon"));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 637, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane jTab = new JTabbedPane(JTabbedPane.TOP);
		jTab.setBounds(12, 224, 595, 245);
		contentPane.add(jTab);
		
		JScrollPane scrollPane = new JScrollPane();
		jTab.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int d=table.getSelectedRow();
				String tenMH=table.getValueAt(d, 0).toString();
				String gia=table.getValueAt(d, 1).toString();
				String giamGia=table.getValueAt(d, 2).toString();
				
				etTMH.setText(tenMH);
				etGIA.setText(gia);
				etGiamGia.setText(giamGia);

			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn m\u1EB7t h\u00E0ng");
		lblNewLabel.setBounds(12, 114, 90, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gi\u00E1");
		lblNewLabel_1.setBounds(12, 143, 56, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Gi\u1EA3m gi\u00E1");
		lblNewLabel_2.setBounds(12, 172, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		etTMH = new JTextField();
		etTMH.setBounds(129, 111, 116, 22);
		contentPane.add(etTMH);
		etTMH.setColumns(10);
		
		etGIA = new JTextField();
		etGIA.setBounds(129, 140, 116, 22);
		contentPane.add(etGIA);
		etGIA.setColumns(10);
		
		etGiamGia = new JTextField();
		etGiamGia.setBounds(129, 169, 116, 22);
		contentPane.add(etGiamGia);
		etGiamGia.setColumns(10);
		
		JButton btThem = new JButton("Th\u00EAm");
		btThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					String tenMH = etTMH.getText();
					Integer gia = Integer.parseInt(etGIA.getText());
					Double giamGia = Double.parseDouble(etGiamGia.getText());
					dc.KetNoi();
					
						tdbo.them( tenMH, gia, giamGia);
						table.setModel(tdbo.napbang("thucdon"));
					
				}catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
		btThem.setBounds(313, 139, 97, 25);
		contentPane.add(btThem);
		
		JButton btSua = new JButton("S\u1EEDa");
		btSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {

					String tenMH = etTMH.getText();
					Integer gia = Integer.parseInt(etGIA.getText());
					Double giamGia = Double.parseDouble(etGiamGia.getText());
//					if(kiemtra(manv).next()) {
//						JOptionPane.showMessageDialog(null, "Đã có nhân viên này");
//					}
//					else {
					tdbo.sua( tenMH, gia, giamGia);
					table.setModel(tdbo.napbang("thucdon"));
					//}	
					
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btSua.setBounds(313, 177, 97, 25);
		contentPane.add(btSua);
		
		JButton btXoa = new JButton("X\u00F3a");
		btXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int t=JOptionPane.showConfirmDialog(null, "Are you sure?");
					if(t==0) {
						String tenMH=etTMH.getText();
						tdbo.xoa(tenMH);
						table.setModel(tdbo.napbang("thucdon"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btXoa.setBounds(425, 177, 97, 25);
		contentPane.add(btXoa);
		
		JLabel lblNewLabel_3 = new JLabel("T\u00ECm ki\u1EBFm");
		lblNewLabel_3.setBounds(313, 99, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		etTK = new JTextField();
		etTK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==10) {
					try {
						DefaultTableModel mh= new DefaultTableModel();
						mh.addColumn("TenMH");
						mh.addColumn("Gia");
						mh.addColumn("GiamGia");
						dc.KetNoi();
						String tenMH=etTK.getText();
						ResultSet rs=timkiem(tenMH);
						Object[] t= new Object[3];
						while(rs.next()) {
							t[0]=rs.getString(1);
							t[1]=rs.getString(2);
							t[2]=rs.getString(3);
							mh.addRow(t);
						}
						table.setModel(mh);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		etTK.setText("");
		etTK.setBounds(381, 96, 162, 22);
		contentPane.add(etTK);
		etTK.setColumns(10);
		
		JButton btFresh = new JButton("Refesh");
		btFresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					tdbo.gettd();
					table.setModel(tdbo.napbang("thucdon"));
					etTMH.setText("");
					etGIA.setText("");
					etGiamGia.setText("");
					etTK.setText("");
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btFresh.setBounds(425, 139, 97, 25);
		contentPane.add(btFresh);
		
		JLabel lblNewLabel_4 = new JLabel("Quản lí thực đơn");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setBounds(192, 13, 238, 37);
		contentPane.add(lblNewLabel_4);
	}
}
