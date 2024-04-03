package logico;

public abstract class Componente {
	protected String marca;
	protected String numeroSerie;
	protected float precio;
	protected char disponibilidad;
	protected int cantidad;
	public Componente(String marca, String numeroSerie, float precio,int cantidad) { 
		super();
		this.marca = marca;
		this.numeroSerie = numeroSerie;
		this.precio = precio;
		this.cantidad = cantidad;
		this.disponibilidad = 'D'; 
		
	}
	public String getMarca() {
		return marca;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public float getPrecio() {
		return precio;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public char getDisponibilidad() {
		
		return disponibilidad;
	}
	public void setDisponibilidad(char disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;

	}
	
	
	
}
