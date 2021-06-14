package ar.com.manflack.expensemanager.app.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User
{
    @Id
    private UUID id;

    private String username;

    private String password;

    private String email;
}
