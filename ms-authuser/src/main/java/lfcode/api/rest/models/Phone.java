package lfcode.api.rest.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("deprecation")
@Entity
@Table(name= "TB_PHONES")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true, length = 12)
	
	private String number; 
	@Column( length = 25)
	private String type;

	@ManyToOne
	@JoinColumn(name = "phone_id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "phone_fx"))
	private UserModel userPhone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public UserModel getUserphone() {
		return userPhone;
	}

	public void setUserphone(UserModel userphone) {
		this.userPhone = userphone;
	}
}
