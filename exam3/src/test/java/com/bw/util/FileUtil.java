package com.bw.util;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bw.bean.Engineer;
import com.bw.bean.Profession;
import com.bw.mapper.EngineerDao;

public class FileUtil {
	@Test
	public void examTest() throws IOException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		EngineerDao dao = ac.getBean(EngineerDao.class);
		URL url = FileUtil.class.getClassLoader().getResource("exam.txt");
		 BufferedReader br = new BufferedReader(new FileReader(url.getFile()));
		 String str = null;
		 while((str =  br.readLine())!= null){
			String[] split = str.split("\\|");//按行读取的数据进行切割
			Profession p1;
			Profession p2;
			if(split[6] != null && !"".equals(split[6].trim())){//当名字不为null的时候，有值
				//获取所选专业1的id
				p2 = dao.findByName(split[6]);
			}else{
				//专业名字为空的时候,空对象
				p2 = new Profession();
			}
			
			Engineer e = new Engineer(null, split[0], split[1], split[2], split[3], split[4], (p1 = dao.findByName(split[5])) == null ? 0 :p1.getPid() ,p2.getPid(), split[7], Integer.parseInt(split[8]), split[9]);
			dao.insertEngineer(e);
		 }
		 br.close();
	}
	
	
}
