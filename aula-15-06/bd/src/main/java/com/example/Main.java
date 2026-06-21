package com.example;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws Exception{
        String url = "jdbc:postgresql://localhost:5432/aulasjdbc";
        String user = "postgres";
        String password = "1234";

        
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stm = conn.createStatement();


            ResultSet rs = stm.executeQuery("SELECT * FROM department");
            
            

            while ( rs.next()) {
                String nome = rs.getString("name");
                System.out.println("Departamento: " + nome);
                
            }
            System.out.println();

            String sql = "INSERT INTO aluno (id, nomeAluno, email) VALUES (?, ?, ?)";

            PreparedStatement pst1 = conn.prepareStatement(sql);
            pst1.setInt(1, 6);
            pst1.setString(2, "Lucas");
            pst1.setString(3, "Lucas@gmail.com");
            int rowsAffected = pst1.executeUpdate();
            System.out.println("Linhas inseridas: " + rowsAffected);

            ResultSet rAluno = stm.executeQuery("SELECT * FROM aluno");

            while ( rAluno.next()) {
                String nome = rAluno.getString("nomeAluno");
                System.out.println("aluno: " + nome);

                String email = rAluno.getString("email");
                System.out.println("email: " + email);


                System.out.println();
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}