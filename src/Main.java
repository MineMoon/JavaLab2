//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

import Departament.*;
import java.util.Scanner;

// FIXME: Префикс C для класса (4-6 стр.), PascalCase для всех имен (3 стр.), самодокументируемый код (1 стр.)
// префикс _ для параметров (6 стр.), вывод и комментарии должны быть на английском (3 стр.), PascalCase (3 стр.)
// public class Main {
// 	public static void main(String[] args) {
// 		Scanner sc = new Scanner(System.in);
// 		UserInput input = new UserInput();

// 		int choice = 2;
// 		int choiceTask = 0;
// 		int argument = 0;
// 		boolean exit = false;

// 		do{

// 			if(choice == 2){
// 				choiceTask = input.inputChoiceInt(1,4, "тему:\n1. Время\n2. Дом\n3. Отделы и сотрудники\n4. Пистолет");
// 			}

// 			switch (choiceTask) {

// 				case 1:

// 					argument = input.inputPositiveInt(0);

// 					Time time = new Time(argument);
// 					System.out.println("Time: " + time.toString());
// 					System.out.println();

// 					// Task
// //					Time time1 = new Time(10);
// //					Time time2 = new Time(10000);
// //					Time time3 = new Time(100000);
// //
// //					System.out.println("Time: " + time1.toString());
// //					System.out.println("Time: " + time2.toString());
// //					System.out.println("Time: " + time3.toString());
// 					break;

// 				case 2:

// 					argument = input.inputDiaposonInt(1,163, "кол-во этажей");

// 					House house = new House(argument);
// 					System.out.println(house.toString());

// 					// Task
// //					House house1 = new House(1);
// //					House house2 = new House(5);
// //					House house3 = new House(23);
// //
// //					System.out.println(house1.toString());
// //					System.out.println(house2.toString());
// //					System.out.println(house3.toString());

// 					// for Task 4
// //					house.getFloor() = 2; // error
// 					break;

// 				case 3:
// 					Department department = new Department("IT");

// 					Employee emp1 = new Employee("Петров", department);
// 					Employee emp2 = new Employee("Козлов", department);
// 					Employee emp3 = new Employee("Сидоров", department);
// 					department.setBoss(emp2);

// 					Employee emp4 = new Employee("",department);


// //					System.out.println(emp2.toString());
// //					System.out.println(emp1.toString());
// //					System.out.println(emp3.toString());
// 					System.out.println(department.toString());

// //					System.out.println(emp1.getDepartment().toString());
// 					break;

// 				case 4:

// 					Gun pistol = new Gun(3);

// 					pistol.shot();
// 					pistol.shot();
// 					pistol.shot();
// 					pistol.shot();
// 					pistol.shot();

// 					pistol.reload();
// 					break;
// 			}
// 			System.out.println();

// 			System.out.println("Повторить?\n1. Да\n2. К выбору задания\n3. Выход");
// 			choice = input.inputDiaposonInt(1, 3, "вариант");
// 			if(choice == 3){
// 				exit = true;
// 			}
// 			System.out.println();

// 		}while (!exit);
// 	}
// }
//
// FIXTO:
public class CMain {
    public static void Main(String[] _Args) {
        // Constants for task selection
        final int KTaskTime = 1;
        final int KTaskHouse = 2;
        final int KTaskDepartment = 3;
        final int KTaskGun = 4;

        // Constants for menu navigation
        final int KMenuRepeat = 1;
        final int KMenuToTaskSelection = 2;
        final int KMenuExit = 3;

        Scanner InputScanner = new Scanner(System.in); // Standard scanner for input
        CUserInput InputHandler = new CUserInput(); // Helper for validated user input

        int NavigationChoice = 2; // Stores user choice for repeating or exiting
        int SelectedTask = 0; // Stores the current active task ID
        int TaskArgument = 0; // Universal argument for different tasks
        boolean bIsExit = false; // Flag to terminate the main loop

        do {
            if (NavigationChoice == KMenuToTaskSelection) {
                SelectedTask = InputHandler.InputChoiceInt(1, 4, 
                    "a topic:\n1. Time\n2. House\n3. Departments and Employees\n4. Gun");
            }

            switch (SelectedTask) {
                case KTaskTime:
                    TaskArgument = InputHandler.InputPositiveInt(0);
                    CTime TimeObject = new CTime(TaskArgument);
                    System.out.println("Time: " + TimeObject.toString());
                    break;

                case KTaskHouse:
                    final int KMaxHouseFloors = 163;
                    TaskArgument = InputHandler.InputRangeInt(1, KMaxHouseFloors, "number of floors");
                    CHouse HouseObject = new CHouse(TaskArgument);
                    System.out.println(HouseObject.toString());
                    break;

                case KTaskDepartment:
                    CDepartment ItDepartment = new CDepartment("IT");
                    CEmployee FirstEmployee = new CEmployee("Petrov", ItDepartment);
                    CEmployee BossEmployee = new CEmployee("Kozlov", ItDepartment);
                    CEmployee ThirdEmployee = new CEmployee("Sidorov", ItDepartment);
                    
                    ItDepartment.SetBoss(BossEmployee);
                    System.out.println(ItDepartment.toString());
                    break;

                case KTaskGun:
                    final int KInitialAmmo = 3;
                    CGun Pistol = new CGun(KInitialAmmo);
                    Pistol.Shoot();
                    Pistol.Shoot();
                    Pistol.Shoot();
                    Pistol.Shoot();
                    Pistol.Reload();
                    break;

                default:
                    System.out.println("Unknown task selected.");
                    break;
            }

            System.out.println();
            System.out.println("Repeat?\n1. Yes\n2. Back to task selection\n3. Exit");
            
            NavigationChoice = InputHandler.InputRangeInt(KMenuRepeat, KMenuExit, "option");
            
            if (NavigationChoice == KMenuExit) {
                bIsExit = true;
            }
            
            System.out.println();

        } while (!bIsExit);
        
        InputScanner.close();
    }
}