package com.example.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserBalanceController {
	
	@Autowired
	private UserRepository userRepository;
	

	
	@GetMapping("/usersBalance/{id}")
	public UserBalanceVO retrieveUser(@PathVariable long id)
	{
		Optional<User> optionalUser=userRepository.findById(id);
		if(!optionalUser.isPresent())
			throw new UserNotFoundException("id-"+id);
		
		UserBalanceVO vo=new UserBalanceVO();
		User user =optionalUser.get();
		vo.setFullName(user.getFirstName()+" "+user.getLastName());
		Double totalBalance=new Double(0);
		for(Account account :user.getAcounts())
		{
			totalBalance=totalBalance+account.getBalance();
		}
		vo.setTotalBalance(totalBalance);
		return vo;
	}
	
}
