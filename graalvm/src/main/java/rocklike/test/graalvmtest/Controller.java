package rocklike.test.graalvmtest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping(path = {"/ping/{pong}"}, produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity ping(@PathVariable String pong) {
    	String p2 = pong + pong + pong;
        return ResponseEntity.ok().body(p2);
    }
    
    @GetMapping(path = {"/bkakskf-no-use/{pong}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity noUse(@PathVariable String pong) {
    	String p2 = pong + pong + pong;
    	PingDto d = new PingDto();
    	d.setPing(p2);
    	return ResponseEntity.ok().body(d);
    }
    
    @GetMapping(path = {"/fsfrgsf-no-use/{pong}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity noUse2(@PathVariable String pong) {
    	String p2 = pong + pong + pong;
    	PingDto d = new PingDto();
    	d.setPing(p2);
    	return ResponseEntity.ok().body(d);
    }

    @GetMapping(path = {"/basfsfxv-no-use/{pong}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity noUse3(@PathVariable String pong) {
    	String p2 = pong + pong + pong;
    	Map<String, String> m = new HashMap<>();
    	m.put("ping", p2);
    	return ResponseEntity.ok().body(m);
    }

    class PingDto {
    	private String ping;
		public String getPing() {
			return ping;
		}
		public void setPing(String ping) {
			this.ping = ping;
		}
    	
    }
}