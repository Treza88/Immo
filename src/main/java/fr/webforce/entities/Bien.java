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
