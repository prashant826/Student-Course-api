package pvr.springproject.course;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService{
	
	@Autowired
	private CourseRepository courseRepository;
	
		
	public List<Course> getallCourses(Integer id){
		
		List<Course> courses = new ArrayList<>();
		courseRepository.findAllByTopicId(id).forEach(courses::add);
		return courses;
	}
	
	public Optional<Course> getCourseById(Integer id){
		return courseRepository.findById(id);
	}
	
	public void addCourse(Course topic) {
		courseRepository.save(topic);
	}
	
	public void updateCourse(Course topic) {
		courseRepository.save(topic);
	}
	
	public void deleteCourse(Integer id) {
		courseRepository.deleteById(id);
	}
	
}
