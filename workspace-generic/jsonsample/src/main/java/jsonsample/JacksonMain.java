package jsonsample;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonMain {

	public static void main(String[] args){
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		try {
			User user = mapper.readValue(new File("src\\main\\resources\\user.json"), User.class);
			System.out.println(user);
			mapper.writeValue(new File("src\\main\\resources\\user-modified.json"), user);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
