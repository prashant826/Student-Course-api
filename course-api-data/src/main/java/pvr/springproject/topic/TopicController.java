package pvr.springproject.topic;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@GetMapping("/hello")
	public String hello() {	
		return "Hi";
	}
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics(){
		return topicService.getallTopics();	
	}
	
	@GetMapping("/topic/{id}")
	public Optional<Topic> getTopics(@PathVariable int id) {
		return topicService.getTopicById(id);
	}
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@PutMapping("/topic/{id}")
	public void updateTopic(@RequestBody Topic topic ,@PathVariable Integer id) {
		topicService.updateTopic(id,topic);
	}
	
	@DeleteMapping("/topic/{id}")
	public void deleteTopic(@PathVariable Integer id) {
		topicService.deleteTopic(id);
	}
	
	
}
