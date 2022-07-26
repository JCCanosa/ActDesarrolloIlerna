import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws GastoException {
		// Variables inicializadas.
		String nombreUsuario="";
		int edadUsuario=0;
		String DNIUsuario="";
		String descGasto="";
		double cantGasto=0;
		String descIngreso="";
		double cantIngreso=0;
		double saldoCuenta = 0;
		ArrayList<Gasto> gastos = new ArrayList<Gasto>();
		ArrayList<Ingreso> ingresos = new ArrayList<Ingreso>();
		int opcion=0;
				
		//Clase scanner para lectura por teclado.
		Scanner lector = new Scanner(System.in);
		
		//Instanciacion de clases
		Usuario usuario = new Usuario(nombreUsuario,edadUsuario,DNIUsuario);
		Gasto gasto = new Gasto(cantGasto, descGasto);
		Ingreso ingreso = new Ingreso(cantIngreso, descIngreso);
		Cuenta cuenta = new Cuenta(saldoCuenta, usuario, gastos, ingresos);
		GastoException excepcion = new GastoException();
		
		//Creación de usuario
		System.out.println("Introduce el nombre de usuario");
		nombreUsuario = lector.nextLine();
		usuario.setNombre(nombreUsuario);
		System.out.println("Introduce la edad del usuario");
		edadUsuario = lector.nextInt();
		usuario.setEdad(edadUsuario);
		System.out.println("Introduce el DNI del usuario");
		DNIUsuario = lector.next();
		usuario.setDNI(DNIUsuario);
		
		//Comprovación del formato del DNI
		while(usuario.setDNI(DNIUsuario) != true) {
			System.out.println("DNI introducido incorrecto");
			System.out.println("Introduce el DNI del usuario válido");
			DNIUsuario = lector.next();
		}
		System.out.println(usuario.toString());
		System.out.println();
		
		//Menú de opciones de la aplicación.
		do {
		System.out.println("Realiza una nueva acción");
		System.out.println("1 Introduce un nuevo gasto");
		System.out.println("2 Introduce un nuevo ingreso");
		System.out.println("3 Mostrar gastos");
		System.out.println("4 Mostrar ingresos");
		System.out.println("5 Mostrar saldo");
		System.out.println("0 Salir");
		System.out.println();
		opcion=lector.nextInt();
		lector.nextLine();
		
		//Casos de elección del menú
		switch(opcion) {
		//Introduccion de gastos con excepción
		case 1:
			System.out.println("Introduce la descripcion");
			descGasto = lector.nextLine();
			gasto.setDescripcion(descGasto);
			System.out.println("Introduce la cantidad");
			cantGasto = lector.nextDouble();
			lector.nextLine();
			try {
				if(cantGasto > saldoCuenta) {
					throw new GastoException();
				} else {
					gasto.setDinero(cantGasto);
					gastos.add(new Gasto(cantGasto, descGasto));
					saldoCuenta = saldoCuenta - cantGasto;
					cuenta.setSaldo(saldoCuenta);
					System.out.println("Saldo restante: " + cuenta.getSaldo()+"€");
					System.out.println();
				}
			}catch(Exception e) {
				System.out.println(excepcion.getMessage());
			}	
			break;
			
		//Introduccion de ingresos	
		case 2:
			System.out.println("Introduce la descripcion");
			descIngreso = lector.nextLine();
			ingreso.setDescripcion(descIngreso);
			System.out.println("Introduce la cantidad");
			cantIngreso = lector.nextDouble();
			lector.nextLine();
			ingreso.setDinero(cantIngreso);
			ingresos.add(new Ingreso(cantIngreso,descIngreso));	
			saldoCuenta = saldoCuenta + cantIngreso;
			cuenta.setSaldo(saldoCuenta);
			System.out.println("Saldo restante: " + cuenta.getSaldo()+"€");
			System.out.println();
			break;
		
		//Mostrar el arraylist de los gastos
		case 3:
			for(int i=0; i<gastos.size(); i++) {
				System.out.println(cuenta.getGastos().get(i));
			}
			System.out.println();
			break;
			
		//Mostrar el arraylist de los ingresos
		case 4:
			for(int i=0; i<ingresos.size(); i++) {
				System.out.println(cuenta.getIngresos().get(i));
			}
			System.out.println();
			break;
		
		//Mostrar saldo total
		case 5:
			System.out.println(cuenta.toString());
			System.out.println();
			break;
		}
		}while (opcion !=0);
		
		//Mensaje fin programa y cierre de Scanner
		System.out.println("Fin del programa.");
		System.out.println("Gracias por utilizar la aplicación.");
		lector.close();
		}
}
