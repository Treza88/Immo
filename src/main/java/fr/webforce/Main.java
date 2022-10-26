package fr.webforce;

import fr.webforce.entities.Adresse;
import fr.webforce.entities.Bien;
import fr.webforce.services.CommandSQL;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        String types[] = {"Maison", "Appartement", "Garage", "Terrain vide", "Jardin"};
        String numeros[] = {"56", "95", "87", "26", "123", "5624"};
        String rues[] = {"Rue massena", "Boulvard du tilleul", "Impasse cordont", "Cité des gardins", "Place principale"};
        String codePostals[] = {"59641", "88456", "51369", "02569", "75000"};
        String villes[] = {"Tartampion", "Nowhere", "Top ville", "Bad ville", "Groland ville"};
        int nbPieces[] = {1, 2, 3, 4, 5};
        int surfHabits[] = {100, 210, 153, 72, 165};
        int prixs[] = {150000, 220000, 320000, 470000, 510000};
        int anneeConsts[] = {1954, 2010, 2004, 1987, 1674};

        Scanner sc = new Scanner(System.in);
//        System.out.println("Entrer le type de logement : ");String  type = sc.nextLine();
//        sc.nextLine();
//        System.out.println("Entrer le nombre de piece : ");int nbPiece = sc.nextInt();
//        System.out.println("Entrer la surface Habitable : ");int surfHabit = sc.nextInt();
//        System.out.println("Entrer le prix : ");int prix = sc.nextInt();
//        System.out.println("Entrer l'année de construction' : ");int anneeConst = sc.nextInt();
//        System.out.println("Il y a t'il un garage? true/false ");Boolean garage = sc.nextBoolean();
//        System.out.println("Il y a t'il une terrasse? true/false  : ");Boolean terrasse = sc.nextBoolean();
//        System.out.println("Il y a t'il un balcon? true/false : ");Boolean balcon = sc.nextBoolean();
//        System.out.println("Il y a t'il un jardin? true/false : ");Boolean jardin = sc.nextBoolean();
//        System.out.println("Entrer le numéro du logement : ");String numero = sc.nextLine();
//        sc.nextLine();
//        System.out.println("Entrer la rue : ");String rue = sc.nextLine();
//        sc.nextLine();
//        System.out.println("Entrer le code postal : ");String codePostal = sc.nextLine();
//        sc.nextLine();
//        System.out.println("Entrer la ville : ");String ville = sc.nextLine();
//
//        Bien maison1 = new Bien(type, nbPiece, surfHabit, prix, anneeConst, garage, terrasse, balcon, jardin);
//        Adresse adresse1 = new Adresse(numero, rue, codePostal, ville);

        //for (int i = 0; i < 25; i++) {

        Bien maison1 = new Bien(getRandomString(types), getRandomInt(nbPieces), getRandomInt(surfHabits), getRandomInt(prixs), getRandomInt(anneeConsts), true, true, true, true);
        Adresse adresse1 = new Adresse(getRandomString(numeros), getRandomString(rues), getRandomString(codePostals), getRandomString(villes));

//        CommandSQL insert1 = new CommandSQL();
//        insert1.insert(maison1, adresse1);

//        CommandSQL trouverParId = new CommandSQL();
//        trouverParId.findById();

//        CommandSQL modifier = new CommandSQL();
//        modifier.update(maison1, adresse1);

//        CommandSQL supprimmer = new CommandSQL();
//        supprimmer.delete(adresse1);

//        CommandSQL trouveTout = new CommandSQL();
//        trouveTout.findAll();

        //}
        System.out.println("Que voulez vous faire ? ");
        System.out.println("\t1 - Une recherche par type");
        System.out.println("\t2 - Une recherche par ville");
        System.out.println("\t3 - Une recherche par prix");
        System.out.println("\t4 - Inserer un bien ");
        System.out.println("\t5 - Une mise a jour d'un bien");
        System.out.println("\t6 - Une supperession d'un bien apres une recherche");
        int choix = sc.nextInt();
        CommandSQL recherchType1 = new CommandSQL();
        String table = "";
        switch (choix){
            case 1:

                recherchType1.recherchType(1, "bien");

                break;
            case 2:
                recherchType1.recherchType(2,"adresse");

                break;
            case 3:
                recherchType1.recherchType(3,"bien");

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            default:

        }








    }

    public static int getRandomInt(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static String getRandomString(String[] array) {
        Random rnd = new Random();
        int index = rnd.nextInt(array.length);
        return array[index];
    }

}