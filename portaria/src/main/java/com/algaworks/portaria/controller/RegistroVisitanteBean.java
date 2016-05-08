package com.algaworks.portaria.controller;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.portaria.model.Visitante;
import com.algaworks.portaria.repository.Visitantes;

@Named
@ViewScoped
public class RegistroVisitanteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FotoCameraBean fotoCamera;
	
	@Inject
	private Visitantes visitantes;

	private Visitante visitante;
	
	private List<Visitante> todosVisitantes;
	
	public void consultar(){
		todosVisitantes = visitantes.todos();
	}
	
	public void novo(){
		visitante = new Visitante();
		fotoCamera.limpar();
	}
	
	public void adicionar(){
		visitante.setDataVisita(new Date());
		visitante.setFoto(fotoCamera.getFotoByte());
		
		visitantes.guardar(visitante);
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public List<Visitante> getTodosVisitantes() {
		return todosVisitantes;
	}
	
	

}
