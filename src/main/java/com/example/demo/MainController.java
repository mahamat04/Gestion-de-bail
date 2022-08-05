package com.example.demo;


import java.util.Date;

//import com.sun.glass.ui.Clipboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Label welcomeText;


    @FXML private TextField Txf;
    @FXML private PasswordField Pwd;
    @FXML private Label etat;

    @FXML
    public void Login (ActionEvent event) throws SQLException {
        Connection con = testConnection.connect();
        PreparedStatement stat = null;
        ResultSet resultat = null;
        String requete = "SELECT * FROM utilisateur WHERE LOGIN = ? AND PWD = ? ";
        try {
            stat = con.prepareStatement(requete);
            stat.setString(1, Txf.getText().toString());
            stat.setString(2, Pwd.getText().toString());
            resultat = stat.executeQuery();
            if(resultat.next())
            {
                etat.setText("Connection reussi");
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            else{
                etat.setText("Echec de la connection");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void Quitter(ActionEvent event) {
        System.exit(0);
    }

        @FXML
        private Stage stage;
        @FXML
        private Scene scene;
        @FXML
        private Parent root;

        @FXML
        public void Enreg(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("Enregistrer.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        public void Retour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Creation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Creation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Menu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void Creation2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Creation(2).fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Suppression(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Suppression.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void Consultation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Consultation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML private TableView<Contrat> maTable;
    @FXML private TableColumn<Contrat, String> IdContrat;
    @FXML private TableColumn<Contrat, String> NumCNI;
    @FXML private TableColumn<Contrat, String> Nom;
    @FXML private TableColumn<Contrat, Date> DateDebut;
    @FXML private TableColumn<Contrat, Integer> Duree;
    @FXML private TableColumn<Contrat, Date> DateFin;

    public ObservableList<Contrat> data = FXCollections.observableArrayList();

    Connection con = null;
    String requete = null;
    PreparedStatement stat = null;
    ResultSet resultat = null;

    @FXML
    public void AfficherContrat() throws IOException
    {

        try {
            requete = "SELECT * FROM contrat";
            stat = con.prepareStatement(requete);
            resultat = stat.executeQuery();
            while (resultat.next()){
                data.add(new Contrat(resultat.getString(1),
                        resultat.getString(2),
                        resultat.getString(3),
                        resultat.getDate(4),
                        resultat.getInt(5),
                        resultat.getDate(6)));

            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        IdContrat.setCellValueFactory(new PropertyValueFactory<Contrat, String>("IDCONTRAT"));
        NumCNI.setCellValueFactory(new PropertyValueFactory<Contrat, String>("NUMEROCNI"));
        Nom.setCellValueFactory(new PropertyValueFactory<Contrat, String>("NOM"));
        DateDebut.setCellValueFactory(new PropertyValueFactory<Contrat, Date>("DATEDEBUT"));
        Duree.setCellValueFactory(new PropertyValueFactory<Contrat, Integer>("DUREE"));
        DateFin.setCellValueFactory(new PropertyValueFactory<Contrat, Date>("DATEFIN"));

        maTable.setItems(data);

    }

    @FXML private TextField TxtN;
    @FXML private TextField TxtAd;
    @FXML private TextField TxtNu;
    @FXML private TextField TxtPs;
    @FXML private ComboBox<String> cbn;
    ObservableList<String> maListe = FXCollections.observableArrayList("1","2","3","4");

    @FXML
    public void AjouterUtilisateur()
    {
        String LOGIN = TxtNu.getText();
        String PWD = TxtPs.getText();
        String NOM = TxtN.getText();
        String E_MAIL = TxtAd.getText();

        Utilisateur user = new Utilisateur();
        user.setLOGIN(LOGIN);
        user.setPWD(PWD);
        user.setNOM(NOM);
        user.setE_MAIL(E_MAIL);

        int etat = testConnection.saveUser(user);

        if(etat > 0){
            Alert test = new Alert(Alert.AlertType.INFORMATION);
            test.setTitle("Ajout d'utilisateur");
            test.setHeaderText("Alerte");
            test.setContentText("Utilisateur ajouté");
            test.showAndWait();
        }
        else {
            Alert test = new Alert(Alert.AlertType.INFORMATION);
            test.setTitle("Ajout d'utilisateur");
            test.setHeaderText("Alerte");
            test.setContentText("Utilisateur non ajouté");
            test.showAndWait();
        }


    }

    @FXML
    public void vider(){
        TxtN.clear();
        TxtNu.clear();
        TxtAd.clear();
        TxtPs.clear();
    }



    @FXML private TextField TxtSupID;
    @FXML private TextField TxtSupNum;
    @FXML private TextField TxtSupNom;

    @FXML
    public void viderContrat(){
        TxtSupID.clear();
        TxtSupNum.clear();
        TxtSupNom.clear();
    }




    @FXML
    public void SupprimerContrat(){
        String sup = TxtSupID.getText();
        int etat = testConnection.deleteContrat(sup);
        if(etat > 0){
            Alert test = new Alert(Alert.AlertType.INFORMATION);
            test.setTitle("Suppression Contrat");
            test.setHeaderText("Alerte");
            test.setContentText("Contrat supprimer");
            test.showAndWait();
        }
        else {
            Alert test = new Alert(Alert.AlertType.INFORMATION);
            test.setTitle("Suppression Contrat");
            test.setHeaderText("Alerte");
            test.setContentText("Contrat non supprimer");
            test.showAndWait();
        }

    }



    @FXML private TextField TxtAddNumCNI;
    @FXML private TextField TxtAddNumP;
    @FXML private TextField TxtAddIDc;
    @FXML private TextField TxtAddNom;
    @FXML private TextField TxtAddPrenom;
    @FXML private DatePicker TxtAddDate;
    @FXML private TextField TxtAddSexe;
    @FXML private TextField TxtAddProf;
    @FXML private TextField TxtAddSat;
    @FXML private TextField TxtAddEmail;

    @FXML
    public void AjoutLocataire(ActionEvent event) throws IOException
    {
        String NUMEROCNI = TxtAddNumCNI.getText();
        String NUMPIECE = TxtAddNumP.getText();
        String IDCONTRAT = TxtAddIDc.getText();
        String NOM = TxtAddNom.getText();
        String PRENOM = TxtAddPrenom.getText();
        Date DATENAISSANCE = (Date) TxtAddDate.getUserData();
        String SEXE = TxtAddSexe.getText();
        String PROFESSION = TxtAddProf.getText();
        String STATUT_SOCIAL = TxtAddSat.getText();
        String E_MAIL = TxtAddEmail.getText();


        Locataire loc = new Locataire();

        loc.setNUMEROCNI(NUMEROCNI);
        loc.setNUMPIECE(NUMPIECE);
        loc.setIDCONTRAT(IDCONTRAT);
        loc.setNOM(NOM);
        loc.setPRENOM(PRENOM);
        loc.setDATENAISSANCE(DATENAISSANCE);
        loc.setSEXE(SEXE);
        loc.setPROFESSION(PROFESSION);
        loc.setSTATUT_SOCIAL(STATUT_SOCIAL);
        loc.setE_MAIL(E_MAIL);

        int etat = testConnection.saveLocataire(loc);

        if(etat > 0){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Creation(2).fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else {
            Alert test = new Alert(Alert.AlertType.INFORMATION);
            test.setTitle("Ajout Loctaire");
            test.setHeaderText("Alerte");
            test.setContentText("Loactaire non ajouté");
            test.showAndWait();
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}