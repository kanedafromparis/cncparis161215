/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kanedafromparis.ose.fakedatagen;

/**
 *
 * @author csabourdin
 */
public class FDGPersonne {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;

    private String firstname;
    private String lastname;
    private String cardVendor;
    private String stnum;
    private String street;
    private String postalCode;
    private String city;

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the cardVendor
     */
    public String getCardVendor() {
        return cardVendor;
    }

    /**
     * @param cardVendor the cardVendor to set
     */
    public void setCardVendor(String cardVendor) {
        this.cardVendor = cardVendor;
    }

    /**
     * @return the stnum
     */
    public String getStnum() {
        return stnum;
    }

    /**
     * @param stnum the stnum to set
     */
    public void setStnum(String stnum) {
        this.stnum = stnum;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

}
