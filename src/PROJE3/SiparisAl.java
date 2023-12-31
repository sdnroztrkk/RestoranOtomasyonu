package PROJE3;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class SiparisAl {
	public void Siparis(String MasaAdi, String  YemekAdi)
    {
		
        Connection connection;
        Baglan bag = new Baglan();
        PreparedStatement statement;
        ResultSet resultSet;
        try{
            connection = bag.getConnection();
            
            statement = connection.prepareStatement("select YemekAdi,Fiyat from MENU where YemekAdi=?");
            statement.setString(1,YemekAdi);
            resultSet = statement.executeQuery();
            SiparisYonetim order1 = new SiparisYonetim();
            SiparisYonetim table = new SiparisYonetim();
            while (resultSet.next()){
                order1.insert(MasaAdi, resultSet.getString("YemekAdi"),resultSet.getInt("Fiyat"));
            }
            table.deletetable(MasaAdi);
            table.tableCreate(MasaAdi,"DOLU");
           
        }catch (SQLException exception){
            bag.showErrorMessage(exception);
        }
    }


}
