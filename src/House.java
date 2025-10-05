public class House {
    private final int floor;

    // properties
    public int getFloor() {
        return floor;
    }

    // for Task 4
//    public void setFloor(int settedFloor) {
//        if(settedFloor < 0 || settedFloor > 164){
//            this.floor = 1; // error
//        } else {
//            this.floor = settedFloor; // error
//        }
//    }

    // constructor
    public House(int floor) {
        if(floor < 0 || floor > 164){
            this.floor = 1;
        } else {
            this.floor = floor;
        }
    }

    // copy
    public House(House house) {
        this.floor = house.getFloor();
    }

    @Override
    public String toString() {

        if (floor % 100 >= 11 && floor % 100 <= 14) {
            return String.format("Дом с %d %s", floor, "этажами");
        }
        if(floor % 10 == 1){
            return String.format("Дом с %d %s", floor, "этажом");
        }

        return String.format("Дом с %d %s", floor, "этажами");
    }

}
