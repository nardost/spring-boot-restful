package org.sbootrestful.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import org.sbootrestful.model.Usernames;

public interface UsernamesRepository extends JpaRepository<Usernames,Long> {

	Collection<Usernames> findByAccountUsername(String username);
	
}