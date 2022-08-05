package com.example.demo;

import java.sql.*;

public class testConnection
{

    public static Connection connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/gestion";
            String user = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static int saveUser(Utilisateur user){
        int st = 0;
        try {
            String requete = "INSERT INTO utilisateur(LOGIN, PWD, NOM, E_MAIL) VALUES(?, ?, ?, ?)";
            Connection con = testConnection.connect();
            PreparedStatement stat = con.prepareStatement(requete);
            stat.setString(1, user.getLOGIN());
            stat.setString(2, user.getPWD());
            stat.setString(3, user.getNOM());
            stat.setString(4, user.getE_MAIL());

            st = stat.executeUpdate();
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }






    public static int saveLocataire(Locataire loc){
        int st = 0;
        try {
            String requete = "INSERT INTO locataire(NUMEROCNI, NUMPIECE, IDCONTRAT, NOM, PRENOM, DATENAISSANCE, SEXE, PROFESSION, STATUT_SOCIAL, E_MAIl ) VALUES (?, ? , ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = testConnection.connect();
            PreparedStatement stat = con.prepareStatement(requete);
            stat.setString(1, loc.getNUMEROCNI());
            stat.setString(2, loc.getNUMPIECE());
            stat.setString(3, loc.getIDCONTRAT());
            stat.setString(4, loc.getNOM());
            stat.setString(5, loc.getPRENOM());
            stat.setDate(6, (Date) loc.getDATENAISSANCE());
            stat.setString(7, loc.getSEXE());
            stat.setString(8, loc.getPROFESSION());
            stat.setString(9, loc.getSTATUT_SOCIAL());
            stat.setString(10, loc.getE_MAIL());


            st = stat.executeUpdate();
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }







    public static int deleteContrat (String id){
        int st = 0;

        try {
            String requete = "DELETE FROM contrat WHERE IDCONTRAT = ?";
            Connection con = testConnection.connect();
            PreparedStatement stat = con.prepareStatement(requete);
            stat.setString(1,id);
            st = stat.executeUpdate();
            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }

    public static Contrat getContrat(int id){
            Contrat ctr = new Contrat();
            try {
                String requete = "SELECT * FROM contrat WHERE IDCONTRAT = ?";
                Connection con = testConnection.connect();
                PreparedStatement stat = con.prepareStatement(requete);
                ResultSet resultat = stat.executeQuery();
                if(resultat.next()){
                    ctr.setIDCONTRAT(resultat.getString(1));
                    ctr.setNUMEROCNI(resultat.getString(2));
                    ctr.setNOM(resultat.getString(3));
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            return ctr;
    }
}
