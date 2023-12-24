package PROJE3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) {
		final String dbUrl="jdbc:mysql://localhost:3306/NESPRO";
		 final String userName="root";
		 final String password="Karatekin123";
		try (Connection connection = DriverManager.getConnection(dbUrl, userName, password)) {
           if (connection != null) {
               System.out.println("Veritabanına başarıyla bağlandı!");
               Statement statement = connection.createStatement();
               String sql="CREATE DATABASE NESPRO";
               //statement.executeUpdate(sql);
       		

               // Tablo oluşturma sorgusu
               String createTableSQL = "CREATE TABLE YONETİM "
                       + "( Kullanıcı VARCHAR(20), "
                       +  "Sifre INTEGER)";

               // Tablo oluşturma sorgusunu çalıştırma
             // statement.executeUpdate(createTableSQL);
              String sql3 ="INSERT INTO YONETİM VALUES ('TUSUZE',1234)";
              statement.executeUpdate(sql3);

             //  System.out.println("tablosu oluşturuldu!");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

	}


}
