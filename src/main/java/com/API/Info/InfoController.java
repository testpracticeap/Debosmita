package com.API.Info;

import java.util.List;
import com.API.Info.InfoDAO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
	@Autowired
	private InfoDAO infodao;

	@GetMapping("/infos")
	public List<Infos> getInfos() {

		return this.infodao.getAllInfos();
	}
	
	@PostMapping("/infos")
	public Infos addInfos(@RequestBody Infos info) {
		this.infodao.addInfo(info);
		return info;
	}
}
