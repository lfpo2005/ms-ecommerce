package lfcode.api.rest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lfcode.api.rest.enums.UserStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name= "TB_USERS")
public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 150)
    private String fullName;
	
	@Column(unique = true, length = 50)
	private String email;
	
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private UserStatus UserStatus;
	
	@Column(unique = true, length = 20)
	private String login;
	
	private String password;
	
	private String token;

	@Column(unique = true, length = 20)
	private String cpf;
	
	@Column(length = 500)
    private String imageUrl;
		 
	 @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
	 private LocalDateTime creationDate;
	 
	 @Column(nullable = false)
	 @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy HH:mm:ss")
	 private LocalDateTime lastUpdateDate;
	 
	 @Column(nullable = false)
	 @OneToMany(mappedBy = "userPhone", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	 private List<Phone> userPhone = new ArrayList<Phone>();

	@Column(nullable = false)
	@OneToMany(mappedBy = "userAddress", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Address> userAddress = new ArrayList<Address>();


	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();
	 
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		UserModel other = (UserModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public UserStatus getUserStatus() {
		return UserStatus;
	}

	public void setUserStatus(UserStatus userStatus) {
		UserStatus = userStatus;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Phone> getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(List<Phone> userPhone) {
		this.userPhone = userPhone;
	}

	public List<Address> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<Address> userAddress) {
		this.userAddress = userAddress;
	}
}