package com.example.student;

public class StudentDTO
{
    private int age;
    private String name;
    private String course;
    private double marks;

    public int getAge()
    {
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getCourse()
    {
        return course;
    }
    public void setCourse(String course)
    {
        this.course=course;
    }

    public double getMarks()
    {
        return marks;
    }
    public void setMarks(double marks)
    {
        this.marks=marks;
    }
}
