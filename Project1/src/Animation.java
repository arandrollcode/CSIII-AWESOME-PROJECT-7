import mayflower.*;

public class Animation
{
    private MayflowerImage[] frames;
    private int framerate, currentFrame;

    public Animation(int framerate, String[] imgs)
    {
        this.framerate = framerate;
        currentFrame = 0;
        frames = new MayflowerImage[imgs.length];
        
        for (int i=0; i<imgs.length; i++) {
            frames[i] = new MayflowerImage(imgs[i]);
        }
    }
    
    public int getFrameRate() {
        return framerate;
    }
    
    public MayflowerImage getNextFrame() {
        int oldFrame = currentFrame;
        currentFrame++;
        currentFrame %= frames.length;
        
        return frames[oldFrame];
    }
    
    public void scale(int w, int h) {
        for (int i=0; i<frames.length; i++) {
            frames[i].scale(w, h);
        }
    }
    
    public void setTransparency(int percent) {
    	for (int i=0; i<frames.length; i++) {
            frames[i].setTransparency(percent);
        }   
    }
    
    public void mirrorHorizontally() {
    	for (int i=0; i<frames.length; i++) {
    	    frames[i].mirrorHorizontally();
    	}
    }
    
    public void setBounds(int x, int y, int w, int h) {
    	for (int i=0; i<frames.length; i++) {
    	    frames[i].crop(x, y, w, h);
    	}
    }
}
