package logico;

public class Microprocesador extends Componente {
	private String modelo;
	private String tipoConexion;
	private float velocidadProcesamientos;
	
	public Microprocesador(String marca, String numeroSerie, float precio, int cantidad, String modelo, String tipoConexion,
			float velocidadProcesamientos) {
		super(marca, numeroSerie, precio, cantidad);
		this.modelo = modelo;
		this.tipoConexion = tipoConexion;
		this.velocidadProcesamientos = velocidadProcesamientos;
	}
	public String getModelo() {
		return modelo;
	}
	public String getTipoConexion() {
		return tipoConexion;
	}
	public float getVelocidadProcesamientos() {
		return velocidadProcesamientos;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setTipoConexion(String tipoConexion) {
		this.tipoConexion = tipoConexion;
	}
	public void setVelocidadProcesamientos(float velocidadProcesamientos) {
		this.velocidadProcesamientos = velocidadProcesamientos;
	}
}
