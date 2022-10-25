package fr.webforce.services;


import fr.webforce.configurations.Connect;

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
    public void insert(Bien bien, int nb_piece, int surf_habit, int prix, int annee_const, boolean garage, boolean terrasse,
                       boolean balcon, boolean jardin, String numero, String rue,String code_postal,String ville) throws SQLException {

        Connection gc = Connect.getConnection();

        try (PreparedStatement pst = gc.prepareStatement("INSERT INTO adresse VALUES(null,?,?,?,?")){
            pst.setString(1,numero);
            pst.setString(2,rue);
            pst.setString(3,code_postal);
            pst.setString(4,ville);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Statement st = gc.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT id_adresse FROM adresse WHERE id_adresse=(SELECT MAX(id_adresse) FROM adresse)");

                System.out.println(sb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




        try (PreparedStatement st = gc.prepareStatement("INSERT INTO bien VALUES(null,?,?,?,?,?,?,?,?,?,null")){
            st.setString(1,bien.);
            st.setInt(2,nb_piece);
            st.setInt(3,surf_habit);
            st.setInt(4,prix);
            st.setInt(5,annee_const);
            st.setBoolean(6,garage);
            st.setBoolean(7,terrasse);
            st.setBoolean(8,balcon);
            st.setBoolean(9,jardin);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}



}