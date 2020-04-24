package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import soundsystem.config.CDPlayerConfig;

public class ApplicationMain {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(CDPlayerConfig.class);
		CompactDisc disc = context.getBean(SgtPeppers.class);
		disc.play();
	}
}
