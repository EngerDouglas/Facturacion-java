package logico;

import java.util.ArrayList;

public class Combo {
	
	private String codigo;
	private ArrayList<Componente>misComponentes;
	private float precio;

	public Combo(String codigo, ArrayList<Componente> misComponentes, float precio) {
		super();
		this.codigo = codigo;
		this.misComponentes = misComponentes;
		this.precio = precio;
	}
	
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}

	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

}
