package com.studentstay.app.Services;

import java.util.List;

import com.studentstay.app.Entity.Cantones;

public interface ICantonesService {

	public List<Cantones> finAll();

	public Cantones save (Cantones cantones);
	
	public Cantones findById(String id_canton);
	
	public void delete (String id_canton);
}
