package negocio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import data.DataPersonaje;
import entidades.*;

public class CtrlABMPersonaje {

	private ArrayList<Personaje> personajes;
	
	private data.DataPersonaje dataPer;
	
	public CtrlABMPersonaje(){
		personajes = new ArrayList<Personaje>();
		dataPer=new DataPersonaje();
	}
	
	public void add(Personaje p) {
		p.setPtos_totales(200);
		dataPer.add(p);
		/*if(datosValidos(p)){
			dataPer.add(p);
		}*/
			
	}
	
	public void update(Personaje p, String nom){
		dataPer.update(p, nom);
	}
	
	public void delete(int cod, String nom){
		dataPer.delete(cod, nom);
	}
	
	public Personaje getPersonaje (String nom){
		return dataPer.getByNombre(nom);
	}
	
	public Personaje getPersonaje (int cod){
		return dataPer.getByCodigo(cod);
	}
	
	public boolean coincideNombre (String nom){
		return dataPer.coincideNombre(nom);
	}
	
	public boolean coincideCodNom (int cod, String nom){
		return dataPer.coincideCodigoNom(cod, nom);
	}


	//Validar datos del personaje antes de la carga al la bd
	public boolean datosValidos(Personaje p){
		boolean valido=true;
		int suma=0;

		if(p.getDefensa()>20 )
		{
			 JOptionPane.showMessageDialog(null, "LA DEFENSA NO DEBE SER MAYOR A 20");
			 valido=false;
		}
		
		if(p.getEvasion()>80)
		{
			JOptionPane.showMessageDialog(null, "LA EVASION NO DEBE SER MAYOR A 80");
			valido=false;
		}
		

		if (valido==true)
		{
		//int resto=0;
		 suma= p.getDefensa() + p.getEvasion() + p.getVida() + p.getEnergia();
			 if(suma>200)
			 {
				 JOptionPane.showMessageDialog(null, "PUNTOS ASIGNADOS MAYORES A LOS TOTALES");
				 valido=false;
			 }
		}
		
		return valido;
		
	}
	
//FUNCION PARA COMPROBAR SI UN STRING ES UN NUMERO
	/*public boolean isNumber(int valor){
		int val;
		try
		{
			val = Integer.parseInt(valor);
			return true;
		}catch(Exception e){
			return false;
		}
	}*/
}
