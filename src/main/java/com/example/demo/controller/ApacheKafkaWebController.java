package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.KafkaSender;

@RestController
@RequestMapping(value="/javainuse-kafka")
public class ApacheKafkaWebController {
	
   @Autowired
   KafkaSender kafkaSender;
	
   private final Logger logger=LoggerFactory.getLogger(ApacheKafkaWebController.class);
	
	@GetMapping(value="/producer")
	public String producer(@RequestParam("message") String message) {
		logger.debug("starts produecr message");
		kafkaSender.send(message);
		logger.debug("Afetr send() method ");
		return "Message sent to the kafka Topic java_in_use_topic succesfully";
		
	}
}
