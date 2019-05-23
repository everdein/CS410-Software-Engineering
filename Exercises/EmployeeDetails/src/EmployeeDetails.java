/*EmployeeDetails class is used to −

        get/set the value of employee's name.
        get/set the value of employee's monthly salary.
        get/set the value of employee's age.

}*/

public class EmployeeDetails {
    private String name;
    private double monthlySalary;


    private String firstName;
    private String designation;
    private int age;



    /**
     * @return the firstName
     */

    public String getFirstName() {
        return firstName;
    }


    /**
     * @param firstName the firstName to set
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    /**
     * @return the designation
     */

    public String getDesignation() {
        return designation;
    }


    /**
     * @param designation the designation to set
     */

    public void setDesignation(String designation) {
        this.designation = designation;
    }


    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the name
     */

    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */

    public void setNickName(String name) {
        this.name = name;
    }


    /**
     * @return the monthlySalary
     */

    public double getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * @param monthlySalary the monthlySalary to set
     */

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }


}

