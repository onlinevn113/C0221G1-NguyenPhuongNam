package model.repository;

import model.bean.AttachService;
import model.bean.Contract;
import model.bean.ContractDetail;
import model.bean.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository {
    BaseRepository baseRepository=new BaseRepository();
    String insertContract="insert into contract (employee_id,customer_id,service_id,contract_start_date,contract_end_date,contract_deposit,contract_total)\n" +
            "values  \n" +
            "(?,?,?,?,?,?,?);";
    String insertContractDetail="insert into contract_detail(contract_id,attach_service_id,quantity)\n" +
            " values (?,?,?);";
    public boolean createContract(Contract contract) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(insertContract);
            statement.setInt(1,contract.getEmployeeId());
            statement.setInt(2,contract.getCustomerId());
            statement.setInt(3,contract.getServiceId());
            statement.setString(4,contract.getContractStartDate());
            statement.setString(5,contract.getContractEndDate());
            statement.setInt(6,contract.getContractDeposit());
            statement.setInt(6,contract.getContractTotal());
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }


    public boolean createContractDetail(ContractDetail contractDetail) throws SQLException {
        boolean check = false;
        Connection connection = baseRepository.connectDataBase();
        try {
            PreparedStatement statement = connection.prepareStatement(insertContractDetail);
            statement.setInt(1,contractDetail.getContractId());
            statement.setInt(2,contractDetail.getAttachServiceId());
            statement.setInt(3,contractDetail.getQuantity());
            check = statement.executeUpdate() > 0;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }

    public List<Contract> findByAllContract() {
        Connection connection = baseRepository.connectDataBase();
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from contract");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int contractId=resultSet.getInt("contract_id");
                int employeeId=resultSet.getInt("employee_id");
                int customerId=resultSet.getInt("customer_id");
                int serviceId=resultSet.getInt("service_id");
                String contractStartDate=resultSet.getString("contract_start_date");
                String contractEndDate=resultSet.getString("contract_end_date");
                int contractDeposit=resultSet.getInt("contract_deposit");
                int contractTotal=resultSet.getInt("contract_total");
                contracts.add(new Contract(contractId,employeeId,customerId,serviceId,contractStartDate,contractEndDate,contractDeposit,contractTotal));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contracts;
    }


    public List<AttachService> findByAllAttachService() {
        Connection connection = baseRepository.connectDataBase();
        List<AttachService> attachServices = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from attach_service");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int attachServiceId=resultSet.getInt("attach_service_id");
                String attachServiceName=resultSet.getString("attach_service_name");
                double attachServiceCost=resultSet.getDouble("attach_service_cost");
                int attachServiceUnit=resultSet.getInt("attach_service_until");
                String attachServiceStatus=resultSet.getString("attach_service_status");
                attachServices.add(new AttachService(attachServiceId,attachServiceName,attachServiceCost,attachServiceUnit,attachServiceStatus));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return attachServices;
    }

}
