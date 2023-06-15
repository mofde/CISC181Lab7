package cisc181.lab_7;
//LabCourse represents a lab course.
public class LabCourse extends Course {
    public final int MAX_SEATS = 20;
    private Course[] labSessions;
    public LabCourse(String Dept, int CourseNum, int SectNum, int Capacity) {
        super(Dept, CourseNum, SectNum, Capacity);
        if (this.Capacity%MAX_SEATS != 0) {
            this.labSessions = new Course[(int) (this.Capacity / MAX_SEATS) + 1];
        } else {
            this.labSessions = new Course[(int) (this.Capacity / MAX_SEATS)];
        }
        for (int i = 0; i < labSessions.length; i++) {
            this.labSessions[i] = new Course(Dept, CourseNum, 100+i, MAX_SEATS);
        }
    }
    //getLabSessions gets the current lab sessions.
    public Course[] getLabSessions() {
        return this.labSessions;
    }
    //toString prints the Course's toString and then concatenating the Lab Sessions one per line but
    //indented four blank spaces.
    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append(super.toString() + "\n");
        for (Course course: this.labSessions) {
            retString.append("    " + course.toString() + "\n");
        }
        return retString.toString();
    }
}
