package com.example.dao;

import com.example.db.ConnectionFactory;

public class DAOFactory {
    public static DepartmentDAO createDepartmentDAO() {
        return new DepartmentDAOImpl(ConnectionFactory.getConnection());
    }

    public static SellerDAO createSellerDAO() {
        return new SellerDAOImpl(ConnectionFactory.getConnection());
    }
}
