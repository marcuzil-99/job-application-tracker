package it.marcob.jobtracker.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="job_applications")
@Builder
@ToString
public class JobApplication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(nullable = false, length = 50)
	private String company;
	
	@Column(nullable = false, length = 50)
	private String roleTitle;
	
	@Column(nullable = false, length = 50)
	private String status;
	
	@Column(nullable = false)
	private LocalDate applicationDate;
	
	@Column(nullable = false, length = 200)
	private String url;
	
	@OneToMany(mappedBy = "jobApplication", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
	private List<FollowUpTask> followUpTasks;

}
