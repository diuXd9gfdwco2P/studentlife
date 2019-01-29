package com.yanis.studentlife;

public class Plan {
    public String nom;
    public String description;
    public String lieu;
    public String phone;

    public Plan(String nom, String description, String lieu, String phone) {
        this.nom = nom;
        this.description = description;
        this.lieu = lieu;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", lieu='" + lieu + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
