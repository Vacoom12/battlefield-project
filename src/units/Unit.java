package src.units;

public class Unit {
    protected int x, y;    
    protected int width, height; 
    protected int health;      
    protected String name;  

    public Unit(String name, int x, int y, int width, int height, int health) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
    }

    public void takeDamage() {
        if (health > 0) 
            health--;
    }

    public boolean isDestroyed() {
        return health == 0;
    }
}
