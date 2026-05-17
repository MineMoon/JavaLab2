//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

//FIXME: Префикс C для класса (4-6 стр.), PascalCase (3 стр.), излишнее документирование (12 стр.)
//       вывод и комментарии должны быть на английском (3 стр.), префикс _ для параметров (6 стр.)
//       форматирование фигурных скобок(8 стр.), магические числа в константы(14 стр.), самодокментируемый код (1 стр.),
//       магические числа в константы(14 стр.)
// public class House {
//     private final int floor;

//     // properties
//     public int getFloor() {
//         return floor;
//     }

//     // for Task 4
// //    public void setFloor(int settedFloor) {
// //        if(settedFloor < 0 || settedFloor > 164){
// //            this.floor = 1; // error
// //        } else {
// //            this.floor = settedFloor; // error
// //        }
// //    }

//     // constructor
//     public House(int floor) {
//         if(floor < 0 || floor > 164){
//             this.floor = 1;
//         } else {
//             this.floor = floor;
//         }
//     }

//     // copy
//     public House(House house) {
//         this.floor = house.getFloor();
//     }

//     @Override
//     public String toString() {

//         if (floor % 100 >= 11 && floor % 100 <= 14) {
//             return String.format("Дом с %d %s", floor, "этажами");
//         }
//         if(floor % 10 == 1){
//             return String.format("Дом с %d %s", floor, "этажом");
//         }

//         return String.format("Дом с %d %s", floor, "этажами");
//     }

// }
//
// FIXTO:
public class CHouse {
    // Constants for floor limits and defaults
    private final int KMinFloors = 1;
    private final int KMaxFloors = 164;
    private final int KDefaultFloors = 1;

    private final int Floor; // Number of floors in the house

    /**
     * Constructor with floor validation.
     */
    public CHouse(int _Floor) {
        if (_Floor < KMinFloors || _Floor > KMaxFloors) {
            this.Floor = KDefaultFloors;
        } else {
            this.Floor = _Floor;
        }
    }

    /**
     * Copy constructor.
     */
    public CHouse(CHouse _House) {
        if (_House != null) {
            this.Floor = _House.GetFloor();
        } else {
            this.Floor = KDefaultFloors;
        }
    }

    /**
     * Returns the number of floors.
     */
    public int GetFloor() {
        return Floor;
    }

    /**
     * Returns a string representation of the house.
     */
    @Override
    public String toString() {
        // In English, singular "floor" is only for 1, otherwise "floors"
        String FloorSuffix = (Floor == 1) ? "floor" : "floors";
        return String.format("House with %d %s", Floor, FloorSuffix);
    }
}