package com.bw.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.bean.Engineer;
import com.bw.bean.Profession;
import com.bw.mapper.EngineerDao;

@Service
public class ImpEngineerService implements EngineerService{
	@Resource
	private EngineerDao dao;

	@Override
	public List<Profession> findAllProfession() {
		// TODO Auto-generated method stub
		return dao.findAllProfession();
	}

	@Override
	public List<Map<String, Object>> findAllEnfineer(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.findAllEnfineer(map);
	}

	@Override
	public boolean delAllEngineer(Integer[] eids) {
		int i = dao.delAllEngineer(eids);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean delByEid(Integer eid) {
		int i = dao.delByEid(eid);
		if(i>0){
			return true;
		}
		return false;
	}

	@Override
	public Engineer findByEid(Integer eid) {
		// TODO Auto-generated method stub
		return dao.findByEid(eid);
	}

	@Override
	public boolean update(Engineer e) {
		int i = dao.update(e);
		if(i>0){
			return true;
		}
		return false;
	}
}
