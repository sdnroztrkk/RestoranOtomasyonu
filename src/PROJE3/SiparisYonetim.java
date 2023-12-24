package PROJE3;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class SiparisYonetim {

	public void insert(String MasaAdi,String YemekAdi,int Fiyat )
    {
        Connection connection;
        Baglan bag = new Baglan();
        PreparedStatement statement;
        try{
            connection = bag.getConnection();
            String sql = "insert into SİPARİSLAR (MasaAdi,YemekAdi,Fiyat) values (?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,MasaAdi);
            statement.setString(2,YemekAdi);
            statement.setInt(3,Fiyat);
            statement.executeUpdate();
        }catch (SQLException exception){
            bag.showErrorMessage(exception);
        }
    }

 
 

 public void deleteOrder(String MasaAdi)
    {
        Connection connection;
        Baglan bag = new Baglan();
        PreparedStatement statement;
        try{
            connection= bag.getConnection();
            statement = connection.prepareStatement("delete from SİPARİSLAR where MasaAdi =?");
            statement.setString(1,MasaAdi);
            statement.executeUpdate();
        }catch (SQLException exception){
            bag.showErrorMessage(exception);
        }
    }
 public void getPaid(String MasaAdi) {
	 int fatura = 0;
	Connection connection;
        Baglan helper = new Baglan();
        PreparedStatement Statement;
        ResultSet resultSet;
        try{
            connection = helper.getConnection();
            Statement = connection.prepareStatement("select  id,MasaAdi,YemekAdi,Fiyat from SİPARİSLAR where MasaAdi=?");
            Statement.setString(1,MasaAdi);
            resultSet = Statement.executeQuery();
            List<Integer> fiyatlar = new ArrayList<>();
            while (resultSet.next()){
    			System.out.print(resultSet.getString("YemekAdi")+"      ");
    			System.out.println(resultSet.getInt("Fiyat")+" ");
    			int fiyat = resultSet.getInt("Fiyat");
    	        fiyatlar.add(fiyat);
              
            }
            for (int fiyat : fiyatlar) {
                fatura += fiyat;
            }
            KasaYonetim pay1 = new KasaYonetim();
                pay1.insert(MasaAdi,fatura);
           // System.out.println("Toplam Fiyat: " + fatura);
            deleteOrder(MasaAdi);
            deletetable(MasaAdi);
            tableCreate(MasaAdi,"BOS");
            
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
    }
 public void deletetable(String MasaAdi)
    {
        Connection connection;
        Baglan helper = new Baglan();
        PreparedStatement statement;
        try{
            connection= helper.getConnection();
            statement = connection.prepareStatement("delete from MASALAR where MasaAdi =?");
            statement.setString(1,MasaAdi);
            statement.executeUpdate();
        }catch (SQLException exception){
            helper.showErrorMessage(exception);
        }
    }
 public void tableCreate(String MasaAdi,String Durum)
    {
	    Connection connection;
        Baglan bag = new Baglan();
        PreparedStatement statement;
        try{
            connection= bag.getConnection();
            String sql = "insert into MASALAR (MasaAdi,Durum) values (?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,MasaAdi);
            statement.setString(2,Durum);
            statement.executeUpdate();
        }catch (SQLException exception){
            bag.showErrorMessage(exception);
        }
    }
	
}
