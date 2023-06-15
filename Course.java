package cisc181.lab_7;
//Represents a course.
public class Course implements Comparable<Course>{
    protected String Dept;
    protected int CourseNum;
    protected int SectNum;
    protected int Capacity;
    public Course(String Dept, int CourseNum, int SectNum, int Capacity) {
        this.Dept = Dept;
        this.CourseNum = CourseNum;
        this.SectNum = SectNum;
        this.Capacity = Capacity;
    }
    //getDept gets the current Dept.
    public String getDept() {
        return this.Dept.toUpperCase();
    }
    //getCourseNum gets the current CourseNum.
    public int getCourseNum() {
        return this.CourseNum;
    }
    //getSectNum gets the current SectNum.
    public int getSectNum() {
        return this.SectNum;
    }
    //getCapacity gets the current Capacity.
    public int getCapacity() {
        return this.Capacity;
    }
    //toString prints the Dept in uppercase letters, CourseNum, dash and SectNum in that order with
    //no spaces.
    public String toString() {
        String StringCourseNum = Integer.toString(this.CourseNum);
        String StringSectNum = Integer.toString(this.SectNum);
        return this.Dept.toUpperCase() + StringCourseNum + "-" + StringSectNum;
    }
    //equals returns true if the Dept, CourseNum and SectNum are equal.
    public boolean equals(Course course) {
        if (!Dept.equals(course.Dept)) {
            return false;
        }
        if (CourseNum != course.CourseNum) {
            return false;
        }
        return SectNum == course.SectNum;
    }
    @Override
    //compareTo sorts a collection of Courses first by Dept, then by CourseNum and lastly by
    //SectNum.
    public int compareTo(Course otherCourse) {
        if (Dept.compareTo(otherCourse.Dept) == 0) {
            if (Integer.toString(CourseNum).compareTo(Integer.toString(otherCourse.CourseNum)) == 0) {
                return Integer.toString(SectNum).compareTo(Integer.toString(otherCourse.SectNum));
            } else {
                return Integer.toString(CourseNum).compareTo(Integer.toString(otherCourse.CourseNum));
            }
        } else {
            return Dept.compareTo(otherCourse.Dept);
        }
    }
}
