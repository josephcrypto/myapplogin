package cn.coding.com.myapplogin.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 *@Author JosephCrypto
 *@Create 2022-07-2/11/22 10:07 PM
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String language;

    private String mobile;

    private String address;

    private String email;

    private String password;

    private byte gender;

    private Boolean enabled;
}
