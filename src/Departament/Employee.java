//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

package Departament;

import java.util.Objects;

//FIXME: Префикс C для класса (4-6 стр.), PascalCase (3 стр.), излишнее документирование (12 стр.)
//       вывод и комментарии должны быть на английском (3 стр.), префикс _ для параметров (6 стр.)
//       форматирование фигурных скобок(8 стр.), магические числа в константы(14 стр.), самодокументируемый код (1 стр.),
//       магические строки в константы(14 стр.)
// public class Employee {
//     private String name;
//     private Department department;

//     // properties
//     public String getName() {
//         return new String(name);
//     }

//     public void setName(String name) {
//         if(name == null || name.length() == 0){
//             this.name = "unknown";
//         } else {
//             this.name = name;
//         }
//     }

//     public Department getDepartment() {
//         if (this.department == null) {
//             return null;
//         } else {
//             return new Department(department);
//         }
//     }

//     Department getRefDepartment() {
//         return this.department;
//     }

//     void setDepartment(Department department) { // видимость только в пакете Department
//         this.department = department;
//     }

//     // constructors
//     public Employee(){
//         name = "unknown";
//         department = null;
//     }


//     public Employee(String name){
//         this.setName(name);
//         this.department = null;
//     }


//     public Employee(String name, Department department){
//         this.setName(name);
//         if(department != null){
//             department.addEmployee(this);
//         }
//     }

//     // copy
//     public Employee(Employee copyEmployee){
//         if(copyEmployee != null){
//             this.setName(copyEmployee.getName());
//             this.setDepartment(copyEmployee.getRefDepartment()); // лучше создавать копию или назначать тот же отдел?
//         } else {
//             this.setName(null);
//             this.setDepartment(null);
//         }

//     }

//     @Override
//     public String toString() {
//         if (this.department == null) {
//             return String.format("%s не находится ни в одном из отделов", this.getName());
//         }

//         if (this.department.getRefBoss() == this) {
//             String depName = "без названия";
//             if (this.department.getName() != null && !this.department.getName().isEmpty() && !Objects.equals(this.department.getName(), "unknown")) {
//                 depName = this.department.getName();
//             }
//             return String.format("%s начальник отдела %s", this.getName(), depName);
//         }

//         String depName = "без названия";
//         if (this.department.getName() != null && !this.department.getName().isEmpty() && !Objects.equals(this.department.getName(), "unknown")) {
//             depName = this.department.getName();
//         }

//         String bossName = "еще не назначен";
//         if (this.department.getBoss() != null) {
//             if (this.department.getBoss().getName() != null && !this.department.getBoss().getName().isEmpty()) {
//                 bossName = this.department.getBoss().getName();
//             }
//         }

//         return String.format("%s работает в отделе %s, начальник которого %s",
//                 this.getName(), depName, bossName);
//     }
// }
//
// FIXTO:
public class CEmployee {
    // Constants for default string values
    private final String KUnknownName = "Unknown";
    private final String KNoDepartment = "No Department";
    private final String KNoManager = "Not Assigned Yet";

    private String Name; // Full name of the employee
    private CDepartment Department; // Department where the employee works

    /**
     * Default constructor.
     */
    public CEmployee() {
        this.Name = KUnknownName;
        this.Department = null;
    }

    /**
     * Constructor with name only.
     */
    public CEmployee(String _Name) {
        this.SetName(_Name);
        this.Department = null;
    }

    /**
     * Constructor with name and department association.
     */
    public CEmployee(String _Name, CDepartment _Department) {
        this.SetName(_Name);
        if (_Department != null) {
            _Department.AddEmployee(this);
        }
    }

    /**
     * Copy constructor.
     */
    public CEmployee(CEmployee _CopyEmployee) {
        if (_CopyEmployee != null) {
            this.SetName(_CopyEmployee.GetName());
            this.SetDepartment(_CopyEmployee.GetRefDepartment());
        } else {
            this.Name = KUnknownName;
            this.Department = null;
        }
    }

    /**
     * Returns the name of the employee.
     */
    public String GetName() {
        return (Name == null) ? KUnknownName : Name;
    }

    /**
     * Sets the employee name with validation.
     */
    public void SetName(String _Name) {
        if (_Name == null || _Name.isEmpty()) {
            this.Name = KUnknownName;
        } else {
            this.Name = _Name;
        }
    }

    /**
     * Returns a copy of the department (using copy constructor).
     */
    public CDepartment GetDepartment() {
        return (this.Department == null) ? null : new CDepartment(this.Department);
    }

    /**
     * Internal: Returns a direct reference to the department.
     */
    public CDepartment GetRefDepartment() {
        return this.Department;
    }

    /**
     * Internal: Sets the department reference.
     */
    void SetDepartment(CDepartment _Department) {
        this.Department = _Department;
    }

    @Override
    public String toString() {
        if (this.Department == null) {
            return String.format("%s does not belong to any department", this.GetName());
        }

        String DepName = KNoDepartment; // Display name for the department
        if (this.Department.GetName() != null && !this.Department.GetName().isEmpty()) {
            if (!this.Department.GetName().equalsIgnoreCase(KUnknownName)) {
                DepName = this.Department.GetName();
            }
        }

        // Logic if the employee is the manager of the department
        if (this.Department.GetRefBoss() == this) {
            return String.format("%s is the manager of the %s department", this.GetName(), DepName);
        }

        String ManagerName = KNoManager; // Display name for the manager
        if (this.Department.GetBoss() != null) {
            CEmployee Boss = this.Department.GetRefBoss();
            if (Boss.GetName() != null && !Boss.GetName().isEmpty()) {
                ManagerName = Boss.GetName();
            }
        }

        return String.format("%s works in the %s department, which is managed by %s",
                this.GetName(), DepName, ManagerName);
    }
}