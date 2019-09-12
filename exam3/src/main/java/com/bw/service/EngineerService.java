package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.bean.Engineer;
import com.bw.bean.Profession;

public interface EngineerService {

	List<Profession> findAllProfession();

	List<Map<String, Object>> findAllEnfineer(Map<String, Object> map);

	boolean delAllEngineer(Integer[] eids);

	boolean delByEid(Integer eid);

	Engineer findByEid(Integer eid);

	boolean update(Engineer e);

}
