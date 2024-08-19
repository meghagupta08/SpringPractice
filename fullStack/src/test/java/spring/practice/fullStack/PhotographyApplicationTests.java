package spring.practice.fullStack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PhotographyApplicationTests {


	@Value("${app.info}")
	private String appName;


	@Value("${app.description}")
	private String appDescription;


	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void beforeEachMethod(){
		System.out.println("Application Name is:"+appName+"  \nApplication description:"+appDescription);
	}

}
