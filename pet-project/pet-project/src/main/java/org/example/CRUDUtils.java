package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtils {
    private static String INSERT_PlAYER = "INSERT INTO players(gender, best_score) VALUES (?,?);";
    private static String UPDATE_SCORE = "UPDATE players SET best_score = ? WHERE id = ? ;";
    private static String DELETE_PlAYER = "DELETE FROM players  WHERE best_score = 0 ;";

//    public static List<User> getStudentData(String query) {
//        List<User> players = new ArrayList<>();
//
//        try (Connection connection = DBUtils.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//             ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String course_name = rs.getString("course_name");
//
//                students.add(new Student(id, name, surname, course_name));
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return students;
//    }
//
//    public static List<Student> saveStudent(Student student) {
//        List<Student> students = new ArrayList<>();
//
//        try (Connection connection = DBUtils.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT)) {
//            preparedStatement.setString(1, student.getName());
//            preparedStatement.setString(2, student.getSurname());
//            preparedStatement.setString(3, student.getCourse_name());
//            preparedStatement.executeUpdate();
//
//            PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM students");
//            ResultSet rs = allStudents.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String course_name = rs.getString("course_name");
//
//                students.add(new Student(id, name, surname, course_name));
//
//            }
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return students;
//    }
//
//    public static List<Student> updateStudent(int studentId, String courseName) {
//        List<Student> updateStudents = new ArrayList<>();
//        try (Connection connection = DBUtils.getConnection();
//
//             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT)) {
//            preparedStatement.setString(1, courseName);
//            preparedStatement.setInt(2, studentId);
//            preparedStatement.executeUpdate();
//
//            PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM students");
//            ResultSet rs = allStudents.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String course_name = rs.getString("course_name");
//
//                updateStudents.add(new Student(id, name, surname, course_name));
//
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return updateStudents;
//    }
//
//
//    public static List<Student> deleteStudent(int studentId) throws SQLException {
//        List<Student> updateStudents = new ArrayList<>();
//        try (Connection connection = DBUtils.getConnection();
//
//             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT)) {
//            preparedStatement.setInt(1, studentId);
//            preparedStatement.executeUpdate();
//
//            PreparedStatement allStudents = connection.prepareStatement("SELECT * FROM students");
//            ResultSet rs = allStudents.executeQuery();
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                String surname = rs.getString("surname");
//                String course_name = rs.getString("course_name");
//
//                updateStudents.add(new Student(id, name, surname, course_name));
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return updateStudents;
//
//    }
}
