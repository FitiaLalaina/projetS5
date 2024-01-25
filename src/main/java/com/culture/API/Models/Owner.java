package com.culture.API.Models;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import com.culture.API.Repository.OwnerRepository;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
@Entity
public class Owner implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOwner;

    @Basic
    private String name;

    @Basic
    private String email;

    @Basic
    private String pwd;

    @OneToOne(mappedBy = "owner")
    private Wallet wallet;

    @Basic 
    private int privilege;

    @OneToMany(mappedBy = "owner" , fetch = FetchType.EAGER)
    @Transient
    private List<Field> fields;

    public Owner login(OwnerRepository or)throws SQLException{
        return Owner.getOwner(or,this.getEmail(),this.getPwd());
    }

    public Owner() {
    }
    
    public Owner(int idOwner,String email, String name, int privilege, String pwd) {
        this.idOwner = idOwner;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.privilege = privilege;
    }
    
    public Owner(int idOwner, String name, String email, String pwd, Wallet wallet, int privilege, List<Field> fields) {
        this.idOwner = idOwner;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.wallet = wallet;
        this.privilege = privilege;
        this.fields = fields;
    }

    public int getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(int idOwner) {
        this.idOwner = idOwner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public static Owner saveOwner(Owner o, OwnerRepository or) throws SQLException{
        Owner ow = or.save(o);
        return ow;
    }
    public static List<Owner> findAllOwner(OwnerRepository or) throws SQLException{
        List<Owner> o = or.findAll();
        return o;
    }
    public static Owner getOwner(OwnerRepository or,String email, String pwd) throws SQLException{
        Owner ow = or.findByEmailAndPwd(email,pwd);
        return ow;
    }

}
