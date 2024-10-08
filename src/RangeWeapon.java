public class RangeWeapon extends Weapon {

    private int ammo;


    public RangeWeapon(String name, String finName, int ammo) {
        super(name, finName);
        this.ammo = ammo;
    }


     @Override
    public int checkammo(){
        return ammo;

     }


}
