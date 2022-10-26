package fr.webforce.services;


import com.mysql.cj.protocol.Resultset;
import fr.webforce.configurations.Connect;

import fr.webforce.entities.Adresse;
import fr.webforce.entities.Bien;

import java.sql.*;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class CommandSQL {

    public void findAll() {

        Connection gc = Connect.getConnection();
        try (Statement st = gc.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM bien JOIN adresse on bien.id_adresse=adresse.id_adresse");
            while (rs.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append(rs.getInt("id_bien") + ", ");
                sb.append(rs.getString("type") + ", ");
                sb.append(rs.getInt("nb_piece") + ", ");
                sb.append(rs.getInt("surf_habit") + ", ");
                sb.append(rs.getInt("prix") + ", ");
                sb.append(rs.getInt("annee_const") + ", ");
                sb.append(rs.getBoolean("garage") + ", ");
                sb.append(rs.getBoolean("terrasse") + ", ");
                sb.append(rs.getBoolean("balcon") + ", ");
                sb.append(rs.getBoolean("jardin") + ", ");
                sb.append(rs.getInt("id_adresse") + ", ");

                sb.append(rs.getInt("id_adresse") + ", ");
                sb.append(rs.getString("numero") + ", ");
                sb.append(rs.getString("rue") + ", ");
                sb.append(rs.getString("code_postal") + ", ");
                sb.append(rs.getString("ville") + ", ");
                System.out.println(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void findById() {
        Scanner sc = new Scanner(System.in);
        int id = 1;
        System.out.println("Entrez l'id recherché : ");
        id = sc.nextInt();

        Connection gc = Connect.getConnection();

        try (PreparedStatement st = gc.prepareStatement("SELECT b.id_bien,b.type,b.nb_piece, " +
                "b.surf_habit,b.prix,b.annee_const,b.garage,b.terrasse,b.balcon,b.jardin,a.numero," +
                "a.rue,a.code_postal,a.ville FROM bien b JOIN adresse a on b.id_adresse=a.id_adresse where id_bien = ?")) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append(rs.getInt("id_bien") + ", ");
                sb.append(rs.getString("type") + ", ");
                sb.append(rs.getInt("nb_piece") + ", ");
                sb.append(rs.getInt("surf_habit") + ", ");
                sb.append(rs.getInt("prix") + ", ");
                sb.append(rs.getInt("annee_const") + ", ");
                sb.append(rs.getBoolean("garage") + ", ");
                sb.append(rs.getBoolean("terrasse") + ", ");
                sb.append(rs.getBoolean("balcon") + ", ");
                sb.append(rs.getBoolean("jardin") + ", ");
                //sb.append(rs.getInt("id_adresse") + ", ");

                //sb.append(rs.getInt("id_adresse") + ", ");
                sb.append(rs.getString("numero") + ", ");
                sb.append(rs.getString("rue") + ", ");
                sb.append(rs.getString("code_postal") + ", ");
                sb.append(rs.getString("ville") + ", ");
                System.out.println(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void insert(Bien bien, Adresse adresse) throws SQLException {
        int foreignKey;
        Connection gc = Connect.getConnection();
        String[] column = {"id_adresse"};
        try (PreparedStatement st = gc.prepareStatement("INSERT INTO adresse (numero,rue,code_postal,ville) VALUES (?,?,?,?)", column)) {
            st.setString(1, adresse.getNumero());
            st.setString(2, adresse.getRue());
            st.setString(3, adresse.getCode_postal());
            st.setString(4, adresse.getVille());

            int nb = st.executeUpdate();
            if (nb == 0) {
                throw new SQLException("Pas d'insertion, pas de ligne créée");
            }
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    foreignKey = generatedKeys.getInt(1);
                    System.out.println(foreignKey);
                } else {
                    throw new SQLException("Pas d'insertion, pas d'id_adresse obtenu.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (PreparedStatement st = gc.prepareStatement("INSERT INTO bien VALUES(null,?,?,?,?,?,?,?,?,?,?)")) {
            st.setString(1, bien.getType());
            st.setInt(2, bien.getNb_piece());
            st.setInt(3, bien.getSurf_habit());
            st.setInt(4, bien.getPrix());
            st.setInt(5, bien.getAnnee_const());
            st.setBoolean(6, bien.isGarage());
            st.setBoolean(7, bien.isTerrase());
            st.setBoolean(8, bien.isBalcon());
            st.setBoolean(9, bien.isJardin());
            st.setInt(10, foreignKey);
            int nb2 = st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Bien bien, Adresse adresse) {
        int foreignKey = 1;
        String[] column = {"id_adresse"};
        Scanner sc = new Scanner(System.in);
        int id = 1;
        System.out.println("Entrez l'id recherché : ");
        id = sc.nextInt();


        Connection gc = Connect.getConnection();
        try (PreparedStatement st2 = gc.prepareStatement("SELECT id_adresse FROM bien where id_bien=?", column)) {

            st2.setInt(1, id);

            ResultSet rs = st2.executeQuery();
            if (rs.next()) {
                //int sb = new StringBuilder();
                foreignKey = rs.getInt("id_adresse");
                System.out.println(foreignKey);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        var request = "UPDATE bien SET type = ?, nb_piece = ?, surf_habit = ?, prix = ?, annee_const = ?, garage = ?, terrasse = ?, balcon = ?, jardin = ? WHERE id_bien = ?";
        try (PreparedStatement st = gc.prepareStatement(request)) {


            //ResultSet rs = st.executeQuery();
            st.setString(1, bien.getType());
            st.setInt(2, bien.getNb_piece());
            st.setInt(3, bien.getSurf_habit());
            st.setInt(4, bien.getPrix());
            st.setInt(5, bien.getAnnee_const());
            st.setBoolean(6, bien.isGarage());
            st.setBoolean(7, bien.isTerrase());
            st.setBoolean(8, bien.isBalcon());
            st.setBoolean(9, bien.isJardin());
            st.setInt(10, id);
            int nb = st.executeUpdate();


            var request2 = "UPDATE adresse SET numero = ?, rue = ?, code_postal = ?, ville = ? WHERE id_adresse = ?";
            PreparedStatement st2 = gc.prepareStatement(request2);
            st2.setString(1, adresse.getNumero());
            st2.setString(2, adresse.getRue());
            st2.setString(3, adresse.getCode_postal());
            st2.setString(4, adresse.getVille());
            st2.setInt(5, foreignKey);

            nb = st.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public void delete(Adresse adresse) {
        Scanner sc = new Scanner(System.in);
        int id = 1;
        System.out.println("Entrez l'id à supprimmer : ");
        id = sc.nextInt();
        Connection gc = Connect.getConnection();
        try {
            PreparedStatement st = gc.prepareStatement("DELETE FROM adresse WHERE id_adresse = ?");
            st.setInt(1, id);
            int nb = st.executeUpdate();
            if (nb > 0) {
                System.out.println("Le bien à l'id " + id + " a été supprimé");
            } else {
                System.out.println("Le bien à l'id " + id + " n'a pas été supprimmé");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void recherchType(int TypeRecherche, String table) {
        String champRecherche = "";
        switch (TypeRecherche) {
            case 1:
                champRecherche = "type";
                break;
            case 2:
                champRecherche = "ville";
                break;
            case 3:
                champRecherche = "prix";
                break;

        }
        Scanner sc = new Scanner(System.in);
        Connection gc = Connect.getConnection();
        PreparedStatement st = null;
        try {
            if (champRecherche == "ville") {
                st = gc.prepareStatement("SELECT DISTINCT ville FROM adresse");
            } else if (champRecherche == "type") {
                st = gc.prepareStatement("SELECT DISTINCT type FROM bien");
            } else if (champRecherche == "prix") {

                st = gc.prepareStatement("SELECT DISTINCT prix FROM bien");
            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                String rType = rs.getString(champRecherche);
                System.out.println(rType);
            }
            PreparedStatement st2 = null;
            if (champRecherche == "ville") {
                System.out.println("Quel type voulez vous rechercher?");
                String rtype2 = sc.nextLine();
                st2 = gc.prepareStatement("SELECT * FROM adresse JOIN bien on adresse.id_adresse=bien.id_adresse WHERE ville=?");
                st2.setString(1, rtype2);
            } else if (champRecherche == "type") {
                System.out.println("Quel type voulez vous rechercher?");
                String rtype2 = sc.nextLine();
                st2 = gc.prepareStatement("SELECT * FROM bien JOIN adresse on bien.id_adresse=adresse.id_adresse WHERE type=?");
                st2.setString(1, rtype2);
            }
            else if (champRecherche == "prix") {
                System.out.println("Donner la fourchette de prix:");
                System.out.println("Fourchette basse:");
                int fourchBasse = sc.nextInt();
                System.out.println("Fourchette haute:");
                int fourchHaute = sc.nextInt();
                st2 = gc.prepareStatement("SELECT * FROM bien JOIN adresse on bien.id_adresse=adresse.id_adresse WHERE prix BETWEEN ? AND ?");
                st2.setInt(1, fourchBasse);
                st2.setInt(2, fourchHaute);
            }
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                StringBuilder sb = new StringBuilder();
                sb.append(rs2.getInt("id_bien") + ", ");
                sb.append(rs2.getString("type") + ", ");
                sb.append(rs2.getInt("nb_piece") + ", ");
                sb.append(rs2.getInt("surf_habit") + ", ");
                sb.append(rs2.getInt("prix") + ", ");
                sb.append(rs2.getInt("annee_const") + ", ");
                sb.append(rs2.getBoolean("garage") + ", ");
                sb.append(rs2.getBoolean("terrasse") + ", ");
                sb.append(rs2.getBoolean("balcon") + ", ");
                sb.append(rs2.getBoolean("jardin") + ", ");
                sb.append(rs2.getInt("id_adresse") + ", ");

                sb.append(rs2.getInt("id_adresse") + ", ");
                sb.append(rs2.getString("numero") + ", ");
                sb.append(rs2.getString("rue") + ", ");
                sb.append(rs2.getString("code_postal") + ", ");
                sb.append(rs2.getString("ville") + ", ");
                System.out.println(sb);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}