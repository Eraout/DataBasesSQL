package org.example;

import java.sql.*;
import java.util.Scanner;

public class InsertData extends settings{
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        boolean isWorking = true;
        int input = 0;
        System.out.println("Wellcome to Data Memory! (Enter help to get help)");
        while (isWorking) {
            String command = sc.nextLine();
            switch (command) {
                default:
                    System.out.println("Enter help to get help");
                    break;
                case "help":
                    System.out.println("Type 'add' to add number in memory.\nType 'show' to show all results\nType 'exit' to close program");
                    break;
                case "add":
                    System.out.print("Enter a number: ");
                    input = sc.nextInt();
                    try (Connection connection = DriverManager.getConnection(url, username, password)) {
                        String sql = "INSERT INTO IntMemo (value) VALUES (?)";

                        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                            // Устанавливаем числовое значение
                            preparedStatement.setInt(1, input);

                            // Выполняем запрос
                            preparedStatement.executeUpdate();

                            System.out.println("Data inserted successfully!");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "show":
                    try (Connection connection = DriverManager.getConnection(url, username, password)) {
                        String sql = "SELECT * FROM IntMemo";

                        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                                // Перебор результатов запроса
                                while (resultSet.next()) {
                                    int id = resultSet.getInt("id");
                                    int value = resultSet.getInt("value");
                                    String date = resultSet.getString("time_record");
                                    // Получение других колонок при необходимости

                                    // Делайте что-то с данными, например, выводите их на экран
                                    System.out.println("ID: " + id + ", Value: " + value + ", Time: " + date);
                                }
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "exit" :
                    isWorking = false;
                    break;
            }

        }
    }
}
