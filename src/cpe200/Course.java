package cpe200;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Course {

    public Course() {
        this("TBA","000000","TBA",30);
    }

    public Course(String n, String cid) {
        this(n, cid, " ", 30);

    }

    public Course(String n, String cid, String l) {
        this(n, cid, l, 30);
    }

    public Course(String n, String cid, String l, int max) {
        this.course_name = !n.equalsIgnoreCase("")?n:"TBA";
        this.course_id = !cid.equalsIgnoreCase("")?cid:"000000";
        this.lecturer = !l.equalsIgnoreCase("")?l:"TBA";
        this.max_students = max;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = !course_name.equalsIgnoreCase("")?course_name:this.course_name;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        if(isValidCourse_id(course_id) && (course_id.length() == 6)){
            this.course_id = course_id;
        }
        else{
            return;
        }
    }

    // implement the other get and set methods here
    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = !lecturer.equalsIgnoreCase("")?lecturer:this.lecturer;
    }

    public int getMax_students() {
        return max_students;
    }

    public void setMax_students(int max_students) {
        if(max_students > 0){
            this.max_students = max_students;
        }else{
            return;
        }
        this.max_students = max_students;
    }

    public int getNo_students() {
        return no_students;
    }

    public void setNo_students(int no_students) {
        if(no_students <= 60 && no_students >= 0){
            this.no_students = no_students;
        }else{
            return;
        }
    }

    @Override
    public String toString() {
        if(no_students == 0){
            String o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has " + "NO" + " student, [maximum: "+ max_students + "]";
            return o;
        }else if(no_students == 1){
            String o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has ONE student, [maximum: "+ max_students + "]";
            return o;
        }else{
            String o = this.course_name + " ("
                    + this.course_id + "), Teacher: "
                    + this.lecturer + ", has " + no_students + " students, [maximum: "+ max_students + "]";
            return o;
        }
    }

    private boolean isValidCourse_id(String id) {
        Pattern p = Pattern.compile(idREGEX);
        Matcher m = p.matcher(id);
        boolean matches = m.matches();
        if(matches){
            return true;
        }
        else{
            return false;
        }
    }

    // Regular expression for the Student ID pattern
    private static final String idREGEX = "[0-9]+";

    // all private attributes
    private String course_name;
    private String course_id;
    private String lecturer;
    private int max_students;
    private int no_students;
}
