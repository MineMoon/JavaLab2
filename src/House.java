//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

// FIXME: Отсутствует Javadoc для класса и 
// методов, используются магические числа (164, 1), 
// нарушены правила отступов (2 пробела), 
// отсутствуют пробелы после ключевых слов if, 
// строковые литералы в методе toString написаны на русском языке, 
// а в конструкторе копирования отсутствует проверка на null.
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
/**
 * Represents a house with a specific number of floors.
 */
public class House {

  private static final int MIN_FLOORS = 1;
  private static final int MAX_FLOORS = 164;
  private static final int DEFAULT_FLOORS = 1;

  private final int floor;

  /**
   * Constructs a house with a validated number of floors.
   *
   * @param floor the number of floors to set.
   */
  public House(int floor) {
    if (floor < MIN_FLOORS || floor > MAX_FLOORS) {
      this.floor = DEFAULT_FLOORS;
    } else {
      this.floor = floor;
    }
  }

  /**
   * Copy constructor to create a house from another house object.
   *
   * @param house the house object to copy.
   */
  public House(House house) {
    if (house != null) {
      this.floor = house.getFloor();
    } else {
      this.floor = DEFAULT_FLOORS;
    }
  }

  /**
   * Returns the number of floors.
   *
   * @return the floor count.
   */
  public int getFloor() {
    return floor;
  }

  /**
   * Returns a string representation of the house in English.
   *
   * @return formatted string with floor count.
   */
  @Override
  public String toString() {
    // In English: "1 floor", otherwise "floors"
    String suffix = (floor == 1) ? "floor" : "floors";
    return String.format("House with %d %s", floor, suffix);
  }
}