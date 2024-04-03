package logico;

public class DiscoDuro extends Componente {
	private String modelo;
	private float capacidadAlmacenamiento;
	private String tipoConexion;
	
	public DiscoDuro(String marca, String numeroSerie, float precio, int cantidad, String modelo, float capacidadAlmacenamiento,
			String tipoConexion) {
		super(marca, numeroSerie, precio, cantidad);
		this.modelo = modelo;
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
		this.tipoConexion = tipoConexion;
	}
	public String getModelo() {
		return modelo;
	}
	public float getCapacidadAlmacenamiento() {
		return capacidadAlmacenamiento;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setCapacidadAlmacenamiento(float capacidadAlmacenamiento) {
		this.capacidadAlmacenamiento = capacidadAlmacenamiento;
	}
	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}

}
