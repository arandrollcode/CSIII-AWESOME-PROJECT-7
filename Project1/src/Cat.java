import mayflower.*;

public class Cat extends MoveableAnimatedActor
{   
    public Cat() 
    {
        String[] paths = new String[10];
        for (int i=1; i<=10; i++) {
            String imgPath = String.format("Project1/src/img/cat/Walk (%d).png", i); 
            paths[i-1] = imgPath;
        }
        Animation walk = new Animation(5, paths);
        walk.scale(100, 87);
        walk.setBounds(18, 5, 54, 80);
        setWalkRightAnimation(walk);
        
        Animation walkLeft = new Animation(5, paths);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 80);
        setWalkLeftAnimation(walkLeft);
        
        String[] idlePaths = new String[10];
        for (int i=1; i<=10; i++) {
            String imgPath = String.format("Project1/src/img/cat/Idle (%d).png", i); 
            idlePaths[i-1] = imgPath;
        }
        Animation idle = new Animation(5, idlePaths);
        idle.scale(100, 87);
        idle.setBounds(18, 5, 54, 80);
        setIdleAnimation(idle);
        
        Animation idleLeft = new Animation(5, idlePaths);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(28, 5, 54, 80);
        setIdleLeftAnimation(idleLeft);
    }
        public void act()
    {
        super.act();
    }
}
