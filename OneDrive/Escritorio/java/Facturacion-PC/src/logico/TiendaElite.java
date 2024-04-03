package logico;

import java.util.ArrayList;

public class TiendaElite {
	
	private ArrayList<Componente>misComponentes;
	private ArrayList<Factura>misFacturas;
	private ArrayList<Cliente>misClientes;
	private ArrayList<Combo>misCombos;
	public static int codigo_componente = 1;
	public static int codigo_factura = 1;
	public static int codigo_combo = 1;
	public static TiendaElite tienda = null;
	
	public TiendaElite() {
		super();
		this.misComponentes = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.misClientes = new ArrayList<>();
		this.misCombos = new ArrayList<>();
	}
	
	public static TiendaElite getInstance()
	{
		if(tienda == null)
		{
			tienda = new TiendaElite();
		}
		return tienda;
	}
	
	public ArrayList<Componente> getMisComponentes() {
		return misComponentes;
	}
	public void setMisComponentes(ArrayList<Componente> misComponentes) {
		this.misComponentes = misComponentes;
	}
	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}
	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}
	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}
	public ArrayList<Combo> getMisCombos() {
		return misCombos;
	}
	public void setMisCombos(ArrayList<Combo> misCombos) {
		this.misCombos = misCombos;
	}
	public static int getCodigo_componente() {
		return codigo_componente;
	}
	public static void setCodigo_componente(int codigo_componente) {
		TiendaElite.codigo_componente = codigo_componente;
	}
	public static int getCodigo_factura() {
		return codigo_factura;
	}
	public static void setCodigo_factura(int codigo_factura) {
		TiendaElite.codigo_factura = codigo_factura;
	}
	public static int getCodigo_combo() {
		return codigo_combo;
	}
	public static void setCodigo_combo(int codigo_combo) {
		TiendaElite.codigo_combo = codigo_combo;
	}
	public static TiendaElite getTienda() {
		return tienda;
	}
	public static void setTienda(TiendaElite tienda) {
		TiendaElite.tienda = tienda;
	}
	
	public void insertarComponente(Componente componente) { 
		misComponentes.add(componente);
		codigo_componente++;
	}
	
	public void insertarFactura(Factura factura) { 
		misFacturas.add(factura);
		codigo_factura++;
	}
	public void insertarClientes(Cliente cliente) {
		misClientes.add(cliente);
	}
	
	public void insertarCombo(Combo combo) {
		misCombos.add(combo);
		codigo_combo++;
	}
	
	
	public int cantTarjetaMadreDisponible() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof TarjetaMadre)
				cant++;
		}
		return cant;
	}
	
	public int cantDiscoDuroDisponible() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof DiscoDuro)
				cant++;
		}
		return cant;
	}
	
	public int cantMemoriaRAMDisponible() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof MemoriaRAM)
				cant++;
		}
		return cant;
	}
	
	public int cantCPUDisponible() {
		int cant = 0;
		for(Componente aux: misComponentes) {
			if(aux instanceof Microprocesador)
				cant++;
		}
		return cant;
	}
	
	public float dineroTotalGenerado() {
		float total = 0;
		for(Factura aux: misFacturas) {
			total += aux.precioFactura();
		}
		return total;
		//retorna la cantidad de dinero vendido en la tienda
	}
	
	public Cliente buscarClienteByCedula(String cedula) {
		Cliente cliente = null;
		
		for (Cliente aux : misClientes) {
			if (aux.getCedula().equalsIgnoreCase(cedula)) {
				cliente = aux;
			
			}
		}
		return cliente;
	}
	
	public Factura buscarFacturaBycodigo(String codigo) {
		Factura factura = null;

		for (Factura aux : misFacturas) {
			if (aux.getCodigo().equalsIgnoreCase(codigo)) {
				factura = aux;
			}
		}
		return factura;

	}

	
	public Componente buscarComponenteBySerial(String codigo) {
		Componente componente = null;
		
		for(Componente aux: misComponentes) {
			if(aux.getNumeroSerie().equalsIgnoreCase(codigo)) {
				
			    componente = aux;
			}
		}
		return componente;
	}
	
	public int buscarComponenteIndexBySerial(String codigo)
	{
		boolean encontrado = false;
		int ind = -1;
		int i = 0;
		
		while(!encontrado && i < misComponentes.size())
		{
			if(misComponentes.get(i).getNumeroSerie().equalsIgnoreCase(codigo))
			{
				ind = i;
				encontrado = true;
			}
			i++;
		}
		return ind;
	}
	
	
	public boolean reabastecer (int cantidad , String serial) {
		Componente componente = buscarComponenteBySerial(serial);
		boolean realizado = false;
		if( componente != null) {
			int suma = cantidad + componente.getCantidad();
			componente.setCantidad(suma);
			realizado = true;
		}
		return realizado;
	}
	
	public void Disponibilidad(String codigo) {
		Componente componente = buscarComponenteBySerial(codigo);
		if( componente != null) {
			if(componente.getCantidad() <= 3) {
				componente.setDisponibilidad('C');
			}
		}
		
	}
	
	public boolean serialExiste(String serial) {
		boolean existe = false;
		for(Componente aux: misComponentes) {
			if(aux.getNumeroSerie().equalsIgnoreCase(serial)) {
				existe = true;
			}
		}
		return existe;
	}
	
	
	
	
	
	
	
	

}
