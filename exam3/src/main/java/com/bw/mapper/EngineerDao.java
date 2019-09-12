package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.bw.bean.Engineer;
import com.bw.bean.Profession;

public interface EngineerDao {
	Profession findByName(String pname);
	void insertEngineer(Engineer e);
	List<Profession> findAllProfession();
	List<Map<String, Object>> findAllEnfineer(Map<String, Object> map);
	int delAllEngineer(Integer[] eids);
	int delByEid(Integer eid);
	Engineer findByEid(Integer eid);
	int update(Engineer e);
}
