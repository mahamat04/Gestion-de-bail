package com.example.demo;

public class Utilisateur {

    public String getLOGIN() {
        return LOGIN;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public String getPWD() {
        return PWD;
    }

    public void setPWD(String PWD) {
        this.PWD = PWD;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getE_MAIL() {
        return E_MAIL;
    }

    public void setE_MAIL(String e_MAIL) {
        E_MAIL = e_MAIL;
    }

    private String LOGIN;
    private String PWD;
    private String NOM;
    private String E_MAIL;





    public Utilisateur(){
        super();
    }
    public Utilisateur(String LOGIN, String PWD, String NOM, String E_MAIL){
        super();
        this.LOGIN = LOGIN;
        this.PWD = PWD;
        this.NOM = NOM;
        this.E_MAIL = E_MAIL;
    }
}
