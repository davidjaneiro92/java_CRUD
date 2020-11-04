package br.com.exemplo.model;

public class Leitor {
	//Atributos 
	
	private int codLeitoe;
	private String nomeLeitor;
	private String tipoLeitor;
	
	//contrutores
	public Leitor() {
		
	}

	public Leitor(int codLeitoe, String nomeLeitor, String tipoLeitor) {
		super();
		this.codLeitoe = codLeitoe;
		this.nomeLeitor = nomeLeitor;
		this.tipoLeitor = tipoLeitor;
	}
	
	//gettes e setter
	public int getCodLeitoe() {
		return codLeitoe;
	}

	public void setCodLeitoe(int codLeitoe) {
		this.codLeitoe = codLeitoe;
	}

	public String getNomeLeitor() {
		return nomeLeitor;
	}

	public void setNomeLeitor(String nomeLeitor) {
		this.nomeLeitor = nomeLeitor;
	}

	public String getTipoLeitor() {
		return tipoLeitor;
	}

	public void setTipoLeitor(String tipoLeitor) {
		this.tipoLeitor = tipoLeitor;
	}
	
	
}
