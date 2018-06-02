package com.revature.dao;

import java.util.List;

import com.revature.beans.Vampire;

public interface VampireDao {

	public List<Vampire> getAllVampires();
	
	public void deleteVampire();
	
	public int insertVampire(Vampire v);
	
}
