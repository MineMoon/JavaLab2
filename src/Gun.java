//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

//FIXME: Префикс C для класса (4-6 стр.), PascalCase (3 стр.)
//       вывод должен быть на английском (3 стр.), префикс _ для параметров (6 стр.)
//       форматирование фигурных скобок(8 стр.), магические числа в константы(14 стр.), самодокментируемый код (1 стр.)
// public class Gun {
//     private int ammo;

//     // properties
//     public int getAmmo() {
//         return ammo;
//     }

//     public void setAmmo(int ammo) {
//         if(ammo < 0){
//             this.ammo = 5;
//         } else if (ammo > 12) {
//             this.ammo = 12;
//         }
//         this.ammo = ammo;
//     }

//     // constructors
//     public Gun(){
//         ammo = 5;
//     }

//     public Gun(int ammo){
//         setAmmo(ammo);
//     }

//     // copy
//     public Gun(Gun copyGun){
//         this.ammo = copyGun.getAmmo();
//     }

//     // methods
//     public void shot(){
//         if(this.ammo > 0){
//             System.out.println("БАХ!");
//             this.ammo--;
//         } else {
//             System.out.println("Клац...");
//         }
//     }

//     public void reload(){
//         System.out.println("ПЕРЕЗАРЯДКА!!!");
//         this.ammo = 12;
//     }

//     @Override
//     public String toString() {
//         return String.format("Пистолет с %d патронами", ammo);
//     }
// }
//
//FIXTO:
public class CGun {
    // Constants for ammo limits
    private final int KDefaultAmmo = 5;
    private final int KMaxAmmo = 12;
    private final int KEmptyAmmo = 0;

    private int Ammo; // Current amount of ammunition in the gun

    /**
     * Default constructor.
     */
    public CGun() {
        Ammo = KDefaultAmmo;
    }

    /**
     * Constructor with initial ammo value.
     */
    public CGun(int _Ammo) {
        SetAmmo(_Ammo);
    }

    /**
     * Copy constructor.
     */
    public CGun(CGun _CopyGun) {
        if (_CopyGun != null) {
            this.Ammo = _CopyGun.GetAmmo();
        }
    }

    /**
     * Returns the current ammo count.
     */
    public int GetAmmo() {
        return Ammo;
    }

    /**
     * Validates and sets the ammo count.
     */
    public void SetAmmo(int _Ammo) {
        if (_Ammo < KEmptyAmmo) {
            this.Ammo = KDefaultAmmo;
        } else if (_Ammo > KMaxAmmo) {
            this.Ammo = KMaxAmmo;
        } else {
            this.Ammo = _Ammo;
        }
    }

    /**
     * Performs a shot if ammo is available.
     */
    public void Shoot() {
        if (this.Ammo > KEmptyAmmo) {
            System.out.println("BANG!");
            this.Ammo--;
        } else {
            System.out.println("Click...");
        }
    }

    /**
     * Reloads the gun to its maximum capacity.
     */
    public void Reload() {
        System.out.println("RELOADING!!!");
        this.Ammo = KMaxAmmo;
    }

    @Override
    public String toString() {
        return String.format("Handgun with %d bullets", Ammo);
    }
}
