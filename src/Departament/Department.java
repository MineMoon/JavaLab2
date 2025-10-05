package Departament;

import java.util.ArrayList;

public class Department {
    private String name;
    private Employee boss;
    private ArrayList<Employee> employees;

    // properties
    public String getName() {
        if(name == null){
            return "unknown";
        }
        return new String(name);
    }

    public void setName(String name) {
        if (name == null || name.length() == 0) {
            this.name = "unknown";
        } else {
            this.name = name;
        }
    }

    public Employee getBoss() {
        if(boss == null){
            return null;
        } else {
            return new Employee(boss);
        }
    }

    Employee getRefBoss() {
        return this.boss;
    }

    public void setBoss(Employee boss) {
        this.boss = boss;
        if (boss != null && !this.includesEmployee(boss)) {
            this.addEmployee(boss);
        }
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> copy = new ArrayList<>();
        for (Employee emp : employees) {
            copy.add(new Employee(emp));
        }
        return copy;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    // constructors
    public Department(){
        this.name = "unknown";
        this.boss = null;
        this.employees = new ArrayList<>();
    }

    public Department(String name){
        this.setName(name);
        this.boss = null;
        this.employees = new ArrayList<>();
    }

    public Department(String name, Employee boss){
        this.setName(name);
        this.setBoss(boss);
        this.employees = new ArrayList<>();
    }

    public Department(String name, Employee boss, ArrayList<Employee> employees){
        this.setName(name);
        this.employees = new ArrayList<>();
        if (employees != null) {
            for (Employee emp : employees) {
                this.addEmployee(emp);
            }
        }
        this.setBoss(boss);
    }

    // copy
    public Department(Department department){
        this();
        this.setName(department.getName());

        if(department.getBoss() != null){
            Employee bossCopy = new Employee(department.boss.getName());
            bossCopy.setDepartment(this);
            this.setBoss(bossCopy);
        }

        for (Employee emp : department.employees) {
            if (department.boss == null || emp!=department.boss) {
                Employee empCopy = new Employee(emp.getName(),this);
                this.addEmployee(empCopy);
            }
        }
    }

    // methods
    public void addEmployee(Employee employee){
        if(employee != null && !this.employees.contains(employee)){
            if(employee.getRefDepartment() != null && employee.getRefDepartment() != this){
                employee.getRefDepartment().removeEmployee(employee);
            }
            this.employees.add(employee);
            employee.setDepartment(this);
        }
    }

    public void removeEmployee(Employee employee){
        if(employee!=null && this.employees.contains(employee)){
            this.employees.remove(employee);
            if (employee == this.boss){
                this.boss = null;
            }
            employee.setDepartment(null);
        }
    }

    public boolean includesEmployee(Employee employee){
        return this.employees.contains(employee);
    }

    @Override
    public String toString() {
        // Название отдела
        String depName = "unknown";
        if (name != null && !name.isEmpty()) {
            depName = name;
        }
        String result = "Отдел\n==" + depName + "==\n";

        if (boss != null) {
            String bossName = "unknown";
            if (boss.getName() != null && !boss.getName().isEmpty()) {
                bossName = boss.getName();
            }
            result += "Начальник: " + bossName + "\n";
        } else {
            result += "Начальник пока не назначен\n";
        }

        // Список сотрудников (кроме босса)
        result += "Сотрудники:\n";
        if (employees.isEmpty()) {
            result += "Сотрудников пока нет\n";
        } else {
            int number = 1;

            for (Employee employee : employees) {
                if (employee != this.boss) {
                    String empName = "unknown";
                    if (employee.getName() != null && !employee.getName().isEmpty()) {
                        empName = employee.getName();
                    }
                    result += String.format("%d: %s\n", number, empName);
                    number++;
                }
            }

            if (employees.size() == 1 && this.boss != null) {
                result += "Только начальник\n";
            }
        }

        return result;
    }


}
