//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

// FIXME: Отсутствует Javadoc для класса и методов, 
// используются магические числа (86400, 3600, 60), 
// нарушены правила отступов (2 пробела), 
// отсутствуют пробелы после ключевых слов if,
// public class Time {
//     private int totalSeconds;

//     // properties
//     public int getTotalSeconds() {
//         return totalSeconds;
//     }

//     public void setTotalSeconds(int totalSeconds) {
//         if(totalSeconds < 0) {
//             this.totalSeconds = 0;
//         } else {
//             this.totalSeconds = totalSeconds;
//         }
//     }

//     // constructors
//     public Time() {
//         this.totalSeconds = 0;
//     }

//     public Time(int totalSeconds) {
//         this.setTotalSeconds(totalSeconds);
//     }

//     // copy
//     public Time(Time time) {
//         this.setTotalSeconds(time.getTotalSeconds());
//     }

//     @Override
//     public String toString() {
//         // %[аргумент_индекс][флаги][ширина][.точность]спецификатор типа
//         // 0 - заполнение нулями, 2 - ширина
//         return String.format("%d:%02d:%02d", totalSeconds % 86400 / 3600, totalSeconds % 3600 / 60, totalSeconds % 60);
//     }

// }
// FIXTO:
/**
 * Represents a time duration stored in total seconds.
 */
public class Time {

  private static final int SECONDS_IN_DAY = 86400;
  private static final int SECONDS_IN_HOUR = 3600;
  private static final int SECONDS_IN_MINUTE = 60;
  private static final int MIN_SECONDS = 0;

  private int totalSeconds;

  /**
   * Constructs a time object with zero seconds.
   */
  public Time() {
    this.totalSeconds = MIN_SECONDS;
  }

  /**
   * Constructs a time object with a specific number of seconds.
   *
   * @param totalSeconds the initial amount of seconds.
   */
  public Time(int totalSeconds) {
    setTotalSeconds(totalSeconds);
  }

  /**
   * Copy constructor to create a time object from another time object.
   *
   * @param time the time object to copy.
   */
  public Time(Time time) {
    if (time != null) {
      this.totalSeconds = time.getTotalSeconds();
    } else {
      this.totalSeconds = MIN_SECONDS;
    }
  }

  /**
   * Returns the total seconds.
   *
   * @return current total seconds.
   */
  public int getTotalSeconds() {
    return totalSeconds;
  }

  /**
   * Validates and sets the total seconds.
   *
   * @param totalSeconds the amount of seconds to set.
   */
  public final void setTotalSeconds(int totalSeconds) {
    if (totalSeconds < MIN_SECONDS) {
      this.totalSeconds = MIN_SECONDS;
    } else {
      this.totalSeconds = totalSeconds;
    }
  }

  /**
   * Returns the time formatted as H:MM:SS.
   *
   * @return formatted time string.
   */
  @Override
  public String toString() {
    // Formatting: %d (hours), %02d (minutes with leading zero), %02d (seconds with leading zero)
    int hours = (totalSeconds % SECONDS_IN_DAY) / SECONDS_IN_HOUR;
    int minutes = (totalSeconds % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
    int seconds = totalSeconds % SECONDS_IN_MINUTE;
    
    return String.format("%d:%02d:%02d", hours, minutes, seconds);
  }
}