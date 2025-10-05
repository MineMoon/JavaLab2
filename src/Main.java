import Departament.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserInput input = new UserInput();

		int choice = 2;
		int choiceTask = 0;
		int argument = 0;
		boolean exit = false;

		do{

			if(choice == 2){
				choiceTask = input.inputChoiceInt(1,4, "тему:\n1. Время\n2. Дом\n3. Отделы и сотрудники\n4. Пистолет");
			}

			switch (choiceTask) {

				case 1:

					argument = input.inputPositiveInt(0);

					Time time = new Time(argument);
					System.out.println("Time: " + time.toString());
					System.out.println();

					// Task
//					Time time1 = new Time(10);
//					Time time2 = new Time(10000);
//					Time time3 = new Time(100000);
//
//					System.out.println("Time: " + time1.toString());
//					System.out.println("Time: " + time2.toString());
//					System.out.println("Time: " + time3.toString());
					break;

				case 2:

					argument = input.inputDiaposonInt(1,163, "кол-во этажей");

					House house = new House(argument);
					System.out.println(house.toString());

					// Task
//					House house1 = new House(1);
//					House house2 = new House(5);
//					House house3 = new House(23);
//
//					System.out.println(house1.toString());
//					System.out.println(house2.toString());
//					System.out.println(house3.toString());

					// for Task 4
//					house.getFloor() = 2; // error
					break;

				case 3:
					Department department = new Department("IT");

					Employee emp1 = new Employee("Петров", department);
					Employee emp2 = new Employee("Козлов", department);
					Employee emp3 = new Employee("Сидоров", department);
					department.setBoss(emp2);

					Employee emp4 = new Employee("",department);


//					System.out.println(emp2.toString());
//					System.out.println(emp1.toString());
//					System.out.println(emp3.toString());
					System.out.println(department.toString());

//					System.out.println(emp1.getDepartment().toString());
					break;

				case 4:

					Gun pistol = new Gun(3);

					pistol.shot();
					pistol.shot();
					pistol.shot();
					pistol.shot();
					pistol.shot();

					pistol.reload();
					break;
			}
			System.out.println();

			System.out.println("Повторить?\n1. Да\n2. К выбору задания\n3. Выход");
			choice = input.inputDiaposonInt(1, 3, "вариант");
			if(choice == 3){
				exit = true;
			}
			System.out.println();

		}while (!exit);
	}
}