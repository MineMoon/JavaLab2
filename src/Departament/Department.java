//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

package Departament;

import java.util.ArrayList;

//FIXME: Префикс C для класса (4-6 стр.), PascalCase (3 стр.), излишнее документирование (12 стр.)
//       вывод и комментарии должны быть на английском (3 стр.), префикс _ для параметров (6 стр.)
//       форматирование фигурных скобок(8 стр.), магические числа в константы(14 стр.), самодокументируемый код (1 стр.),
//       магические числа в константы(14 стр.), именование методов (так как возвращает boolean, нужен префикс b, стр. 6).
// public class Department {
//     private String name;
//     private Employee boss;
//     private ArrayList<Employee> employees;

//     // properties
//     public String getName() {
//         if(name == null){
//             return "unknown";
//         }
//         return new String(name);
//     }

//     public void setName(String name) {
//         if (name == null || name.length() == 0) {
//             this.name = "unknown";
//         } else {
//             this.name = name;
//         }
//     }

//     public Employee getBoss() {
//         if(boss == null){
//             return null;
//         } else {
//             return new Employee(boss);
//         }
//     }

//     Employee getRefBoss() {
//         return this.boss;
//     }

//     public void setBoss(Employee boss) {
//         this.boss = boss;
//         if (boss != null && !this.includesEmployee(boss)) {
//             this.addEmployee(boss);
//         }
//     }

//     public ArrayList<Employee> getEmployees() {
//         ArrayList<Employee> copy = new ArrayList<>();
//         for (Employee emp : employees) {
//             copy.add(new Employee(emp));
//         }
//         return copy;
//     }

//     public void setEmployees(ArrayList<Employee> employees) {
//         this.employees = employees;
//     }

//     // constructors
//     public Department(){
//         this.name = "unknown";
//         this.boss = null;
//         this.employees = new ArrayList<>();
//     }

//     public Department(String name){
//         this.setName(name);
//         this.boss = null;
//         this.employees = new ArrayList<>();
//     }

//     public Department(String name, Employee boss){
//         this.setName(name);
//         this.setBoss(boss);
//         this.employees = new ArrayList<>();
//     }

//     public Department(String name, Employee boss, ArrayList<Employee> employees){
//         this.setName(name);
//         this.employees = new ArrayList<>();
//         if (employees != null) {
//             for (Employee emp : employees) {
//                 this.addEmployee(emp);
//             }
//         }
//         this.setBoss(boss);
//     }

//     // copy
//     public Department(Department department){
//         this();
//         this.setName(department.getName());

//         if(department.getBoss() != null){
//             Employee bossCopy = new Employee(department.boss.getName());
//             bossCopy.setDepartment(this);
//             this.setBoss(bossCopy);
//         }

//         for (Employee emp : department.employees) {
//             if (department.boss == null || emp!=department.boss) {
//                 Employee empCopy = new Employee(emp.getName(),this);
//                 this.addEmployee(empCopy);
//             }
//         }
//     }

//     // methods
//     public void addEmployee(Employee employee){
//         if(employee != null && !this.employees.contains(employee)){
//             if(employee.getRefDepartment() != null && employee.getRefDepartment() != this){
//                 employee.getRefDepartment().removeEmployee(employee);
//             }
//             this.employees.add(employee);
//             employee.setDepartment(this);
//         }
//     }

//     public void removeEmployee(Employee employee){
//         if(employee!=null && this.employees.contains(employee)){
//             this.employees.remove(employee);
//             if (employee == this.boss){
//                 this.boss = null;
//             }
//             employee.setDepartment(null);
//         }
//     }

//     public boolean includesEmployee(Employee employee){
//         return this.employees.contains(employee);
//     }

//     @Override
//     public String toString() {
//         // Название отдела
//         String depName = "unknown";
//         if (name != null && !name.isEmpty()) {
//             depName = name;
//         }
//         String result = "Отдел\n==" + depName + "==\n";

//         if (boss != null) {
//             String bossName = "unknown";
//             if (boss.getName() != null && !boss.getName().isEmpty()) {
//                 bossName = boss.getName();
//             }
//             result += "Начальник: " + bossName + "\n";
//         } else {
//             result += "Начальник пока не назначен\n";
//         }

//         // Список сотрудников (кроме босса)
//         result += "Сотрудники:\n";
//         if (employees.isEmpty()) {
//             result += "Сотрудников пока нет\n";
//         } else {
//             int number = 1;

//             for (Employee employee : employees) {
//                 if (employee != this.boss) {
//                     String empName = "unknown";
//                     if (employee.getName() != null && !employee.getName().isEmpty()) {
//                         empName = employee.getName();
//                     }
//                     result += String.format("%d: %s\n", number, empName);
//                     number++;
//                 }
//             }

//             if (employees.size() == 1 && this.boss != null) {
//                 result += "Только начальник\n";
//             }
//         }

//         return result;
//     }
// }
//
// FIXTO:
public class CDepartment {
    // Constants for default values
    private final String KDefaultName = "Unknown";
    private final int KStartingNumber = 1;

    private String Name; // Name of the department
    private CEmployee Boss; // The manager (boss) of the department
    private ArrayList<CEmployee> Employees; // List of all employees in the department

    /**
     * Default constructor.
     */
    public CDepartment() {
        this.Name = KDefaultName;
        this.Boss = null;
        this.Employees = new ArrayList<>();
    }

    /**
     * Constructor with department name.
     */
    public CDepartment(String _Name) {
        this.SetName(_Name);
        this.Boss = null;
        this.Employees = new ArrayList<>();
    }

    /**
     * Constructor with name and boss.
     */
    public CDepartment(String _Name, CEmployee _Boss) {
        this.SetName(_Name);
        this.SetBoss(_Boss);
        this.Employees = new ArrayList<>();
    }

    /**
     * Copy constructor.
     */
    public CDepartment(CDepartment _Department) {
        this();
        if (_Department != null) {
            this.SetName(_Department.GetName());

            if (_Department.GetBoss() != null) {
                CEmployee BossCopy = new CEmployee(_Department.Boss.GetName());
                BossCopy.SetDepartment(this);
                this.SetBoss(BossCopy);
            }

            for (CEmployee Emp : _Department.Employees) {
                if (_Department.Boss == null || Emp != _Department.Boss) {
                    CEmployee EmpCopy = new CEmployee(Emp.GetName(), this);
                    this.AddEmployee(EmpCopy);
                }
            }
        }
    }

    /**
     * Returns a copy of the department name.
     */
    public String GetName() {
        return (Name == null) ? KDefaultName : new String(Name);
    }

    /**
     * Sets the department name with validation.
     */
    public void SetName(String _Name) {
        if (_Name == null || _Name.isEmpty()) {
            this.Name = KDefaultName;
        } else {
            this.Name = _Name;
        }
    }

    /**
     * Returns a copy of the boss.
     */
    public CEmployee GetBoss() {
        return (Boss == null) ? null : new CEmployee(Boss);
    }

    /**
     * Returns a direct reference to the boss (internal use).
     */
    public CEmployee GetRefBoss() {
        return this.Boss;
    }

    /**
     * Sets the department boss and ensures they are in the employee list.
     */
    public void SetBoss(CEmployee _Boss) {
        this.Boss = _Boss;
        if (_Boss != null && !this.bIncludesEmployee(_Boss)) {
            this.AddEmployee(_Boss);
        }
    }

    /**
     * Adds an employee to the department and handles previous department removal.
     */
    public void AddEmployee(CEmployee _Employee) {
        if (_Employee != null && !this.Employees.contains(_Employee)) {
            if (_Employee.GetRefDepartment() != null && _Employee.GetRefDepartment() != this) {
                _Employee.GetRefDepartment().RemoveEmployee(_Employee);
            }
            this.Employees.add(_Employee);
            _Employee.SetDepartment(this);
        }
    }

    /**
     * Removes an employee and clears their boss status if applicable.
     */
    public void RemoveEmployee(CEmployee _Employee) {
        if (_Employee != null && this.Employees.contains(_Employee)) {
            this.Employees.remove(_Employee);
            if (_Employee == this.Boss) {
                this.Boss = null;
            }
            _Employee.SetDepartment(null);
        }
    }

    /**
     * Checks if the employee belongs to this department.
     */
    public boolean bIncludesEmployee(CEmployee _Employee) {
        return this.Employees.contains(_Employee);
    }

    @Override
    public String toString() {
        String DepNameDisplay = (Name == null || Name.isEmpty()) ? KDefaultName : Name;
        String Result = "Department\n==" + DepNameDisplay + "==\n";

        if (Boss != null) {
            String BossName = (Boss.GetName() == null || Boss.GetName().isEmpty()) ? KDefaultName : Boss.GetName();
            Result += "Manager: " + BossName + "\n";
        } else {
            Result += "Manager not assigned yet\n";
        }

        Result += "Employees:\n";
        if (Employees.isEmpty()) {
            Result += "No employees found\n";
        } else {
            int OrdinalNumber = KStartingNumber;

            for (CEmployee Employee : Employees) {
                if (Employee != this.Boss) {
                    String EmpName = (Employee.GetName() == null || Employee.GetName().isEmpty()) ? KDefaultName : Employee.GetName();
                    Result += String.format("%d: %s\n", OrdinalNumber, EmpName);
                    OrdinalNumber++;
                }
            }

            if (Employees.size() == 1 && this.Boss != null) {
                Result += "Only manager is present\n";
            }
        }

        return Result;
    }
}
