package si.tutorial.jee7fiddle.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the OSEBA database table.
 * 
 */
@Entity
@Table(name="Oseba")
@NamedQuery(name="Oseba.findAll", query="SELECT o FROM Oseba o")
public class Oseba implements Serializable {
	private static final long serialVersionUID = 1L;

	private String emailosebe;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idosebe", nullable=false, unique=true)
	private int idosebe;

	private String imeosebe;

	public Oseba() {
	}

	public String getEmailosebe() {
		return this.emailosebe;
	}

	public void setEmailosebe(String emailosebe) {
		this.emailosebe = emailosebe;
	}

	public int getIdosebe() {
		return this.idosebe;
	}

	public void setIdosebe(int idosebe) {
		this.idosebe = idosebe;
	}

	public String getImeosebe() {
		return this.imeosebe;
	}

	public void setImeosebe(String imeosebe) {
		this.imeosebe = imeosebe;
	}

}