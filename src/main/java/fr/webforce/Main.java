package fr.webforce;

import fr.webforce.entities.Bien;
import fr.webforce.services.CommandSQL;

public class Main {
    public static void main(String[] args) {

        Bien maison1 = new Bien("maison",4,70,120000,);






        CommandSQL trouveTout = new CommandSQL();
        trouveTout.findAll();


    }
}