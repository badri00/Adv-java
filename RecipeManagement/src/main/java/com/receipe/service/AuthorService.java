package com.receipe.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.receipe.repository.AuthorRepository;

@Service
@Transactional
public class AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private ModelMapper mapper;
	
}
