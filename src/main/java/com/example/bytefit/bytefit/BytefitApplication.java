package com.example.bytefit.bytefit;

import com.example.bytefit.bytefit.repository.FoodRepository;
import com.example.bytefit.bytefit.repository.UserRepository;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class BytefitApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FoodRepository foodRepository;

    public static void main(String[] args) {
        SpringApplication.run(BytefitApplication.class, args);
    }

    public void run(String... args) throws Exception {

        MongoOperations mongoOps = new MongoTemplate(MongoClients.create(), "byteFitJava");

        if (!mongoOps.collectionExists("foods")) {
            mongoOps.createCollection("foods");
            log.info("Foods collection created successfully.");
            startupDataInsert("foodDataInsert.sh");

        }
        if (!mongoOps.collectionExists("users")) {
            mongoOps.createCollection("users");
            log.info("Users collection created successfully.");
            startupDataInsert("userDataInsert.sh");
        }

        System.out.println("result" + mongoOps.findById("5e63c7d3c21346494552f108", String.class, "foods"));
//        mongoOps.insert((new Users("brandnewjacobo@hotmail.co.uk","jay123")), "users");

    }

    private void startupDataInsert(String fileName) {
        try {
            String target = new String("/Users/jacobedwards/Documents/gitHub/bytefit-java/src/main/resources/" + fileName);
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(target);
            proc.waitFor();
            StringBuffer output = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
            log.info("Startup data successfully inserted.");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
