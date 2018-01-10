package com.mustafaergan.hibernatevalidation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "aa_user")
@Where(clause = "deleted='false'")
@SQLDelete(sql
        = "UPDATE aa_user "
        + "SET deleted = 'true', password = uuid_in(md5(random()::text || now()::text)::cstring), email = '' "
        + "WHERE user_id = ? ")
@JsonIgnoreProperties({"password"})//Password json isteklerinde gitmesi diye.
public @Data class User {
    @Id
    @GeneratedValue(generator="system-uuid") 
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    @Column(name = "user_id", length = 50)
    private String userId;
    @NotNull
    @Size(min=4, max=50)
    @Pattern(regexp = "^[a-zA-Z0-9,.(._)]*$")
    @Column(name = "username",unique = true)
    private String username;
    @NotNull
    @Size(min=2, max=50)
    @Column(name = "name")
    private String name;
    @NotNull
    @Size(min=2, max=50)
    @Column(name = "surname")
    private String surname;
}