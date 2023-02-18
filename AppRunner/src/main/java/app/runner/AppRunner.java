package app.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*public class AppRunner {
	public static void main(String[] args) {
		String[] ary= {"SAgar"};
		SpringApp1.main(ary);
		SpringApp2.main(ary);
	}
}*/

@SpringBootApplication
@ComponentScan(basePackages = { "com.SpringApp1.*", "com.SpringApp2.*" })
public class AppRunner {
	public static void main(String[] args) {
		SpringApplication.run(AppRunner.class, args);
	}
}