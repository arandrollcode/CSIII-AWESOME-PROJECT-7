import mayflower.MayflowerImage;

public class Animation {
   private MayflowerImage[] frames;
   private int frameRate;
   private int currentFrame;

   public Animation(int frameRate, String[] frames) {
      this.frames = new MayflowerImage[frames.length];

      for(int i = 0; i < frames.length; ++i) {
         this.frames[i] = new MayflowerImage(frames[i]);
      }

      this.frameRate = frameRate;
      this.currentFrame = 0;
   }

   public int getFrameRate() {
      return this.frameRate;
   }

   public MayflowerImage getNextFrame() {
      MayflowerImage nextFrame = this.frames[this.currentFrame];
      ++this.currentFrame;
      this.currentFrame %= this.frames.length;
      return nextFrame;
   }

   public void scale(int w, int h) {
      for(int i = 0; i < this.frames.length; ++i) {
         this.frames[i].scale(w, h);
      }

   }

   public void setTransparency(int percent) {
      for(int i = 0; i < this.frames.length; ++i) {
         this.frames[i].setTransparency(percent);
      }

   }

   public void mirrorHorizontally() {
      for(int i = 0; i < this.frames.length; ++i) {
         this.frames[i].mirrorHorizontally();
      }

   }

   public void setBounds(int x, int y, int w, int h) {
      for(int i = 0; i < this.frames.length; ++i) {
         this.frames[i].crop(x, y, w, h);
      }

   }
}
