package br.com.gerenciadordeprodutos.api.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "fornecedores")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//pra gerar id em sequencia
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "CNPJ", nullable = false, unique = true, length = 15)
    private String CNPJ;

    @Column(name = "email", nullable = false, length = 100)
    private String email;


}
