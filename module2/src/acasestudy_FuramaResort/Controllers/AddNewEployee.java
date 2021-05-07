package acasestudy_FuramaResort.Controllers;

import acasestudy_FuramaResort.Commons.FileUtils;
import acasestudy_FuramaResort.Commons.Validators;
import acasestudy_FuramaResort.exceptions.NameException;

import java.util.List;

public class AddNewEployee {
   void addNewEmployee(String filename){
       FileUtils.setFullPathFile(filename);
       List<String> employeeList= FileUtils.readFileEmployee();
       String id="";
       if (employeeList.isEmpty()){
           id+=1;
       }else {
           id+=(employeeList.size()+1);
       }
       String employeeName = Validators.checkExceptionInput("Enter employee name", Validators.REGEX_VIETNAMESE_NAME, new NameException());
       String employeAge = Validators.checkExceptionInput("Enter employe age",Validators.AGE_REGEX,new NameException());
       String emloployeAddress=Validators.checkExceptionInput("Enter emloploye address",Validators.SERVICE_NAME_REGEX,new NameException());

       FileUtils.setFullPathFile(filename);
       FileUtils.writerFile(new String[]{id, employeeName, employeAge, emloployeAddress});

   }
}
