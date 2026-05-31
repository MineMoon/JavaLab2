//FIXME:отсутствие авторских прав (2 стр.),
//
//FIXTO:
// @copyright MineMoon. All rights reserved.

// FIXME: Отсутствует Javadoc для класса и 
// методов, используются магические числа вместо 
// именованных констант, нарушены правила 
// отступов (2 пробела), отсутствуют пробелы 
// после ключевых слов if, строковые литералы 
// написаны на русском языке, а также нарушен 
// порядок следования аннотаций.
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
/**
 * Represents a gun with ammunition management.
 */
public class Gun {

  private static final int MAX_AMMO = 12;
  private static final int DEFAULT_AMMO = 5;
  private static final int MIN_AMMO = 0;

  private int ammo;

  /**
   * Constructs a gun with default ammunition.
   */
  public Gun() {
    this.ammo = DEFAULT_AMMO;
  }

  /**
   * Constructs a gun with specific ammunition amount.
   *
   * @param ammo the initial amount of ammo.
   */
  public Gun(int ammo) {
    setAmmo(ammo);
  }

  /**
   * Copy constructor to create a gun from another gun object.
   *
   * @param copyGun the gun object to copy.
   */
  public Gun(Gun copyGun) {
    if (copyGun != null) {
      this.ammo = copyGun.getAmmo();
    }
  }

  /**
   * Validates and sets the amount of ammo.
   *
   * @param ammo the amount of ammo to set.
   */
  public final void setAmmo(int ammo) {
    if (ammo < MIN_AMMO) {
      this.ammo = DEFAULT_AMMO;
    } else if (ammo > MAX_AMMO) {
      this.ammo = MAX_AMMO;
    } else {
      this.ammo = ammo;
    }
  }

  /**
   * Returns current ammo count.
   *
   * @return current amount of ammo.
   */
  public int getAmmo() {
    return ammo;
  }

  /**
   * Performs a shot, reducing ammo by one.
   */
  public void shoot() {
    if (this.ammo > MIN_AMMO) {
      System.out.println("BANG!");
      this.ammo--;
    } else {
      System.out.println("Click...");
    }
  }

  /**
   * Reloads the gun to its maximum capacity.
   */
  public void reload() {
    System.out.println("RELOADING!!!");
    this.ammo = MAX_AMMO;
  }

  @Override
  public String toString() {
    return String.format("Gun with %d bullets", ammo);
  }
}
