package com.dimon.presentation;

import com.dimon.services.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] arg){
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Starting lab 2 application");

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationService service = applicationContext.getBean(ApplicationService.class);

        //service.listAllEntities().forEach(item ->
        //        System.out.println(item.getId() + " " + item.getName() + " " + item.getPrice()));
        logger.info("Creating records...");
        try {
            service.create100RandomStudents();
        } catch(Exception e){
            logger.error(e.getMessage());
        }

        //service.listAllEntities().forEach(item ->
        //        System.out.println(item.getId() + " " + item.getName() + " " + item.getPrice()));
        logger.info("Output duplication students...");
        try {
            service.outputDuplicateStudents();
        } catch (Exception e){
            logger.error(e.getMessage());
        }
        logger.info("Closing lab 2 application");

    }

}
