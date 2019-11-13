package com.example.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	List<Account> findByUserId(Long userId);
	Optional<Account> findByIdAndUserId(Long id, Long userId);
	
}
