package com.nelnaji.sapstockmanagement.dl.entities.person;

import com.nelnaji.sapstockmanagement.dl.entities.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user_")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class User extends Person {


    @Column(nullable = false)
    @Setter
    private String password;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    // ne pas oublier d'instancier nos Set Si on fait ca supprimer le @NoArgsConstructor
//    public User(){
//        this.roles = new HashSet<>();
//    }

    public User(UUID id, String firstName, String lastName, String email, String password) {
        super(id, firstName, lastName, email);
//        this.roles = new HashSet<>();
        this.password = password;
    }


    public Set<Role> getRoles() {

        // safe copy pour eviter
        return Set.copyOf(roles);
    }
    public void addRole(Role role){
        roles.add(role);
    }
    public void removeRole(Role role){
        roles.remove(role);
    }

}
