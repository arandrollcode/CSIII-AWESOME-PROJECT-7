import mayflower.*;

public class MoveableAnimatedActor extends AnimatedActor
{
    private Animation walkRight, walkLeft, idle, idleLeft;
    private String currentAction, direction;
    
    public MoveableAnimatedActor() {
        direction = "right";
    }
    
    public void setWalkRightAnimation(Animation a) {
        walkRight = a;
    }
    
    public void setWalkLeftAnimation(Animation a) {
        walkLeft = a;
    }
    
    public void setIdleAnimation(Animation a) {
        idle = a;
    }
    
    public void setIdleLeftAnimation(Animation a) {
        idleLeft = a;
    }
    
    public void setCurrentAction(String s) {
        currentAction = s;
    }
    
    public void act() {
        String newAction = null;
        
        if (currentAction == null) {
            newAction = "idle";
        }
        
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x + w < 800) {
            setLocation(x + 1, y);
            newAction = "walkRight";
            direction = "right";
            if (isBlocked()) {
                setLocation(x - 1, y);
            }
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0) {
            setLocation(x - 1, y);
            newAction = "walkLeft";
            direction = "left";
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0) {
            setLocation(x, y - 1);
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y + h < 600) {
            setLocation(x, y + 1);
        } else {
            newAction = "idle";
            if (direction != null && direction.equals("left")) {
            	newAction = "idleLeft";
            }
        }
        
        super.act();
        
        if (newAction != null && !newAction.equals(currentAction)) {
            if (newAction.equals("idle")) setAnimation(idle);
            else if (newAction.equals("walkRight")) setAnimation(walkRight);
            else if (newAction.equals("walkLeft")) setAnimation(walkLeft);
            else if (newAction.equals("idleLeft")) setAnimation(idleLeft);
            currentAction = newAction;
        }
        
    }
    
    public void setAnimation(Animation a) {
        super.setAnimation(a);
    }
}
