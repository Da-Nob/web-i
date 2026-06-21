package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.example.dao.DAOFactory;
import com.example.dao.DepartmentDAO;
import com.example.dao.SellerDAO;
import com.example.entities.Department;
import com.example.entities.Seller;

public class Main {
    public static void main(String[] args) {
        // String url = "jdbc:postgresql://localhost:5432/loja_jdbc";
        // String usuario = "postgres";
        // String senha = "1234";

        // try (Connection conn = DriverManager.getConnection(url, usuario, senha)) {
        //     System.out.println("Conectado com sucesso");
        // } catch (SQLException e) {
        //     System.err.println("Erro ao conectar ao banco de dados: ");
        //     e.printStackTrace();
        // } 

        // Department d1 = new Department(1, "Vendas");
        // Seller s1 = new Seller(1, "Joao Silva", "joaosilva@email.com", LocalDate.of(1990, 5, 15), 5000.0, d1);

        // System.out.println("Departamneto: " + d1.getName());
        // System.out.printf("Vendedor: %s%n Email: %s%n Data_Nacs: %s%n Salario: %.2f%n Departamento: %s \n", s1.getName(), s1.getEmail(), s1.getBirthDate(), s1.getBaseSalary(), s1.getDepartment().getName());


        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
        SellerDAO sellerDAO = DAOFactory.createSellerDAO();

        // Teste de inserção de departamento
        // Passamos null para o ID, pois ele será gerado automaticamente pelo banco de
        // dados
        Department newDepartment = new Department(null, "Recursos Humanos");
        departmentDAO.insert(newDepartment);

        // Teste de consulta de departamentos
        List<Department> departments = departmentDAO.findAll();

        System.out.println("Departamentos encontrados:");
        for (Department dept : departments) {
            System.out.println(dept.getId() + ": " + dept.getName());
        }

        // Teste de inserção de vendedor
        Seller newSeller = new Seller(null, "Joaquim Filomeno", "joaquim.filomeno@example.com",
                LocalDate.parse("1998-09-04"), 5000.0, departments.getLast()); 
        sellerDAO.insert(newSeller);

        
        List<Seller> sellers = sellerDAO.findAll();

        System.out.println("Vendedores encontrados:");
        for (Seller seller : sellers) {
            System.out.println(seller.getId() + ": " + seller.getName());
        }
    }
}