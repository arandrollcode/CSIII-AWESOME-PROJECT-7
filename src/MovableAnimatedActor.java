import mayflower.Mayflower;

public class MovableAnimatedActor extends AnimatedActor {
   private Animation walkRight;
   private Animation walkLeft;
   private Animation idleRight;
   private Animation idleLeft;
   private Animation fallRight;
   private Animation fallLeft;
   private String currentAction;
   private String direction;
   private boolean falling;

   public void act() {
      super.act();
      falling = isFalling();
      String newAction = null;
      if (currentAction == null) {
         newAction = "";
         setAnimation(idleRight);
      }

      if (direction == null) {
         direction = "right";
      }

      int x = getX();
      int y = getY();
      int w = getWidth();
      int h = getHeight();
      int speed = 1;
      if (Mayflower.isKeyDown(39) && x + w < 800) {
         setLocation((double)(x + speed), (double)y);
         newAction = "walkRight";
         direction = "right";
         if (isBlocked()) {
            setLocation((double)(x - speed), (double)y);
         }
         if (this.falling) { // if falling while key pressed down
            newAction = "";
            this.direction = "right";
         }
         if (this.falling) { // if falling while key pressed down
            newAction = "";
            this.direction = "right";
         }
      } else if (Mayflower.isKeyDown(37) && x > 0) {
         setLocation((double)(x - speed), (double)y);
         newAction = "walkLeft";
         direction = "left";
         if (isBlocked()) {
            setLocation((double)(x + speed), (double)y);
         }
         if (this.falling) {  // if falling while key pressed down
            newAction = "";
            this.direction = "right";
         }
         this.direction = "left";
      } else if (Mayflower.isKeyDown(38) && y > 0) {
         if (this.getYVelocity() == 0.0D) {
            this.setYVelocity(-10.0D);
         }
      } else if (Mayflower.isKeyDown(40) && y + h < 600) {
         setLocation((double)x, (double)(y + speed));
         if (isBlocked()) {
            setLocation((double)x, (double)(y - speed));
         }
      } else if (direction != null && !isFalling()) {
         if (direction.equals("left")) {
            newAction = "idleLeft";
         }

         if (direction.equals("right")) {
            newAction = "idleRight";
         }
      } else if (this.falling) {
         newAction = "left";
      }

      if (newAction != null && !newAction.equals(this.currentAction)) {
         
         if (newAction.equals("walkRight") && !this.falling) {
            this.setAnimation(this.walkRight);
         }

         if (newAction.equals("walkLeft") && !this.falling) {
            this.setAnimation(this.walkLeft);
         }

         if (falling) {
            if (direction.equals("left")) {
               setAnimation(fallLeft);
            }

            if (this.direction.equals("right")) {
               this.setAnimation(this.fallRight);
            }
         }

         if (newAction.equals("idleRight")) {
            this.setAnimation(this.idleRight);
         }

         if (newAction.equals("idleLeft")) {
            this.setAnimation(this.idleLeft);
         }

         this.currentAction = newAction;
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
}
