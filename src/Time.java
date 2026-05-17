//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

//FIXME: Префикс C для класса (4-6 стр.), PascalCase (3 стр.), излишнее документирование (12 стр.)
//       вывод и комментарии должны быть на английском (3 стр.), префикс _ для параметров (6 стр.)
//       форматирование фигурных скобок(8 стр.), магические числа в константы(14 стр.), самодокументируемый код (1 стр.),
//       магические числа в константы(14 стр.)
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

public class CTime {
    // Constants for time calculations
    private final int KSecondsInDay = 86400;
    private final int KSecondsInHour = 3600;
    private final int KSecondsInMinute = 60;
    private final int KEmptyTime = 0;

    private int TotalSeconds; // Absolute number of seconds from the start of the day

    /**
     * Default constructor.
     */
    public CTime() {
        this.TotalSeconds = KEmptyTime;
    }

    /**
     * Constructor with initial seconds value.
     */
    public CTime(int _TotalSeconds) {
        this.SetTotalSeconds(_TotalSeconds);
    }

    /**
     * Copy constructor.
     */
    public CTime(CTime _Time) {
        if (_Time != null) {
            this.SetTotalSeconds(_Time.GetTotalSeconds());
        } else {
            this.TotalSeconds = KEmptyTime;
        }
    }

    /**
     * Returns the total amount of seconds.
     */
    public int GetTotalSeconds() {
        return TotalSeconds;
    }

    /**
     * Sets and validates the total amount of seconds.
     */
    public void SetTotalSeconds(int _TotalSeconds) {
        if (_TotalSeconds < KEmptyTime) {
            this.TotalSeconds = KEmptyTime;
        } else {
            this.TotalSeconds = _TotalSeconds;
        }
    }

    /**
     * Returns the time formatted as H:MM:SS.
     */
    @Override
    public String toString() {
        // Format: %d - hours, %02d - minutes with leading zero, %02d - seconds with leading zero
        int Hours = (TotalSeconds % KSecondsInDay) / KSecondsInHour;
        int Minutes = (TotalSeconds % KSecondsInHour) / KSecondsInMinute;
        int Seconds = TotalSeconds % KSecondsInMinute;

        return String.format("%d:%02d:%02d", Hours, Minutes, Seconds);
    }
}
