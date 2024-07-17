package pvr.springproject.course;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import pvr.springproject.topic.Topic;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("topic/{id}/courses")
	public List<Course> getAllCourses(@PathVariable int id){
		return courseService.getallCourses(id);	
	}
	
	@GetMapping("topic/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable int id) {
		return courseService.getCourseById(id);
	}
	
	
	@PostMapping("topic/{topicId}/courses")
	public void addCourse(@RequestBody Course course, Course Id,@PathVariable int topicId){
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@PutMapping("topic/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course ,@PathVariable Integer id,@PathVariable int topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable Integer id) {
		courseService.deleteCourse(id);
	}
	
	
}
