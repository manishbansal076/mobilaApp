package com.cg.mobshop.dao;

import java.util.List;

import com.cg.mobshop.dto.Mobiles;

public interface MobileDao {
	
	public List<Mobiles> getAllMobiles();
	public Mobiles getMobileDetails(int mobid);
	public int updateMobiles(Mobiles mob);
	public List<Mobiles> delete(int mobid);
	public int addmobile(Mobiles mob);

}
