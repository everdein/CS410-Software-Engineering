/*TestEmployeeDetails class is used for testing the methods of EmpBusinessLogic class. It
tests the yearly salary of the employee.
tests the appraisal amount of the employee.*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.jupiter.api.Assertions.*;


public class TestEmployeeDetails {
    EmployeeDetails employee;
    EmpBusinessLogic empBusinessLogic;

    @BeforeEach
    public void setUp()
    {

      employee = new EmployeeDetails();
      empBusinessLogic = new EmpBusinessLogic();
      employee.setFirstName("John");
      employee.setDesignation("Manager");
      employee.setAge(30);
    }
    @Test
    public void firstNameCannotBeNull()
    {
        assertThat(employee.getFirstName(), notNullValue());
    }
    @Test
    public void firstNameEqualsToJohn()
    {
        assertThat(employee.getFirstName(), is("John"));
//        assertThat(employee.getFirstName(),is(123));
    }
    @Test
    public void designationShouldBeManagerOrContractor()
    {
        assertThat(employee.getDesignation(), anyOf(is("Manager"),is("Contractor")));
    }
    @Test
    public void employeeShouldBeOlderThan20()
    {
        assertThat(employee.getAge(),greaterThan(20));
    }
    @Test
    public void employeeHasAgeProperty()
    {
        assertThat(employee, hasProperty("age"));
    }


    //test to check appraisal
    @Test
    public void testCalculateAppriasal()
    {
        employee.setNickName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);

        double appraisal = empBusinessLogic.calculateAppraisal(employee);
        assertEquals(500, appraisal);
    }

    // test to check yearly salary
    @Test
    public void testCalculateYearlySalary()
    {
        employee.setNickName("Rajeev");
        employee.setAge(25);
        employee.setMonthlySalary(8000);

        double salary = empBusinessLogic.calculateYearlySalary(employee);
        assertEquals(96000, salary);
    }


}
