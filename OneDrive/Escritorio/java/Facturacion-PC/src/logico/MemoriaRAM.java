package logico;

public class MemoriaRAM extends Componente {
	private String tipoMemoria;
	private float cantMemoria;
	
	public MemoriaRAM(String marca, String numeroSerie, float precio, int cantidad, String tipoMemoria, float cantMemoria) {
		super(marca, numeroSerie, precio,cantidad);
		this.tipoMemoria = tipoMemoria;
		this.cantMemoria = cantMemoria;
	}
	public String getTipoMemoria() {
		return tipoMemoria;
	}
	public float getCantMemoria() {
		return cantMemoria;
	}
	public void setTipoMemoria(String tipoMemoria) {
		this.tipoMemoria = tipoMemoria;
	}
	public void setCantMemoria(float cantMemoria) {
		this.cantMemoria = cantMemoria;
	}
}
