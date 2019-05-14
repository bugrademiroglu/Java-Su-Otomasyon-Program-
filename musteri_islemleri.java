package suotomasyonu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class musteri_islemleri {
    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    public musteri_islemleri(){
           String url = "jdbc:mysql://" + Database.host + ":" + Database.port + "/" + Database.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        
     
        
        
    }
    
    
    public ArrayList<Musteriler> musterileriGetir() {
        
        ArrayList<Musteriler> cikti = new ArrayList<Musteriler>();
        
        try {
            statement =  con.createStatement();
            String sorgu =  "SELECT * FROM `musteriler` ";
            
            ResultSet rs =  statement.executeQuery(sorgu);
            
            while(rs.next()) {
                int id = rs.getInt("id");
                String adi = rs.getString("adi");
                String soyadi= rs.getString("soyadi");
                String telefon= rs.getString("telefon");
                String adres = rs.getString("adres");
                
                cikti.add(new Musteriler(id, adi, soyadi, telefon, adres));
                
                
            }
            return cikti;
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(musteri_islemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
        
        
        
        
    }
    public void musteriGuncelle(int id,String yeni_ad,String yeni_soyad,String yeni_telefon,String yeni_adres) {
        String sorgu =  "Update calisanlar set adi = ? , soyadi = ? , telefon = ? , adres = ? where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1,yeni_ad);
            preparedStatement.setString(2,yeni_soyad);
            
            preparedStatement.setString(3,yeni_telefon);
            preparedStatement.setString(4,yeni_adres);
            
            preparedStatement.setInt(5, id);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(musteri_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    public void MusteriSil(int id) {
        
        String sorgu = "Delete from calisanlar where id = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, id);
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(musteri_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    public void MusteriEkle(String ad,String soyad,String departman,String maas) {
        
        String sorgu = "Insert Into calisanlar (ad,soyad,departman,maas) VALUES(?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            
            preparedStatement.setString(1, ad);
            preparedStatement.setString(2, soyad);
            preparedStatement.setString(3, departman);
            preparedStatement.setString(4, maas);
            
            preparedStatement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(musteri_islemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
    }
    /*public boolean girisYap(String kullanici_adi,String parola) {
        
        String sorgu =  "Select * From adminler where username = ? and password = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            
            preparedStatement.setString(1,kullanici_adi);
            preparedStatement.setString(2,parola);
            
            ResultSet rs =  preparedStatement.executeQuery();
            
            return rs.next();
            
        } catch (SQLException ex) {
            Logger.getLogger(CalisanIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
*/

    
        
        
        
        
        
        
    }

    
