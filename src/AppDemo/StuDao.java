package AppDemo;

import java.sql.*;

public class StuDao {
    private static String DB_URL = "jdbc:mysql://localhost:3306/stusystem?useSSL=false";
    private static String driver = "com.mysql.jdbc.Driver";
    private static String USER = "root";
    private static String PASS = "bxy0516";
    private static Connection conn = null;
    private static PreparedStatement ps = null;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void closeAll() {
        try {
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addStuData(String id, String stuName, double math, double eng, double cplus, double PE){
        try {
            Class.forName(driver);
            conn=getConnection();
            String sql="INSERT INTO StuData (id,stuName,passWord,math,eng,cplus,PE) VALUES (?,?,?,?,?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setObject(1,id);
            ps.setObject(2,stuName);
            ps.setObject(3,"111111");
            ps.setObject(4,math);
            ps.setObject(5,eng);
            ps.setObject(6,cplus);
            ps.setObject(7,PE);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }

    public static void deleteStuData(String stuName){
        try {
            Class.forName(driver);
            conn=getConnection();
            String sql="DELETE FROM StuData WHERE stuName=?";
            ps=conn.prepareStatement(sql);
            ps.setObject(1,stuName);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }

    public static void changeStuData(String stuName, String id, double math, double eng, double cplus, double PE){
        try {
            Class.forName(driver);
            conn=getConnection();
            String sql="UPDATE StuData SET id=?,math=?,eng=?,cplus=?,PE=? WHERE stuName=?";;
            ps=conn.prepareStatement(sql);
            ps.setObject(1,id);
            ps.setObject(2,math);
            ps.setObject(3,eng);
            ps.setObject(4,cplus);
            ps.setObject(5,PE);
            ps.setObject(6,stuName);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }

    public static void changeStuPassword(String stuName, String passWord){
        try {
            Class.forName(driver);
            conn=getConnection();
            String sql="UPDATE StuData SET passWord=? WHERE stuName=?";;
            ps=conn.prepareStatement(sql);
            ps.setObject(1,passWord);
            ps.setObject(2,stuName);
            ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            closeAll();
        }
    }
}
