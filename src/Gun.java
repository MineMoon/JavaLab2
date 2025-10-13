public class Gun {
    private int ammo;

    // properties
    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        if(ammo < 0){
            this.ammo = 5;
        } else if (ammo > 12) {
            this.ammo = 12;
        }
        this.ammo = ammo;
    }

    // constructors
    public Gun(){
        ammo = 5;
    }

    public Gun(int ammo){
        setAmmo(ammo);
    }

    // copy
    public Gun(Gun copyGun){
        this.ammo = copyGun.getAmmo();
    }

    // methods
    public void shot(){
        if(this.ammo > 0){
            System.out.println("БАХ!");
            this.ammo--;
        } else {
            System.out.println("Клац...");
        }
    }

    public void reload(){
        System.out.println("ПЕРЕЗАРЯДКА!!!");
        this.ammo = 12;
    }

    @Override
    public String toString() {
        return String.format("Пистолет с %d патронами", ammo);
    }
}
