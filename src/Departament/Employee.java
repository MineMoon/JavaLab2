//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

package Departament;

import java.util.Objects;

// FIXME: Отсутствует Javadoc для публичных элементов,
// используется 4-пробельный отступ вместо 2,
// избыточное создание объектов new String(),
// интерфейс toString и комментарии написаны на русском языке,
// нарушены правила пробелов после ключевых слов и вокруг операторов, 
// отсутствуют фигурные скобки в блоках управления.
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
/**
 * Represents an employee associated with a department.
 */
public class Employee {

  private static final String UNKNOWN = "unknown";
  private static final String NO_NAME = "no name";

  private String name;
  private Department department;

  /**
   * Default constructor initializing employee with unknown name.
   */
  public Employee() {
    this.name = UNKNOWN;
    this.department = null;
  }

  /**
   * Constructs an employee with a specified name.
   *
   * @param name the name of the employee.
   */
  public Employee(String name) {
    setName(name);
    this.department = null;
  }

  /**
   * Constructs an employee with a name and a department.
   *
   * @param name       the name of the employee.
   * @param department the department the employee belongs to.
   */
  public Employee(String name, Department department) {
    setName(name);
    if (department != null) {
      department.addEmployee(this);
    }
  }

  /**
   * Copy constructor.
   *
   * @param copyEmployee the employee object to copy.
   */
  public Employee(Employee copyEmployee) {
    if (copyEmployee != null) {
      setName(copyEmployee.getName());
      setDepartment(copyEmployee.getRefDepartment());
    } else {
      this.name = UNKNOWN;
      this.department = null;
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    if (name == null || name.isEmpty()) {
      this.name = UNKNOWN;
    } else {
      this.name = name;
    }
  }

  public Department getDepartment() {
    return (this.department == null) ? null : new Department(department);
  }

  Department getRefDepartment() {
    return this.department;
  }

  /**
   * Sets the department reference. Visible within the department package.
   */
  void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public String toString() {
    if (this.department == null) {
      return String.format("%s does not belong to any department", getName());
    }

    String depName = NO_NAME;
    if (department.getName() != null && !department.getName().isEmpty()
        && !Objects.equals(department.getName(), UNKNOWN)) {
      depName = department.getName();
    }

    if (department.getRefBoss() == this) {
      return String.format("%s is the manager of the %s department", getName(), depName);
    }

    String bossName = "not assigned yet";
    if (department.getBoss() != null) {
      Employee boss = department.getRefBoss();
      if (boss.getName() != null && !boss.getName().isEmpty()) {
        bossName = boss.getName();
      }
    }

    return String.format("%s works in the %s department, managed by %s",
        getName(), depName, bossName);
  }
}