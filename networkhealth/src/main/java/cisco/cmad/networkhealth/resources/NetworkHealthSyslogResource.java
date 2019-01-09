package cisco.cmad.networkhealth.resources;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cisco.cmad.networkhealth.entity.CounterStatitics;
import cisco.cmad.networkhealth.entity.Syslog;
import cisco.cmad.networkhealth.service.SyslogService;

@RequestMapping("/network/health/v1/events")
@RestController
public class NetworkHealthSyslogResource {

	@Autowired
	public SyslogService syslogService;
	
	@GetMapping("/syslog")
	public ResponseEntity<List<Syslog>> getAllSyslogMessages() {
		return new ResponseEntity<List<Syslog>>(syslogService.getAllSyslogMessages(),HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping("/syslog/counters")
	public ResponseEntity<List<CounterStatitics>> getSyslogCounters() {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
		headers.add("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
		return new ResponseEntity<List<CounterStatitics>>(syslogService.fetchSyslogCounters(),headers,HttpStatus.OK);
	}
	
	
}
