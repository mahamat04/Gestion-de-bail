package com.example.demo;

import java.sql.Date;

public class Contrat {
    private String IDCONTRAT;


    public String getIDCONTRAT() {
        return IDCONTRAT;
    }

    public void setIDCONTRAT(String IDCONTRAT) {
        this.IDCONTRAT = IDCONTRAT;
    }

    public String getNUMEROCNI() {
        return NUMEROCNI;
    }

    public void setNUMEROCNI(String NUMEROCNI) {
        this.NUMEROCNI = NUMEROCNI;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public Date getDATEDEBUT() {
        return DATEDEBUT;
    }

    public void setDATEDEBUT(Date DATEDEBUT) {
        this.DATEDEBUT = DATEDEBUT;
    }

    public int getDUREE() {
        return DUREE;
    }

    public void setDUREE(int DUREE) {
        this.DUREE = DUREE;
    }

    public Date getDATEFIN() {
        return DATEFIN;
    }

    public void setDATEFIN(Date DATEFIN) {
        this.DATEFIN = DATEFIN;
    }

    private String NUMEROCNI;
    private String NOM;
    private Date DATEDEBUT;
    private int DUREE;
    private Date DATEFIN;





    public Contrat(){
        super();
    }
    public Contrat(String IDCONTRAT, String NUMEROCNI, String NOM, Date DATEDEBUT, int DUREE, Date DATEFIN){
        super();
        this.IDCONTRAT = IDCONTRAT;
        this.NUMEROCNI = NUMEROCNI;
        this.NOM = NOM;
        this.DATEDEBUT = DATEDEBUT;
        this.DUREE = DUREE;
        this.DATEFIN = DATEFIN;

    }


}
