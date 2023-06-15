package cisc181.lab_7;
import java.util.ArrayList;
import java.util.Collections;
//Represents a course catalog.
public class CourseCatalog {
    private ArrayList<Course> courses;
    public CourseCatalog() {
        this.courses = new ArrayList<>();
    }
    //courseExists returns true if the course already exists the CourseCatalog.
    private boolean courseExists(Course course) {
        for (Course aCourse: this.courses) {
            if (aCourse.equals(course)) {
                return true;
            }
        }
        return false;
    }
    //getAllCourses gets the current courses.
    public ArrayList<Course> getAllCourses() {
        return this.courses;
    }
    //addCourse adds a course to the ArrayList. It only adds the course if it does not already exist
    //and returns a boolean true if the course was added.
    public boolean addCourse(Course course) {
        boolean courseAdded = false;
        if (!courseExists(course)) {
            courseAdded = this.courses.add(course);
            Collections.sort(this.courses);
        }
        return courseAdded;
    }
    //removeCourse removes the course from the CourseCatalog if it exists and returns a boolean true
    //if the course was removed.
    public boolean removeCourse(Course course) {
        return this.courses.remove(course);
    }
    //printCourseCatalog prints the catalog displaying each Course on its own line in the order that
    //the courses are stored in the ArrayList.
    public void printCourseCatalog() {
        for (Course course: this.courses) {
            System.out.println(course);
        }
    }
}