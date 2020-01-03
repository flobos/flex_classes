package libreria_alm;

public class Conferencia {
	private int confId;
	private String conf_nombre;
	private String tip_conf_idn;
	private String conf_max_capacidad;
	private String conf_fecha_creacion;
	private String conf_fecha_inicio;
	private String conf_duracion;
	private String est_conf_idn;
    
    public Conferencia() {
    	
    }
   
    public Conferencia(int confId, String conf_nombre,  String tip_conf_idn,  String conf_max_capacidad,  String conf_fecha_creacion, String conf_fecha_inicio, String conf_duracion,String est_conf_idn) {
		
    	this.confId = confId;
		this.conf_nombre = conf_nombre;
		this.tip_conf_idn = tip_conf_idn;
		this.conf_max_capacidad = conf_max_capacidad;
		this.conf_fecha_creacion = conf_fecha_creacion;
		this.conf_fecha_inicio = conf_fecha_inicio;
		this.conf_duracion = conf_duracion;
		this.est_conf_idn = est_conf_idn;
		
//		System.out.println("\n\n"+this.conf_idn+"/"+this.conf_nombre+"/"+this.est_conf_idn+"/"+this.tip_conf_nombre+"/"+this.hora_inicio+"/"+this.conf_duracion+"\n\n");
	}   

    public void set_confId(int confId) {
		this.confId = confId;
	}
    public int get_confId() {
		return confId;
	}
    
    public void set_conf_nombre(String conf_nombre) {
		this.conf_nombre = conf_nombre;
	}
	public String get_conf_nombre() {
		return conf_nombre;
	}
	
	public void set_tip_conf_idn(String tip_conf_idn) {
		this.tip_conf_idn = tip_conf_idn;
	}
	public String get_tip_conf_idn() {
		return tip_conf_idn;
	}
	
	
	public void set_conf_max_capacidad(String conf_max_capacidad) {
		this.conf_max_capacidad = conf_max_capacidad;
	}
	public String get_conf_max_capacidad() {
		return conf_max_capacidad;
	}
	
	public void set_conf_fecha_creacion(String conf_fecha_creacion) {
		this.conf_fecha_creacion = conf_fecha_creacion;
	}
	public String get_conf_fecha_creacion() {
		return conf_fecha_creacion;
	}
	
	
	
	public void set_conf_fecha_inicio(String conf_fecha_inicio) {
		this.conf_fecha_inicio = conf_fecha_inicio;
	}
	public String get_conf_fecha_inicio() {
		return conf_fecha_inicio;
	}
	
	
	public void set_conf_duracion(String conf_duracion) {
		this.conf_duracion = conf_duracion;
	}
	public String get_conf_duracion() {
		return conf_duracion;
	}
	
	public void set_est_conf_idn(String est_conf_idn) {
		this.est_conf_idn = est_conf_idn;
	}
	public String get_est_conf_idn() {
		return est_conf_idn;
	}
}