package fr.webforce;

import fr.webforce.entities.Adresse;
import fr.webforce.entities.Bien;
import fr.webforce.services.CommandSQL;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        Bien maison1 = new Bien("maison", 4, 70, 120000, 1920, true, true, true, true);
        Adresse adresse1 = new Adresse("25", "rue du jardinaet", "59000", "Lille");

        CommandSQL insert1 = new CommandSQL();
        insert1.insert(maison1, adresse1);
        CommandSQL trouveTout = new CommandSQL();
        trouveTout.findAll();
    }
}