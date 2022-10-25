package fr.webforce.entities;

public class Adresse {
    String numero;
    String rue;
    String code_postal;
    String ville;

    public Adresse(String numero, String rue, String code_postal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
    }
}
