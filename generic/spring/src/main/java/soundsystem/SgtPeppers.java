package soundsystem;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {

	private String title = "Sgt. Peppers Lovely Hearts Club Band";
	private String artist = "The Beatles";
	
    @Value("#{T(System).currentTimeMillis()}")
    private String time;
    
	public void play() {
		System.out.println("Playing "+ title+" by "+artist);
		System.out.println("Locale = "+time);
	}

}
