/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectap;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Dawla
 */

@Entity
@Table(name = "adoption_pet")
public class AdoptionPet implements java.io.Serializable {
    @Id
    @Column(name="PetId")
    private int id;
    
    @Column(name="PetName")
    private String petName;
    
    @Column(name="PetType")
    private String petType;
    
    @Column(name="PetGender")
    private String petGender;
    
    @Column(name="PetInfo")
    private String info;
    
    @Column(name="Reason")
    private String reason;
    
    @Column(name="OwnerName")
    private String ownerName;
    
    @Column(name="Address")
    private String address;
    
    @Column(name="Email")
    private String email;
    
    @Column(name="PetAge")
    private String petAge;
    
    @Column(name="PetAgeUnit")
    private String petAgeUnit;
    
    @Column(name="Phone")
    private String phone;
    
    @Column(name="PetWeight")
    private String petWeight;
    
    @Column(name="PetImage")
    private String image;
   
    
    public AdoptionPet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getImage() {
        if(image == null){
            return image = "https://www.generationsforpeace.org/wp-content/uploads/2018/03/empty.jpg";
        }
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    public String getPetName() {
        if (petName == null) {
        return "None";
        }
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        if (petType == null) {
        return "None";
        }
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetGender() {
        if (petGender == null) {
        return "None";
        }
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public String getInfo() {
        if (info == null) {
        return "None";
        }
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getReason() {
        if (reason == null) {
        return "None";
        }
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOwnerName() {
        if (ownerName == null) {
        return "None";
        }
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        if (address == null) {
        return "None";
        }
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        if (email == null) {
        return "None";
        }
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public String getPetAgeUnit() {
        return petAgeUnit;
    }

    public void setPetAgeUnit(String petAgeUnit) {
        this.petAgeUnit = petAgeUnit;
    }

    public String getPhone() {
        if (phone == null) {
        return "None";
        }
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPetWeight() {
        if (petWeight == null) {
        return "None";
        }
        return petWeight;
    }

    public void setPetWeight(String petWeight) {
        this.petWeight = petWeight;
    }

}


