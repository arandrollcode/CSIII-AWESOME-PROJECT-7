import mayflower.*;

public class MovableAnimatedActor extends AnimatedActor {
   private Animation walkRight, walkLeft, idleRight, idleLeft, fallRight, fallLeft;
   private String currentAction = "";
   private String direction = "left";
   private boolean falling;
   private boolean dead;

   public void act() {
      super.act();

      falling = isFalling();
      String newAction = "";

      int x = getX(), y = getY();
      int w = getWidth(), h = getHeight();
      int xVelocity = 2;

      double newX = x, newY = y;
      if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x + w < 800) {
         if (!isBlocked())
            newX += xVelocity;
         newAction = "walkRight";
         direction = "right";
      }
      if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0) {
         if (!isBlocked())
            newX -= xVelocity;
         newAction = "walkLeft";
         direction = "left";
      }
      if (Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0) {
         if (getYVelocity() == 0.0) {
            setYVelocity(-10.0);
         }
      }

      if (falling) {
         if (direction.equals("left"))
            newAction = "fallLeft";
         else
            newAction = "fallRight";
      } else if (!newAction.contains("walk")) { // standing still or idle
         if (direction.equals("left")) {
            newAction = "idleLeft";
         }

         if (direction.equals("right")) {
            newAction = "idleRight";
         }
      }

      setLocation(newX, newY);

      if (newAction != null && !newAction.equals(currentAction)) {
         switch (newAction) {
            case "walkRight":
               setAnimation(walkRight);
               break;
            case "walkLeft":
               setAnimation(walkLeft);
               break;
            case "fallLeft":
               setAnimation(fallLeft);
               break;
            case "fallRight":
               setAnimation(fallRight);
               break;
            case "idleLeft":
               setAnimation(idleLeft);
               break;
            case "idleRight":
               setAnimation(idleRight);
               break;
         }
      }

      currentAction = newAction;

      if (getY() + 87 > 600) {
         dead = true;
      }
   }

   public void setAnimation(Animation a) {
      super.setAnimation(a);
   }

   public void setWalkRightAnimation(Animation a) {
      walkRight = a;
   }

   public void setWalkLeftAnimation(Animation a) {
      walkLeft = a;
   }

   public void setIdleRightAnimation(Animation a) {
      idleRight = a;
   }

   public void setIdleLeftAnimation(Animation a) {
      idleLeft = a;
   }

   public void setFallRightAnimation(Animation a) {
      fallRight = a;
   }

   public void setFallLeftAnimation(Animation a) {
      fallLeft = a;
   }

   public boolean isDead() {
      return dead;
   }
}
