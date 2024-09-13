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
      this.falling = this.isFalling();
      String newAction = null;
      if (this.currentAction == null) {
         newAction = "";
         this.setAnimation(this.idleRight);
      }

      if (this.direction == null) {
         this.direction = "right";
      }

      int x = this.getX();
      int y = this.getY();
      int w = this.getWidth();
      int h = this.getHeight();
      int speed = 1;
      if (Mayflower.isKeyDown(39) && x + w < 800) {
         this.setLocation((double)(x + speed), (double)y);
         newAction = "walkRight";
         this.direction = "right";
         if (this.isBlocked()) {
            this.setLocation((double)(x - speed), (double)y);
         }
      } else if (Mayflower.isKeyDown(37) && x > 0) {
         this.setLocation((double)(x - speed), (double)y);
         newAction = "walkLeft";
         this.direction = "left";
         if (this.isBlocked()) {
            this.setLocation((double)(x + speed), (double)y);
         }
      } else if (Mayflower.isKeyDown(38) && y > 0) {
         if (this.getYVelocity() == 0.0D) {
            this.setYVelocity(-10.0D);
         }
      } else if (Mayflower.isKeyDown(40) && y + h < 600) {
         this.setLocation((double)x, (double)(y + speed));
         if (this.isBlocked()) {
            this.setLocation((double)x, (double)(y - speed));
         }
      } else if (this.direction != null && !this.isFalling()) {
         if (this.direction.equals("left")) {
            newAction = "idleLeft";
         }

         if (this.direction.equals("right")) {
            newAction = "idleRight";
         }
      } else if (this.falling) {
         newAction = "";
      }

      if (newAction != null && !newAction.equals(this.currentAction)) {
         if (newAction.equals("idleRight")) {
            this.setAnimation(this.idleRight);
         }

         if (newAction.equals("idleLeft")) {
            this.setAnimation(this.idleLeft);
         }

         if (newAction.equals("walkRight")) {
            this.setAnimation(this.walkRight);
         }

         if (newAction.equals("walkLeft")) {
            this.setAnimation(this.walkLeft);
         }

         if (this.falling) {
            if (this.direction.equals("left")) {
               this.setAnimation(this.fallLeft);
            }

            if (this.direction.equals("right")) {
               this.setAnimation(this.fallRight);
            }
         }

         this.currentAction = newAction;
      }

   }

   public void setAnimation(Animation a) {
      super.setAnimation(a);
   }

   public void setWalkRightAnimation(Animation a) {
      this.walkRight = a;
   }

   public void setWalkLeftAnimation(Animation a) {
      this.walkLeft = a;
   }

   public void setIdleRightAnimation(Animation a) {
      this.idleRight = a;
   }

   public void setIdleLeftAnimation(Animation a) {
      this.idleLeft = a;
   }

   public void setFallRightAnimation(Animation a) {
      this.fallRight = a;
   }

   public void setFallLeftAnimation(Animation a) {
      this.fallLeft = a;
   }
}
