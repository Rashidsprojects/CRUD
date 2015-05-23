package com.rashid.model;

import java.util.Date;

/**
 * Created by Rashid on 23.05.2015.
 */
public class Staff {
    private int id;
    private int indexNum;
    private String surname;
    private String name;
    private String patronymic;
    private Date dob;
    private int idPost;
    private int idRank;
    private int idSubdiv;
    private Date contractDate;
    private int contractPeriond;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIndexNum() {
        return indexNum;
    }
    public void setIndexNum(int indexNum) {
        this.indexNum = indexNum;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public int getIdPost() {
        return idPost;
    }
    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }
    public int getIdRank() {
        return idRank;
    }
    public void setIdRank(int idRank) {
        this.idRank = idRank;
    }
    public int getIdSubdiv() {
        return idSubdiv;
    }
    public void setIdSubdiv(int idSubdiv) {
        this.idSubdiv = idSubdiv;
    }
    public Date getContractDate() {
        return contractDate;
    }
    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }
    public int getContractPeriond() {
        return contractPeriond;
    }
    public void setContractPeriond(int contractPeriond) {
        this.contractPeriond = contractPeriond;
    }

    @Override
    public String toString() {
        return "Staff [id=" + id + ", indexNum=" + indexNum
                + ", surname=" + surname + ", name=" + name + ", patronymic="
                + patronymic + ", dob=" + dob + ", idPost=" + idPost
                + ", idRank=" + idRank + ", idSubdiv=" + idSubdiv + ", contractDate="
                + contractDate + ", contractPeriond=" + contractPeriond + "]";
    }
}
