import java.util.Locale;
import java.util.Scanner;
import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class TTS {

	  static final String VOICES = "freetts.voices";
	 static final String VOICEDIR = "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory";
	
	public static void main(String[] args) {
		//version with input from user 
		try {
			Scanner s= new Scanner(System.in);
			String text= s.nextLine();
			System.setProperty(VOICES, VOICEDIR);
			Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");		
			Synthesizer syn = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
			syn.allocate();
			syn.resume();
			syn.speakPlainText(text, null);
			syn.waitEngineState(Synthesizer.QUEUE_EMPTY);
			syn.deallocate();
			s.close();
	}catch(Exception e) {
		e.printStackTrace();
	}	
		//version with input from code
		/*try {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us"+ ".cmu_us_kal.KevinVoiceDirectory");
		
		
		Synthesizer syn= Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
		syn.allocate();
		syn.resume();
		syn.speakPlainText("im good, what about you Zoubir?", null);
		syn.waitEngineState(Synthesizer.QUEUE_EMPTY);
		syn.deallocate();
	}
	catch(Exception exce) {
		exce.printStackTrace();
	}*/
	
}
}
