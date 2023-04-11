package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/beelproject?autoReconnect=true&useSSL=false", "root", "123456789");
        Statement stmt = con.createStatement();

        // SELECT
//        ResultSet rs = stmt.executeQuery("SELECT * FROM boats");
//        ResultSetMetaData rsmd = rs.getMetaData();
//        System.out.println("Total columns: " + rsmd.getColumnCount());
//        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//            System.out.println(
//                    "Column " + i + " [name: " + rsmd.getColumnName(i) + " - type: " + rsmd.getColumnTypeName(i) + "]");
//        }
//        System.out.println("--------------------");
//        while (rs.next())
//            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
//
//        // Insert
//        String sqlInsert = "INSERT INTO boats(id, name, type, owner_id) "
//                + " VALUE(1001, 'Beel 1001', 'Strong', 12);";
//        int numberRowsAffected = stmt.executeUpdate(sqlInsert);
//        System.out.println("Affected rows after inserted: " + numberRowsAffected);
//
//        // Update
//        String sqlUpdate = "UPDATE boats SET name='Beel 860' WHERE id=860";
//        numberRowsAffected = stmt.executeUpdate(sqlUpdate);
//        System.out.println("Affected rows after updated: " + numberRowsAffected);
//
//        // Delete
//        String sqlDelte = "DELETE FROM boats WHERE id=864";
//        numberRowsAffected = stmt.executeUpdate(sqlDelte);
//        System.out.println("Affected rows after deleted: " + numberRowsAffected);

        // call procedure

        String sql = "{call getAllBoats()}";
        CallableStatement cstm = con.prepareCall(sql);
        try (ResultSet rs = cstm.executeQuery();) {
            while (rs.next()) {
                showUserInfo(rs);
            }
        }

        con.close();
    }

    private static void showUserInfo(ResultSet rs) throws SQLException {
        System.out.println("Id: " + rs.getInt(1));
        System.out.println("Name: " + rs.getString(2));
        System.out.println("Type: " + rs.getString(3));
        System.out.println("Ownder id: " + rs.getInt(4));
        System.out.println("Date made: " + rs.getDate(5));
        System.out.println("Rental price: " + rs.getFloat(6));
        System.out.println("---");
    }
}
