package fr.webforce.services;


import fr.webforce.configurations.Connect;

import fr.webforce.entities.Adresse;
import fr.webforce.entities.Bien;

import java.sql.*;

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

    public void insert(Bien bien, Adresse adresse) throws SQLException {
        int aze;
        Connection gc = Connect.getConnection();
        String[] id_col = {"id_adresse"};
        try (PreparedStatement st = gc.prepareStatement("INSERT INTO adresse (numero,rue,code_postal,ville) VALUES (?,?,?,?)", id_col)) {
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
                    aze = generatedKeys.getInt(1);
                    System.out.println(aze);
                } else {
                    throw new SQLException("Pas d'insertion, pas d'id_adresse obtenu.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Connection gc3 = Connect.getConnection();
        try (PreparedStatement st2 = gc3.prepareStatement("INSERT INTO bien VALUES(null,?,?,?,?,?,?,?,?,?,?)")) {
            st2.setString(1, bien.getType());
            st2.setInt(2, bien.getNb_piece());
            st2.setInt(3, bien.getSurf_habit());
            st2.setInt(4, bien.getPrix());
            st2.setInt(5, bien.getAnnee_const());
            st2.setBoolean(6, bien.isGarage());
            st2.setBoolean(7, bien.isTerrase());
            st2.setBoolean(8, bien.isBalcon());
            st2.setBoolean(9, bien.isJardin());
            st2.setInt(10, aze);
            int nb2 = st2.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}