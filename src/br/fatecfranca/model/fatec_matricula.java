package br.fatecfranca.model;

import java.util.Date;

public class fatec_matricula {
	private int codigo;
	private int codigoaluno;
	private int codigocurso;
	private Date matricula;

	/** 
	 * 
	 * @return 
	 * @Descrição  
	 */
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/** 
	 * 
	 * @return 
	 * @Descrição  
	 */
	public int getCodigoaluno() {
		return codigoaluno;
	}

	public void setCodigoaluno(int codigoaluno) {
		this.codigoaluno = codigoaluno;
	}

	/** 
	 * 
	 * @return 
	 * @Descrição  
	 */
	public int getCodigocurso() {
		return codigocurso;
	}

	public void setCodigocurso(int codigocurso) {
		this.codigocurso = codigocurso;
	}

	/** 
	 * 
	 * @return 
	 * @Descrição  
	 */
	public Date getMatricula() {
		return matricula;
	}

	public void setMatricula(Date matricula) {
		this.matricula = matricula;
	}

}
