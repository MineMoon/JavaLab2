public class Time {
    private int totalSeconds;

    // properties
    public int getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(int totalSeconds) {
        if(totalSeconds < 0) {
            this.totalSeconds = 0;
        } else {
            this.totalSeconds = totalSeconds;
        }
    }

    // constructors
    public Time() {
        this.totalSeconds = 0;
    }

    public Time(int totalSeconds) {
        this.setTotalSeconds(totalSeconds);
    }

    // copy
    public Time(Time time) {
        this.setTotalSeconds(time.getTotalSeconds());
    }

    @Override
    public String toString() {
        // %[аргумент_индекс][флаги][ширина][.точность]спецификатор типа
        // 0 - заполнение нулями, 2 - ширина
        return String.format("%d:%02d:%02d", totalSeconds % 86400 / 3600, totalSeconds % 3600 / 60, totalSeconds % 60);
    }

}
