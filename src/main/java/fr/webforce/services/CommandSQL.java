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
                sb.append(rs.getInt("type") + ", ");
                sb.append(rs.getInt("nb_piece") + ", ");
                sb.append(rs.getInt("surf_habit") + ", ");
                sb.append(rs.getInt("prix") + ", ");
                sb.append(rs.getInt("annee_const") + ", ");
                sb.append(rs.getInt("garage") + ", ");
                sb.append(rs.getInt("terrasse") + ", ");
                sb.append(rs.getInt("balcon") + ", ");
                sb.append(rs.getInt("jardin") + ", ");
                sb.append(rs.getInt("id_adresse") + ", ");

                sb.append(rs.getInt("id_adresse") + ", ");
                sb.append(rs.getInt("id_numero") + ", ");
                sb.append(rs.getInt("id_rue") + ", ");
                sb.append(rs.getInt("id_code_postal") + ", ");
                sb.append(rs.getInt("ville") + ", ");
                System.out.println(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void insert(Bien bien, Adresse adresse) throws SQLException {

        Connection gc = Connect.getConnection();

        try (PreparedStatement st = gc.prepareStatement("INSERT INTO adresse VALUES(null,?,?,?,?")){
            st.setString(1,adresse.getNumero());
            st.setString(2,adresse.getRue());
            st.setString(3,adresse.getCode_postal());
            st.setString(4, adresse.getVille());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        try (Statement st = gc.createStatement()) {
//            ResultSet rs = st.executeQuery("SELECT id_adresse FROM adresse WHERE id_adresse=(SELECT MAX(id_adresse) FROM adresse)");
//
//               //System.out.println(sb);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }




        try (PreparedStatement st = gc.prepareStatement("INSERT INTO bien VALUES(null,?,?,?,?,?,?,?,?,?,null")){
            st.setString(1,bien.getType());
            st.setInt(2,bien.getNb_piece());
            st.setInt(3,bien.getSurf_habit());
            st.setInt(4,bien.getPrix());
            st.setInt(5,bien.getAnnee_const());
            st.setBoolean(6,bien.isGarage());
            st.setBoolean(7,bien.isTerrase());
            st.setBoolean(8,bien.isBalcon());
            st.setBoolean(9,bien.isJardin());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}



}