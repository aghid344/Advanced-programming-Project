/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectap;
import java.time.LocalDate;
import java.util.Date;
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
@Table(name = "pet_hotel")
public class PetHotel implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pet_hotel")
    private int idPetHotel;

    @Column(name = "pet_type")
    private String petType;

    @Column(name = "city")
    private String city;

    @Column(name = "do_arrival")
    private LocalDate doArrival;

    @Column(name = "do_dep")
    private LocalDate doDep;

    @Column(name = "price")
    private int price;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private UserPet userPet;

    public PetHotel(int idPetHotel, String petType, String city, LocalDate doArrival, LocalDate doDep, int price, UserPet userPet) {
        this.idPetHotel = idPetHotel;
        this.petType = petType;
        this.city = city;
        this.doArrival = doArrival;
        this.doDep = doDep;
        this.price = price;
        this.userPet = userPet;
    }

    public PetHotel() {
    }

    public int getIdPetHotel() {
        return idPetHotel;
    }

    public void setIdPetHotel(int idPetHotel) {
        this.idPetHotel = idPetHotel;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDoArrival() {
        return doArrival;
    }

    public void setDoArrival(LocalDate doArrival) {
        this.doArrival = doArrival;
    }

    public LocalDate getDoDep() {
        return doDep;
    }

    public void setDoDep(LocalDate doDep) {
        this.doDep = doDep;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public UserPet getUserPet() {
        return userPet;
    }

    public void setUserPet(UserPet userPet) {
        this.userPet = userPet;
    }
    
    
    
}
