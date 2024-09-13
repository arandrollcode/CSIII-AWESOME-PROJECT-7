import mayflower.*;

public class GravityActor extends Actor
{
    public GravityActor() {
        
    }
    
    public void act() {
        if (!isBlocked()) {
            setLocation(getX(), getY() + 1);
        }
    }
    
    public boolean isBlocked() {
        return isTouching(Block.class);
    }
}
