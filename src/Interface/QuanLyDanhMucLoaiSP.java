/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import DataBase.connect;
import Proccess.LoaiSP;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
/**
 *
 * @author haidu
 */
public final class QuanLyDanhMucLoaiSP extends javax.swing.JFrame {

   private final LoaiSP lsp = new LoaiSP();
   private boolean cothem = true;
   private final connect cn = new connect();
   
   private final DefaultTableModel tableModel = new DefaultTableModel();
   
public void ShowData() throws SQLException {
    List<LoaiSP> lst = lsp.getALLLoaiSP(); // Lấy danh sách LoaiSP
       for (LoaiSP loaiSP : lst) {
           Object[] rows = {loaiSP.getMaloai(), loaiSP.getTenloai()};
           tableModel.addRow(rows); // Thêm dòng dữ liệu vào tableModel
       } // Xử lý ngoại lệ
}

   
   //Ham xoa du lieu trong tableModel   //Ham xoa du lieu trong tableModel
    public void ClearData() throws SQLException{
        //Lay chi so dong cuoi cung
        int n=tableModel.getRowCount()-1;
        for(int i=n;i>=0;i--)
        tableModel.removeRow(i);//Remove tung dong
    }

   //Ham xoa cac TextField
    private void setNull()
    {
    //Xoa trang cac JtextField
        this.txtMaloai.setText(null);
        this.txtTenloai.setText(null);
        this.txtMaloai.requestFocus();
    }

        //Ham khoa cac TextField
    private void setKhoa(boolean a)
    {
        //Khoa hoac mo khoa cho Cac JTextField
        this.txtMaloai. setEnabled (!a);
        this.txtTenloai. setEnabled (!a);
    }
    
    //Ham khoa cac Button
    private void setButton(boolean a)
    {
    //Vo hieu hoac co hieu luc cho cac JButton
        this.btThem. setEnabled (a);
        this.btXoa. setEnabled (a);
        this.btSua. setEnabled (a);
        this.btLuu. setEnabled (!a);
        this.btKLuu. setEnabled (!a);
        this.btThoat. setEnabled (a);
    }
   
    public QuanLyDanhMucLoaiSP() throws SQLException{
        initComponents(); // Khởi tạo các components trên JFrame
        String []colsName = {"Mã Loai", "Tên loai"};
        // đặt tiêu đề cột cho tableModel
        tableModel.setColumnIdentifiers(colsName);
        // kết nối jtable với tableModel
        jTableLoaiSP.setModel(tableModel);
        //gọi hàm ShowData để đưa dữ liệu vào tableModel
        ShowData();
        //goi Ham xoa trang cac TextField
        setNull();
        //Goi ham Khoa cac TextField
        setKhoa(true);
        //Goi vo hieu 2 button Luu, K.Luu. Mo khoa 4 button con lao
        setButton(true);
}
    public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
        try {
            new QuanLyDanhMucLoaiSP().setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khởi tạo: " + e.getMessage());
        }
    });
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        labelml = new javax.swing.JLabel();
        txtMaloai = new javax.swing.JTextField();
        txtTenloai = new javax.swing.JTextField();
        labeltl = new javax.swing.JLabel();
        btThem = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btLuu = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLoaiSP = new javax.swing.JTable();
        btKLuu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DANH MỤC LOẠI SẢN PHẨM");

        labelml.setText("Mã Loại: ");

        txtMaloai.setToolTipText("");
        txtMaloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaloaiActionPerformed(evt);
            }
        });

        txtTenloai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenloaiActionPerformed(evt);
            }
        });

        labeltl.setText("Tên Loại");

        btThem.setText("Thêm");
        btThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btThemMouseClicked(evt);
            }
        });

        btXoa.setText("Xóa");
        btXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaMouseClicked(evt);
            }
        });

        btSua.setText("Sửa");
        btSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSuaMouseClicked(evt);
            }
        });

        btLuu.setText("Lưu");
        btLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLuuMouseClicked(evt);
            }
        });

        btThoat.setText("Thoát");
        btThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btThoatMouseClicked(evt);
            }
        });

        jTableLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Loại", "Tên Loại"
            }
        ));
        jTableLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLoaiSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLoaiSP);
        if (jTableLoaiSP.getColumnModel().getColumnCount() > 0) {
            jTableLoaiSP.getColumnModel().getColumn(0).setResizable(false);
        }

        btKLuu.setText("K Lưu");
        btKLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btKLuuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btThem)
                                .addGap(41, 41, 41)
                                .addComponent(btXoa)
                                .addGap(44, 44, 44)
                                .addComponent(btSua)
                                .addGap(46, 46, 46)
                                .addComponent(btLuu)
                                .addGap(60, 60, 60)
                                .addComponent(btKLuu)
                                .addGap(55, 55, 55)
                                .addComponent(btThoat))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labeltl)
                                    .addComponent(labelml))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenloai, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelml)
                    .addComponent(txtMaloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labeltl)
                    .addComponent(txtTenloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btXoa)
                    .addComponent(btSua)
                    .addComponent(btLuu)
                    .addComponent(btThoat)
                    .addComponent(btKLuu))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaloaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaloaiActionPerformed

    private void txtTenloaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenloaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenloaiActionPerformed

    private void jTableLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLoaiSPMouseClicked
      // Hiển thị dữ liệu lên các JTextField khi Click chuột vào JTable
{
    try {
        int row = jTableLoaiSP.getSelectedRow(); // Lấy chỉ số dòng đang chọn
        String ml = jTableLoaiSP.getModel().getValueAt(row, 0).toString(); // Lấy mã loại từ cột đầu tiên
        
        // Gọi hàm lấy dữ liệu theo mã loại
        LoaiSP obj = lsp.getLoaiSP(ml); 

        if (obj != null) {
            // Set text vào từng JTextField
            txtMaloai.setText(obj.getMaloai());
            txtTenloai.setText(obj.getTenloai());
            // Thêm các trường khác nếu cần
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log hoặc xử lý ngoại lệ
    } catch (Exception e) {
        e.printStackTrace(); // Xử lý các ngoại lệ khác nếu cần
    }
}
    }//GEN-LAST:event_jTableLoaiSPMouseClicked

    private void btThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThoatMouseClicked
       this.dispose();
    }//GEN-LAST:event_btThoatMouseClicked

    private void btXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaMouseClicked
        String ml = txtMaloai.getText();
        try {
            if (ml.length() == 0) {
                JOptionPane.showMessageDialog(null, "Chọn 1 loại SP để xóa", "Thông báo", 1);
            } else {
                if (JOptionPane.showConfirmDialog(null, "Bạn muốn xóa loại " + ml + " này hay không?", "Thông báo", 2) == 0) {
                    lsp.DeleteData(ml); // Gọi hàm xóa dữ liệu theo mã loại
                    ClearData();        // Xóa dữ liệu trong tableModel
                    ShowData();         // Đổ dữ liệu vào table Model
                    setNull();          // Xóa trắng Textfield
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Xóa thất bại", "Thông báo", 1);
        }

    }//GEN-LAST:event_btXoaMouseClicked

    private void btThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThemMouseClicked
        // TODO add your handling code here:
            setNull();//Xoa trang TextField
    setKhoa(false);//Mo khoa TextField
    setButton(false);//Goi ham khoa cac Button
    cothem=true;//Gan cothem = true de ghi nhan trang thai them moi
    }//GEN-LAST:event_btThemMouseClicked

    private void btSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSuaMouseClicked
        // TODO add your handling code here:
        String ml=txtMaloai.getText();
        if(ml.length()==0) //Chua chon Ma loai
        JOptionPane.showMessageDialog(null,"Vui long chon loi can sua",
        "Thong bao",1);
        else
        {
        setKhoa(false);//Mo khoa cac TextField
        this.txtMaloai.enable(false);
        setButton(false); //Khoa cac Button
        cothem=false; //Gan cothem=false de ghi nhan trang thai la sua
        }
    }//GEN-LAST:event_btSuaMouseClicked

    private void btLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLuuMouseClicked
        // TODO add your handling code here:
        
    String ml = txtMaloai.getText();
    String tl = txtTenloai.getText();

    if (ml.length() == 0 || tl.length() == 0) {
        JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã loại và Tên loại", "Thông báo", 1);
    } else if (ml.length() > 2 || tl.length() > 30) {
        JOptionPane.showMessageDialog(null, "Mã loại chỉ 2 ký tự, tên loại là 20", "Thông báo", 1);
    } else {
        try {
            LoaiSP obj = new LoaiSP();
            obj.setMaloai(ml); // Giả sử có phương thức setMaloai trong lớp LoaiSP
            obj.setTenloai(tl); // Giả sử có phương thức setTenloai trong lớp LoaiSP

            if (cothem == true) { // Lưu cho thêm mới
                lsp.InsertData(obj);
            } else { // Lưu cho sửa
                lsp.EditData(obj);
            }

            ClearData(); // Gọi hàm xóa dữ liệu trong tableModel
            ShowData();  // Đổ lại dữ liệu vào Table Model
            setNull();   // Xóa trắng Textfield

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại", "Thông báo", 1);
        }

        setKhoa(false);
        setButton(true);
    }  
    }//GEN-LAST:event_btLuuMouseClicked

    private void btKLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btKLuuMouseClicked
        // TODO add your handling code here:
        setNull();
setKhoa(true);
setButton(true);
    }//GEN-LAST:event_btKLuuMouseClicked

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btKLuu;
    private javax.swing.JButton btLuu;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btThoat;
    private javax.swing.JButton btXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLoaiSP;
    private javax.swing.JLabel labelml;
    private javax.swing.JLabel labeltl;
    private javax.swing.JTextField txtMaloai;
    private javax.swing.JTextField txtTenloai;
    // End of variables declaration//GEN-END:variables

    private void setVisiable(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
