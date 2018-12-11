package com.cg.mobshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.mobshop.dto.Mobiles;

@Repository
public class MobileDaoImpl implements MobileDao {
	
	@PersistenceContext
	EntityManager manager;

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Mobiles> getAllMobiles() {
		System.out.println("in dao class method....");
		String str = "select mobile from Mobiles mobile ";
		TypedQuery<Mobiles> query=
				manager.createQuery(str, Mobiles.class);
		return query.getResultList();
		
	}

	@Override
	public Mobiles getMobileDetails(int mobid) {
		Mobiles mobile=manager.find(Mobiles.class, mobid);
		return mobile;
	}

	@Override
	public int updateMobiles(Mobiles mob) {
		manager.merge(mob);
		return mob.getMobileId();
	}

	@Override
	public List<Mobiles> delete(int mobid) {
		
		Mobiles mobile=getMobileDetails(mobid);
		manager.remove(mobile);
		return getAllMobiles();
	}

	@Override
	public int addmobile(Mobiles mob) {
		manager.persist(mob);
		manager.flush();
		return mob.getMobileId();
	}

}
