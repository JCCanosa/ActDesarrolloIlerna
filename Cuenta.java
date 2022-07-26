import java.util.ArrayList;

public class Cuenta {
	
	//Atributos
	private double saldo;
	private Usuario usuario;
	private ArrayList<Gasto>gastos;
	private ArrayList<Ingreso>ingresos;
	
	//Constructor
	public Cuenta(double saldo, Usuario usuario, ArrayList<Gasto>gastos, ArrayList<Ingreso>ingresos) {
		this.saldo = 0;
		this.usuario = usuario;
		this.gastos=gastos;
		this.ingresos=ingresos;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo=saldo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario=usuario;
	}
	public double addIngresos(String description, double cantidad) {
		return saldo;
	}
	public double addGastos(String description, double cantidad) {
		return saldo;
	}
	public ArrayList<Ingreso> getIngresos(){
		return ingresos;
	}
	public ArrayList<Gasto> getGastos(){
		return gastos;
	}
	
	public String toString() {
		return "El saldo del usuario " + usuario.getNombre() + " es de: " + saldo +"€";
	}
	
}
