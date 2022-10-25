package fr.webforce.entities;

public class Bien {

    String type;
    int nb_piece;
    int surf_habit;
    int prix;
    int annee_const;
    boolean garage;
    boolean terrase;
    boolean balcon;
    boolean jardin;

    public String getType() {
        return type;
    }

    public int getNb_piece() {
        return nb_piece;
    }

    public int getSurf_habit() {
        return surf_habit;
    }

    public int getPrix() {
        return prix;
    }

    public int getAnnee_const() {
        return annee_const;
    }

    public boolean isGarage() {
        return garage;
    }

    public boolean isTerrase() {
        return terrase;
    }

    public boolean isBalcon() {
        return balcon;
    }

    public boolean isJardin() {
        return jardin;
    }

    public Bien(String type, int nb_piece, int surf_habit, int prix, int annee_const, boolean garage, boolean terrase, boolean balcon, boolean jardin) {
        this.type = type;
        this.nb_piece = nb_piece;
        this.surf_habit = surf_habit;
        this.prix = prix;
        this.annee_const = annee_const;
        this.garage = garage;
        this.terrase = terrase;
        this.balcon = balcon;
        this.jardin = jardin;
    }
}
