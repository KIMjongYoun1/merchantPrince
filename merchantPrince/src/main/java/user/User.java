package user;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString(exclude = "passWord")
public class User {
	
	@Id
	@Column(name = "user_id", nullable = false, unique = true)
	private String userId;
	
	
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	
	@Column(name = "password", nullable = false)
	private String passWord;
	
	
	@Column(name ="email", nullable = false)
	private String email;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@PrePersist //  저장되기전에 먼저 실행한다고 함.
	public void prePersist() {
		this.createdAt = LocalDateTime.now();
	}
	
}
