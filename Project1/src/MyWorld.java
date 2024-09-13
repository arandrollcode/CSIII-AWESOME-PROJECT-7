import mayflower.*;

public class MyWorld extends World {
    public MyWorld() 
    {
        setBackground("Project1\\src\\img\\BG\\BG.png");
        
        Mayflower.showBounds(true);
        
        Cat cat = new Cat();
        addObject(cat, 400, 100);
        
        Block b = new Block();
        addObject(b, 400, 500);
        Block b2 = new Block();
        addObject(b2, 528, 372);
    }
    
    public void act()
    {
    }
}