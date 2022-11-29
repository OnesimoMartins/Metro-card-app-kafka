package ao.martins.colossosdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ColossosDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColossosDeliveryApplication.class, args);
		Integer x=0;
		Integer y=0;
		Integer a=10000;
		Integer b=10000;
		System.out.println((a==b)+";"+(x==y));
	}

}
