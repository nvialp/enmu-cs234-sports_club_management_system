public static void main (String[] args)
{
  //creat a new school
  School enmu = new School ();

  System.out.println ("Number of Courses: " + enmu.getNumCourses ());
  //create students
  Student s1 = new Student ("Emma", 18);
  Student s2 = new Student ("John", 21);
  Student s3 = new Student ("Julian", 20);
  Student s4 = new Student ("Bella", 19);
  Student s5 = new Student("Carlos", 22);
  Student s6 = new Student("Stephen", 18);
  
  //create instructors
  Instructor ecv = new Instructor ("Eduardo", "Portales");
  Instructor ei = new Instructor ("Essa", "Clovis");
  Instructor staff = new Instructor();
  Adjunct big = new Adjunct (4, "Carlos", "Lubock");
  //create courses
  Course cs123 = new Course (123, "Computer Science I");
  cs123.setProfessor(ei);
  Course cs234 = new Course (234, "Computer Science II");
  cs234.setProfessor(ecv);
  Course csxx = new Course(111, "Directed Studies", staff);
  Course elective = new Course (222, "Big Data", big);
  //add students to courses
  cs123.addStudent(s6);
  cs123.addStudent(s5);
  
  cs234.addStudent(s1);
  cs234.addStudent(s6);
  cs234.addStudent(s2);
  
  csxx.addStudent(s3);
  csxx.addStudent(s4);
  
  elective.addStudent(s4);
  elective.addStudent(s6);
  elective.addStudent(s2);
  
  //add courses to the School
  enmu.addCourse(cs123);
  enmu.addCourse(cs234);
  enmu.addCourse(csxx);
  enmu.addCourse(elective);
  System.out.println("Number of Courses: "+ enmu.getNumCourses());
  
  //this course exists
  enmu.getCourseInfo(234);
  //this course does not exist 
  enmu.getCourseInfo(555);
  //this course exists
  enmu.getCourseInfo(222);
}
