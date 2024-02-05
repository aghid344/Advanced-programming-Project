package com.mycompany.projectap;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class App extends Application {
    
    private Session session = HibernateUtil.getSessionFactory().openSession();
    private Transaction tx = session.beginTransaction();
    private final ObservableList<String> Types = FXCollections.observableArrayList("All", "Dogs Only", "Cats Only", "Birds Only");
    private String imagePath, petImage;  
    private ImageView imageViewAt, imageViewPet;
    private TextField petNametf, petAgetf, petWeighttf, ownerNametf, ownerPhonetf, ownerEmailtf, ownerAddresstf, 
            nameTextPage2, emailTextPage2, petTextPage2, nameOrEmailText, tf1, tf2, tf3, tf4;
    private PasswordField passwordField, passwordLGField;
    private TextArea txtInfo, reasonTa;
    private DatePicker datePicker, arrive, dep;
    private ComboBox<String> cboType, cboGender;
    private ToggleGroup groupAge, groupPetType;
    private RadioButton catRadio, dogRadio, birdRadio, adoptRadio;
    private User retrievedUser = new User();
    private UserPet retrievedPet;
    private PetHotel retrievedPetHotel;
    private int retrievedUserId, retrievedPetId, lastPrice;;
    private ChoiceBox<String> petTypeListHotel, cityListForHotel;
    private Label givenName, givenType, givenDOB, givenUsername, givenEmail, givenFood, givenHealth, givenCare, givenGame;
    //private Image PetPic;
    
    
    Scene NadeemScene ;
    Scene PetHotelScene ;
    Scene Adoption;
    Scene Medical;
    Scene LogIn;
    Scene SignUp;
    Scene Menu;
    Scene enviromentInfo;
    Scene Adopt;
    Scene AdoptOffer1;
    Scene AdoptOffer2;
    Scene AddPetInfo;
    Scene About;
    Scene PetAccount;

    @Override
    public void start(Stage stage) {
        
         String color = "#e7eff1" ;
         
         
         /////////////////////////////////////////////////////////////////////////////////////////////////// Log in and Sign up Scene //////////////////////////////////////////////////////////////////////////////////////////////////////////
        BorderPane borderFirst = new BorderPane();
        borderFirst.setStyle("-fx-background-color: " + color);
        borderFirst.setPadding(new Insets(20));
        
       
        VBox CenterFirst = new VBox(20);
        CenterFirst.setStyle(color);
       CenterFirst.setAlignment(Pos.CENTER);
       
        Text welcomeFirst = new Text("Welcome To");
        welcomeFirst.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 45));
        welcomeFirst.setTextAlignment(TextAlignment.CENTER);
        welcomeFirst.setFill(Color.GRAY);
        
        Label NadeemFirst = new Label(" نَــدِيـم");
        NadeemFirst.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD,FontPosture.ITALIC, 80));
        NadeemFirst.setTextFill(Color.rgb(42,78,80));
         
        Text petOwnerFirst = new Text("pet owners community");
        petOwnerFirst.setTextAlignment(TextAlignment.CENTER);
        petOwnerFirst.setFont(Font.font("Comic Sans MS", FontWeight.SEMI_BOLD, 35));
        petOwnerFirst.setFill(Color.DARKGRAY);
        
        
         Button LoginFirst = new Button("Log in");
         LoginFirst.setPrefWidth(300);
         LoginFirst.setPrefHeight(50);
         LoginFirst.setStyle("-fx-base: #a7ab9e ; -fx-font:25 arial;");
         Button SignupFirst = new Button("Sign up");
         SignupFirst.setPrefWidth(300);
         SignupFirst.setPrefHeight(50);
         SignupFirst.setStyle("-fx-base: #a7ab9e ; -fx-font:25 arial;");
        
         CenterFirst.getChildren().addAll(welcomeFirst,NadeemFirst,petOwnerFirst,LoginFirst,SignupFirst);
         
         VBox leftFirst = new VBox();
         ImageView catFootFirst = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\cat foot.png");
         catFootFirst.setFitHeight(450);
         catFootFirst.setFitWidth(90);

         leftFirst.getChildren().addAll(catFootFirst);
        
        StackPane bottomFirst = new StackPane();
        ImageView BirdFirst = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\bird.png");
        
        bottomFirst.getChildren().addAll(BirdFirst);
        bottomFirst.setAlignment(Pos.BASELINE_RIGHT);
        bottomFirst.setPadding(new Insets(20));
        
        borderFirst.setCenter(CenterFirst);
        borderFirst.setLeft(leftFirst);
        borderFirst.setBottom(bottomFirst);
        
        NadeemScene = new Scene(borderFirst,640,640);
        
        /////////////////////////////////////////////////////////////////////////////////////////////////// Sign up Scene //////////////////////////////////////////////////////////////////////////////////////////////////////////
        Color fontColor = Color.rgb(73, 65, 64);
        
        VBox rootSignUp = new VBox();
        rootSignUp.setAlignment(Pos.TOP_CENTER);
        rootSignUp.setStyle("-fx-background-color: #e7eff1 ");
        
        HBox creatAccountPage = new HBox(20);
        creatAccountPage.setAlignment(Pos.CENTER);
        creatAccountPage.setPadding(new Insets(10));
        
        Text CAtext = new Text();
        CAtext.setText("Create New Account");
        CAtext.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 40)); 
        CAtext.setFill(fontColor);
        
        ImageView backArrowSign = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\left-arrow.png");
         backArrowSign.setFitHeight(13);
         backArrowSign.setFitWidth(15);
         
         Button backSign = new Button("Back",backArrowSign);
         backSign.setPrefWidth(80);
         backSign.setPrefHeight(20);
         backSign.setStyle("-fx-base: #a7ab9e ; -fx-font:15 arial;");
         backSign.setAlignment(Pos.CENTER);
        
        VBox userInfo = new VBox(); 
        
        //username
        Text UNtext = new Text();
        UNtext.setText("\nUSERNAME*");
        UNtext.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 10)); 
        UNtext.setFill(fontColor);
        nameTextPage2 = new TextField(); 
        nameTextPage2.setPromptText("Choose a username Ex. Amal_2");
        nameTextPage2.setStyle("-fx-background-color: #e7eff1; "+ "-fx-text-fill: #A7AB9E; "+ "-fx-font-size: 15px; " + "-fx-border-color: #A7AB9E; "+ "-fx-border-width: 2px;"+ "-fx-padding: 10px 80px;");
        
        
        
        //Email
        Text EText = new Text();
        EText.setText("\nEMAIL*");
        EText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 10));        EText.setFill(fontColor);
        emailTextPage2 = new TextField();
        emailTextPage2.setPromptText("Enter your E-mail Ex. yourname@example.com");
        emailTextPage2.setStyle("-fx-background-color: #e7eff1; "                + "-fx-text-fill: #A7AB9E; "
                + "-fx-font-size: 15px; "                + "-fx-border-color: #A7AB9E; "
                + "-fx-border-width: 2px;"                + "-fx-padding: 10px 80px;");

                   
        //Password 
        Text PassText = new Text(); 
        PassText.setText("\nPASSWORD*");
        PassText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 10)); 
        PassText.setFill(fontColor);
        
        passwordField = new PasswordField(); 
        passwordField.setPromptText("Choose a vaild password");
        passwordField.setStyle("-fx-background-color: #e7eff1; "                + "-fx-text-fill: #A7AB9E; "
                + "-fx-font-size: 15px; "                + "-fx-border-color: #A7AB9E; "
                + "-fx-border-width: 2px;"                + "-fx-padding: 10px 80px;");

                
        //Pet's name
        Text PNtext = new Text(); 
        PNtext.setText("\nPET'S NAME");
        PNtext.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 10)); 
        PNtext.setFill(fontColor);
        
        petTextPage2 = new TextField();
        petTextPage2.setPromptText("Enter your pet's name Ex. ANDY");
        petTextPage2.setStyle("-fx-background-color: #e7eff1; "                + "-fx-text-fill: #A7AB9E; "
                + "-fx-font-size: 15px; "                + "-fx-border-color: #A7AB9E; "
                + "-fx-border-width: 2px;"                + "-fx-padding: 10px 80px;");


        
        //date of birth of the pet
        Text PBtext = new Text();   
        PBtext.setText("\nPET'S BIRTH DATE");
        PBtext.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 10));   
        PBtext.setFill(fontColor);
        datePicker = new DatePicker();   
        datePicker.setPromptText("Select");
        datePicker.setStyle("-fx-background-color: #e7eff1; "                + "-fx-text-fill: #A7AB9E; "
                + "-fx-font-size: 15px; "                + "-fx-border-color: #A7AB9E; "
                + "-fx-border-width: 2px;"                + "-fx-padding: 10px 80px;");
               
        //Pet type
        HBox petTypeButtons = new HBox(100); 
        Text PTtext = new Text();
        PTtext.setText("\nPET TYPE\n");  
        PTtext.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 10));
        PTtext.setFill(fontColor);   
        groupPetType = new ToggleGroup();
        catRadio = new RadioButton("CAT"); 
        catRadio.setToggleGroup(groupPetType);
        dogRadio = new RadioButton("DOG"); 
        dogRadio.setToggleGroup(groupPetType);
        birdRadio = new RadioButton("BIRD"); 
        birdRadio.setToggleGroup(groupPetType);
        adoptRadio = new RadioButton("ADOPT"); 
        adoptRadio.setToggleGroup(groupPetType);
        petTypeButtons.getChildren().addAll(catRadio, dogRadio, birdRadio, adoptRadio); 
       
                
        //photos        
        HBox signUpBox = new HBox(40);
        signUpBox.setPadding(new Insets(30, 0, 30, 0));   
        String link1 = "file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\Circles SignUp.jpg";
        Image image = new Image(link1);   
        ImageView circlePhoto = new ImageView(image);
        ImageView circlePhoto2 = new ImageView(image);   
        circlePhoto.setFitHeight(140);
        circlePhoto.setFitWidth(140);     
        circlePhoto.setPreserveRatio(true);
        circlePhoto2.setFitHeight(140);    
        circlePhoto2.setFitWidth(140);
        circlePhoto2.setPreserveRatio(true);
        
        //sign up button      
        Button SignUpButtonPage2 = new Button("SIGN UP");
        SignUpButtonPage2.setStyle("-fx-background-color: #A7AB9E; " + "-fx-text-fill: #494140; "+ "-fx-font-size: 15px; " + "-fx-padding: 10px 40px;");
        signUpBox.setAlignment(Pos.CENTER); 
        signUpBox.getChildren().addAll(circlePhoto, SignUpButtonPage2, circlePhoto2);
        
        
        userInfo.setPadding(new Insets(30, 70, 70, 70)); 
        userInfo.getChildren().addAll(UNtext, nameTextPage2, EText, emailTextPage2, PassText, passwordField, PNtext, petTextPage2, PBtext, datePicker, PTtext, petTypeButtons, signUpBox);
        
        creatAccountPage.getChildren().addAll(backSign,CAtext);        
        rootSignUp.getChildren().addAll( creatAccountPage, userInfo);
        
        SignUp = new Scene(rootSignUp, 640, 640);
        
        
        /////////////////////////////////////////////////////////////////////////////////////////////////// Log in Scene //////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        VBox rootLogIn = new VBox();
        rootLogIn.setAlignment(Pos.TOP_CENTER);
        rootLogIn.setStyle("-fx-background-color: #e7eff1 "); 
        
        HBox LoginPageLabel = new HBox(185);
        LoginPageLabel.setPadding(new Insets(10));
        
        VBox loginInfo = new VBox();
        
        //page 3 label       
        Text LGtext = new Text();
        LGtext.setText("Login");       
        LGtext.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 50));
        LGtext.setFill(fontColor);      
        LGtext.setTextAlignment(TextAlignment.CENTER);
        
        HBox forBack = new HBox(5);
        
        ImageView backArrowLogin = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\left-arrow.png");
         backArrowLogin.setFitHeight(13);
         backArrowLogin.setFitWidth(15);
         
         Button backLogin = new Button("Back",backArrowLogin);
         backLogin.setPrefWidth(80);
         backLogin.setPrefHeight(20);
         backLogin.setStyle("-fx-base: #a7ab9e ; -fx-font:15 arial;");
         backLogin.setAlignment(Pos.TOP_LEFT);
         
         forBack.getChildren().addAll(backLogin);
        
        //Username or email       
        Text UorEtext = new Text();
        UorEtext.setText("\nUSERNAME OR EMAIL");     
        UorEtext.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        UorEtext.setFill(fontColor);   
        nameOrEmailText = new TextField();
        nameOrEmailText.setPromptText("Enter your E-mail or Username here");        nameOrEmailText.setStyle("-fx-background-color: #e7eff1; "
                + "-fx-text-fill: #A7AB9E; "                + "-fx-font-size: 15px; "
                + "-fx-border-color: #A7AB9E; " +                  "-fx-border-width: 2px;" +
                  "-fx-padding: 20px 80px;");   
        
        //Password   
        Text PassLGText = new Text();
        PassLGText.setText("\nPASSWORD");
        PassLGText.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 15));
        PassLGText.setFill(fontColor);  
        passwordLGField = new PasswordField();
        passwordLGField.setPromptText("Enter your password here");   
        passwordLGField.setStyle("-fx-background-color: #e7eff1; "
                + "-fx-text-fill: #A7AB9E; "                + "-fx-font-size: 15px; "
                + "-fx-border-color: #A7AB9E; " +                  "-fx-border-width: 2px;" +
                  "-fx-padding: 20px 80px;");        
        
        //Login button   
        HBox LoginBox = new HBox(40);
        LoginBox.setPadding(new Insets(50, 0, 50, 0));
        String link2 = "file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\Cat foot2.jpg";   
        Image imageLog = new Image(link2);
        ImageView catFoot = new ImageView(imageLog);
        
        //Setting the image view  
        catFoot.setFitHeight(540);
        catFoot.setFitWidth(540); 
        catFoot.setPreserveRatio(true);
        Button buttonLoginPage3 = new Button("LOG IN");        
        buttonLoginPage3.setStyle("-fx-background-color: #A7AB9E; "
                + "-fx-text-fill: #494140; "                + "-fx-font-size: 15px; "
                + "-fx-padding: 10px 50px;"); 
        LoginBox.setAlignment(Pos.CENTER);
        LoginBox.getChildren().addAll( buttonLoginPage3);
        
        loginInfo.setPadding(new Insets(50, 70, 70, 70)); 
        loginInfo.getChildren().addAll( UorEtext,nameOrEmailText, PassLGText,passwordLGField, LoginBox , catFoot);
        LoginPageLabel.getChildren().addAll(forBack,LGtext);    
        rootLogIn.getChildren().addAll(LoginPageLabel, loginInfo);
        
        LogIn = new Scene(rootLogIn, 640, 640);        
        
        
        /////////////////////////////////////////////////////////////////////////////////////////////////// Pet Hotel Scene //////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        BorderPane hotelBorder = new BorderPane();
        hotelBorder.setStyle("-fx-background-color: " + color);
        
        
         HBox topHotel = new HBox(30);
         topHotel.setPadding(new Insets(5));
         
         
         ImageView circlesHotel = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\Circles.png");
         circlesHotel.setFitHeight(115);
         circlesHotel.setFitWidth(160);
         
         Label pethotelTextHotel = new Label("PET HOTEL");
         pethotelTextHotel.setFont(Font.font("Comic Sans MS", FontWeight.BOLD,50));
         pethotelTextHotel.setTextFill(Color.rgb(42,78,80));
         
         
         ImageView LogoHotel = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\logo.png");
         LogoHotel.setFitHeight(90);
         LogoHotel.setFitWidth(80);
         
         ImageView backArrowHotel = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\left-arrow.png");
         backArrowHotel.setFitHeight(13);
         backArrowHotel.setFitWidth(15);
         
         Button backHotel = new Button("Back",backArrowHotel);
         backHotel.setPrefWidth(80);
         backHotel.setPrefHeight(20);
         backHotel.setStyle("-fx-base: #a7ab9e ; -fx-font:15 arial;");
         
         StackPane leftoneHotel = new StackPane();
         leftoneHotel.getChildren().addAll(circlesHotel, backHotel);
         backHotel.setAlignment(Pos.TOP_LEFT);
         
         topHotel.getChildren().addAll(leftoneHotel,pethotelTextHotel,LogoHotel);
         
         
         
         StackPane bottom2Hotel = new StackPane();
         bottom2Hotel.setPadding(new Insets(10));
         bottom2Hotel.setAlignment(Pos.CENTER);
  
         ImageView petHotel = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\pet hotel.png");
         petHotel.setFitHeight(210);
         petHotel.setFitWidth(190);
         
         ImageView reverseCircleHotel = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\reverse circle.png");
         reverseCircleHotel.setFitHeight(170);
         reverseCircleHotel.setFitWidth(170);
         
         
         bottom2Hotel.setAlignment(reverseCircleHotel,Pos.BOTTOM_RIGHT);
         bottom2Hotel.getChildren().addAll(petHotel,reverseCircleHotel);
         
         
         GridPane centerHotel = new GridPane();
         centerHotel.setAlignment(Pos.CENTER);
         centerHotel.setVgap(10);
         centerHotel.setHgap(10);

         
         
         Label petTyppeHotel = new Label("Pet's type :");
         petTyppeHotel.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 20));
         petTyppeHotel.setTextFill(Color.rgb(42,78,80));
         
         String[] petTypesHotel = {"Cat" , "Dog" , "Bird"};
         petTypeListHotel = new ChoiceBox<>();
         petTypeListHotel.setPrefWidth(250);
         petTypeListHotel.setPrefHeight(40);
         petTypeListHotel.setValue("Select Type");
         petTypeListHotel.getItems().addAll(petTypesHotel);
         
         
         
         Label CityForHotel = new Label("City :");
         CityForHotel.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 20));
         CityForHotel.setTextFill(Color.rgb(42,78,80));
         
         
         String[] cityForHotel = {"Makkah" , "Jeddah" , "Ryiadh"};
         cityListForHotel = new ChoiceBox<>();
         cityListForHotel.setPrefWidth(250);
         cityListForHotel.setPrefHeight(40);
         cityListForHotel.setValue("Select City");
         cityListForHotel.getItems().addAll(cityForHotel);
         
         
         Label DOarrival = new Label("Date of arrival :");
         DOarrival.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 20));
         DOarrival.setTextFill(Color.rgb(42,78,80));
         
         arrive = new DatePicker();
         arrive.setPrefWidth(250);
         arrive.setPrefHeight(40);
         
         
         Label DOdep = new Label("Date of departure :");
         DOdep.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 20));
         DOdep.setTextFill(Color.rgb(42,78,80));
         
         dep = new DatePicker();
         dep.setPrefWidth(250);
         dep.setPrefHeight(40);
         
         
         HBox combin = new HBox(10);
         
         Button price = new Button("Calculate the price");
         price.setPrefWidth(180);
         price.setPrefHeight(20);
         price.setStyle("-fx-base: #a7ab9e ; -fx-font:15 arial;");
         
         
         Label priceInfo = new Label("       35sr per day ..");
         priceInfo.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 15));
         priceInfo.setTextFill(Color.rgb(42,78,80));
         
         
         Label priceText = new Label();
         priceText.setFont(Font.font("Comic Sans MS", FontWeight.SEMI_BOLD, 18));
         priceText.setTextFill(Color.rgb(42,78,80));
         
         Label confirmText = new Label();
         confirmText.setFont(Font.font("Comic Sans MS", FontWeight.SEMI_BOLD, 13));
         confirmText.setTextFill(Color.rgb(42,78,80));
         
         Button confirmReserve = new Button("Confirm");
         confirmReserve.setPrefWidth(100);
         confirmReserve.setPrefHeight(20);
         confirmReserve.setStyle("-fx-base: #a7ab9e ; -fx-font:15 arial;");
         
         
         price.setOnAction(e -> {

            LocalDate arr = arrive.getValue();
            LocalDate depar = dep.getValue();
            long days = ChronoUnit.DAYS.between(arr, depar);

            boolean validDate = checkDate(days, arrive, dep);

            if (validDate == true) {
                if (arr != null && depar != null) {

                    lastPrice = CalPrice(days);
                    priceText.setText("   The price is :  " + lastPrice + " sr");
                    priceText.setTextFill(Color.rgb(42, 78, 80));
                }
            }
        });
         GridPane.setColumnSpan(confirmText, 2);
         GridPane.setRowSpan(confirmText, 2);
         
         combin.getChildren().addAll(price,confirmReserve);            
         centerHotel.add(combin, 1, 5);       
         centerHotel.add(petTyppeHotel, 1, 0);
         centerHotel.add(petTypeListHotel, 1, 1);
         centerHotel.add(CityForHotel, 1, 2);
         centerHotel.add(cityListForHotel, 1, 3);
         centerHotel.add(DOarrival, 0, 3);
         centerHotel.add(arrive,0,4);
         centerHotel.add(DOdep, 0, 5);
         centerHotel.add(dep,0,6);
         centerHotel.add(priceInfo, 1, 4);
         centerHotel.add(priceText, 1, 6);
         centerHotel.add(confirmText, 0, 8);

        
         
        hotelBorder.setTop(topHotel);
        hotelBorder.setBottom(bottom2Hotel);
        hotelBorder.setCenter(centerHotel);
        
        PetHotelScene = new Scene(hotelBorder,640,640);
        
        /////////////////////////////////////////////////////////////////////////////////////////////////// Adopt or offer adopt //////////////////////////////////////////////////////////////////////////////////////////////////////////
        
         
        BorderPane paneadobt = new BorderPane();
        paneadobt.setStyle("-fx-background-color: rgb(232, 239, 240);");
        paneadobt.setPadding(new Insets(20));

        VBox centeradobt = new VBox(30);
        centeradobt.setStyle("-fx-background-color: rgb(232, 239, 240);");
        centeradobt.setAlignment(Pos.CENTER);

        Text ado = new Text("What would you like to do?");
        ado.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, 45));
        ado.setFill(Color.web("#294D4F"));

        Button ptad = new Button("Find a Pet for Adoption ");
        ptad.setPrefWidth(300);
        ptad.setPrefHeight(50);
        ptad.setStyle("-fx-base: #a7ab9e ; -fx-font:22 arial;");

        Button ofead = new Button("Offer a Pet for Adoption");
        ofead.setPrefWidth(300);
        ofead.setPrefHeight(50);
        ofead.setStyle("-fx-base: #a7ab9e ; -fx-font:22 arial;");

       
        centeradobt.getChildren().addAll(ado, ptad, ofead);
        
    StackPane bottomadobt = new StackPane();
    Image image1ado = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\adop image.jpg");
    ImageView imageViewadobt= new ImageView(image1ado);
    imageViewadobt.setFitHeight(250);
    imageViewadobt.setFitWidth(250);
    bottomadobt.getChildren().addAll(imageViewadobt);
    bottomadobt.setAlignment(Pos.BOTTOM_CENTER);
    
    
        ImageView backArrowAdopt= new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\left-arrow.png");
         backArrowAdopt.setFitHeight(13);
         backArrowAdopt.setFitWidth(15);
         
         Button backAdopt = new Button("Back",backArrowAdopt);
         backAdopt.setPrefWidth(80);
         backAdopt.setPrefHeight(20);
         backAdopt.setStyle("-fx-base: #a7ab9e ; -fx-font:15 arial;");
         backAdopt.setAlignment(Pos.TOP_LEFT);
  

         paneadobt.setTop(backAdopt);
         paneadobt.setCenter(centeradobt);
         paneadobt.setBottom(bottomadobt);
        
         Adoption = new Scene(paneadobt, 640, 640);
         
///////////////////////////////////////////////////////////////////////////////////////////////// Medical assistance ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
         BorderPane panemed = new BorderPane();
        panemed.setStyle("-fx-background-color: rgb(232, 239, 240);");
        
          HBox header4med = new HBox(110);
         header4med.setStyle("-fx-background-color: rgb(232, 239, 240);");
         header4med.setPadding(new Insets(5));
//        header4med.setAlignment(Pos.CENTER);
      
        Label headerTxt3med = new Label("Medical Assistance");
        headerTxt3med.setStyle("-fx-font: 30px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-font-weight: bold;");
        headerTxt3med.setPadding(new Insets(10));
        
        
        //back button
        ImageView backArrowMed= new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\left-arrow.png");
         backArrowMed.setFitHeight(13);
         backArrowMed.setFitWidth(15);
         
         Button backMed = new Button("Back",backArrowMed);
         backMed.setPrefWidth(80);
         backMed.setPrefHeight(20);
         backMed.setStyle("-fx-base: #a7ab9e ; -fx-font:15 arial;");
         backMed.setAlignment(Pos.TOP_LEFT);
         
         HBox forBackmed = new HBox();
         forBackmed.getChildren().addAll(backMed);
        
        header4med.getChildren().addAll(forBackmed,headerTxt3med );
        
        
         //body
        GridPane bodyPane3med = new GridPane();
        bodyPane3med.setStyle("-fx-background-color: rgb(231, 239, 241);");
        bodyPane3med.setPadding(new Insets(10));
        bodyPane3med.setHgap(10);
        bodyPane3med.setVgap(10);
        bodyPane3med.setAlignment(Pos.CENTER);
        bodyPane3med.setGridLinesVisible(false);
        
        GridPane post1med = new GridPane();
        post1med.setPadding(new Insets(30));
        post1med.setStyle("-fx-font: 13px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-background-color: #c0c3b9");
        post1med.setHgap(10);
        post1med.setVgap(5);
        post1med.setGridLinesVisible(false);
        
        GridPane post2med = new GridPane();
        post2med.setPadding(new Insets(30));
        post2med.setStyle("-fx-font: 13px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-background-color: #c0c3b9");
        post2med.setHgap(10);
        post2med.setVgap(5);
        post2med.setGridLinesVisible(false);
        
         
        GridPane post3med = new GridPane();
        post3med.setPadding(new Insets(30));
        post3med.setStyle("-fx-font: 13px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-background-color: #c0c3b9");
        post3med.setHgap(10);
        post3med.setVgap(5);
        post3med.setGridLinesVisible(false);
        
        GridPane post4med = new GridPane();
        post4med.setPadding(new Insets(30));
        post4med.setStyle("-fx-font: 13px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-background-color: #c0c3b9");
        post4med.setHgap(10);
        post4med.setVgap(5);
        post4med.setGridLinesVisible(false);
        //
         Label clincl = new Label("Claws Clinc");
        Label addressl = new Label("Address:- meacca,Batha Quraish");
        Label call = new Label("call: 055310059");
        //
       Label okacl = new Label("OKA Vet Clinic");
        Label okad = new Label("Address:- Dammam,Abdullah FouadDistrict");
        Label okac = new Label("call: 0138250750");
        //
        Label Attwajc = new Label("Attwaj Vet Clinc");
        Label Attwajad = new Label("Address:- Riyadh, pets Market");
        Label Attwcl = new Label("call: 0545465354");
        //
         Label hamcl = new Label("Al-Hamra Pet Care Clinics");
        Label hamad = new Label("Address:- Jeddah, Alhamra District");
        Label hamca = new Label("call: 0545477883");
       
        
        clincl.setStyle("-fx-font-weight: bold;");
        addressl.setStyle("-fx-font-weight: bold;");
       call.setStyle("-fx-font-weight: bold;");
        
        okacl.setStyle("-fx-font-weight: bold;");
        okad.setStyle("-fx-font-weight: bold;");
        okac.setStyle("-fx-font-weight: bold;");
        
        Attwajc.setStyle("-fx-font-weight: bold;");
        Attwajad.setStyle("-fx-font-weight: bold;");
        Attwcl.setStyle("-fx-font-weight: bold;");
        
        
        hamcl.setStyle("-fx-font-weight: bold;");
        hamad.setStyle("-fx-font-weight: bold;");
        hamca.setStyle("-fx-font-weight: bold;");
       
         
        post1med.add(clincl,0,0);
        post1med.add(addressl, 0,1 );
        post1med.add(call, 0, 2);
        
        post2med.add(okacl,0,0);
        post2med.add(okad, 0,1 );
        post2med.add(okac, 0, 2);
        
        post3med.add(Attwajc,0,0);
        post3med.add(Attwajad, 0,1 );
        post3med.add(Attwcl, 0, 2);
        
        post4med.add(hamcl,0,0);
        post4med.add(hamad, 0,1 );
        post4med.add(hamca, 0, 2);
        
        
        bodyPane3med.add(post1med,0,0);
        bodyPane3med.add(post2med,1,0);
        bodyPane3med.add(post3med,0,1);
        bodyPane3med.add(post4med,1,1);
        
         StackPane bottommed = new StackPane();
         Image image1med = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\medical image.jpg");
         ImageView imageViewmed = new ImageView(image1med);
         imageViewmed.setFitHeight(250);
         imageViewmed.setFitWidth(250);
         bottommed.getChildren().addAll(imageViewmed);
         bottommed.setAlignment(Pos.BOTTOM_CENTER);
    
     
    
    
         panemed.setLeft(bodyPane3med);
         panemed.setTop(header4med);
         panemed.setBottom(bottommed);
        
        
         Medical = new Scene(panemed, 640, 640);
         
        ///////////////////////////////////////////////////////////////////////////////////////////////// Menu ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
        
        
        Group pane = new Group();
        Image imageLogo = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\logo.png");
        ImageView imageView = new ImageView(imageLogo);
        imageView.setFitHeight(60); 
        imageView.setFitWidth(58);
        imageView.setPreserveRatio(true);
        imageView.setX(578);
        imageView.setY(55);
        
       
     
        ImageView about = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\about.png");
        ToggleButton B5= new ToggleButton("About",about);
        B5.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal bold 13px 'serif' ");
        about.setFitHeight(17); 
        about.setFitWidth(17);
        B5.setTranslateX(30);
        B5.setTranslateY(28);
       
        
         
         ToggleButton B1= new ToggleButton();
        B1.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal bold 13px 'serif' ");
        B1.setText("Pet’s Hotel");
        B1.setTranslateX(130);
        B1.setTranslateY(28);
        
          ToggleButton B2= new ToggleButton();
        B2.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal bold 13px 'serif' ");
        B2.setText("Adoptions");
        B2.setTranslateX(233);
        B2.setTranslateY(28);
        
         ToggleButton B3= new ToggleButton();
        B3.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal bold 13px 'serif' ");
        B3.setText("Medical Assistance");
        B3.setTranslateX(343);
        B3.setTranslateY(28);
        
          ToggleButton B4= new ToggleButton();
        B4.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal bold 13px 'serif' ");
        B4.setText("Living information");
        B4.setTranslateX(495);
        B4.setTranslateY(28);
       
        
       
        
  
        Image grayCat = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\GrayCat.jpg");
        ImageView imageView1 = new ImageView(grayCat);
        imageView1.setFitHeight(300); 
        imageView1.setFitWidth(330);
        imageView1.setX(446);
        imageView1.setY(104);
        imageView1.setPreserveRatio(true);
        
        Image dogHand = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\dogHand.jpg");
        ImageView imageView2 = new ImageView(dogHand);
        imageView2.setFitHeight(35); 
        imageView2.setFitWidth(35);
        imageView2.setX(400);
        imageView2.setY(150);
        imageView2.setPreserveRatio(true);
       
        
        ImageView imageView3 = new ImageView(dogHand);
        imageView3.setFitHeight(35); 
        imageView3.setFitWidth(35);
        imageView3.setX(457);
        imageView3.setY(400);
        imageView3.setPreserveRatio(true);
        
        Image Dog = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\Dog.jpg");
        ImageView imageView4 = new ImageView(Dog);
        imageView4.setFitHeight(320); 
        imageView4.setFitWidth(320);
        imageView4.setX(220);
        imageView4.setY(180);
        imageView4.setPreserveRatio(true);
        
        
        
        Image image5 = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\backGraoun.jpg");
        ImageView imageView5 = new ImageView(image5);
        imageView5.setFitHeight(420); 
        imageView5.setFitWidth(400);
        imageView5.setX(370);
        imageView5.setY(400);
        imageView5.setPreserveRatio(true);
        
   
        
        ImageView imageView6 = new ImageView(image5);
        imageView6.setFitHeight(420); 
        imageView6.setFitWidth(400);
        imageView6.setX(-150);
        imageView6.setY(-190);
        imageView6.setPreserveRatio(true);
        
       
        
        Image image7 = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\BirdMenu.jpg");
        ImageView imageView7 = new ImageView(image7);
        imageView7.setFitHeight(300); 
        imageView7.setFitWidth(330);
        imageView7.setX(10);
        imageView7.setY(235);
        imageView7.setPreserveRatio(true);
        
          
        ImageView imageView8 = new ImageView(dogHand);
        imageView8.setFitHeight(35); 
        imageView8.setFitWidth(35);
        imageView8.setX(185);
        imageView8.setY(250);
        imageView8.setPreserveRatio(true);
        

        Line line = new Line();
        line.setStartX(525.0f); 
        line.setStartY(570.0f);
        line.setEndX(110.0f);
        line.setEndY(570.0f);
        line.setStrokeWidth(1.5);
         Color c = Color.rgb(94,158,162);
        line.setStroke(c);
        
        Line line1 = new Line();
        line1.setStartX(400.0f); 
        line1.setStartY(580.0f);
        line1.setEndX(210.0f);
        line1.setEndY(580.0f);
        line1.setStrokeWidth(1.5);
        line1.setStroke(c);
        
        Line line2 = new Line();
        line2.setStartX(350.0f); 
        line2.setStartY(590.0f);
        line2.setEndX(260.0f);
        line2.setEndY(590.0f);
        line2.setStrokeWidth(1.5);
        line2.setStroke(c);
          
        
        Text text = new Text(); 
        text.setText("Make Your pet Happy"); 
        text.setX(150); 
        text.setY(555); 
        text.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 35));
        Color b= Color.rgb(42, 78,80);
        text.setFill(b);
       
     
    
       
         pane.getChildren().addAll(imageView1);
         pane.getChildren().addAll(imageView5);
         pane.getChildren().addAll(imageView3);
         pane.getChildren().addAll(imageView2);
         pane.getChildren().addAll(imageView6);
         pane.getChildren().addAll(imageView4);
         pane.getChildren().addAll(imageView7);
         pane.getChildren().addAll(imageView8);
         pane.getChildren().addAll(imageView);
         pane.getChildren().addAll(line);
         pane.getChildren().addAll(line1);
         pane.getChildren().addAll(line2);
         pane.getChildren().addAll(text);
         pane.getChildren().addAll(B1);
         pane.getChildren().addAll(B2);
         pane.getChildren().addAll(B3);
         pane.getChildren().addAll(B4);
         pane.getChildren().addAll(B5);
          
        
         Menu = new Scene(pane, 640, 640);
         Color a = Color.rgb(231,239,241); 
         Menu.setFill(a);
         
         ///////////////////////////////////////////////////////////////////////////////////////////////// Enviroment Info ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         Group Pane1 = new Group();
        Color R= Color.rgb(206,206,206);
        Color S= Color.rgb(153,121,107);
        Color x2= Color.rgb(167,171,158);
        
        ImageView imageViewlog = new ImageView(imageLogo);
        imageViewlog.setFitHeight(60); 
        imageViewlog.setFitWidth(60);
        imageViewlog.setPreserveRatio(true);
        imageViewlog.setX(574);
        imageViewlog.setY(10);
        
//         Image imageS = new Image("file:\\C:\\Users\\aghid\\Downloads\\sh.jpg\\");
//        ImageView imageViewSearch = new ImageView(imageS);
//        imageViewSearch.setFitHeight(210); 
//        imageViewSearch.setFitWidth(210);
//        imageViewSearch.setPreserveRatio(true);
//        imageViewSearch.setX(210);
//        imageViewSearch.setY(90);


        ToggleButton B7= new ToggleButton("Back",backArrowMed);
        backArrowMed.setFitHeight(15);
        backArrowMed.setFitWidth(15);
        B7.setStyle("-fx-base: #a7ab9e ; -fx-font:15 serif;");
        B7.setTranslateX(20);
        B7.setTranslateY(10);
        B7.setAlignment(Pos.BOTTOM_CENTER);
        
      
          
       
        ImageView imageView5_2= new ImageView(image5);
        imageView5_2.setFitHeight(420); 
        imageView5_2.setFitWidth(400);
        imageView5_2.setX(370);
        imageView5_2.setY(400);
        imageView5_2.setPreserveRatio(true);
        
   
        
        ImageView imageView6_2 = new ImageView(image5);
        imageView6_2.setFitHeight(420); 
        imageView6_2.setFitWidth(400);
        imageView6_2.setX(-150);
        imageView6_2.setY(-200);
        imageView6_2.setPreserveRatio(true);
        
        
        Circle circle = new Circle();//Drawing a Circle
        circle.setCenterX(40.0f); //Setting the properties of the circle
        circle.setCenterY(610.0f);
        circle.setRadius(21.0f);
        circle.setFill(x2);
        
         ImageView imageViewPla = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\plus.jpg");
         ToggleButton B8= new ToggleButton("",imageViewPla);
         B8.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#FFFFFF;");
         B8.setTranslateX(25);
         B8.setTranslateY(600);
        imageViewPla.setX(25);
        imageViewPla.setY(610);
        imageViewPla.setFitHeight(15); 
        imageViewPla.setFitWidth(15);
        
       
        
        
       
        
        
    
        
         //--------------------------------Cat----------------------------------------------------------------------------
         
         Color x= Color.rgb(84,84,84);
         
         
        Image imageCat = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\prettyCat.jpg");
        ImageView imageView_C = new ImageView(imageCat);
        imageView_C.setFitHeight(70); 
        imageView_C.setFitWidth(70);
        imageView_C.setX(545);
        imageView_C.setY(155);
        imageView_C.setPreserveRatio(true);
        
        Rectangle rectangle = new Rectangle();
        rectangle.setX(367); //Setting the Properties of the Rectangle
        rectangle.setY(140);
        rectangle.setWidth(258);
        rectangle.setHeight(260);
        rectangle.setFill(R);
       
          Text text1 = new Text(); 
        text1.setText("Cats:-"); 
        text1.setX(450); 
        text1.setY(160); 
        text1.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 19));
        text1.setFill(x);
      
        
          Text text3 = new Text();
        text3.setText("Food:"); 
        text3.setX(376); 
        text3.setY(180);
        text3.setTextAlignment(TextAlignment.CENTER);
        text3.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text3.setFill(S);
        
        Text textFood = new Text();
        textFood.setText("A good diet should be provided to cats\n based on many factors such as age,\n activity level, and health."); 
        textFood.setX(370); 
        textFood.setY(195);
        textFood.setTextAlignment(TextAlignment.JUSTIFY);
        
        textFood.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        textFood.setFill(x);
        
        
        Text text4 = new Text();
        text4.setText("Health:"); 
        text4.setX(370); 
        text4.setY(240);
        text4.setTextAlignment(TextAlignment.CENTER);
        text4.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text4.setFill(S);
        
        
        Text textHe = new Text();
        textHe.setText("They must be cleaned and combed continuously and \n regularly, which maintains their general leanliness \n and health, and reduces hair loss and the percentage \n of hairballs."); 
        textHe.setX(370); 
        textHe.setY(255);
        textHe.setTextAlignment(TextAlignment.JUSTIFY);
        textHe.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        textHe.setFill(x);
        
         Text text5 = new Text();
        text5.setText("Litter Box:"); 
        text5.setX(370); 
        text5.setY(312);
        text5.setTextAlignment(TextAlignment.CENTER);
        text5.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text5.setFill(S);
        
                
        Text textTd = new Text();
        textTd.setText("The box should be cleaned daily as cats do not use it if it\n is dirty and smelly."); 
        textTd.setX(370); 
        textTd.setY(325);
        textTd.setTextAlignment(TextAlignment.JUSTIFY);
        textTd.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        textTd.setFill(x);
        
        Text text6 = new Text();
        text6.setText("Play:"); 
        text6.setX(370); 
        text6.setY(355);
        text6.setTextAlignment(TextAlignment.CENTER);
        text6.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text6.setFill(S);
                
        Text textp = new Text();
        textp.setText("Cats love movement, so you should choose a toy  from \n games that can move in fast and unexpected ways");
        textp.setX(370); 
        textp.setY(370);
        textp.setTextAlignment(TextAlignment.JUSTIFY);
        textp.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        textp.setFill(x);
        
       //--------------------------------Dog------------------------------------------------------------------------
        Image imageDog = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\prettyDog.jpg");
        ImageView imageViewDog= new ImageView(imageDog);
        imageViewDog.setFitHeight(70); 
        imageViewDog.setFitWidth(70);
        imageViewDog.setX(206);
        imageViewDog.setY(155);
        imageViewDog.setPreserveRatio(true);
        
        
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setX(30); //Setting the Properties of the Rectangle
        rectangle1.setY(150);
        rectangle1.setWidth(253);
        rectangle1.setHeight(250);
        rectangle1.setFill(R);
        
        
         Text textA_1 = new Text(); 
        textA_1.setText("Dogs:-"); 
        textA_1.setTextAlignment(TextAlignment.CENTER);
        textA_1.setX(100); 
        textA_1.setY(170); 
        textA_1.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 19));
        textA_1.setFill(x);
        
        Text text7 = new Text();
        text7.setText("Food:"); 
        text7.setX(38); 
        text7.setY(190);
        text7.setTextAlignment(TextAlignment.CENTER);
        text7.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text7.setFill(S);
        
        Text textFood1 = new Text();
        textFood1.setText("Dogs are affected by the type of food \n provided to them, so their  food must \n be carefully selected and appropriate for their age."); 
        textFood1.setX(35); 
        textFood1.setY(208);
        textFood1.setTextAlignment(TextAlignment.JUSTIFY);
        textFood1.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        textFood1.setFill(x);
        
        Text text8= new Text();
        text8.setText("Health:"); 
        text8.setX(35); 
        text8.setY(252);
        text8.setTextAlignment(TextAlignment.CENTER);
        text8.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text8.setFill(S);
        
        
        Text textHe1= new Text();
        textHe1.setText("Dogs, especially puppies, should be presented \n to the veterinarian during the first six months\n of life to take the necessary vaccinations."); 
        textHe1.setX(35); 
        textHe1.setY(267);
        textHe1.setTextAlignment(TextAlignment.JUSTIFY);
        textHe1.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        textHe1.setFill(x);
        
        Text text9 = new Text();
        text9.setText("Training a dog::"); 
        text9.setX(35); 
        text9.setY(311);
        text9.setTextAlignment(TextAlignment.CENTER);
        text9.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text9.setFill(S);
        
        Text textli = new Text();
        textli.setText("A dog can be trained to obey voice commands \n in order to improve his behavior."); 
        textli.setX(35); 
        textli.setY(325);
        textli.setTextAlignment(TextAlignment.JUSTIFY);
        textli.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        textli.setFill(x);

        
        Text text10 = new Text();
        text10.setText("Play:"); 
        text10.setX(35); 
        text10.setY(354);
        text10.setTextAlignment(TextAlignment.CENTER);
        text10.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text10.setFill(S);
        
        
        Text textp1 = new Text();
        textp1.setText("Play is a natural part of a dog's exercise and helps in its \n psychological and physical development.");
        textp1.setX(32); 
        textp1.setY(370);
        textp1.setTextAlignment(TextAlignment.JUSTIFY);
        textp1.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        textp1.setFill(x);
        
        //----------------------------------Brid----------------------------------------------------------------------   
        Image imageBird = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\prettyBird.jpg");
        ImageView imageViewBrid= new ImageView(imageBird);
        imageViewBrid.setFitHeight(70); 
        imageViewBrid.setFitWidth(70);
        imageViewBrid.setX(411);
        imageViewBrid.setY(425);
        imageViewBrid.setPreserveRatio(true);
        
        
         Rectangle rectangle2 = new Rectangle();
        rectangle2.setX(155); //Setting the Properties of the Rectangle
        rectangle2.setY(413);
        rectangle2.setWidth(333);
        rectangle2.setHeight(218);
        rectangle2.setFill(R);        
      
        
         
        Text text2 = new Text();
        text2.setText("Brids:-"); 
        text2.setX(260); 
        text2.setY(435);
        text2.setTextAlignment(TextAlignment.CENTER);
        text2.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 19));
        text2.setFill(x);
        
        
        Text text11 = new Text();
        text11.setText("Food:"); 
        text11.setX(160); 
        text11.setY(442);
        text11.setTextAlignment(TextAlignment.CENTER);
        text11.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text11.setFill(S);
        
         Text textFood2 = new Text();
        textFood2.setText("Providing appropriate nutrition for birds according to \n their types, as each type of sparrow feeds on  a specific \n type of grain or food."); 
        textFood2.setX(160); 
        textFood2.setY(456);
        textFood2.setTextAlignment(TextAlignment.JUSTIFY);
        textFood2.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        textFood2.setFill(x);
        
        
        
        Text text12 = new Text();
        text12.setText("Health:"); 
        text12.setX(160); 
        text12.setY(500);
        text12.setTextAlignment(TextAlignment.CENTER);
        text12.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text12.setFill(S);
        
        
         Text textHe2 = new Text();
        textHe2.setText("Inferring the bird's disease as soon as  you see it breathing with its\n mouth open, as this can be dealt with by mixing a special antibiotic \n with water and offering it to him."); 
        textHe2.setX(160); 
        textHe2.setY(515);
        textHe2.setTextAlignment(TextAlignment.JUSTIFY);
        textHe2.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        textHe2.setFill(x);
        
        Text text13 = new Text();
        text13.setText("Birdcage prparation:"); 
        text13.setX(160); 
        text13.setY(558);
        text13.setTextAlignment(TextAlignment.CENTER);
        text13.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text13.setFill(S);
        
         Text textB = new Text();
        textB.setText("Make sure to place the cage in places that do not contain noise,\n and make sure to place it in a quiet and comfortable place."); 
        textB.setX(160); 
        textB.setY(570);
        textB.setTextAlignment(TextAlignment.JUSTIFY);
        textB.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        textB.setFill(x);
        
        Text text14 = new Text();
        text14.setText("Play:"); 
        text14.setX(160); 
        text14.setY(598);
        text14.setTextAlignment(TextAlignment.CENTER);
        text14.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 13));
        text14.setFill(S);
        
         Text textp2 = new Text();
        textp2.setText("It is preferable in the cage to contain at least three toys, such as the\n upper stairs that they like to swing on."); 
        textp2.setX(160); 
        textp2.setY(610);
        textp2.setTextAlignment(TextAlignment.JUSTIFY);
        textp2.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 10));
        
        textp2.setFill(x);
       
        
         Pane1.getChildren().addAll(imageViewlog);
         Pane1.getChildren().addAll(imageView5_2);
         Pane1.getChildren().addAll(imageView6_2);
        // Pane1.getChildren().addAll(imageViewSearch);
         Pane1.getChildren().addAll(rectangle);
         Pane1.getChildren().addAll(rectangle2);
         Pane1.getChildren().addAll(imageView_C);
         Pane1.getChildren().addAll(rectangle1);
         Pane1.getChildren().addAll(imageViewDog);
         Pane1.getChildren().addAll(imageViewBrid);
         Pane1.getChildren().addAll(text1);
         Pane1.getChildren().addAll(text2);
         Pane1.getChildren().addAll(textA_1);
         Pane1.getChildren().addAll(text3);
         Pane1.getChildren().addAll(textFood);
         Pane1.getChildren().addAll(textHe);
         Pane1.getChildren().addAll(text4);
         Pane1.getChildren().addAll(text5);
         Pane1.getChildren().addAll(textTd);
         Pane1.getChildren().addAll(text6);
         Pane1.getChildren().addAll(textp);
         Pane1.getChildren().addAll(text7);
         Pane1.getChildren().addAll(textFood1);
         Pane1.getChildren().addAll(text8);
         Pane1.getChildren().addAll(textHe1);
         Pane1.getChildren().addAll(text9);
         Pane1.getChildren().addAll(textli);
         Pane1.getChildren().addAll(text10);
         Pane1.getChildren().addAll(textp1);
         Pane1.getChildren().addAll(text11);
         Pane1.getChildren().addAll(textFood2);
         Pane1.getChildren().addAll(text12);
         Pane1.getChildren().addAll(textHe2);
         Pane1.getChildren().addAll(text13);
         Pane1.getChildren().addAll(textB);
         Pane1.getChildren().addAll(text14);
         Pane1.getChildren().addAll(textp2);
         Pane1.getChildren().addAll(B7);
         Pane1.getChildren().addAll(circle);
         Pane1.getChildren().addAll(B8);
         
         enviromentInfo = new Scene(Pane1, 640, 640);
         enviromentInfo.setFill(a);
         ///////////////////////////////////////////////////////////////////////////////////////////////// Add Pet Info ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         Group Pane2 = new Group();
     
       
        ImageView imageViewlog1 = new ImageView(imageLogo);
        imageViewlog1.setFitHeight(60); 
        imageViewlog1.setFitWidth(60);
        imageViewlog1.setPreserveRatio(true);
        imageViewlog1.setX(574);
        imageViewlog1.setY(10);
        
       
        ToggleButton B10= new ToggleButton("Back",backArrowMed);
        backArrowMed.setFitHeight(15);
        backArrowMed.setFitWidth(15);
        B10.setStyle("-fx-base: #a7ab9e ; -fx-font:15 serif;");
        B10.setTranslateX(20);
        B10.setTranslateY(10);
        B10.setAlignment(Pos.BOTTOM_CENTER);
      
        
        ToggleButton B11= new ToggleButton("View Your Pet's Profile");
        backArrowMed.setFitHeight(15);
        backArrowMed.setFitWidth(15);
        B11.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#FFFFFF;-fx-font: normal bold 14px 'serif' ");
        B11.setTranslateX(460);
        B11.setTranslateY(600);
        B11.setAlignment(Pos.BOTTOM_CENTER);
        
        
        
        ImageView imageView5_3= new ImageView(image5);
        imageView5_3.setFitHeight(420); 
        imageView5_3.setFitWidth(400);
        imageView5_3.setX(370);
        imageView5_3.setY(400);
        imageView5_3.setPreserveRatio(true);
        
   
        
        ImageView imageView6_3 = new ImageView(image5);
        imageView6_3.setFitHeight(420); 
        imageView6_3.setFitWidth(400);
        imageView6_3.setX(-150);
        imageView6_3.setY(-200);
        imageView6_3.setPreserveRatio(true);
        
        
        
        
        
        ToggleButton B9 = new ToggleButton("Add to your pet profile");
        B9.setTranslateX(25);
        B9.setTranslateY(600);
        B9.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#FFFFFF;-fx-font: normal bold 14px 'serif' ");
        B9.setTranslateX(20);
        B9.setTranslateY(600);
        B9.setAlignment(Pos.BOTTOM_CENTER);
  
       
        
    
        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField();
        tf4 = new TextField();
      
       Label lb1= new Label("  Enter the Food:  ");
       lb1.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal bold 18px 'serif' ");
       lb1.setTranslateX(90);
       lb1.setTranslateY(250);
       tf1.setTranslateX(338);
       tf1.setTranslateY(250);
       
          Label lb2= new Label("  Enter the Health:  ");
       lb2.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal bold 18px 'serif' ");
       lb2.setTranslateX(90);
       lb2.setTranslateY(300);
       tf2.setTranslateX(338);
       tf2.setTranslateY(300);
       
          Label lb3= new Label(" Enter How to take care of it: ");
       lb3.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal bold 18px 'serif' ");
       lb3.setTextAlignment(TextAlignment.CENTER);
       lb3.setTranslateX(90);
       lb3.setTranslateY(350);
       tf3.setTranslateX(338);
       tf3.setTranslateY(350);
       
          Label lb4= new Label(" Enter the games he likes:  ");
       lb4.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal bold 18px 'serif' ");
       lb4.setTextAlignment(TextAlignment.CENTER);
       lb4.setTranslateX(90);
       lb4.setTranslateY(400);
       tf4.setTranslateX(338);
       tf4.setTranslateY(400);
       
        Text textTitle = new Text();
        textTitle.setText("Liveilhood  information  for  your  pet:"); 
        textTitle.setX(90); 
        textTitle.setY(195);
        textTitle.setTextAlignment(TextAlignment.CENTER);
        textTitle.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal bold 26px 'Abril Fatface' ");
        textTitle.setFill(x);
        
       
        Pane2.getChildren().addAll(imageViewlog1);
        Pane2.getChildren().addAll(imageView5_2);
        Pane2.getChildren().addAll(imageView6_3);
        Pane2.getChildren().addAll(lb1);
        Pane2.getChildren().addAll(tf1);
        Pane2.getChildren().addAll(lb2);
        Pane2.getChildren().addAll(tf2);
        Pane2.getChildren().addAll(lb3);
        Pane2.getChildren().addAll(tf3);
        Pane2.getChildren().addAll(lb4);
        Pane2.getChildren().addAll(tf4);
        Pane2.getChildren().addAll(textTitle);
        Pane2.getChildren().addAll(B10);
        Pane2.getChildren().addAll(B9);
        Pane2.getChildren().addAll(B11);
        
        AddPetInfo = new Scene(Pane2,640,640);
        AddPetInfo.setFill(a);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////// Pet Account ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
        BorderPane AccountPane = new BorderPane();
        
        HBox headerAcc = new HBox(130);
        headerAcc.setStyle("-fx-background-color: #E7EFF1;");
        headerAcc.setPadding(new Insets(30, 30, 0, 30));
        
        Label Accountlbl = new Label("YOUR PET PROFILE");
        Accountlbl.setStyle("-fx-font: 20px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-font-weight: bold;");
        
        Button backAcc = new Button("Back",backArrowMed );
        backAcc.setStyle("-fx-base: #a7ab9e ; -fx-font:15 serif;");
        
        ImageView LogoAcc = new ImageView("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\logo.png");
        LogoAcc.setFitHeight(60);
        LogoAcc.setFitWidth(50);
        
        headerAcc.getChildren().addAll(backAcc, Accountlbl, LogoAcc); 
        
        //body
        GridPane bodyAcc = new GridPane();
        bodyAcc.setStyle("-fx-font: 13px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-background-color: #c0c3b9");
        bodyAcc.setPadding(new Insets(10));
        bodyAcc.setHgap(10);
        bodyAcc.setVgap(10);
        
        
        imageViewPet = new ImageView();
        imageViewPet.setFitWidth(150);
        imageViewPet.setFitHeight(150);
        
        
        Label nameLabel = new Label("Pet's Name: ");
        givenName = new Label();
        
        Label typeLabel = new Label("Type: ");
        givenType = new Label();
        
        Label dobLabel = new Label("Pet's DOB: ");
        givenDOB = new Label();
       
        Label usernameLabel = new Label("Username: ");
        givenUsername = new Label();
        
        Label emailLabel = new Label("Email: ");
        givenEmail = new Label();
        
        Label foodLabel = new Label("Your Pet's Food: ");
        givenFood = new Label();

        Label healthLabel = new Label("Your Pet's Health: ");
        givenHealth = new Label();

        Label careLabel = new Label("How to take care of it: ");
        givenCare = new Label();
        
        Label gamesLabel = new Label("Games Your Pet Prefers: ");
        givenGame = new Label();        

        nameLabel.setStyle("-fx-font-weight: bold;");
        typeLabel.setStyle("-fx-font-weight: bold;");
        dobLabel.setStyle("-fx-font-weight: bold;");
        usernameLabel.setStyle("-fx-font-weight: bold;");
        emailLabel.setStyle("-fx-font-weight: bold;");
        foodLabel.setStyle("-fx-font-weight: bold;");
        healthLabel.setStyle("-fx-font-weight: bold;");
        careLabel.setStyle("-fx-font-weight: bold;");
        gamesLabel.setStyle("-fx-font-weight: bold;");
        
//        GridPane.setColumnSpan(imageViewPet, 2);
        GridPane.setRowSpan(imageViewPet, 5);
        
        bodyAcc.add(imageViewPet, 9, 0);
        bodyAcc.add(nameLabel, 0, 0);
        bodyAcc.add(givenName, 0, 1);
        bodyAcc.add(typeLabel, 0, 2);
        bodyAcc.add(givenType, 0, 3);
        bodyAcc.add(dobLabel, 0, 4);
        bodyAcc.add(givenDOB, 0,5);
        bodyAcc.add(usernameLabel, 0, 6);
        bodyAcc.add(givenUsername, 0, 7);
        bodyAcc.add(emailLabel, 0, 8);
        bodyAcc.add(givenEmail, 0, 9);
        bodyAcc.add(foodLabel, 1, 0);
        bodyAcc.add(givenFood, 1, 1);
        bodyAcc.add(healthLabel, 1, 2);
        bodyAcc.add(givenHealth, 1, 3);
        bodyAcc.add(careLabel, 1, 4);
        bodyAcc.add(givenCare, 1, 5);
        bodyAcc.add(gamesLabel, 1, 6);
        bodyAcc.add(givenGame, 1, 7);
        
        VBox centerPane = new VBox();
        centerPane.setAlignment(Pos.CENTER);
        centerPane.setPadding(new Insets(30));
        centerPane.setStyle("-fx-background-color: #E7EFF1;");
        centerPane.getChildren().addAll(bodyAcc);
        
        AccountPane.setTop(headerAcc);  
        AccountPane.setCenter(centerPane);
        
        PetAccount = new Scene(AccountPane, 640, 640);
        
        ////////////////////////////////////////////////////////////////////////////////////////////////// About ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        Group pane1 = new Group();
       
        ImageView imageView9 = new ImageView(imageLogo);
        imageView9.setFitHeight(60); 
        imageView9.setFitWidth(60);
        imageView9.setPreserveRatio(true);
        imageView9.setX(574);
        imageView9.setY(10);
        
        // ImageView arrow = new ImageView("file:\\C:\\Users\\aghid\\Downloads\\ar.jpg\\");
         
        
        ToggleButton B6= new ToggleButton("Back",backArrowMed);
        backArrowMed.setFitHeight(15);
        backArrowMed.setFitWidth(15);
        B6.setStyle("-fx-base: #a7ab9e ; -fx-font:15 serif;");
        B6.setTranslateX(20);
        B6.setTranslateY(10);
           
         
        Image image0A = new Image("file:C:/Users/dia03/OneDrive/سطح المكتب/photo/cat.gif");
        ImageView imageView0A = new ImageView(image0A);
        imageView0A.setFitHeight(400); 
        imageView0A.setFitWidth(500);
        imageView0A.setX(270);
        imageView0A.setY(155);
        imageView0A.setPreserveRatio(true);
        
        
        ImageView imageView5A = new ImageView(image5);
        imageView5A.setFitHeight(420); 
        imageView5A.setFitWidth(400);
        imageView5A.setX(370);
        imageView5A.setY(450);
        imageView5A.setPreserveRatio(true);
        
   
        
        ImageView imageView6A = new ImageView(image5);
        imageView6A.setFitHeight(420); 
        imageView6A.setFitWidth(400);
        imageView6A.setX(-150);
        imageView6A.setY(-190);
        imageView6A.setPreserveRatio(true);
        
        
        Image image8 = new Image("file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\Cat foot2.jpg");
        ImageView imageView8A = new ImageView(image8);
        imageView8A.setFitHeight(300); 
        imageView8A.setFitWidth(250);
        imageView8A.setX(80);
        imageView8A.setY(420);
        imageView8A.setPreserveRatio(true);
         
        Text textA = new Text(); 
        textA.setText("Application idea:- "); 
        textA.setX(60); 
        textA.setY(265); 
        textA.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 35));
        //Color x = Color.rgb(84,84,84);
        Color x1= Color.rgb(63,128,132);
        textA.setFill(x1);
        
        Text textA1 = new Text(); 
        textA1.setText(" A pet application that includes a login for \n the user and provides him with several \n services , including :- medical aids , adoption,\n"); 
        textA1.setTextAlignment(TextAlignment.CENTER);
        textA1.setX(10); 
        textA1.setY(325); 
        textA1.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 19));
        textA1.setFill(x);
        
        
        Text textA2 = new Text();
        textA2.setText(" pet hotel and living information. "); 
        textA2.setX(60); 
        textA2.setY(405);
        textA2.setTextAlignment(TextAlignment.CENTER);
        textA2.setFont(Font.font("Abril Fatface", FontWeight.BOLD, FontPosture.REGULAR, 19));
        textA2.setFill(x);
       
     
         pane1.getChildren().addAll(imageView9);
         pane1.getChildren().addAll(imageView0A);
         pane1.getChildren().addAll(imageView5A);
         pane1.getChildren().addAll(imageView6A);
         pane1.getChildren().addAll(imageView8A);
         pane1.getChildren().addAll(textA1);
         pane1.getChildren().addAll(textA2);
         pane1.getChildren().addAll(textA);
         pane1.getChildren().addAll(B6);
         
         About = new Scene(pane1,640,640);
         About.setFill(a);
         
        ///////////////////////////////////////////////////////////////////////////////////////////////// Offer Adopt ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
         
    
        //scene offer a pet (1) 
        BorderPane containerPane = new BorderPane();

        //header
        StackPane Offer1Header = new StackPane();
        VBox header = new VBox();
        header.setPadding(new Insets(10));
        header.setAlignment(Pos.CENTER);
        header.setStyle("-fx-background-color: #E7EFF1;");
        Label headerTxt = new Label("OFFER A PET FOR ADOPTION");
        Label subTxt = new Label("Pet's Information");
        headerTxt.setStyle("-fx-font: 20px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-font-weight: bold;");
        subTxt.setStyle("-fx-font: 18px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        header.getChildren().addAll(headerTxt, subTxt);

        Button backbtn1 = new Button("Back", backArrowMed);
        backbtn1.setStyle("-fx-base: #a7ab9e ; -fx-font:15 serif;");
        
        StackPane.setMargin(backbtn1, new Insets(0, 0, 0,-450));
        
        Offer1Header.getChildren().addAll(header, backbtn1);
        
        
        //body
        GridPane bodyGrid = new GridPane();
        bodyGrid.setHgap(10);
        bodyGrid.setVgap(5);
        //For aligning nodes inside the GridPane
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.LEFT);
        bodyGrid.getColumnConstraints().add(column1);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        bodyGrid.getColumnConstraints().add(column2);
        bodyGrid.setAlignment(Pos.CENTER);
        bodyGrid.setPadding(new Insets(0, 0, 200, 0));
        bodyGrid.setStyle("-fx-background-color: #E7EFF1;");
        
        petNametf = new TextField();
        petAgetf = new TextField();
        petWeighttf = new TextField();

        petNametf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
        petAgetf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
        petWeighttf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
        petWeighttf.setPromptText("in KG");
          
        cboType = new ComboBox<>(); //type
        cboType.setItems(FXCollections.observableArrayList("Cat", "Dog", "Bird"));
        cboType.setPrefWidth(500);
        cboType.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-background-color: #ffffff; -fx-border-color: #A7AB9E;");

        cboGender = new ComboBox<>(); //gender
        cboGender.setItems(FXCollections.observableArrayList("Male", "Female", "Unknown"));
        cboGender.setPrefWidth(500);
        cboGender.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-background-color: #ffffff; -fx-border-color: #A7AB9E;");

        txtInfo = new TextArea();
        txtInfo.setPrefSize(500, 200);
        txtInfo.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");

        //labels information
        Label lblAttachedPhoto = new Label();
        Label petNamelbl = new Label("Pet's Name: ");
        Label petTypelbl = new Label("Select the pet's type: *");
        Label petAgelbl = new Label("Pet's Age: ");
        
        Label petGenderlbl = new Label("Select the pet's gender: *");
        Label petWeightlbl = new Label("Pet's Weight: ");
        Label petInfolbl = new Label("Additional information or details: ");

        //labels style
        lblAttachedPhoto.setPadding(new Insets(0, 0, 0, 100));
        lblAttachedPhoto.setStyle("-fx-font: 12px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        petNamelbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        petTypelbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        petAgelbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        petGenderlbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        petWeightlbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        petInfolbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");

        //Buttons 
        RadioButton rbDays = new RadioButton("Days");
        RadioButton rbMonths = new RadioButton("Months");
        RadioButton rbYears = new RadioButton("Years");
        groupAge = new ToggleGroup();
        rbDays.setToggleGroup(groupAge);
        rbMonths.setToggleGroup(groupAge);
        rbYears.setToggleGroup(groupAge);

        rbDays.setStyle("-fx-font: 12px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        rbMonths.setStyle("-fx-font: 12px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        rbYears.setStyle("-fx-font: 12px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        
        GridPane.setMargin(rbDays, new Insets(0, 0, 0, 280));
        GridPane.setMargin(rbMonths, new Insets(0, 0, 0, 360));
        GridPane.setMargin(rbYears, new Insets(0, 0, 0, 450));
        
        Button attachBtn = new Button("Attach Photo"); //to attach photo
        attachBtn.setStyle("-fx-base: #a7ab9e ; -fx-font:15 serif;");
        GridPane.setMargin(attachBtn, new Insets(0, 0, 10, 0));

        Button continueBtn = new Button("Continue"); //to the next scene
        GridPane.setMargin(continueBtn, new Insets(0, 0, 0, 430));
        continueBtn.setStyle("-fx-base: #a7ab9e ; -fx-font:15 serif;");
        continueBtn.setDisable(true);
          
        // Create an ImageView for pet
        imageViewAt = new ImageView();
        imageViewAt.setFitWidth(80);
        imageViewAt.setFitHeight(80);

        String image1Path = "file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\148.jpg";
        Image image11 = new Image(image1Path);
        ImageView imageV1 = new ImageView(image11);
        imageV1.setFitHeight(100); //setting the fit height and width of the image view
        imageV1.setFitWidth(300);
        GridPane.setMargin(imageV1, new Insets(-60, 0, 0, 0));

        

        bodyGrid.add(petNamelbl, 0, 0);
        bodyGrid.add(petNametf, 0, 1);
        bodyGrid.add(petTypelbl, 0, 2);
        bodyGrid.add(cboType, 0, 3);
        bodyGrid.add(petAgelbl, 0, 4);
        bodyGrid.add(rbDays, 0, 4);
        bodyGrid.add(rbMonths, 0, 4);
        bodyGrid.add(rbYears, 0, 4);
        bodyGrid.add(petAgetf, 0, 5);
        bodyGrid.add(petGenderlbl, 0, 6);
        bodyGrid.add((cboGender), 0, 7);
        bodyGrid.add(petWeightlbl, 0, 8);
        bodyGrid.add(petWeighttf, 0, 9);
        bodyGrid.add(petInfolbl, 0, 10);
        bodyGrid.add(txtInfo, 0, 11);
        bodyGrid.add(imageV1, 0, 14);
        bodyGrid.add(attachBtn, 0, 12);
        bodyGrid.add(lblAttachedPhoto, 0, 13);
        bodyGrid.add(imageViewAt, 0, 13);
        bodyGrid.add(continueBtn, 0, 13);
        
        containerPane.setTop(Offer1Header);
        containerPane.setCenter(bodyGrid);
        AdoptOffer1 = new Scene(containerPane, 640, 640);
         
        
        
         /////////////////////////////////////////////////////////////////////////////////////////////////  Offer 2 Adopt ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
         //scene offer a pet (2) 
        BorderPane containerPane2 = new BorderPane();
        
        //header
        StackPane Offer2Header = new StackPane();
        VBox header2 = new VBox();
        header2.setPadding(new Insets(10));
        header2.setAlignment(Pos.CENTER);
        header2.setStyle("-fx-background-color: #E7EFF1;");
        Label headerTxt2 = new Label("OFFER A PET FOR ADOPTION");
        Label subTxt2 = new Label("Owner's Information");
        headerTxt2.setStyle("-fx-font: 20px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-font-weight: bold;");
        subTxt2.setStyle("-fx-font: 18px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        header2.getChildren().addAll(headerTxt2, subTxt2);
        
        ImageView Offer2Logo = new ImageView(imageLogo);
        Offer2Logo.setFitHeight(60);
        Offer2Logo.setFitWidth(80);
        StackPane.setMargin(Offer2Logo, new Insets(0, 0, 0,500));
  
        Offer2Header.getChildren().addAll(header2, Offer2Logo);
        
        //body
        GridPane bodyGrid2 = new GridPane();
        bodyGrid2.setHgap(10);
        bodyGrid2.setVgap(5);
        //For aligning nodes inside the GridPane
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setHalignment(HPos.LEFT);
        bodyGrid2.getColumnConstraints().add(column1);
        ColumnConstraints column4 = new ColumnConstraints();
        column4.setHalignment(HPos.LEFT);
        bodyGrid2.getColumnConstraints().add(column2);
        bodyGrid2.setAlignment(Pos.CENTER);
        bodyGrid2.setPadding(new Insets(0, 0, 200, 0));
        bodyGrid2.setStyle("-fx-background-color: #E7EFF1;");

        //labels information
        Label ownerNamelbl = new Label("Owner Name: *");
        Label ownerPhonelbl = new Label("Phone Number: ");
        Label ownerEmaillbl = new Label("Email: ");
        Label ownerAddresslbl = new Label("Location/Address: *");
        Label reasonlbl = new Label("Why are you offering the pet for adoption? ");

        ownerNamelbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        ownerPhonelbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        ownerEmaillbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        ownerAddresslbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");
        reasonlbl.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;");

        //Text Fields
        ownerNametf = new TextField();
        ownerPhonetf = new TextField();
        ownerEmailtf = new TextField();
        ownerAddresstf = new TextField();
        
        reasonTa = new TextArea();
        
        ownerPhonetf.setPromptText("ex. 500000000");

        ownerNametf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
        ownerPhonetf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
        ownerEmailtf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
        ownerAddresstf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
        reasonTa.setPrefSize(500, 200);
        reasonTa.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");

        //Buttons
        Button submitbtn = new Button("Submit"); //to the next scene
        GridPane.setMargin(submitbtn, new Insets(0, 0, 0, 430));
        submitbtn.setStyle("-fx-base: #a7ab9e ; -fx-font:15 serif;");
        
        Button backbtn2 = new Button("Back", backArrowMed); //to the next scene
        backbtn2.setStyle("-fx-base: #a7ab9e ; -fx-font:15 serif;");
        
        String image2Path = "file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\Cat foot2.jpg";
        Image image2 = new Image(image2Path);
        ImageView imageV2 = new ImageView(image2);
        imageV2.setFitHeight(100); //setting the fit height and width of the image view
        imageV2.setFitWidth(450);
        GridPane.setMargin(imageV2, new Insets(60, 0, 0, 30));

        
        
        
        bodyGrid2.add(ownerNamelbl, 0, 0);
        bodyGrid2.add(ownerNametf, 0, 1);
        bodyGrid2.add(ownerPhonelbl, 0, 2);
        bodyGrid2.add(ownerPhonetf, 0, 3);
        bodyGrid2.add(ownerEmaillbl, 0, 4);
        bodyGrid2.add(ownerEmailtf, 0, 5);
        bodyGrid2.add(ownerAddresslbl, 0, 6);
        bodyGrid2.add(ownerAddresstf, 0, 7);
        bodyGrid2.add(reasonlbl, 0, 8);
        bodyGrid2.add(reasonTa, 0, 9);
        bodyGrid2.add(backbtn2, 0, 13);
        bodyGrid2.add(submitbtn, 0, 13);
        bodyGrid2.add(imageV2, 0, 14);

        containerPane2.setTop(Offer2Header);
        containerPane2.setCenter(bodyGrid2);
         AdoptOffer2 = new Scene(containerPane2, 640, 640);
         
         
         /////////////////////////////////////////////////////////////////////////////////////////////////  Adopt ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
        //scene adoption 
        BorderPane containerPane3 = new BorderPane();
        
        //header
        StackPane adoptionHeader = new StackPane();
        VBox header3 = new VBox();
        header3.setPadding(new Insets(10));
        header3.setAlignment(Pos.CENTER);
        header3.setStyle("-fx-background-color: #E7EFF1;");
        
        Label headerlbl3 = new Label("FIND A PET FOR ADOPTION");
        headerlbl3.setStyle("-fx-font: 20px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-font-weight: bold;");
        headerlbl3.setPadding(new Insets(0, 0, 10, 0));

        ComboBox<String> cboPets = new ComboBox<>();
        cboPets.setItems(Types);
        cboPets.setPrefWidth(200);
        cboPets.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F;-fx-background-color: #ffffff; -fx-border-color: #A7AB9E;");
        cboPets.setValue("All");
        header3.getChildren().addAll(headerlbl3, cboPets);
        
        Button backbtn3 = new Button("Back", backArrowMed);
        backbtn3.setStyle("-fx-base: #a7ab9e ; -fx-font:15 serif;");
        StackPane.setMargin(backbtn3, new Insets(0, 0, 0,-450));
        
        ImageView logoAdoView = new ImageView(imageLogo);
        logoAdoView.setFitHeight(60);
        logoAdoView.setFitWidth(80);
        StackPane.setMargin(logoAdoView, new Insets(0, 0, 0,500));
  
        adoptionHeader.getChildren().addAll(header3, logoAdoView, backbtn3);
        
        //body
        GridPane bodyPane3 = new GridPane();
        bodyPane3.setStyle("-fx-background-color: #E7EFF1;");
        bodyPane3.setPadding(new Insets(10));
        bodyPane3.setHgap(10);
        bodyPane3.setVgap(10);
        bodyPane3.setAlignment(Pos.CENTER);
 
        session = HibernateUtil.getSessionFactory().openSession();
        List<AdoptionPet> petListAll = null;
        String queryStr1 = "from AdoptionPet";
        Query query = session.createQuery(queryStr1);
        petListAll = query.list();
        session.close();

        for (int i = 0; i < petListAll.size(); i++) {
            AdoptionPet p = petListAll.get(i);
            GridPane petPost = createPost(p);
            bodyPane3.add(petPost, 0, i);
        }
        
        containerPane3.setTop(adoptionHeader);
        containerPane3.setCenter(bodyPane3);
        
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(containerPane3);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setPrefViewportWidth(400);
        scrollPane.setPrefViewportHeight(300);
        
        Adopt = new Scene(scrollPane, 640, 640);
         
        
        /////////////////////////////////////////////////////////////////////////////////////////////////// Actions ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        LoginFirst.setOnAction(e->{
            stage.setScene(LogIn);
        });
        
        SignupFirst.setOnAction(e->{
            stage.setScene(SignUp);
        });
        
        backLogin.setOnAction(e ->{
            stage.setScene(NadeemScene);
        });
        
        backSign.setOnAction(e ->{
            stage.setScene(NadeemScene);
        });
        
        
        buttonLoginPage3.setOnAction(event -> { //Connect DB
            if (checkUser() == true) {
                stage.setScene(Menu);
            }
        });
        
        SignUpButtonPage2.setOnAction(event -> {  //Connect DB
            if(checkValidUsername(nameTextPage2) == true  && checkValidEmail(emailTextPage2) == true && checkValidPassword(passwordField) ){
                newUser(retrievedUser);
                stage.setScene(Menu);
            }               
        });
        
        
        backHotel.setOnAction(e ->{
             stage.setScene(Menu);
        });
        
        
        backAdopt.setOnAction(e ->{
             stage.setScene(Menu);
        });
         
        backMed.setOnAction(e ->{
            stage.setScene(Menu);
        });
        
         
        confirmReserve.setOnAction(e -> {
            newReservation();
            updateReservation();
            confirmText.setText("Your Reservation Has Been Confirmed. Nadeem Team Will Contact You Soon, Thank You");
        });
        
        backAcc .setOnAction(e -> {
             stage.setScene(Menu);
        });  

        B1.setOnAction(e -> {
             stage.setScene(PetHotelScene);
        });  
        
        B2.setOnAction(e -> {
             stage.setScene(Adoption);
        });  
        
        B3.setOnAction(e -> {
             stage.setScene(Medical);
        });  
        
        B4.setOnAction(e -> {
             stage.setScene(enviromentInfo);
        });  
        
        
        B5.setOnAction(e -> {
             stage.setScene(About);
        });
        
        B6.setOnAction(e -> {
             stage.setScene(Menu);
        });  
          
        B6.setOnKeyPressed(event -> { //from about to menu
            if (event.getCode().isLetterKey()) {
                stage.setScene(Menu);
            }
        });
        
        B7.setOnAction(e -> {
             stage.setScene(Menu);
        });  

        B7.setOnKeyPressed(event -> {
            if (event.getCode().isLetterKey()) {
                stage.setScene(Menu);
            }
        });
                  
        
          
        B8.setOnAction(e -> {
            stage.setScene(AddPetInfo);
        });  
        
        B9.setOnAction(e -> { 
            if(!tf1.getText().isEmpty() || !tf2.getText().isEmpty() || !tf3.getText().isEmpty() || !tf4.getText().isEmpty()){
                updatePetInfo();
                Text updated = new Text("Your Pet's Information has been updated"); 
                updated.setStyle("-fx-background-color:#a7ab9e;-fx-text-fill:#494140;-fx-font: normal 14px 'Abril Fatface' ");
                updated.setFill(x);
                updated.setTranslateX(200);
                updated.setTranslateY(500);
                Pane2.getChildren().add(updated);
            }
        });  
        
        B10.setOnAction(e -> {
             stage.setScene(Menu);
        }); 
        
        B10.setOnKeyPressed(event -> {
            if (event.getCode().isLetterKey()) {
                stage.setScene(Menu);
            }
         });
        
        B11.setOnAction(event -> {
            printPetInfo();
            stage.setScene(PetAccount);
        });
        
        imageViewPet.setOnMouseClicked(event ->{
            petImage = attachPhoto(new Label());  
            imageViewPet.setImage(new Image(petImage));
            retrievedPet.setPetpic(petImage);
        });
        
        ptad.setOnAction(event -> {
            stage.setScene(Adopt);
        });
        
        ofead.setOnAction(event -> {
            stage.setScene(AdoptOffer1);
        });     
                
        backbtn1.setOnAction(event -> {
            stage.setScene(Adoption);  
        });
        
        backbtn3.setOnAction(event -> {
            stage.setScene(Adoption);  
        });       
        
        continueBtn.setOnAction(event -> {
            if(checkValidAge(petAgetf, groupAge) == true  && checkValidWeight(petWeighttf) == true){
                stage.setScene(AdoptOffer2);
            }        
        });

        backbtn2.setOnAction(event -> {
            petAgetf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
            petWeighttf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
            stage.setScene(AdoptOffer1);
        });

        
        submitbtn.setOnAction(event -> {
            if (checkName(ownerNametf) == true && checkValidPhone(ownerPhonetf) == true && checkValidAddress(ownerAddresstf) == true){
                addPetForAdoption();
                stage.setScene(Adoption);    
            }   
        });
        
        attachBtn.setOnAction(event -> {
            imagePath = attachPhoto(lblAttachedPhoto);
            imageViewAt.setImage(new Image(imagePath));
        });
        
        cboType.setOnAction(event -> {
            if (cboType.getValue() != null && cboGender.getValue() != null) {
                continueBtn.setDisable(false);
            }
        });

        cboGender.setOnAction(event -> {
            if (cboGender.getValue() != null && cboType.getValue() != null) {
                continueBtn.setDisable(false);
            }
        });
        
        
        cboPets.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            GridPane petPost = new GridPane();
            session = HibernateUtil.getSessionFactory().openSession();
            String queryStr;
            List<AdoptionPet> petList = null;
                  
            if (newValue.equals("All")) {
                bodyPane3.getChildren().clear();
                queryStr = "from AdoptionPet";
                Query query1 = session.createQuery(queryStr);
                petList = query1.list();
                
            } else if (newValue.equals("Dogs Only")) {
                bodyPane3.getChildren().clear();
                queryStr = "from AdoptionPet where PetType = 'Dog'";
                Query query2 = session.createQuery(queryStr);
                petList = query2.list();

            } else if (newValue.equals("Cats Only")) {
                bodyPane3.getChildren().clear();
                queryStr = "from AdoptionPet where PetType = 'Cat'";
                Query query3 = session.createQuery(queryStr);
                petList = query3.list();

            } else if (newValue.equals("Birds Only")) {
                bodyPane3.getChildren().clear();
                queryStr = "from AdoptionPet where PetType = 'Bird'";
                Query query4 = session.createQuery(queryStr);
                petList = query4.list();
            }   

            for (int i = 0; i < petList.size(); i++) {
                AdoptionPet p = petList.get(i);
                petPost = createPost(p);
                bodyPane3.add(petPost, 0, i);
            }
            session.close();
        });
        
        
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        stage.setTitle("نـديـم");
        stage.setScene(NadeemScene); //NadeemScene
        stage.show();
        
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Extra Methods ////////////////////////////////////////////////////////////////////////////////////    
    
    public int CalPrice(long days){
        
        int price = 35 ; 
        
        int finalPrice = (int) (days * price);
    
        return finalPrice;
    
    }
    
    public boolean checkDate(Long days, DatePicker DOA , DatePicker DOD){
        boolean validDate = false;
        
         if(days < 0){
             DOA.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #FF0000;");  
             DOD.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #FF0000;");  
             Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Date"); 
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid date. \nThe date of Arrival shoud be before the date of Departure");
            alert.showAndWait();
            
            validDate = false;
         }
         
         
         else{
         validDate = true;
          DOA.setStyle("");  
             DOD.setStyle("");  
         }
        
    return validDate; }
    
    private boolean checkValidEmail(TextField tf) {
    String email = tf.getText();
    boolean validEmail = false;
    
    if (!email.isEmpty()) {
        // Customize your email validation criteria here
        if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
            validEmail = true;      
        } 
        else {
            tf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #FF0000;");            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Email");            
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid email address.");            
            alert.showAndWait();
        }    } else {
        validEmail = true;
    }
    return validEmail;
    }

    private boolean checkValidPassword(PasswordField passwordField) {
    String password = passwordField.getText();   
    boolean validPassword = false;
    
    if (!password.isEmpty()) {
        // Customize your password validation criteria here 
        if (password.length() >= 8) {
            validPassword = true;        } else {
            passwordField.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #FF0000;");   
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Password");     
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid password. It should be at least 8 characters long."); 
            alert.showAndWait();
        } 
    } 
    else {
        validPassword = true;   
    }

    return validPassword;
    }
    
    
    private boolean checkValidUsername(TextField tf) {    
   String username = tf.getText();
    boolean validUsername = false;
    if (!username.isEmpty()) {   
if (username.matches("^[a-zA-Z0-9_]+$") && username.length() >= 4 && username.length() <= 20) {
            validUsername = true; 
}
else {
            tf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #FF0000;");    
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Username"); 
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid username. It should consist of alphanumeric characters and underscores, and be between 4 and 20 characters long.");
            alert.showAndWait();
        }    
    } 
    else {
        validUsername = true;    }

    return validUsername;
    }
    
    //scene offer 1 methods
    private boolean checkValidAge(TextField tf, ToggleGroup tg) {
        String input = tf.getText();
        boolean validAge = false;
        if (!input.isEmpty()) {
            try {
                Integer.valueOf(input);
                if(tg.getSelectedToggle() != null){
                    validAge = true;
                }
                else{
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Invalid Input");
                    alert.setHeaderText(null);
                    alert.setContentText("Please Select the age unit.");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {
                tf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #FF0000;");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid integer value.");
                alert.showAndWait();
            }
        }
        else{
            validAge = true;
        }
        return validAge;
    }
    
    private String attachPhoto(Label lblAttachedPhoto) {
        // Create a FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Photo");

        // Set the file extension filters
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(
                        "Image Files", "*.png", "*.jpg", "*.jpeg"));

        // Show the file dialog
        File selectedFile = fileChooser.showOpenDialog(null);
        String path;
        if (selectedFile != null) {
            path = selectedFile.toURI().toString();


            // Update the label text
            lblAttachedPhoto.setText("Photo attached: \n" + selectedFile.getName());        
            return path;
        }
        return "";
    }
    
    private boolean checkValidWeight(TextField tf) {
        String input = tf.getText();
        boolean validWeight = false;
        if (!input.isEmpty()) {
            try {
                Double.valueOf(input);
                validWeight = true;
            } catch (NumberFormatException e) {
                tf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #FF0000;");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid double value.");
                alert.showAndWait();
            }
        }  
        else{
          validWeight = true;  
        }
        return validWeight;
    }
    
    //scene offer 2 methods
    
    private boolean checkName(TextField tf){
        String input = tf.getText();
        boolean value;
        if(input.isEmpty()){
            tf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #FF0000;");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Owner Name is required.");
            alert.showAndWait();
            value = false;
        }
        else{
            value = true;
        }
        return value;
    }
    
    private boolean isValidPhoneNumber(String phoneNumber) {
    // Regular expression pattern for Saudi phone numbers starting with 5
    String regex = "^5[0-9]{8}$";

    // Check if the phone number matches the pattern
    return phoneNumber.matches(regex);
}
    
    private boolean checkValidPhone(TextField tf){
        String input = tf.getText();
        boolean isValidPhone = false;
            input = input.replaceAll("[^0-9]", "");
            if (input.isEmpty() || !isValidPhoneNumber(input)) {
                tf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #FF0000;");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid phone number start with 5 ex.500000000");
                alert.showAndWait();
                isValidPhone = false;
            } 
            else{
                tf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
                isValidPhone = true;
            }
        return isValidPhone;   
    }
    
    private boolean checkValidAddress(TextField tf){
        String input = tf.getText();
        boolean isValidAddress = false;
        if(input.isEmpty()){
                tf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #FF0000;");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter an address");
                alert.showAndWait();
            }
        else{
            tf.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-border-color: #A7AB9E;");
            isValidAddress = true;
        }
        return isValidAddress; 
    }
    
    
    private void addPetForAdoption(){
        AdoptionPet p = new AdoptionPet();
        p.setPetName(petNametf.getText());
        p.setPetType(cboType.getValue());
        p.setPetAge(petAgetf.getText());      
        RadioButton selectedRadioButton = (RadioButton) groupAge.getSelectedToggle();
        if (selectedRadioButton!=null){
            String selectedValue = selectedRadioButton.getText();
            p.setPetAgeUnit(selectedValue);
        }
        else{
            p.setPetAgeUnit("-");
        }
        p.setPetGender(cboGender.getValue());
        p.setPetWeight(petWeighttf.getText());
        p.setInfo(txtInfo.getText());
        p.setImage(imagePath);
        p.setOwnerName(ownerNametf.getText());
        p.setPhone(ownerPhonetf.getText());
        p.setEmail(ownerEmailtf.getText());
        p.setAddress(ownerAddresstf.getText());
        p.setReason(reasonTa.getText());
        
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(p);
        tx.commit();
        session.close();
    }
    
    private GridPane createPost(AdoptionPet p) {
        GridPane post = new GridPane();
        post.setPadding(new Insets(30));
        post.setStyle("-fx-font: 14px 'Comic Sans MS'; -fx-text-fill: #294D4F; -fx-background-color: #c0c3b9");
        post.setHgap(10);
        post.setVgap(5);
        post.setPrefWidth(600);
        
        ImageView imageViewPost = new ImageView();
        Image image = new Image(p.getImage());
        imageViewPost.setImage(image);
        imageViewPost.setFitWidth(150);
        imageViewPost.setFitHeight(150);

        Label nameLabel = new Label("Pet's Name: ");
        Label givenName = new Label();
        givenName.setText(p.getPetName());
        GridPane.setMargin(givenName, new Insets(0, 0, 0, 90));
        
        Label typeLabel = new Label("Type: ");
        Label givenType = new Label();
        givenType.setText(p.getPetType());
        GridPane.setMargin(givenType, new Insets(0, 0, 0, 50));
        
        Label ageLabel = new Label("Age: ");
        Label givenAge = new Label();
        givenAge.setText(p.getPetAge() +" " + p.getPetAgeUnit());
        GridPane.setMargin(givenAge, new Insets(0, 0, 0, 40));
        
        Label genderLabel = new Label("Gender: ");
        Label givenGender = new Label();
        givenGender.setText(p.getPetGender());
        GridPane.setMargin(givenGender, new Insets(0, 0, 0, 60));
        
        Label weightLabel = new Label("Weight: ");
        Label givenWeight = new Label();
        if(!p.getPetWeight().isEmpty()){
            givenWeight.setText(p.getPetWeight() + " kg");
        }
        else{
            givenWeight.setText(p.getPetWeight());
        }
        GridPane.setMargin(givenWeight, new Insets(0, 0, 0, 60));
        
        Label ownerNameLabel = new Label("Owner's Name: ");
        Label givenOwnerName = new Label();
        givenOwnerName.setText(p.getOwnerName());
        GridPane.setMargin(givenOwnerName, new Insets(0, 0, 0, 110));
        
        Label phoneLabel = new Label("Phone Number: ");
        Label givenPhone = new Label();
        givenPhone.setText(p.getPhone());
        GridPane.setMargin(givenPhone, new Insets(0, 0, 0, 110));
        
        Label addressLabel = new Label("Address: ");
        Label givenAddress = new Label();
        givenAddress.setText(p.getAddress());
        GridPane.setMargin(givenAddress, new Insets(0, 0, 0, 70));
        
        Label emailLabel = new Label("email: ");
        Label givenEmail = new Label();
        givenEmail.setText(p.getEmail());
        GridPane.setMargin(givenEmail, new Insets(0, 0, 0, 50));
        
        Label infoLabel = new Label("Additional Info: ");
        Label givenInfo = new Label();
        givenInfo.setText(p.getInfo());
        GridPane.setMargin(givenInfo, new Insets(0, 0, 0, 110));
        
        Label reasonLabel = new Label("Reason for adoption: ");
        Label givenReason = new Label();
        givenReason.setText(p.getReason());
        GridPane.setMargin(givenReason, new Insets(0, 0, 0, 150));
        
        nameLabel.setStyle("-fx-font-weight: bold;");
        typeLabel.setStyle("-fx-font-weight: bold;");
        ageLabel.setStyle("-fx-font-weight: bold;");
        genderLabel.setStyle("-fx-font-weight: bold;");
        weightLabel.setStyle("-fx-font-weight: bold;");
        ownerNameLabel.setStyle("-fx-font-weight: bold;");
        phoneLabel.setStyle("-fx-font-weight: bold;");
        addressLabel.setStyle("-fx-font-weight: bold;");
        emailLabel.setStyle("-fx-font-weight: bold;");
        infoLabel.setStyle("-fx-font-weight: bold;");
        reasonLabel.setStyle("-fx-font-weight: bold;");

        GridPane.setColumnSpan(imageViewPost, 2);

        post.add(imageViewPost, 0, 0);
        post.add(nameLabel, 0, 1);
        post.add(givenName, 0, 1);
        post.add(typeLabel, 0, 2);
        post.add(givenType, 0, 2);
        post.add(ageLabel, 0, 3);
        post.add(givenAge, 0, 3);
        post.add(genderLabel, 0, 4);
        post.add(givenGender, 0, 4);
        post.add(weightLabel, 0, 5);
        post.add(givenWeight, 0, 5);
        post.add(ownerNameLabel, 0, 6);
        post.add(givenOwnerName, 0, 6);
        post.add(phoneLabel, 0, 7);
        post.add(givenPhone, 0, 7);
        post.add(addressLabel, 0, 8);
        post.add(givenAddress, 0, 8);
        post.add(emailLabel, 0, 9);
        post.add(givenEmail, 0, 9);
        post.add(infoLabel, 0, 10);
        post.add(givenInfo, 0, 10);
        post.add(reasonLabel, 0, 11);
        post.add(givenReason, 0, 11);
        
        return post;
    }
    
    private void newUser(User user){
        
//        User user = new User();
        user.setUsername(nameTextPage2.getText());
        user.setEmail(emailTextPage2.getText());
        user.setPassword(passwordField.getText());

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
        
        retrievedUser = user;
        retrievedUserId = retrievedUser.getUserId();
        RadioButton selectedBtn = (RadioButton) groupPetType.getSelectedToggle();  

        if (selectedBtn != adoptRadio){
            UserPet pet = new UserPet();
            String selectedValue2 = selectedBtn.getText();
            
            pet.setPetname(petTextPage2.getText());
            pet.setPetDOB(datePicker.getValue());
            pet.setPettype(selectedValue2);
            pet.setPetpic(petImage);
//            pet.setUser(retrievedUser);
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(pet);
            tx.commit();
            session.close();
            retrievedPet = pet;
//            System.out.println(retrievedUser.getUserId());
//            System.out.println(retrievedPet.getPetID());            
        }
    }
    
    private boolean checkUser() {
        //retrive Users list
        session = HibernateUtil.getSessionFactory().openSession();
        //List<User> users = null;
        String queryStr = "from User where username = :nameOrEmail or email = :nameOrEmail";
        Query query = session.createQuery(queryStr);
        query.setParameter("nameOrEmail", nameOrEmailText.getText());
        //users = query.list();
        User u = (User) query.uniqueResult();
        session.close();

        boolean userExists = false;
        
//        for (User u : users) {
            if (u != null) {

            if (u.getPassword().equals(passwordLGField.getText())) {
                userExists = true;
                retrievedUser = u;
//                System.out.println(retrievedUser.getUserId());
                retrievedPet = retrievedUser.getPet();
                
//                System.out.println(retrievedPet.getPetID());
                retrievedUserId = retrievedUser.getUserId();
            }
        }

        if (!userExists) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password");
            alert.showAndWait();
        }

        
        return userExists;      
    }
    
    private void updatePetInfo() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        UserPet updatePet = null;

        // Retrieve the UserPet object associated with the current user
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserPet> query = builder.createQuery(UserPet.class);
        Root<UserPet> root = query.from(UserPet.class);
        query.select(root).where(builder.equal(root.get("user"), retrievedUser));
        updatePet = session.createQuery(query).uniqueResult();

        // Update the pet information
        updatePet.setPetfood(tf1.getText());
        updatePet.setPethealth(tf2.getText());
        updatePet.setPetcare(tf3.getText());
        updatePet.setPetgames(tf4.getText());
        updatePet.setPetpic(petImage);
        session.update(updatePet);
        tx.commit();
        session.close();
        retrievedPet = updatePet; 
    }
    
    private void newReservation(){    
 
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
        UserPet userpet = retrievedUser.getPet();
        PetHotel pethotel = new PetHotel();
        pethotel.setPetType(petTypeListHotel.getValue());
        pethotel.setCity(cityListForHotel.getValue());
        pethotel.setDoArrival(arrive.getValue());
        pethotel.setDoDep(dep.getValue());
        pethotel.setPrice(lastPrice);

        pethotel.setUserPet(userpet);
        
        session.save(pethotel);
        tx.commit();
        session.close();
        
        retrievedPetHotel = pethotel;
    }
    
    private void updateReservation(){ 
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();        
        PetHotel updateRes = null;

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PetHotel> query = builder.createQuery(PetHotel.class);
        Root<PetHotel> root = query.from(PetHotel.class);
        query.select(root).where(builder.equal(root.get("userPet"), retrievedPet));
        updateRes = session.createQuery(query).uniqueResult();
        session.update(updateRes);
        tx.commit();
        session.close();
        retrievedPetHotel = updateRes; 
        //System.out.println(retrievedPetHotel.getIdPetHotel());
    }
    
    private void printPetInfo(){
        givenName.setText(retrievedPet.getPetname());
        givenType.setText(retrievedPet.getPettype());
        if(retrievedPet.getPetDOB() != null){
            givenDOB.setText(retrievedPet.getPetDOB().toString());
        }
        else{
            givenDOB.setText("-");
        }
        givenUsername.setText(retrievedUser.getUsername());
        givenEmail.setText(retrievedUser.getEmail());
        givenFood.setText(retrievedPet.getPetfood());
        givenHealth.setText(retrievedPet.getPethealth());
        givenCare.setText(retrievedPet.getPetcare());
        givenGame.setText(retrievedPet.getPetgames());
        imageViewPet.setImage(new Image(retrievedPet.getPetpic()));

        
//        System.out.println(retrievedUser.getUserId());
//        System.out.println(retrievedPet.getPetID());
//        System.out.println(retrievedPetHotel.getIdPetHotel());

    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args) {
        launch();
    } 

}
