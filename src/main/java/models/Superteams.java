package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "super_team")
public class Superteams {
	
	@Id
	@Column(name = "team_name")
	private String team_name;
	
	@Column(name = "alignment_type")
	private String alignment_type;

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getAlignment_type() {
		return alignment_type;
	}

	public void setAlignment_type(String alignment_type) {
		this.alignment_type = alignment_type;
	}

	public Superteams(String team_name, String alignment_type) {
		super();
		this.team_name = team_name;
		this.alignment_type = alignment_type;
	}

	public Superteams() {
		super();
	}

	@Override
	public String toString() {
		return "Superteams [team_name=" + team_name + ", alignment_type=" + alignment_type + "]";
	}
	
	

}
