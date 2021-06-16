package spacesurvival.controller.sound;

import spacesurvival.controller.sound.command.CommandAudio;
import spacesurvival.controller.sound.command.PlaySoundCommand;
import spacesurvival.controller.sound.command.ResetTiming;
import spacesurvival.controller.sound.command.StopSoundCommand;
import spacesurvival.model.sound.CmdAudioType;
import spacesurvival.model.sound.Sound;
import spacesurvival.utilities.path.SoundPath;

public class CallerAudio {
    private final CommandAudio cmdAudioOn;
    private final CommandAudio cmdAudioOff;
    private final CommandAudio cmdResetTiming;
    private Sound sound;

    /** 
     * Contructor for CallerAudio, inizialize a new CallerAudio without setting a current sound.
     * 
     */
    public CallerAudio() {
    this.cmdAudioOn = new PlaySoundCommand();
    this.cmdAudioOff = new StopSoundCommand();
    this.cmdResetTiming = new ResetTiming();
    }

    /** 
     * Contructor for CallerAudio, inizialize a new CallerAudio setting the passed sound.
     * 
     * @param sound the sound that will be set on this caller.
     */
    public CallerAudio(final Sound sound) {
        this();
        this.sound = sound;
    }

    /** 
     * Get the current sound.
     * 
     * @return the current sound of this caller.
     */
    public Sound getSound() {
        return this.sound;
    }

    /** 
     * Set sound to the caller.
     * 
     * @param sound the sound that will be set on this caller.
     */
    public void setSound(final Sound sound) {
        this.sound = sound;
    }

    /** 
     * Change the volume of the current sound.
     * 
     * @param currentVolume the volume that will be set on the current sound.
     */
    public void changeVolume(final int currentVolume) {
        final double parsedVolume = currentVolume / 100.0f;
        this.sound.setVolume(parsedVolume);
    }

    /** 
     * Check if the current sound is the same to which the passed path corresponds.
     * 
     * @param sound the path of the sound to be checked.
     * @return true if the current sound is equal to the corrisponding of the path.
     */
    public boolean isNewSound(final SoundPath sound) {
        return this.sound.getSoundType() != sound;
    }

    /** 
     * Read the passed command and execute the command on the specified concrete command. 
     * 
     * @param cmd the command to execute
     */
    public void execute(final CmdAudioType cmd) {

        switch (cmd) {
        case AUDIO_ON:
            cmdAudioOn.execute(sound); break;
        case AUDIO_OFF:
            cmdAudioOff.execute(sound); break;
        case RESET_TIMING:
            cmdResetTiming.execute(sound); break;
        default:
            cmdResetTiming.execute(sound); break;
        }
    }

    /** 
     * Returns a string that specifies the possible commands this caller can execute.
     * @return return the string
     */
    public String toString() {
        return "CallerAudio{" 
                + "CommandAudio= cmdAudioOn, cmdAudioOff, cmdResetTiming, "
                + "sound=" + this.getSound().toString() + '}';
    }
}
