package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.bean.Engineer;
import com.bw.bean.Profession;
import com.bw.service.EngineerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class EngineerController {
	@Resource
	private EngineerService es;
	
	@RequestMapping("findAllProfession.do")
	@ResponseBody
	public List<Profession> findAllProfession() {
		List<Profession> list = es.findAllProfession();
		return list;
	}
	@RequestMapping("list.do")
	public String findAllEnfineer(ModelMap mm,String sname,String areaname,Integer pid,@RequestParam(required=false,defaultValue="1")Integer pageNum) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("sname", sname);
		map.put("areaname", areaname);
		map.put("pid", pid);
		PageHelper.startPage(pageNum, 10);
		List<Map<String, Object>> list = es.findAllEnfineer(map);
		PageInfo<Map<String, Object>> page = new PageInfo<Map<String, Object>>(list);
		mm.put("page", page);
		return "list";
	}
	@RequestMapping("delAllEngineer.do")
	@ResponseBody
	public boolean delAllEngineer(Integer[] eids) {
		boolean b = es.delAllEngineer(eids);
		return b;
	}
	@RequestMapping("delByEid.do")
	@ResponseBody
	public boolean delByEid(Integer eid) {
		boolean b = es.delByEid(eid);
		return b;
	}
	@RequestMapping("toUpdate.do")
	@ResponseBody
	public Map<String, Object> toUpdate(Integer eid) {
		List<Profession> list = es.findAllProfession();
		Engineer e = es.findByEid(eid);
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("list",list);
		map.put("e",e);
		return map;
	}
	@RequestMapping("update.do")
	@ResponseBody
	public boolean update(Engineer e) {
		boolean b = es.update(e);
		return b;
	}
}
