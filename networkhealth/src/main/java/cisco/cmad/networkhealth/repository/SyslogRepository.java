package cisco.cmad.networkhealth.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cisco.cmad.networkhealth.entity.Syslog;


@Repository
public interface SyslogRepository extends CrudRepository<Syslog, Integer>{


	
	public List<Syslog> findByEventType(@PathParam("eventType") String eventType) ;
}
