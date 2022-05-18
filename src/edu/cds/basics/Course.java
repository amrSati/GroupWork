package edu.cds.basics;

//Section 7.8\\

class Course {

    // Attributes
    private String name;
    private String Students[];
    private int numberOfStudents;
    private int count;

    // Construct instance
    public Course(String name, int numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
        Students = new String[numberOfStudents];
        count = 0;
    }

    public String getName() {
        return name;
    }

    public String[] getStudents() {
        return Students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void addStudent(String student) {
        if (count >= numberOfStudents)
            resize();

        Students[count++] = student;
    }

    // Resize students array
    private void resize() {
        // Create temporary array
        String tmp[] = Students;
        Students = new String[count * 2];

        // Copy students into new resized array
        System.arraycopy(tmp, 0, Students, 0, tmp.length);
    }
}