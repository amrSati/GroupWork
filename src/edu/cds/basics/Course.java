package edu.cds.basics;

//Section 7.8\\

class Course {

    private String name;
    private String Students[];
    private int numberOfStudents;
    private int count;

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

        Students[count] = student;
        count++;
    }

    private void resize() {
        String tmp[] = Students;
        Students = new String[count + 1];

        for (int i = 0; i < tmp.length; i++)
            Students[i] = tmp[i];

    }
}