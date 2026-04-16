package it.marcob.jobtracker.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder.Default;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="users")
@Builder
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length = 50)
	private String firstName;
	
	@Column(nullable=false, length = 50)
	private String lastName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private Role role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@Default
	private List<JobApplication> applications;
}
