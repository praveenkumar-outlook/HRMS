package com.i2i.service;

import java.util.List;

import org.hibernate.exception.DataException;

import com.i2i.dao.DepartmentDao;
import com.i2i.model.Department;

/**
 * <p>
 * Service class which does validations with the user input of employee details.
 * Passes values to the Dao class to carry out manipulations.
 * Throws error messages in case of occurrence of any exceptions.
 * </p>
 *
 * @author Praveenkumar
 *
 * @created 2016-08-15
 */
public class DepartmentService {
    DepartmentDao departmentDao = new DepartmentDao();
    
    /**
     * <p>
     * This method checks the presence of department ID in the database.
     * Passes the value to its dao class to insert if not present. 
     * </p>
     * 
     * @param department
     *       model object that stores the department data associated with model.
     * @return boolean
     *       gives the status of the insertion into the database.
     * @throws com.i2i.exception.DataException
     *       throws error message if problem arises with inserting the data in the database.
     */
    public boolean addEmployee(Department department) throws DataException, com.i2i.exception.DataException {
        if (departmentDao.findDepartment(department.getDepartmentId()) == null) {
            return departmentDao.insertDepartment(department);
        }
        return false;
    }
    
    /**
     * <p>
     * This method checks the presence of department ID in the database.
     * Passes the value to its dao class to delete if present.
     * </p>
     * 
     * @param departmentId
     *       contains the ID of the department.
     * @return boolean
     *       gives the status of the deletion from the database.
     * @throws com.i2i.exception.DataException
     *       throws error message if problem arises with deleting the data in the database.
     */
    public boolean deleteDepartment(int departmentId) throws DataException, com.i2i.exception.DataException {
        if (departmentDao.findDepartment(departmentId) != null) {
            return departmentDao.removeDepartment(departmentId);
        }
        return false;
    }
    
    /**
     * <p>
     * This method passes the department ID to its dao class to search in the database.
     * Returns the model object of the department to its controller to display.
     * </p>
     *
     * @param departmentId
     *       contains the ID of the department.
     * @throws com.i2i.exception.DataException
     *       throws error message if problem arises with searching the data in the database.
     */
    public Department searchDepartment(int departmentId) throws DataException, DataException, com.i2i.exception.DataException {
        return departmentDao.findDepartment(departmentId);
    }
    
    /**
     * <p>
     * This method retrieves the Department data from the records and returns the list of data to display.
     * </p>
     * @throws com.i2i.exception.DataException
     *       throws error message if problem arises with retrieving list of data from the database.
     */
    public List<Department> displayDepartments() throws DataException, com.i2i.exception.DataException {
        return departmentDao.retrieveDepartments();
    }
}