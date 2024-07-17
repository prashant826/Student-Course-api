package pvr.springproject.topic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService{
	
	@Autowired
	private CourseRepository topicRepository;
		
	public List<Topic> getallTopics(){
		
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopicById(Integer id){
		return topicRepository.findById(id);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(Integer id, Topic topic) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(Integer id) {
		topicRepository.deleteById(id);
	}
	
}
