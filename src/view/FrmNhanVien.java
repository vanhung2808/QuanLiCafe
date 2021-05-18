package view;
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

import bo.nhanvienbo;
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

public class FrmNhanVien extends JFrame {
	DungChung dc= new DungChung();
	nhanvienbo nvbo=new nhanvienbo();

	private JPanel contentPane;
	private JTable table;
	private JTextField etMNV;
	private JTextField etHT;
	private JTextField etGT;
	private JTextField etNS;
	private JTextField etSDT;
	private JTextField etDC;
	private JTextField etNLV;
	private JTextField etLuong;
	private JTextField etTK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmNhanVien frame = new FrmNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ResultSet timkiem(String name) throws Exception{
		String sql=" select * from NhanVien where hoten like N'%"+name+"%'";
		PreparedStatement cmd= dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		return rs;
	}
	
	public ResultSet kiemtra(String manv) throws Exception{
		String sql="select * from NhanVien where manv = '%"+manv+"%'";
		PreparedStatement cmd=dc.cn.prepareStatement(sql);
		ResultSet rs= cmd.executeQuery();
		return rs;
	}

	/**
	 * Create the frame.
	 */
	public FrmNhanVien() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					nvbo.getnv();
					table.setModel(nvbo.napbang("nhanvien"));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 933, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 442, 891, 237);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Nhân Viên", null, scrollPane, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int d=table.getSelectedRow();
				String manv=table.getValueAt(d, 0).toString();
				String hoten=table.getValueAt(d, 1).toString();
				String gioitinh=table.getValueAt(d, 2).toString();
				String ngaysinh=table.getValueAt(d, 3).toString();
				String sdt=table.getValueAt(d, 4).toString();
				String diachi=table.getValueAt(d, 5).toString();
				String ngaylamviec=table.getValueAt(d, 6).toString();
				String luong=table.getValueAt(d, 7).toString();
				etMNV.setText(manv);
				etHT.setText(hoten);
				etGT.setText(gioitinh);
				etNS.setText(ngaysinh);
				etDC.setText(diachi);
				etSDT.setText(sdt);
				etNLV.setText(ngaylamviec);
				etLuong.setText(luong);
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn");
		lblNewLabel_1.setBounds(37, 190, 76, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_2.setBounds(37, 219, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_3.setBounds(37, 248, 56, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ng\u00E0y sinh");
		lblNewLabel_4.setBounds(37, 277, 56, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblNewLabel_5.setBounds(37, 306, 76, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblNewLabel_6.setBounds(37, 335, 56, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Ng\u00E0y B\u0110 l\u00E0m vi\u1EC7c");
		lblNewLabel_7.setBounds(37, 364, 99, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("L\u01B0\u01A1ng");
		lblNewLabel_8.setBounds(37, 393, 56, 16);
		contentPane.add(lblNewLabel_8);
		
		etMNV = new JTextField();
		etMNV.setBounds(165, 184, 116, 22);
		contentPane.add(etMNV);
		etMNV.setColumns(10);
		
		etHT = new JTextField();
		etHT.setBounds(165, 216, 116, 22);
		contentPane.add(etHT);
		etHT.setColumns(10);
		
		etGT = new JTextField();
		etGT.setBounds(165, 245, 116, 22);
		contentPane.add(etGT);
		etGT.setColumns(10);
		
		etNS = new JTextField();
		etNS.setBounds(165, 274, 116, 22);
		contentPane.add(etNS);
		etNS.setColumns(10);
		
		etSDT = new JTextField();
		etSDT.setBounds(165, 303, 116, 22);
		contentPane.add(etSDT);
		etSDT.setColumns(10);
		
		etDC = new JTextField();
		etDC.setBounds(165, 332, 116, 22);
		contentPane.add(etDC);
		etDC.setColumns(10);
		
		etNLV = new JTextField();
		etNLV.setBounds(165, 361, 116, 22);
		contentPane.add(etNLV);
		etNLV.setColumns(10);
		
		etLuong = new JTextField();
		etLuong.setBounds(165, 390, 116, 22);
		contentPane.add(etLuong);
		etLuong.setColumns(10);
		
		JButton btThem = new JButton("Th\u00EAm");
		btThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {

					String manv = etMNV.getText();
					String hoten = etHT.getText();
					String gioitinh = etGT.getText();
					SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
					Date ngaySinh=dd.parse(etNS.getText());
					String sdt = etSDT.getText();
					String diachi = etDC.getText();
					Date ngaylamviec=dd.parse(etNLV.getText());
					Long luong = Long.parseLong(etLuong.getText());
					dc.KetNoi();
					if(!kiemtra(manv).next()) {
						int t=JOptionPane.showConfirmDialog(null, "Are you sure?");
						if(t==0) {
						nvbo.them( manv, hoten, gioitinh, ngaySinh, sdt, diachi, ngaylamviec, luong);
						table.setModel(nvbo.napbang("nhanvien"));
						}
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Đã có nhân viên này");
					}
					
				
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btThem.setBounds(440, 244, 97, 25);
		contentPane.add(btThem);
		
		JButton btSua = new JButton("S\u1EEDa");
		btSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					
					String manv = etMNV.getText();
					String hoten = etHT.getText();
					String gioitinh = etGT.getText();
					SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
					Date ngaySinh=dd.parse(etNS.getText());
					String sdt = etSDT.getText();
					String diachi = etDC.getText();
					Date ngaylamviec=dd.parse(etNLV.getText());
					Long luong = Long.parseLong(etLuong.getText());
					if(kiemtra(manv).next()) {
						JOptionPane.showMessageDialog(null, "Đã có nhân viên này");
					}
					else {
						int t=JOptionPane.showConfirmDialog(null, "Are you sure?");
						if(t==0) {
						nvbo.sua( manv, hoten, gioitinh, ngaySinh, sdt, diachi, ngaylamviec, luong);
						table.setModel(nvbo.napbang("nhanvien"));
						}
					}	
					
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btSua.setBounds(440, 302, 97, 25);
		contentPane.add(btSua);
		
		JButton btXoa = new JButton("X\u00F3a");
		btXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int t=JOptionPane.showConfirmDialog(null, "Are you sure?");
					if(t==0) {
						String manv=etMNV.getText();
						nvbo.xoa(manv);
						table.setModel(nvbo.napbang("nhanvien"));
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btXoa.setBounds(440, 355, 97, 25);
		contentPane.add(btXoa);
		
		etTK = new JTextField();
		etTK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==10) {
					try {
						DefaultTableModel mh= new DefaultTableModel();
						mh.addColumn("MaNV");
						mh.addColumn("HoTen");
						mh.addColumn("GioiTinh");
						mh.addColumn("NgaySinh");
						mh.addColumn("SDT");
						mh.addColumn("DiaChi");
						mh.addColumn("NgayBDLV");
						mh.addColumn("Luong");
						dc.KetNoi();
						String name=etTK.getText();
						ResultSet rs=timkiem(name);
						Object[] t= new Object[9];
						while(rs.next()) {
							t[0]=rs.getString(1);
							t[1]=rs.getString(2);
							t[2]=rs.getString(3);
							t[3]=rs.getString(4);
							t[4]=rs.getString(5);
							t[5]=rs.getString(6);
							t[6]=rs.getString(7);
							t[7]=rs.getString(8);
							mh.addRow(t);
						}
						table.setModel(mh);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		});
		etTK.setBounds(533, 198, 116, 22);
		contentPane.add(etTK);
		etTK.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Tìm kiếm");
		lblNewLabel_9.setBounds(438, 201, 56, 16);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("Refresh");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					nvbo.getnv();
					table.setModel(nvbo.napbang("nhanvien"));
					etMNV.setText("");
					etHT.setText("");
					etGT.setText("");
					etNS.setText("");
					etDC.setText("");
					etSDT.setText("");
					etNLV.setText("");
					etLuong.setText("");
					etTK.setText("");
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(552, 244, 97, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("DANH SÁCH NHÂN VIÊN");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_10.setBounds(269, 28, 435, 43);
		contentPane.add(lblNewLabel_10);
	}
}
