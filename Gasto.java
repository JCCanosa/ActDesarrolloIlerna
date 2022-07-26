
public class Gasto extends Dinero{
	
	public Gasto(double gasto, String descripcion){
		this.dinero=gasto;
		this.descripcion=descripcion;
	}
	
	public String toString() {
		return "Gasto: " + descripcion + ", cantidad: " + dinero +"€";
	}
	
}
