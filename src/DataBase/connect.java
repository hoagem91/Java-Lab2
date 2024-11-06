/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DataBase;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.*;

/**
 *
 * @author Lenovo
 */
public class connect {

    private String server = "localhost";
    private String user = "sa";
    private String password = "123456";
    private String db = "LoaiSP";
    private int port = 1433;

    // Method to create and return a new connection to the SQL Server database
    public Connection getConnection() {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        ds.setEncrypt(false);
        ds.setTrustServerCertificate(true);

        try {
            Connection conn = ds.getConnection();
            System.out.println("Kết nối thành công!"); // Success message
            return conn;
        } catch (SQLException ex) {
            System.out.println("Kết nối thất bại: " + ex.getMessage()); // Failure message
            return null;
        }
    }

    // Method to close a given connection
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối thành công.");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public ResultSet LoadData(String sql) throws SQLException{
        Connection conn = getConnection();
        if(conn != null){
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        }
        return null;
    }
    public void UpdateData(String sql) throws SQLException {
        Connection conn = getConnection();
        Statement statement = conn.createStatement();
        statement.executeUpdate(sql);
    }
}
 
