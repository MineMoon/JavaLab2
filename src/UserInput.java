//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

import java.util.Scanner;


//FIXME: Префикс C для класса (4-6 стр.), PascalCase (3 стр.), излишнее документирование (12 стр.)
//       вывод и комментарии должны быть на английском (3 стр.), префикс _ для параметров (6 стр.)
//       форматирование фигурных скобок(8 стр.), магические числа в константы(14 стр.), самодокументируемый код (1 стр.),
//       магические числа в константы(14 стр.)
// public class UserInput {
// 	private final Scanner scanner = new Scanner(System.in);
// 	private final Check check = new Check();
// 	private String input;

// 	public int inputInt(int number){
// 		if(number == 0){
// 			System.out.println("Введите число: ");
// 		}
// 		else if(number>0){
// 			System.out.println("Введите " + number + "-ое число: ");
// 		}

// 		input = scanner.nextLine();
// 		while (!check.isInteger(input)){
// 			System.out.println("Некорректный ввод!");
// 			if(number == 0){
// 				System.out.println("Введите число: ");
// 			}
// 			else if(number>0){
// 				System.out.println("Введите " + number + "-ое число: ");
// 			}
// 			input = scanner.nextLine();
// 		}
// 		return Integer.parseInt(input);
// 	}

// 	public int inputPositiveInt(int number){
// 		if(number == 0){
// 			System.out.println("Введите целое число: ");
// 		}
// 		else if(number>0){
// 			System.out.println("Введите " + number + "-ое целое число: ");
// 		}

// 		input = scanner.nextLine();

// 		while (true) {
// 			try {
// 				int value = Integer.parseInt(input);
// 				if (value < 0) {
// 					System.out.println("Число должно быть положительным!");
// 					if(number == 0){
// 						System.out.println("Введите целое число: ");
// 					}
// 					else if(number>0){
// 						System.out.println("Введите " + number + "-ое целое число: ");
// 					}
// 				} else {
// 					return value;
// 				}
// 			} catch (NumberFormatException e) {
// 				System.out.println("Некорректный ввод!");
// 				if(number == 0){
// 					System.out.println("Введите целое число: ");
// 				}
// 				else if(number>0){
// 					System.out.println("Введите " + number + "-ое целое число: ");
// 				}
// 			}
// 			input = scanner.nextLine();
// 		}
// 	}

// 	public String inputString(String what){
// 		System.out.println("Введите "+ what + ": ");
// 		input = scanner.nextLine();
// 		return input;
// 	}

// 	public int inputDiaposonInt(int start, int end, String what){
// 		System.out.println("Введите "+ what+ " от " + start + " до " + end + ": ");

// 		input = scanner.nextLine();
// 		while (!check.isInteger(input)) {
// 			System.out.println("Некорректный ввод!");
// 				System.out.println("Введите число от" + start + " до " + end + ": ");
// 			input = scanner.nextLine();
// 		}
// 		while (!(start<=Integer.parseInt(input)&&(end>=Integer.parseInt(input)))) {
// 			System.out.println("Диапозон от " + start + " до " + end + "!");

// 			System.out.println("Введите "+ what+ " от " + start + " до " + end + ": ");
// 			input = scanner.nextLine();
// 			while (!check.isInteger(input)) {
// 				System.out.println("Некорректный ввод!");
// 				System.out.println("Введите число от" + start + " до " + end + ": ");
// 				input = scanner.nextLine();
// 			}
// 		}
// 		return Integer.parseInt(input);
// 	}

// 	public int inputChoiceInt(int start, int end, String what){
// 		System.out.println("Выберете "+ what);

// 		input = scanner.nextLine();
// 		while (!check.isInteger(input)) {
// 			System.out.println("Некорректный ввод!");
// 			System.out.println("Введите число от " + start + " до " + end + "!");
// 			System.out.println("Выберете "+ what);
// 			input = scanner.nextLine();
// 		}
// 		while (!(start <= Integer.parseInt(input) && (end >= Integer.parseInt(input)))) {
// 			System.out.println("Диапозон от " + start + " до " + end + "!");
// 			System.out.println("Выберете "+ what);
// 			input = scanner.nextLine();
// 			while (!check.isInteger(input)) {
// 				System.out.println("Введите число от " + start + " до " + end + "!");
// 				System.out.println("Выберете "+ what);
// 				input = scanner.nextLine();
// 			}
// 		}
// 		return Integer.parseInt(input);
// 	}

// 	public int[] inputIntArray(int size){
// 		int[] array = new int[size];
// 		for(int i = 1; i <= size; i++){
// 			array[i-1] = inputInt(i);
// 		}
// 		return array;
// 	}
// }
//
//FIXTO:
public class CUserInput {
    private final Scanner InputScanner = new Scanner(System.in); // Source for user input
    private final CCheck InputChecker = new CCheck(); // Helper for numeric validation
    private String RawInputBuffer; // Temporary storage for raw string input

    /**
     * Reads a generic integer from the console.
     */
    public int InputInt(int _OrdinalNumber) {
        final int KSingleInput = 0;

        if (_OrdinalNumber == KSingleInput) {
            System.out.println("Enter a number: ");
        } else if (_OrdinalNumber > KSingleInput) {
            System.out.println("Enter number #" + _OrdinalNumber + ": ");
        }

        RawInputBuffer = InputScanner.nextLine();
        while (!InputChecker.IsInteger(RawInputBuffer)) {
            System.out.println("Invalid input!");
            if (_OrdinalNumber == KSingleInput) {
                System.out.println("Enter a number: ");
            } else {
                System.out.println("Enter number #" + _OrdinalNumber + ": ");
            }
            RawInputBuffer = InputScanner.nextLine();
        }
        return Integer.parseInt(RawInputBuffer);
    }

    /**
     * Reads a positive integer from the console.
     */
    public int InputPositiveInt(int _OrdinalNumber) {
        final int KSingleInput = 0;
        final int KMinimumValue = 0;

        while (true) {
            if (_OrdinalNumber == KSingleInput) {
                System.out.println("Enter a positive integer: ");
            } else {
                System.out.println("Enter positive integer #" + _OrdinalNumber + ": ");
            }

            RawInputBuffer = InputScanner.nextLine();

            try {
                int Value = Integer.parseInt(RawInputBuffer);
                if (Value < KMinimumValue) {
                    System.out.println("The number must be positive!");
                } else {
                    return Value;
                }
            } catch (NumberFormatException _Ex) {
                System.out.println("Invalid input format!");
            }
        }
    }

    /**
     * Reads a string with a specific context prompt.
     */
    public String InputString(String _PromptContext) {
        System.out.println("Enter " + _PromptContext + ": ");
        RawInputBuffer = InputScanner.nextLine();
        return RawInputBuffer;
    }

    /**
     * Reads an integer within a specific inclusive range.
     */
    public int InputRangeInt(int _Start, int _End, String _PromptContext) {
        System.out.println("Enter " + _PromptContext + " from " + _Start + " to " + _End + ": ");
        
        while (true) {
            RawInputBuffer = InputScanner.nextLine();
            
            if (InputChecker.IsInteger(RawInputBuffer)) {
                int Value = Integer.parseInt(RawInputBuffer);
                if (Value >= _Start && Value <= _End) {
                    return Value;
                }
                System.out.println("Value out of range (" + _Start + " to " + _End + ")!");
            } else {
                System.out.println("Invalid numeric input!");
            }
            System.out.println("Try again: ");
        }
    }

    /**
     * Reads an integer choice between a specified range.
     */
    public int InputChoiceInt(int _Start, int _End, String _PromptContext) {
        System.out.println("Select " + _PromptContext);
        return InputRangeInt(_Start, _End, "choice");
    }

    /**
     * Reads an array of integers of a specified size.
     */
    public int[] InputIntArray(int _Size) {
        int[] ResultArray = new int[_Size]; // Array to store inputs
        
        for (int i = 0; i < _Size; i++) {
            // Using i + 1 for user-friendly 1-based indexing in prompts
            ResultArray[i] = InputInt(i + 1);
        }
        return ResultArray;
    }
}