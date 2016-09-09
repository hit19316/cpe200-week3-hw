package cpe200;

public class Student {

    public Student(){
        this("John Doe","560610000",1990, false);

    }

    public Student(String n, String sid) {
        this(n, sid, 1990, false);
    }

    public Student(String n, String sid, int yob){
        this(n, sid, yob, false);
    }

    public Student(String n, String sid, int yob, boolean stat){
        if(isValidStudent_id(sid)){
            this.student_id = !sid.equalsIgnoreCase("")?sid:"560610000";
        }else{
            this.student_id = "560610000";
        }
        if(isValidYOB(yob)){
            this.YearOfBirth = yob;
        }else{
            this.YearOfBirth = 1990;
        }
        this.name = !n.equalsIgnoreCase("")?n:"John Doe";
        this.Status = stat;
    }

    public String getName(){
        return name;
    }

    public String getStudent_id(){
        return student_id;
    }

    public int getYearOfBirth(){
        return YearOfBirth;
    }

    public boolean isActive(){
        return Status;
    }

    public void setName(String name){
        if(name.equalsIgnoreCase("")){
            return;
        }else{
            this.name = name;
        }
    }

    public void setStudent_id(String student_id){
        if(isValidStudent_id(student_id)){
            this.student_id = student_id;
        }else{
            return;
        }
    }

    public void setYearOfBirth(int YearOfBirth){
        if(isValidYOB(YearOfBirth)){
            this.YearOfBirth = YearOfBirth;
        }
    }

    // implement all missing constructors here

    // implement all get and set methods here

    @Override
    public String toString() {
        String tmp;
        if(Status == true){
            tmp = "ACTIVE";
        }else{
            tmp = "INACTIVE";
        }
        String o = name + " (" + student_id + ") was born in " + YearOfBirth + " is an " + tmp + " student.";
        return o;
    }

    private boolean isValidStudent_id(String id) {
        if(id.matches(Regex)){
            return true;
        }else{
            return false;
        }
    }

    private boolean isValidYOB(int yob) {
        if(yob > 1989){
            return true;
        }else{
            return false;
        }
    }


    private static final String Regex= "^5([6-9]?)061([0-2]?)([0-9]{3})$";
    // declare your attributes here
    private String name;
    private String student_id;
    private int YearOfBirth;
    private boolean Status;
}
