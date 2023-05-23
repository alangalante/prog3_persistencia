package org.example.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario extends Pessoa{
    private String matricula;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Setor> setores = new ArrayList<>();

    public void addSetor(Setor setor) {
        setores.add(setor);
    }
}
