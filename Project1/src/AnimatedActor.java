import mayflower.*;

public class AnimatedActor extends GravityActor
{
    private Animation animation;
    private Timer animationTimer;
    
    public AnimatedActor()
    {
    }

    public void setAnimation(Animation a) {
        animation = a;
        animationTimer = new Timer(1000);
    }
    
    public void act() {
        if (animationTimer == null) return;
        
        if (animationTimer.isDone()) {
            animationTimer.reset();
            MayflowerImage nextFrame = animation.getNextFrame();
            setImage(nextFrame);
        }
        
        super.act();
    }
}
