public class Enemy {

    private String name;
    private String description;
    private int health;
    private Weapon weapon;
    private String deadMessage;
    private boolean dead;
//------------------------------------constructor
    public Enemy (String name, String description, String deadMessage, int health, Weapon weapon){
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
        this.deadMessage = deadMessage;
        this.dead = false;
    }
//------------------------------------------getter methods-----------------------------------------------
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getHealth(){
        return health;
    }
    public Weapon getWeapon(){
        return weapon;
    }
    public String getDeadMessage(){
        return deadMessage;
    }
    public boolean isDead(){
        return dead;
    }
    //----------------------------------------------battle methods-------------------------------
    public void takeDamage(int damage){
        health -= damage;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }
}
