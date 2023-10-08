package com.bs.sms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
public class SmsController {

        @GetMapping(value = "/sendSMS")
        public ResponseEntity<String> sendSMS(String phoneNumber, String message) {

//                Twilio.init(System.getenv("TWILIO_ACCOUNT_SID"), System.getenv("TWILIO_AUTH_TOKEN"));
//
//                Message.creator(new PhoneNumber("<TO number - ie your cellphone>"),
//                                new PhoneNumber("<FROM number - ie your Twilio number"), "Hello from Twilio 📞").create();
        	
        	System.out.println("I m in sendSMS method");
        	
        	Twilio.init("AC18af237fe0f64da1a4da35a2af8e7be6", "0bc37ef911b1e408732e8670ef1f82da");

        	System.out.println("Twilio init success");
            Message.creator(
            		new PhoneNumber(phoneNumber),
                    new PhoneNumber("+15074193641"), 
                    message)
            	.create();

            System.out.println("Message create success");
            
            return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
        }
}

/** Twilio account credential
saifurcmosh18@gmail.com
saifur@@BILKIZsoft2020!!
**/
