package com.API.Info;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class InfoDAO {
private static List<Infos> list = new ArrayList<>();
	
	static {
		list.add(new Infos(1, "Zeak London", "America", 987654321));
		list.add(new Infos(2, "Michela", "America", 965478321));
		list.add(new Infos(3, "Jared", "Londom", 943287906));
	}
	public List<Infos> getAllInfos()
	{	
		return list;
	}
	public void addInfo(Infos b) {
		list.add(b);
	}
	
}
