package com.example.demo;

import java.util.Date;

public class Locataire {



    public String getNUMEROCNI() {
        return NUMEROCNI;
    }

    public void setNUMEROCNI(String NUMEROCNI) {
        this.NUMEROCNI = NUMEROCNI;
    }

    public String getNUMPIECE() {
        return NUMPIECE;
    }

    public void setNUMPIECE(String NUMPIECE) {
        this.NUMPIECE = NUMPIECE;
    }

    public String getIDCONTRAT() {
        return IDCONTRAT;
    }

    public void setIDCONTRAT(String IDCONTRAT) {
        this.IDCONTRAT = IDCONTRAT;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public Date getDATENAISSANCE() {
        return DATENAISSANCE;
    }

    public void setDATENAISSANCE(Date DATENAISSANCE) {
        this.DATENAISSANCE = DATENAISSANCE;
    }

    public String getSEXE() {
        return SEXE;
    }

    public void setSEXE(String SEXE) {
        this.SEXE = SEXE;
    }

    public String getPROFESSION() {
        return PROFESSION;
    }

    public void setPROFESSION(String PROFESSION) {
        this.PROFESSION = PROFESSION;
    }

    public String getSTATUT_SOCIAL() {
        return STATUT_SOCIAL;
    }

    public void setSTATUT_SOCIAL(String STATUT_SOCIAL) {
        this.STATUT_SOCIAL = STATUT_SOCIAL;
    }

    public String getE_MAIL() {
        return E_MAIL;
    }

    public void setE_MAIL(String e_MAIL) {
        E_MAIL = e_MAIL;
    }

    private String NUMEROCNI;
    private String NUMPIECE;
    private String IDCONTRAT;
    private String NOM;
    private String PRENOM;
    private Date DATENAISSANCE;
    private String SEXE;
    private String PROFESSION;
    private String STATUT_SOCIAL;
    private String E_MAIL;

    public Locataire(){
        super();
    }

    public Locataire(String NUMEROCNI, String NUMPIECE, String IDCONTRAT, String NOM, String PRENOM, Date DATENAISSANCE, String PROFESSION, String STATUT_SOCIAL, String E_MAIL){
        this.NUMEROCNI = NUMEROCNI;
        this.NUMPIECE = NUMPIECE;
        this.IDCONTRAT = IDCONTRAT;
        this.NOM = NOM;
        this.DATENAISSANCE = DATENAISSANCE;
        this.SEXE = SEXE;
        this.PROFESSION = PROFESSION;
        this.STATUT_SOCIAL = STATUT_SOCIAL;
        this.E_MAIL = E_MAIL;
    }
}
