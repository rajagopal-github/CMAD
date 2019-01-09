package cisco.cmad.networkhealth.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cisco.cmad.networkhealth.entity.CounterStatitics;
import cisco.cmad.networkhealth.entity.EventType;
import cisco.cmad.networkhealth.entity.Syslog;
import cisco.cmad.networkhealth.repository.SyslogRepository;

@Service
public class SyslogService {

	@Autowired
	SyslogRepository syslogRepository;
	
	public List<Syslog> getAllSyslogMessages() {
		
		Iterable<Syslog> allIterables = syslogRepository.findAll();
		final List<Syslog> syslogList = new ArrayList<Syslog>();
		allIterables.forEach(syslog -> syslogList.add(syslog));
		
		return syslogList;
	}
	
	public List<CounterStatitics> fetchSyslogCounters() {
		
		List<CounterStatitics> statistics = new ArrayList<>();
		for(EventType eventType: EventType.values()) {
		List<Syslog> syslogList = syslogRepository.findByEventType(eventType.toString());
		if(syslogList != null)
			
			statistics.add(new CounterStatitics(eventType.name(), syslogList.size()));
		}
		return statistics;
	}
}
