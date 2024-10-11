public class Weapon extends Item{

    private int damage;


    public Weapon(String name, String findName, int damage){
        super(name, findName);
        this.damage = damage;

    }

    public int getDamage(){
        return damage;
    }

    public int checkAmmo(){
        return 0;
    }
}
