package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Vampire;
import com.revature.util.HibernateUtil;

public class VampireImpl implements VampireDao{

	public List<Vampire> getAllVampires() {
		List<Vampire> vampires = new ArrayList<Vampire>();
		Session s = HibernateUtil.getSession();
		vampires = s.createQuery("from Vampire").list();
		s.close();
		return vampires;
	}

	public void deleteVampire() {
		// TODO Auto-generated method stub
		
	}

	public int insertVampire(Vampire v) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (Integer) s.save(v);
		tx.commit();
		s.close();
		return result;
		
	}

	
	
}
