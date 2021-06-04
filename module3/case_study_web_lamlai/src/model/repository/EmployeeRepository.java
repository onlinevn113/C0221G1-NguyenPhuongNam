package model.repository;

import model.bean.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    BaseRepository baseRepository = new BaseRepository();
    final String SELECT_ALL_EMPLOYEE = "select * from employee;";

    public List<Employee> findByAll() {
        Connection connection = baseRepository.connectDataBase();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisonId = resultSet.getInt("division_id");
                String userName = resultSet.getString("username");
                employees.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisonId, userName));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }


    public List<Employee> findByName(String name1) {
        List<Employee> employees = new ArrayList<>();
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from employee where employee_name like ?");
            statement.setString(1, "%" + name1 + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisonId = resultSet.getInt("division_id");
                String userName = resultSet.getString("username");
                employees.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisonId, userName));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }



    public Employee findById(int id) {
        Connection connection = baseRepository.connectDataBase();
        Employee employee = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select * from employee  where employee_id= ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                String employeeBirthday = resultSet.getString("employee_birthday");
                String employeeIdCard = resultSet.getString("employee_id_card");
                double employeeSalary = resultSet.getDouble("employee_salary");
                String employeePhone = resultSet.getString("employee_phone");
                String employeeEmail = resultSet.getString("employee_email");
                String employeeAddress = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisonId = resultSet.getInt("division_id");
                String userName = resultSet.getString("username");
                employee = new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisonId, userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


    public boolean create(Employee employee) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("insert into employee( employee_name, position_id, education_degree_id, division_id, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, username )" +
                    "values (?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, employee.getEmployeeName());
            statement.setInt(2, employee.getPositionId());
            statement.setInt(3, employee.getEducationDegreeId());
            statement.setInt(4, employee.getDivisonId());
            statement.setString(5, employee.getEmployeeBirthday());
            statement.setString(6, employee.getEmployeeIdCard());
            statement.setDouble(7, employee.getEmployeeSalary());
            statement.setString(8, employee.getEmployeePhone());
            statement.setString(9, employee.getEmployeeEmail());
            statement.setString(10, employee.getEmployeeAddress());
            statement.setString(11, employee.getUserName());
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public boolean edit(int id, Employee employee) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(" update employee set employee_name=?," +
                    "position_id=?,education_degree_id=?," +
                    "division_id=?,employee_birthday=?," +
                    "employee_id_card=?,employee_salary=?, " +
                    "employee_phone=?,employee_email=?," +
                    "employee_address=?,username=?" +
                    " where employee_id=?");
            statement.setString(1, employee.getEmployeeName());
            statement.setInt(2, employee.getPositionId());
            statement.setInt(3, employee.getEducationDegreeId());
            statement.setInt(4, employee.getDivisonId());
            statement.setString(5, employee.getEmployeeBirthday());
            statement.setString(6, employee.getEmployeeIdCard());
            statement.setDouble(7, employee.getEmployeeSalary());
            statement.setString(8, employee.getEmployeePhone());
            statement.setString(9, employee.getEmployeeEmail());
            statement.setString(10, employee.getEmployeeAddress());
            statement.setString(11, employee.getUserName());
            statement.setInt(12, id);
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check;
    }
    public boolean delete(int id) {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement("delete from employee where employee_id=?");
            statement.setInt(1, id);
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
    public static void main(String[] args) {
        EmployeeRepository employeeRepository=new EmployeeRepository();
        System.out.println(employeeRepository.findByAllDivision().size());
    }
    public List<Division> findByAllDivision() {
        Connection connection = baseRepository.connectDataBase();
        List<Division> divisions = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from division");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                divisions.add(new Division(divisionId, divisionName))
                ;
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisions;
    }
    public List<Position> findByAllPosition() {
        Connection connection = baseRepository.connectDataBase();
        List<Position> positions = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from `position`");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int positionId=resultSet.getInt("position_id");
                String postionName=resultSet.getString("position_name");
                positions.add(new Position(positionId,postionName));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positions;
    }
    public List<User> findByAllUser() {
        Connection connection = baseRepository.connectDataBase();
        List<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from `user`");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String userName=resultSet.getString("username");
                String password=resultSet.getString("password");
                users.add(new User(userName,password));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public List<EducationDegree> findByAllEducationDegree() {
        Connection connection = baseRepository.connectDataBase();
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from education_degree");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int educationDegreeId=resultSet.getInt("education_degree_id");
                String educationDegreeName=resultSet.getString("education_degree_name");
                educationDegrees.add(new EducationDegree(educationDegreeId,educationDegreeName));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegrees;
    }


}
