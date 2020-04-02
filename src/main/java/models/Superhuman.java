package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "superhumans")
public class Superhuman {
	
	@Id
	@Column(name = "super_name")
	private String super_name;
	
	@Column(name = "alignment_type")
	private String alignment_type;
	
	@Column(name = "actual_name")
	private String actual_name;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "power_level")
	private int power_level;
	
	@Column(name = "power_description")
	private String power_description;
	
	@Column(name = "team_name")
	private String team_name;

	public String getSuper_name() {
		return super_name;
	}

	public void setSuper_name(String super_name) {
		this.super_name = super_name;
	}

	public String getAlignment_type() {
		return alignment_type;
	}

	public void setAlignment_type(String alignment_type) {
		this.alignment_type = alignment_type;
	}

	public String getActual_name() {
		return actual_name;
	}

	public void setActual_name(String actual_name) {
		this.actual_name = actual_name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPower_level() {
		return power_level;
	}

	public void setPower_level(int power_level) {
		this.power_level = power_level;
	}

	public String getPower_description() {
		return power_description;
	}

	public void setPower_description(String power_description) {
		this.power_description = power_description;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public Superhuman(String super_name, String alignment_type, String actual_name, String country, int power_level,
			String power_description, String team_name) {
		super();
		this.super_name = super_name;
		this.alignment_type = alignment_type;
		this.actual_name = actual_name;
		this.country = country;
		this.power_level = power_level;
		this.power_description = power_description;
		this.team_name = team_name;
	}

	public Superhuman() {
		super();
	}

	@Override
	public String toString() {
		return "superhuman [super_name=" + super_name + ", alignment_type=" + alignment_type + ", actual_name="
				+ actual_name + ", country=" + country + ", power_level=" + power_level + ", power_description="
				+ power_description + ", team_name=" + team_name + "]";
	}
	
	
	

}
