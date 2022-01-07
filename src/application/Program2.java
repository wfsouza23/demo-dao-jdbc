package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("== TEST 1: Deparment findById ====");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        System.out.println("== TEST 2: Department findAll ====");
        List<Department> list = departmentDao.findAll();

        for(Department obj : list){
            System.out.println(obj);
        }

        System.out.println("== TEST 3: Department insert ====");
        Department newDepartment = new Department(null, "Tecnology");
        departmentDao.insert(newDepartment);
        System.out.println("Insert! New id = " + newDepartment);

        System.out.println("== TEST 4: Deparment update ====");
        department = departmentDao.findById(1);
        department.setName("Business");
        departmentDao.update(department);
        System.out.println("Update Completed!");

        System.out.println("== TEST 6: Department delete ====");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete Completed!");

        sc.close();

    }

}
