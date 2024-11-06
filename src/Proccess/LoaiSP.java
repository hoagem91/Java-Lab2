/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proccess;

import DataBase.connect;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class LoaiSP {
    private String maloai; // Mã loại
    private String tenloai; // Tên loại

    private String LoaiSP;
    private String Sanpham;

    // Getter và Setter cho LoaiSP
    public String getLoaiSP() {
        return LoaiSP;
    }

    public void setLoaiSP(String LoaiSP) {
        this.LoaiSP = LoaiSP;
    }

    // Getter và Setter cho Sanpham
    public String getSanpham() {
        return Sanpham;
    }

    public void setSanpham(String Sanpham) {
        this.Sanpham = Sanpham;
    }
    // Getter và Setter cho maloai
    public String getMaloai() {
        return maloai;
    }

    public void setMaloai(String maloai) {
        this.maloai = maloai;
    }

    // Getter và Setter cho tenloai
    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }
    
    public connect cn= new connect();

    public List<LoaiSP> getALLLoaiSP() throws SQLException {
        String sql = "SELECT * FROM LoaiSP";
        List<LoaiSP> list = new ArrayList<>();
        try (Connection conn = cn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                LoaiSP loaiSP = new LoaiSP();
                loaiSP.setMaloai(rs.getString("Maloai")); // Thiết lập mã loại từ kết quả
                loaiSP.setTenloai(rs.getString("Tenloai")); // Thiết lập tên loại từ kết quả
                list.add(loaiSP);
            }
        }
        return list;
    }
    public LoaiSP getLoaiSP(String ml) throws SQLException {
        String sql = "SELECT * FROM LoaiSP WHERE Maloai=?";
        LoaiSP loaiSP = null;

        try (Connection conn = cn.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ml);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    loaiSP = new LoaiSP();
                    loaiSP.setMaloai(rs.getString("Maloai"));
                    loaiSP.setTenloai(rs.getString("Tenloai"));
                }
            }
        } 
        return loaiSP;
    }
    public boolean InsertData(LoaiSP obj) throws SQLException {
            String sql = "INSERT INTO LoaiSP (Maloai, Tenloai) VALUES (?, ?)";
            try (Connection conn = cn.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, obj.getMaloai());
            stmt.setString(2, obj.getTenloai());
            int rowsAffected = stmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected); // Kiểm tra số dòng bị ảnh hưởng
            return rowsAffected > 0;
            }
    }


    public boolean EditData(LoaiSP obj) throws SQLException {
        String sql = "UPDATE LoaiSP SET Tenloai = ? WHERE Maloai = ?";
    try (Connection conn = cn.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, obj.getTenloai());
        stmt.setString(2, obj.getMaloai());
        int rowsAffected = stmt.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected); // Kiểm tra số dòng bị ảnh hưởng
        return rowsAffected > 0;
        }
    }


    public boolean DeleteData(String ml) throws SQLException {
        String sql = "Delete from LoaiSP where Maloai=?";
        try (Connection conn = cn.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ml);
            return stmt.executeUpdate() > 0;
        }
    }
    //Truy van lieu trong Table Sanpham theo Maloai 
    public ResultSet LoaiSPTheoloai(String ml) { 
        String sql = "SELECT MaSP,TenSP,Dongia,Tenloai FROM Sanpham S, LoaiSP L where L.Maloai=S.Maloai and L.Maloai= '" + ml + "'";
        try{
            return cn.LoadData(sql);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Truy xuat du lieu khong thanh cong " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public ResultSet ShowLoaiSP() throws SQLException{
        String query = "SELECT Maloai FROM LOAISP";
        Connection conn = cn.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        return statement.executeQuery();
    }
}
