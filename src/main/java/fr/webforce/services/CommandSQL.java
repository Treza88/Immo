package fr.webforce.services;


import fr.webforce.configurations.Connect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandSQL {

public void findAll(){

    Connection gc = Connect.getConnection();
    try (Statement st = gc.createStatement()){
        ResultSet rs = st.executeQuery("SELECT * FORM bien FULL JOIN adresse on bien.id_adresse=adresse.id_adresse");
        while (rs.next()){
            StringBuilder sb = new StringBuilder();
            sb.append(rs.getInt("id_bien")+", ");
            sb.append(rs.getInt("type")+", ");
            sb.append(rs.getInt("nb_piece")+", ");
            sb.append(rs.getInt("surf_habit")+", ");
            sb.append(rs.getInt("prix")+", ");
            sb.append(rs.getInt("annee_const")+", ");
            sb.append(rs.getInt("garage")+", ");
            sb.append(rs.getInt("terrasse")+", ");
            sb.append(rs.getInt("balcon")+", ");
            sb.append(rs.getInt("jardin")+", ");
            sb.append(rs.getInt("id_adresse")+", ");
            sb.append(rs.getInt("id_adresse")+", ");
            sb.append(rs.getInt("id_numero")+", ");
            sb.append(rs.getInt("id_rue")+", ");
            sb.append(rs.getInt("id_code_postal")+", ");
            sb.append(rs.getInt("ville")+", ");
            System.out.println(sb);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }


}





}