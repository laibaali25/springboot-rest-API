package com.springboot.springbootEmp_restapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "address-data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
     private String street;
    private String city;
    private String state;
    private String zipCode;
}


// if project will not run then do changesin this file



// package com.springboot.springbootEmp_restapi.model;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class Address {
//     private String street;
//     private String city;
//     private String state;
//     private String zipCode;
// }
