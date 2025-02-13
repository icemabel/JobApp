package com.hande.jobfindapp.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;
    private String postProfile;
    private String postDesc;
    private Integer reqExperience;

    @ElementCollection
    private List<String> postTechStack;
}
