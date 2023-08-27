package com.app.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Category;
import com.app.entities.Product;
import com.app.repository.ICategoryRepository;

@Transactional
@Service
public class CategoryServiceImpl {

	
	@Autowired
	private ICategoryRepository categoryDao;
	
	
	
}
