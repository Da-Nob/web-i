package com.example.dao;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.example.entities.Department;

public class DepartmentDAOImpl implements DepartmentDAO{
    private Connection conn;

    public DepartmentDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();

        try (Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM department")) {
            while (rs.next()) {
                Department department = new Department();
                department.setId(rs.getInt("id"));
                department.setName(rs.getString("name"));

                departments.add(department);
            }

        } catch (SQLException e) {
            System.err.println("erro ao listar departamentos: ");
            e.printStackTrace();
        };

        return departments;
    }

    @Override
    public Department findById(Integer id) {
        try (Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM Department WHERE id = ?")) {
            
            if (rs.next()) {
                Department department = new Department();
                department.setName(rs.getString("name"));
                department.setId(rs.getInt("id"));

                return department;
            }

        } catch (SQLException e) {
            System.err.println("erro ao procurar departamentos: ");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Department department) {

      String sql = "UPDATE department SET name = ? WHERE id = ?";

      try (PreparedStatement st = conn.prepareStatement(sql)){

        st.setString(1, department.getName());
        st.setInt(2, department.getId());

        st.executeUpdate();
        
      } catch (SQLException e) {
        System.err.println("Erro ao atualizar o departamento");
        e.printStackTrace();
      }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM department WHERE id = ?";

      try (PreparedStatement pst = conn.prepareStatement(sql)){

        pst.setInt(1, id);

        int affectedRows = pst.executeUpdate();
        if (affectedRows > 0) System.out.println("Deleção feita");
        
      } catch (SQLException e) {
        System.err.println("Erro ao deletar o departamento");
        e.printStackTrace();
      }
    }

    @Override
    public void insert(Department department) {
        
        String sql = "INSERT INTO department ?";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, department.getName());

            int affectedRows = pst.executeUpdate();
            if (affectedRows > 0) System.out.println("Inserção feita");
        } catch (SQLException e) {
            System.err.println("erro ao inserrrir");
            e.printStackTrace();
        }
    }
}
