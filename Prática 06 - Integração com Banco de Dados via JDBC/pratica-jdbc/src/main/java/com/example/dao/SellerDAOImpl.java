package com.example.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.example.entities.Seller;
import com.example.entities.Department;

public class SellerDAOImpl implements SellerDAO {
    private Connection conn;

    public SellerDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Seller> findAll() {
        List<Seller> sellers = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(
                        "SELECT seller.*, department.name AS department_name FROM seller INNER JOIN department ON seller.department_id = department.id")) {

            while (rs.next()) {

                Seller seller = new Seller();
                seller.setId(rs.getInt("id"));
                seller.setName(rs.getString("name"));
                seller.setEmail(rs.getString("email"));
                seller.setBirthDate(rs.getDate("birth_date").toLocalDate());
                seller.setBaseSalary(rs.getDouble("base_salary"));

                Department department = new Department();
                department.setId(rs.getInt("department_id"));
                department.setName(rs.getString("department_name"));

                seller.setDepartment(department);

                sellers.add(seller);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar vendedores:");
            e.printStackTrace();
        }

        return sellers;
    }

    @Override
    public Seller findById(Integer id) {

        String sql = "SELECT * FROM seller WHERE id = ?";

       try (PreparedStatement st = conn.prepareStatement(sql);
       ResultSet rs = st.executeQuery()) {

        st.setInt(1, id);
        if (rs.next()) {
                Seller seller = new Seller();
                seller.setId(rs.getInt("id"));
                seller.setName(rs.getString("name"));

        return seller; 
        }
       } catch (SQLException e) {
            System.err.println("Erro ver seller:");
            e.printStackTrace();
       }

        return null;
    }

    @Override
    public void insert(Seller seller) {

        try (PreparedStatement pstmt = conn.prepareStatement(
                "INSERT INTO seller (name, email, birth_date, base_salary, department_id) VALUES (?, ?, ?, ?, ?)")) {
            pstmt.setString(1, seller.getName());
            pstmt.setString(2, seller.getEmail());
            pstmt.setDate(3, Date.valueOf(seller.getBirthDate())); 
            pstmt.setDouble(4, seller.getBaseSalary());
            pstmt.setInt(5, seller.getDepartment().getId());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Vendedor inserido com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir vendedor:");
            e.printStackTrace();
        }

    }

    @Override
    public void update(Seller seller) {
        String sql = "UPDATE seller SET name = ? WHERE id = ? ";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
        
            pst.setString(1, seller.getName());
            pst.setInt(2, seller.getId());

            int affectedRows = pst.executeUpdate();
            
            if (affectedRows > 0) System.out.println("deu certo atualzar");

        } catch (SQLException e) {
            System.err.println("ERRO AO ATUALIZAR");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {

        String sql = "DELETE FROM seller WHERE id = ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)){
            
            pst.setInt(1, id);

            int affectedRows = pst.executeUpdate();
            
            if (affectedRows > 0) System.out.println("deletou corretamente");

        } catch (Exception e) {
            System.err.println("falhou ao deletar");
            e.printStackTrace();
        }
    }
}
