package org.staffManagement.repository.repoImpl;

import org.staffManagement.dbConfig.DbConfiguration;
import org.staffManagement.model.Salary;
import org.staffManagement.repository.SalaryRepo;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class SalaryRepoImpl extends DbConfiguration implements SalaryRepo {
    @Override
    public boolean addSalary(Salary s) {
        try{
            preparedStatement = connection.prepareStatement("insert into salary(s_id,basic_salary,hra,da,pf,month_year,net_salary) values(?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,s.getStaff_id());
            preparedStatement.setInt(2,s.getBasic_salary());
            preparedStatement.setInt(3,s.getHra());
            preparedStatement.setInt(4,s.getDa());
            preparedStatement.setInt(5,s.getPf());
            preparedStatement.setString(6, s.getMonth_year().toString());
            preparedStatement.setInt(7, s.getNet_salary());
            return preparedStatement.executeUpdate()>0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateSalary(Salary s) {
        try{
            preparedStatement = connection.prepareStatement("update salary set s_id=?, basic_salary=?, hra=?, da=?, pf=?, month_year=?, net_salary=? where salary_id="+s.getSalary_id());
            preparedStatement.setInt(1,s.getStaff_id());
            preparedStatement.setInt(2,s.getBasic_salary());
            preparedStatement.setInt(3,s.getHra());
            preparedStatement.setInt(4,s.getDa());
            preparedStatement.setInt(5,s.getPf());
            preparedStatement.setString(6, s.getMonth_year().toString());
            preparedStatement.setInt(7, s.getNet_salary());
            return preparedStatement.executeUpdate()>0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteSalary(int sid) {

        try{
            preparedStatement = connection.prepareStatement("delete from salary where salary_id = "+sid);
            return preparedStatement.executeUpdate()>0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Salary> viewSalary() {
        List<Salary> salList = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement("select * from salary");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Salary sal = new Salary();
                sal.setSalary_id(resultSet.getInt(1));
                sal.setStaff_id(resultSet.getInt(2));
                sal.setBasic_salary(resultSet.getInt(3));
                sal.setHra(resultSet.getInt(4));
                sal.setDa(resultSet.getInt(5));
                sal.setPf(resultSet.getInt(6));
                sal.setMonth_year(YearMonth.parse(resultSet.getString(7)));
                sal.setNet_salary(resultSet.getInt(8));
                salList.add(sal);
            }
            return salList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int findHolidayReduction(int id) {
        try{
            preparedStatement = connection.prepareStatement("select count(*) from attendance group by status, s_id having status = 'absent' AND s_id ="+id);
            resultSet = preparedStatement.executeQuery();
            int countOfHoliday = 0;
            while(resultSet.next()) {
                countOfHoliday = resultSet.getInt(1);
            }
            return countOfHoliday;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Salary getSalaryById(int salId) {
        try{
            Salary s = new Salary();
            preparedStatement = connection.prepareStatement("select * from salary where salary_id = "+salId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                s.setSalary_id(resultSet.getInt(1));
                s.setStaff_id(resultSet.getInt(2));
                s.setBasic_salary(resultSet.getInt(3));
                s.setHra(resultSet.getInt(4));
                s.setDa(resultSet.getInt(5));
                s.setPf(resultSet.getInt(6));
                s.setMonth_year(YearMonth.parse(resultSet.getString(7)));
                s.setNet_salary(resultSet.getInt(8));
            }
            return s;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
