package it.contrader.model;


public class Staff {

	private int idStaff;
	private String nome;
	private String cognome;
	private String email;
	private String posizione;
	private int numeroTelefono;
	private String dataAssunzione;
	private String sede;
	private int oreSettimanali;
	private String codiceFiscale;
	
	public Staff(int idStaff, String nome, String cognome, String email, String posizione, int numeroTelefono,
			 String dataAssunzione, String sede, int oreSettimanali, String codiceFiscale) {
		this.setIdStaff(idStaff);
		this.setNome(nome);
		this.setCognome(cognome);
		this.setEmail(email);
		this.setPosizione(posizione);
		this.setNumeroTelefono(numeroTelefono);
		this.setDataAssunzione(dataAssunzione);
		this.setSede(sede);
		this.setOreSettimanali(oreSettimanali);
		this.setCodiceFiscale(codiceFiscale);

		
		
	}
	public int getIdStaff() {
		return idStaff;
	}
	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPosizione() {
		return posizione;
	}
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	public int getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getDataAssunzione() {
		return dataAssunzione;
	}
	public void setDataAssunzione(String dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	public int getOreSettimanali() {
		return oreSettimanali;
	}
	public void setOreSettimanali(int oreSettimanali) {
		this.oreSettimanali = oreSettimanali;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataAssunzione == null) ? 0 : dataAssunzione.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idStaff;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + numeroTelefono;
		result = prime * result + oreSettimanali;
		result = prime * result + ((posizione == null) ? 0 : posizione.hashCode());
		result = prime * result + ((sede == null) ? 0 : sede.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Staff other = (Staff) obj;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataAssunzione == null) {
			if (other.dataAssunzione != null)
				return false;
		} else if (!dataAssunzione.equals(other.dataAssunzione))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idStaff != other.idStaff)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroTelefono != other.numeroTelefono)
			return false;
		if (oreSettimanali != other.oreSettimanali)
			return false;
		if (posizione == null) {
			if (other.posizione != null)
				return false;
		} else if (!posizione.equals(other.posizione))
			return false;
		if (sede == null) {
			if (other.sede != null)
				return false;
		} else if (!sede.equals(other.sede))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Staff [idStaff=" + idStaff + ", idIterSelettivo=" + ", nome=" + nome + ", cognome="
				+ cognome + ", email=" + email + ", posizione=" + posizione + ", numeroTelefono=" + numeroTelefono
				+ ", dataAssunzione=" + dataAssunzione + ", sede=" + sede + ", oreSettimanali=" + oreSettimanali
				+ ", codiceFiscale=" + codiceFiscale + "]";
	}
	
	
}
