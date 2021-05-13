package model.sound;

import utilities.SoundPath;

import java.util.Optional;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

	
public abstract class Sound {
		private static final double START_VOLUME = 0.50;
	    private SoundPath soundPath;
	    private double volume;
	    private Optional<Clip> clip = Optional.empty();
	    private boolean isPlaying = false;

		public Sound() {
			this.soundPath = null;
			this.volume = START_VOLUME;
		}

	    public Sound(final SoundPath sound) {
	    	this.soundPath = sound;
	    	this.volume = START_VOLUME;
	    }
	    
	    public void setSoundType(SoundPath sound) {
	    	this.soundPath = sound;
	    }
	    
	    public SoundPath getSoundType() {
	    	return this.soundPath;
	    }
	    
	    public void setClip(Clip clip) {
	    	System.out.println(Optional.of(clip));
	    	this.clip = Optional.of(clip);
	    	System.out.println(this.clip.get());
	    }
	    
	    public Optional<Clip> getClip() {
	    	return this.clip;
	    }
	    
	    public boolean isPlaying() {
	    	
	    	return this.isPlaying;
			//return this.clip.map(DataLine::isActive).orElse(false);
	    	
	    }
	    
	    
	    public void stopClip() {
	    	this.clip.get().stop();
	    	this.isPlaying = false;
	    }


	    public void startClip() {   	
	    	playSound(this.soundPath.getValue(), this.volume);
	    	this.isPlaying = true;
	    }
	    
	    protected abstract void playSound(String fileName, double volume);
	   
	    
		public void setVol(double volume) {
			System.out.println("Sono entrato");

			FloatControl gain = null;

			System.out.println(this.clip);

			System.out.println(getClip().get());
			
			gain = (FloatControl) getClip().get().getControl(FloatControl.Type.MASTER_GAIN);
		
			float dB = (float) (Math.log(volume) / Math.log(10) * 20);
			gain.setValue(dB);
			
		}

}
