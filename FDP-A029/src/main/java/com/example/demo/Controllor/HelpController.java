package com.example.demo.Controllor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Ticket;
import com.example.demo.Model.User;
import com.example.demo.Service.HelpService;
import com.example.demo.Service.LoginService;

@RestController
public class HelpController {

	@Autowired
	HelpService helpService;
	
	/*method used to check the insert details of the ticket*/

	@PostMapping("/help/insertTicket")
	@CrossOrigin(origins = "http://localhost:4200")
	public Ticket insertTicket(@RequestBody Ticket ticket) {

		Ticket u = helpService.insertTicket(ticket);
		return u;

	}
	
	/*Method used to get details of the user*/

	@GetMapping("getAllHelpRequests")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Ticket> getHelpRequests() {
		return helpService.getRequests();

	}
	
	@PostMapping("/updateResolution")
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean updateTicket(@RequestBody Ticket ticket) {
	
		return helpService.updateTicket(ticket);


	}
}
