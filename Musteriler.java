package suotomasyonu;

public class Musteriler {
    
    private int id;
    private String adi;
    private String soyadi;
    private String telefon ;
    private String adres;

     Musteriler(int id,String adi,String soyadi,String telefon,String adres){
         this.id=id;
         this.adi=adi;
         this.soyadi=soyadi;
         this.telefon=telefon;
         this.adres=adres;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
  