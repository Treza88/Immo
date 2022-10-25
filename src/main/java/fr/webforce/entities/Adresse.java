package fr.webforce.entities;

public class Adresse {
    String numero;
    String rue;
    String code_postal;
    String ville;

    public String getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getCode_postal() {
        return code_postal;
    }

    public String getVille() {
        return ville;
    }

    public Adresse(String numero, String rue, String code_postal, String ville) {
        this.numero = numero;
        this.rue = rue;
        this.code_postal = code_postal;
        this.ville = ville;
    }
}
