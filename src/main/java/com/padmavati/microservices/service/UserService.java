package com.padmavati.microservices.service;

import com.padmavati.microservices.enitity.User;
import com.padmavati.microservices.exception.ResourceNotFoundException;
import com.padmavati.microservices.model.request.UserRequest;
import com.padmavati.microservices.repository.UserRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User getData(int id){
       return userRepository.findById(String.valueOf(id)).orElseThrow(() -> new ResourceNotFoundException("id provided is not present please recheck your id!"));
    }

    public List<User> getUsersByAge(int age){
        return userRepository.findByAge(age);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public String addUser(UserRequest user){
        User u = User.builder()
                .age(user.getAge())
                .name(user.getName())
                .designation(user.getDesignation()).build();
        userRepository.save(u);
        return "User added successfully";
    }

    public ByteArrayInputStream generateExcelForUsers() throws IOException {
        List<User> users = getAllUsers();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("users");

        Row row = sheet.createRow(0);
        List<String> headers = Arrays.asList("Id","Name","Age","Designation");
        for(int i=0;i<4;i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(headers.get(i));
        }
        int rowCounter=1;
        for(int i=0;i< users.size();i++){
            User user = users.get(i);
            Row userRow = sheet.createRow(rowCounter++);
            int cellCounter = 0;
            //id
            Cell cell = userRow.createCell(cellCounter++);
            cell.setCellValue(user.getId());

            //name
            cell = userRow.createCell(cellCounter++);
            cell.setCellValue(user.getName());

            //age
            userRow.createCell(cellCounter++).setCellValue(user.getAge());

            //designation
            cell = userRow.createCell(cellCounter++);
            cell.setCellValue(user.getDesignation());
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}
