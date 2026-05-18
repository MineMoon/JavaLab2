//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

//FIXME: camelCase, Отсутствие Javadoc, форматирование отступов 
// public class Check {

// 	public boolean isInteger(String str) {
// 		try {
// 			Integer.parseInt(str);
// 			return true;
// 		} catch (NumberFormatException e) {
// 			return false;
// 		}
// 	}

// 	public boolean Positive (int num) {
// 		return num >= 0;
// 	}

// }
//
//FIXTO:
/**
 * Utility class for numerical checks and calculations.
 */
public class Check {

  /**
   * Checks if a string can be parsed as an integer.
   *
   * @param input the string to check.
   * @return true if the string is a valid integer, false otherwise.
   */
  public boolean isInteger(String input) {
    if (input == null || input.isEmpty()) {
      return false;
    }
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Checks if a number is prime.
   *
   * @param number the integer to check.
   * @return true if the number is prime, false otherwise.
   */
  public boolean isPrime(int number) {
    if (number < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Calculates the sum of digits of a given number.
   *
   * @param number the integer whose digits will be summed.
   * @return the absolute sum of all digits.
   */
  public int sumOfDigits(int number) {
    int sum = 0;
    int tempNumber = Math.abs(number);
    while (tempNumber > 0) {
      sum += tempNumber % 10;
      tempNumber /= 10;
    }
    return sum;
  }
}
