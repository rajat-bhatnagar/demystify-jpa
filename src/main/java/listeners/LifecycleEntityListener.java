package listeners;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class LifecycleEntityListener {
	@PrePersist
	public void prePersist(Object object){
		System.out.println("********* Default Entity Listener @PrePersist *********");
	}
	
	@PostPersist
	public void postPersist(Object object){
		System.out.println("********* Default Entity Listener @PostPersist *********"); 
	}
}
