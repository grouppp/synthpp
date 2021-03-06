package synthpp;

import processing.core.PApplet;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import java.awt.*;

public class KeyBoard
{
    private KeyButton buttons[];
    private int[] referenceTones = {0,1,2,3,4,5,6,7,8,9,10,11,12};
    private float[] tones;
    private char keys[] = {'A','W','S','E','D','F','T','G','Y','H','U','J','K'};
    private String notes[] = {"C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B","C"};
    private int octave = 7;
    private boolean keyStates[];
    private PApplet parent;
    private boolean isInitialized = false;
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    private int keysPressed = 0;
    private float MAXAMP = 1.0f;

    private Synthesizer synth;
    private int defaultChannel = 1;

    MidiChannel channelA, channelW, channelS, channelE, channelD, channelF, channelT, channelG, channelY, channelH, channelU,
                channelJ, channelK;

    private int tickIndex = 0; //tracks midi sequence ticks when recording

    private MidiRecorder midiRecorder;
    private boolean record;


    public KeyBoard(PApplet pApplet, int xPositoin, int yPosition, int width, int height){
        this.parent = pApplet;
        this.xPosition = xPositoin;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        octave = 7;

        try
        {
            this.synth = MidiSystem.getSynthesizer();
            this.synth.open();
        }
        catch(MidiUnavailableException e)
        {
            e.printStackTrace();
        }

        channelA = synth.getChannels()[2];
        channelW = synth.getChannels()[3];
        channelS = synth.getChannels()[4];
        channelE = synth.getChannels()[5];
        channelD = synth.getChannels()[6];
        channelF = synth.getChannels()[7];
        channelT = synth.getChannels()[8];
        channelG = synth.getChannels()[10];
        channelY = synth.getChannels()[11];
        channelH = synth.getChannels()[12];
        channelU = synth.getChannels()[13];
        channelJ = synth.getChannels()[14];
        channelK = synth.getChannels()[15];

        midiRecorder = null;
        record = false;
    }

    public void setOctave(int octave)
    {
        if(octave >= -1 && octave <= 11)
        {
            this.octave = octave;
            shiftOctave();
        }
    }

    public int getOctave()
    {
        return this.octave;
    }

    //if this is set to true and a MidiRecorder has been registered the the
    //notes will be recorded to the registered MidiRecorder
    public void recordNotes(boolean r)
    {
        record = r;
    }

    public void registerRecorder(MidiRecorder recorder)
    {
        midiRecorder = recorder;
    }

    public void keyPressed(char key)
    {
        keysPressed = 0;
        for(int i=0;i<keys.length;i++)
        {
            if(Character.toUpperCase(key) == keys[i])
            {
                keyStates[i] = true;
            }
            if(keyStates[i])
            {
                keysPressed++;
            }
        }
        float amp = MAXAMP;
        if(keysPressed == 0) amp = MAXAMP;
        else amp=MAXAMP/keysPressed;
        for(int i=0;i<keys.length;i++)
        {
            if(keyStates[i])
            {
                if(i == 0)
                {
                    int noteNum = referenceTones[i];
                    channelA.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 1)
                {
                    int noteNum = referenceTones[i];
                    channelW.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 2)
                {
                    int noteNum = referenceTones[i];
                    channelS.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 3)
                {
                    int noteNum = referenceTones[i];
                    channelE.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 4)
                {
                    int noteNum = referenceTones[i];
                    channelD.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 5)
                {
                    int noteNum = referenceTones[i];
                    channelF.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 6)
                {
                    int noteNum = referenceTones[i];
                    channelT.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 7)
                {
                    int noteNum = referenceTones[i];
                    channelG.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 8)
                {
                    int noteNum = referenceTones[i];
                    channelY.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 9)
                {
                    int noteNum = referenceTones[i];
                    channelH.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 10)
                {
                    int noteNum = referenceTones[i];
                    channelU.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 11)
                {
                    int noteNum = referenceTones[i];
                    channelJ.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
                else if(i == 12)
                {
                    int noteNum = referenceTones[i];
                    channelK.noteOn(noteNum, 125);
                    if (midiRecorder != null && record) {
                        midiRecorder.addNote(noteNum, 125, tickIndex++, defaultChannel);
                    }
                }
            }
        }
    }
    public void keyReleased(char key)
    {
        keysPressed = 0;

        char upperKey = Character.toUpperCase(key);

        for(int i=0;i<keys.length;i++)
        {
            if(upperKey == keys[i])
            {
                if(i == 0)
                {
                    channelA.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 1)
                {
                    channelW.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 2)
                {
                    channelS.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 3)
                {
                    channelE.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 4)
                {
                    channelD.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 5)
                {
                    channelF.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 6)
                {
                    channelT.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 7)
                {
                    channelG.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 8)
                {
                    channelY.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 9)
                {
                    channelH.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 10)
                {
                    channelU.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 11)
                {
                    channelJ.allSoundOff();
                    keyStates[i] = false;
                }
                else if(i == 12)
                {
                    channelK.allSoundOff();
                    keyStates[i] = false;
                }
            }
            if(keyStates[i])
            {
                keysPressed++;
            }
        }
    }

    //return array of notes
    public String[] getNotes(){
        return notes;
    }

    public void draw(){
        if(isInitialized) {
            // Display all the keyButtons
            for (int i = 0; i <  buttons.length; i++) {
                buttons[i].draw(keyStates[i]);
            }
            //draw the black keys second
            for (int i = 0; i <  buttons.length; i++) {
                if (i == 1 || i == 3 || i == 6 || i == 8 || i == 10) {
                    buttons[i].draw(keyStates[i]);
                }
            }
        }
    }

    public void init(){
        buttons = new KeyButton[keys.length];
        keyStates = new boolean[keys.length];
        tones =  new float[referenceTones.length];

        //shift the octave to the default tones
        shiftOctave();

        // Initialize all "keyButtons"
        int whiteKeyWidth = width/keys.length;
        int blackKeyWidth = whiteKeyWidth/2 + 8;
        int whiteKeyHeight = height;
        int blackKeyHeight = whiteKeyHeight/2;
        int numberOfWhiteKeys = 0;
        for (int i = 0; i < buttons.length; i++) {
            switch(i){
                case 1:
                case 3:
                case 6:
                case 8:
                case 10:{ //these will be the black keys
                    buttons[i] = new KeyButton(parent, (xPosition + (whiteKeyWidth * numberOfWhiteKeys))-(blackKeyWidth/2), yPosition, blackKeyWidth, blackKeyHeight, '\0',Color.WHITE, Color.BLACK, Color.pink);
                    break;
                }
                default:{//the rest will be white keys
                    buttons[i] = new KeyButton(this.parent, xPosition + (whiteKeyWidth * numberOfWhiteKeys++), yPosition, whiteKeyWidth, whiteKeyHeight, notes[i].charAt(0),Color.BLACK, Color.WHITE, Color.pink);
                    break;
                }
            }
        }

        isInitialized = true;
    }

    //helper function
    private void shiftOctave(){
        for(int i = 0; i < referenceTones.length; ++i){
            referenceTones[i] = i + (12 * octave);
        }
    }

    //private inner class
    private class KeyButton {
        private float xPos;         // horizontal location of keyButton
        private float yPos;         //vertical location of keyButton
        private float width;        // width of key
        private float height;
        private char text;          //text on the key
        private Color foreGround;
        private Color backGround;
        private Color highLight;
        private boolean isPressed;      // state of keyButton (mouse is over or not?)
        private PApplet parent;     // The parent PApplet that we will render ourselves onto


        public KeyButton(PApplet p, int xPosition, int yPositoin, int keyWidth, int keyHeight, char keyText, Color fg, Color bg, Color pressedHighLight) {
            parent = p;
            xPos = xPosition;
            yPos = yPositoin;
            width = keyWidth; // parent.random(10,30);
            height = keyHeight;
            text = keyText;
            foreGround = fg;
            backGround = bg;
            isPressed = false;
            highLight = pressedHighLight;
        }

        // Draw key
        public void draw (boolean pressed) {
            parent.strokeWeight(2);
            parent.stroke(0);
            if (pressed) {
                parent.fill(255, 200, 200);
            } else {
                parent.fill(backGround.getRGB());
            }
            parent.rect(xPos, yPos, width, height);
            parent.fill(foreGround.getRGB());
            parent.text(text, xPos + (width / 2 - 3), yPos + height - 5);

        }
    }
}
