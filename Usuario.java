import java.util.regex.Pattern;

public class Usuario {
	//Atributos
	private String nombre;
	private int edad;
	private String DNI;
	
	//Constructor
	public Usuario(String nombre, int edad, String DNI) {
		this.nombre = nombre;
		this.edad = edad;
		this.DNI = DNI;
	}
	
	//Getters y setters	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad=edad;
	}
	
	public String getDNI() {
		return DNI;
	}
	
	//Comprobación del formato del DNI con expresiones regulares
	public boolean setDNI(String DNI) {
		String cDNI = "^[0-9]{8}-?[A-Z]{1}$";
		Pattern patron = Pattern.compile(cDNI);
		return patron.matcher(DNI).matches();
	}

	public String toString() {
	
		return "Usuario creado correctamente";
	}
	
}
