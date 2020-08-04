package com.example.fypwebhost;


public class ResultModelClass {
private String id,StudentID,ClassID,AssignmentID,fileLink;

    public ResultModelClass() {
    }

    public ResultModelClass(String id, String studentID, String classID, String assignmentID, String fileLink) {
        this.id = id;
        StudentID = studentID;
        ClassID = classID;
        AssignmentID = assignmentID;
        this.fileLink = fileLink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String classID) {
        ClassID = classID;
    }

    public String getAssignmentID() {
        return AssignmentID;
    }

    public void setAssignmentID(String assignmentID) {
        AssignmentID = assignmentID;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
}