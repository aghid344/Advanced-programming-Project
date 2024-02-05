/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectap;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 *
 * @author Dawla
 */
@Entity
@Table(name = "user_pet")
public class UserPet implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pet_id")
    private int petID;
    
    @Column(name = "pet_name")
    private String petname;
    
    @Column(name = "pet_dob")
    private LocalDate petDOB;
    
    @Column(name = "pet_type")
    private String pettype;
    
    @Column(name = "pet_food")
    private String petfood;
    
    @Column(name = "pet_health")
    private String pethealth;
    
    @Column(name = "pet_care")
    private String petcare;
    
    @Column(name = "pet_games")
    private String petgames;
    
    @Column(name = "pet_pic")
    private String petpic;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @OneToOne(mappedBy = "userPet")
    private PetHotel petHotel;


    public UserPet(int petID, String petname, LocalDate petDOB, String pettype, String petfood, String pethealth, String petcare, String petgames, String petpic, User user) {
        this.petID = petID;
        this.petname = petname;
        this.petDOB = petDOB;
        this.pettype = pettype;
        this.petfood = petfood;
        this.pethealth = pethealth;
        this.petcare = petcare;
        this.petgames = petgames;
        this.petpic = petpic;
        this.user = user;
    }

    public UserPet() {
    }

    public int getPetID() {
        return petID;
    }

    public String getPetname() {
        return petname;
    }

    public LocalDate getPetDOB() {
        return petDOB;
    }

    public String getPettype() {
        return pettype;
    }

    public String getPetfood() {
        return petfood;
    }

    public String getPethealth() {
        return pethealth;
    }

    public String getPetcare() {
        return petcare;
    }

    public String getPetgames() {
        return petgames;
    }

    public String getPetpic() {
        if (petpic == null){
            return "file:C:\\Users\\dia03\\OneDrive\\سطح المكتب\\photo\\add_pic.png";
        }
        return petpic;
    }

    public User getUser() {
        return user;
    }
    
    public PetHotel getPetHotel() {
        return petHotel;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public void setPetDOB(LocalDate petDOB) {
        this.petDOB = petDOB;
    }

    public void setPettype(String pettype) {
        this.pettype = pettype;
    }

    public void setPetfood(String petfood) {
        this.petfood = petfood;
    }

    public void setPethealth(String pethealth) {
        this.pethealth = pethealth;
    }

    public void setPetcare(String petcare) {
        this.petcare = petcare;
    }

    public void setPetgames(String petgames) {
        this.petgames = petgames;
    }

    public void setPetpic(String petpic) {
        this.petpic = petpic;
    }

    public void setUser(User user) {
        this.user = user;
    }   
    
    public void setPetHotel(PetHotel petHotel) {
        this.petHotel = petHotel;
    }
    
}
