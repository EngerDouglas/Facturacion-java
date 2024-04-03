package logico;

import java.util.ArrayList;

public class Factura {
	
	private String codigo;
	private ArrayList<Componente>misComponentes;
	private ArrayList<Combo>misCombos;
	private Cliente cliente;
	
	
	public Factura(String codigo, ArrayList<Componente> misComponentes, ArrayList<Combo>misCombos, Cliente cliente) {
		super();
		this.codigo = codigo;
		this.misComponentes = misComponentes;
		this.cliente = cliente;
		this.misCombos = misCombos;
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
	
	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}

	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public float precioFactura () {
		float precio = 0;
		for(Componente aux: misComponentes) {
			precio += aux.precio;
		}
		return precio;
	}
	
	public float ventaTarjeta(){
		float total=0;
		for(Componente aux: misComponentes) {
			if(aux instanceof TarjetaMadre) {
				total += aux.precio;
			}
		}
		return total;
	}
	
	public float ventaCPU(){
		float total=0;
		for(Componente aux: misComponentes) {
			if(aux instanceof Microprocesador) {
				total += aux.precio;
			}
		}
		return total;
	}
	
	public float ventaDiscoDuro(){
		float total=0;
		for(Componente aux: misComponentes) {
			if(aux instanceof DiscoDuro) {
				total += aux.precio;
			}
		}
		return total;
	}
		
	
	public float ventaMemoriaRAM(){
		float total=0;
		for(Componente aux: misComponentes) {
			if(aux instanceof MemoriaRAM) {
				total += aux.precio;
			}
		}
		return total;
	}
		
	public int cantTarjetaMadreVendido() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof TarjetaMadre)
				cant++; 
		}
		return cant;
	}
	
	public int cantDiscoDuroVendido() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof DiscoDuro)
				cant++;
		}
		return cant;
	}
	
	public int cantMemoriaRAMVendido() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof MemoriaRAM)
				cant++;
		}
		return cant;
	}
	
	public int cantCPUVendido() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof Microprocesador)
				cant++;
		}
		return cant;
	}
	
	public int ComponentesVendidos()
	{
		int cant = 0;
		
		for(Componente aux : misComponentes)
		{
			if(aux instanceof Componente)
			{
				cant++;
			}
		}
		return cant;
	}	
	
}
