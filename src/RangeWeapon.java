public class RangeWeapon extends Weapon {

    private int ammo;


    public RangeWeapon(String name, String finName, int damage, int ammo) {
        super(name, finName, damage);
        this.ammo = ammo;
    }


    public void setAmmo(int num){
        ammo = num;
    }


     @Override
    public int checkAmmo(){
        return ammo;

     }


}
