//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

//FIXME: Префикс C для класса (4-6 стр.), PascalCase для всех имен (3 стр.), самодокументируемый код (1 стр.)
// префикс _ для параметров (6 стр.)
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
public class Check {

	/**
     * Checks if a string is a number
     */
	public boolean IsInteger(String _Str) {
		try {
			Integer.parseInt(_Str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
     * Checks that a number is positive
     */
	public boolean IsPositive(int _Num) {
		return _Num >= 0;
	}

}
