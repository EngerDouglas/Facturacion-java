package logico;

public class TarjetaMadre extends Componente {
	private String modelo;
	private String tipoConector;
	private String tipoMemoriaRAM;
	private String tipoConexionDiscoDuro;
	
	public TarjetaMadre(String marca, String numeroSerie, float precio, int cantidad, String modelo, String tipoConector,
			String tipoMemoriaRAM, String tipoConexionDiscoDuro) {
		super(marca, numeroSerie, precio, cantidad);
		this.modelo = modelo;
		this.tipoConector = tipoConector;
		this.tipoMemoriaRAM = tipoMemoriaRAM;
		this.tipoConexionDiscoDuro = tipoConexionDiscoDuro;
	}
	public String getModelo() {
		return modelo;
	}
	public String getTipoConector() {
		return tipoConector;
	}
	public String getTipoMemoriaRAM() {
		return tipoMemoriaRAM;
	}
	public String getTipoConexionDiscoDuro() {
		return tipoConexionDiscoDuro;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setTipoConector(String tipoConector) {
		this.tipoConector = tipoConector;
	}
	public void setTipoMemoriaRAM(String tipoMemoriaRAM) {
		this.tipoMemoriaRAM = tipoMemoriaRAM;
	}
	public void setTipoConexionDiscoDuro(String tipoConexionDiscoDuro) {
		this.tipoConexionDiscoDuro = tipoConexionDiscoDuro;
	}
}
