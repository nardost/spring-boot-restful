package org.sbootrestful.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.sbootrestful.model.Account;

public interface AccountRepository extends JpaRepository<Account,Long> {

	Optional<Account> findByUsername(String username);
}