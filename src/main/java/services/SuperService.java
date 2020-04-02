package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import daos.SuperDAO;


@Service
public class SuperService {

private SuperDAO dao;
	
	@Autowired
	public void setDao(SuperDAO dao) {
		this.dao = dao;
	}
	
	
}
