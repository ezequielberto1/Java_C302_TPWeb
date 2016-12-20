package entidades;

public class Personaje {
	private int codigo, vida, energia, defensa, evasion, ptos_totales, energiaPartida, vidaPartida;
	private String nombre;

	public Personaje(){
		this.setDefensa(0);
		this.setVida(0);
		this.setEnergia(0);
		this.setEvasion(0);
		this.setPtos_totales(200);
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getEnergia() {
		return energia;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getEvasion() {
		return evasion;
	}
	public void setEvasion(int evasion) {
		this.evasion = evasion;
	}

	public int getPtos_totales() {
		return ptos_totales;
	}
	public void setPtos_totales(int ptos_totales) {
		this.ptos_totales = ptos_totales;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEnergiaPartida() {
		return energiaPartida;
	}

	public void setEnergiaPartida(int energiaPartida) {
		this.energiaPartida = energiaPartida;
	}

	public int getVidaPartida() {
		return vidaPartida;
	}

	public void setVidaPartida(int vidaPartida) {
		this.vidaPartida = vidaPartida;
	}	

	public void setEnergiaPartida() {
		this.energiaPartida = this.energia;
	}

	public void setVidaPartida() {
		this.vidaPartida = this.vida;
	}

	public boolean atacar(int ataque, int evasionOponente){

		setEnergiaPartida(getEnergiaPartida()-ataque);
		if((Math.random() * 100) > evasionOponente)	
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public void recibirAtaque(int ataque){

		setVidaPartida(getVidaPartida()-ataque);

	}

	public void defender(){
		int energiaARecuperar, vidaARecuperar;
		energiaARecuperar = getEnergiaPartida() * getDefensa() / 100;
		if ((energiaARecuperar + getEnergiaPartida()) > getEnergia())
		{
			setEnergiaPartida(getEnergia());
		}
		else
		{
			setEnergiaPartida(getEnergiaPartida()+energiaARecuperar) ;
		}
		vidaARecuperar = getVidaPartida() * getDefensa() / 250;
		if ((vidaARecuperar + getVidaPartida())> getVida())
		{
			setVidaPartida(getVida());
		}
		else{
			setVidaPartida(getVidaPartida()+vidaARecuperar);
		}
	}
}
