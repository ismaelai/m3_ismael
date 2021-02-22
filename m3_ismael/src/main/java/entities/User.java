package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")

public class User implements Serializable{
	private static final long serialVersionUID =1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	 private Long id;
	@Column(name="first_name")
	 private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	@Column(name="age")
	 private Integer age;
	@Column(name="nif")	
	private String nif;
	@Column(name="email")
	private String email;
	@Column (name="password")
	private String password;
	@Column(name="married", insertable = true)
	private boolean married;	

	public User() {}

	public User(String firstName, String lastName, Integer age, String nif, String email, String password,
			boolean married) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.nif = nif;
		this.email = email;
		this.password = password;
		this.married = married;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", nif="
				+ nif + ", email=" + email + ", password=" + password + ", married=" + married + "]";
	}
	
}
	
