package pandemic;

// TODO: Auto-generated Javadoc
/**
 * The Class fin.
 */
public class fin {

	/** The vacuna. */
	VacunasPor vacuna = new VacunasPor();
	
	/** The bc. */
	busc_ciudad bc = new busc_ciudad();
	
	/** The lp. */
	LeerParametros lp = new LeerParametros();
	
	private String letra = "T";

	/**
	 * Fin.
	 *
	 * @return true, if successful
	 */
	public boolean fin() {

		boolean fi = false;
		
		//System.out.println(vacuna.getALFA() + ", " + vacuna.getBETA() + ", " + vacuna.getDELTA() + ", " + vacuna.getGAMA());
		
		if (Puntuaciaons_Pandemic.getVacunas() == 4) {
			System.out.println("Has ganado");
			fi = true;
		}

		if (bc.contarInfecciones() > lp.EnfActDerrota || bc.contarBrotes() > lp.NumBroDerrota) {
			System.out.println("Has Perdido pringado");
			fi = true;		
		}

		return fi;

	}
	
	public String resultado() {
        return letra;
    }

    public void setLetra(String nuevaLetra) {
        letra = nuevaLetra;
    }

}
